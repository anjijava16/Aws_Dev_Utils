// Databricks notebook source
// MAGIC %md
// MAGIC You can import this notebook directly from its published HTML version. 
// MAGIC 
// MAGIC First, click on the Home button:
// MAGIC 
// MAGIC ![](https://ardentex-spark.s3.amazonaws.com/philly-spark-etl/home.png)
// MAGIC 
// MAGIC Then, right click on your home directory, and select **Import**:
// MAGIC 
// MAGIC ![](https://ardentex-spark.s3.amazonaws.com/philly-spark-etl/import1.png)
// MAGIC 
// MAGIC In the resulting popup, select **URL**:
// MAGIC 
// MAGIC ![](https://ardentex-spark.s3.amazonaws.com/philly-spark-etl/import2.png)
// MAGIC 
// MAGIC Paste the notebook's public URL in the box, and click the **Import** button.
// MAGIC 
// MAGIC ![](https://ardentex-spark.s3.amazonaws.com/philly-spark-etl/import3.png)

// COMMAND ----------

// MAGIC %md 
// MAGIC 
// MAGIC **NOTE:** With Databricks Community Edition, you only get a limited amount of space (a quota of about 100MB).
// MAGIC You can always mount your own S3 bucket, though. See [these instructions](https://docs.databricks.com/spark/latest/data-sources/aws/amazon-s3.html#mount-an-s3-bucket)
// MAGIC for details.

// COMMAND ----------

// MAGIC %md First, let's go get the Airbnb SF listings file. This is data from March, 2019.

// COMMAND ----------

// MAGIC %sh wget -O /tmp/airbnb-sf-listings-2019-03-06.csv https://ardentex-spark.s3.amazonaws.com/philly-spark-etl/airbnb-sf-listings-2019-03-06.csv

// COMMAND ----------

// MAGIC %fs cp file:/tmp/airbnb-sf-listings-2019-03-06.csv dbfs:/tmp/airbnb-sf-listings-2019-03-06.csv

// COMMAND ----------

// MAGIC %sh rm -f /tmp/airbnb-sf-listings-2019-03-06.csv

// COMMAND ----------

// MAGIC %fs ls dbfs:/tmp/airbnb-sf-listings-2019-03-06.csv

// COMMAND ----------

// MAGIC %fs head dbfs:/tmp/airbnb-sf-listings-2019-03-06.csv

// COMMAND ----------

// MAGIC %python
// MAGIC sf = spark.read.csv("dbfs:/tmp/airbnb-sf-listings-2019-03-06.csv")

// COMMAND ----------

// MAGIC %md The schema is... weird. Why are there no useful column names, and why are the fields all strings?

// COMMAND ----------

// MAGIC %python
// MAGIC sf.printSchema()

// COMMAND ----------

// MAGIC %md
// MAGIC Answers:
// MAGIC 
// MAGIC - We need to tell Spark that the first line is the header, not data.
// MAGIC - We should ask Spark to _infer_ the schema. Note that doing so requires a pass over the file. Don't do this in production.

// COMMAND ----------

// MAGIC %python
// MAGIC sf = (
// MAGIC   spark.read
// MAGIC        .option("header", "true")
// MAGIC        .option("inferSchema", "true")
// MAGIC        .csv("dbfs:/tmp/airbnb-sf-listings-2019-03-06.csv")
// MAGIC )

// COMMAND ----------

// MAGIC %python
// MAGIC sf.printSchema()

// COMMAND ----------

// MAGIC %python
// MAGIC display(sf)

// COMMAND ----------

// MAGIC %python
// MAGIC # The schema, as code
// MAGIC sf.schema

// COMMAND ----------

// MAGIC %md
// MAGIC The following function will convert an inferred schema into Python code
// MAGIC that will programmatically define the schema. You can cut-and-paste the
// MAGIC code.

// COMMAND ----------

// MAGIC %python
// MAGIC from pyspark.sql.types import *
// MAGIC 
// MAGIC def schema_to_code(schema, indentation=2):
// MAGIC   def str_field(field, indentation_level):
// MAGIC     '''
// MAGIC     Convert a field to string representation.
// MAGIC     '''
// MAGIC     field_indent_spaces = " " * ((indentation_level + 1) * indentation)
// MAGIC     field_prefix = '{0}StructField("{1}", '.format(field_indent_spaces, field.name)
// MAGIC     if isinstance(field.dataType, StructType):
// MAGIC       field_type = str_struct(field, indentation_level + 1)
// MAGIC     elif isinstance(field.dataType, ArrayType):
// MAGIC       field_type = str_array(field, indentation_level + 1)
// MAGIC     else:
// MAGIC       field_type = '{0}()'.format(field.dataType)
// MAGIC     return '{0}{1}, {2})'.format(field_prefix, field_type, field.nullable)
// MAGIC   
// MAGIC   def str_array(arr, indentation_level):
// MAGIC     indent_spaces = " " * (indentation_level * indentation)
// MAGIC     prefix = indent_spaces + 'StructField("{0}", ArrayType(\n'.format(field.name)
// MAGIC     fields = [str_field(f, indentation_level + 1) for f in arr]
// MAGIC 
// MAGIC   def str_struct(st, indentation_level):
// MAGIC     indent_spaces = " " * (indentation_level * indentation)
// MAGIC     prefix = indent_spaces + "StructType([\n"
// MAGIC     field_indentation = " " * ((indentation_level + 1) * indentation)
// MAGIC     field_strings = [str_field(field, indentation_level) for field in st.fields]
// MAGIC     fields = ',\n'.join(field_strings)
// MAGIC     return '{0}{1}\n{2}])'.format(prefix, fields, indent_spaces)
// MAGIC   
// MAGIC   return str_struct(schema, 0)

// COMMAND ----------

// MAGIC %python
// MAGIC print(schema_to_code(sf.schema))

// COMMAND ----------

// MAGIC %md Let's read it and specify the schema.

// COMMAND ----------

// MAGIC %python
// MAGIC sf1 = spark.read.option("header", "true").schema(sf.schema).csv("dbfs:/mnt/training/airbnb/sf-listings/sf-listings-2019-03-06.csv")

// COMMAND ----------

// MAGIC %md
// MAGIC Let's winnow the data down to a few columns we want.

// COMMAND ----------

// MAGIC %python
// MAGIC from pyspark.sql.functions import *
// MAGIC sf2 = (
// MAGIC   sf.select(col('name'), col('neighbourhood'), col('host_name'), col('street'),
// MAGIC             col('latitude'), col('longitude'))
// MAGIC )

// COMMAND ----------

// MAGIC %python
// MAGIC display(sf2)

// COMMAND ----------

// MAGIC %md
// MAGIC We can do the same thing with SQL, but we have to give the in-memory DataFrame
// MAGIC a name that can be referenced as if it were a SQL table. This does not create
// MAGIC a table. It just tells Spark SQL that the "table" name "sf" is really an
// MAGIC in-memory DataFrame.

// COMMAND ----------

// MAGIC %python
// MAGIC sf.createOrReplaceTempView("sf")

// COMMAND ----------

// MAGIC %python
// MAGIC sf3 = spark.sql("SELECT name, neighbourhood, host_name, street, latitude, longitude FROM sf")
// MAGIC display(sf3)

// COMMAND ----------

// MAGIC %md
// MAGIC Let's get rid of rows where the neighborhood or host name is null.

// COMMAND ----------

// MAGIC %python
// MAGIC sf4 = (
// MAGIC   sf3.where(~ col('neighbourhood').isNull()).where(~ col('host_name').isNull())
// MAGIC )
// MAGIC display(sf4)

// COMMAND ----------

// MAGIC %python
// MAGIC sf3.count()

// COMMAND ----------

// MAGIC %python
// MAGIC sf4.count()

// COMMAND ----------

// MAGIC %md Finally, we can save it as a Parquet file.

// COMMAND ----------

// MAGIC %python
// MAGIC sf4.write.mode("overwrite").parquet("dbfs:/tmp/sf.parquet")

// COMMAND ----------

// Look, Ma: Scala!
val sf5 = spark.read.parquet("dbfs:/tmp/sf.parquet")

// COMMAND ----------

sf5.count()

// COMMAND ----------

// MAGIC %md
// MAGIC Next up: Some JSON. This data is in a zip file, which we need to download and unpack.
// MAGIC 
// MAGIC **NOTE:** This data is a subset of the data I used during the demo. The original data
// MAGIC is too large and would exceed the 100MB quota.

// COMMAND ----------

// MAGIC %sh wget -O /tmp/tweets.zip https://ardentex-spark.s3.amazonaws.com/philly-spark-etl/tweets.zip

// COMMAND ----------

// MAGIC %sh ls -l /tmp/tweets.zip

// COMMAND ----------

// MAGIC %sh unzip /tmp/tweets.zip

// COMMAND ----------

// MAGIC %sh pwd

// COMMAND ----------

// MAGIC %fs rm --recurse=true dbfs:/tmp/twitter

// COMMAND ----------

// MAGIC %fs mkdirs /tmp/twitter

// COMMAND ----------

// MAGIC %fs cp --recurse=true file:/databricks/driver/twitter dbfs:/tmp/twitter

// COMMAND ----------

// MAGIC %sh rm -rf /tmp/tweets.zip /databricks/driver/twitter

// COMMAND ----------

// MAGIC %fs ls /tmp/twitter/firehose/2018/02/02/00

// COMMAND ----------

// MAGIC %fs head dbfs:/tmp/twitter/firehose/2018/02/02/00/twitterstream-1-2018-02-02-00-09-10-724faefa-dc3a-4eb2-a092-2e5ce0b1b8c7

// COMMAND ----------

// MAGIC %md
// MAGIC Let's start out by reading just one of the files, to get the schema.

// COMMAND ----------

// MAGIC %python
// MAGIC tw1 = (
// MAGIC   spark.read
// MAGIC        .option("inferSchema", "true")
// MAGIC        .json("dbfs:/tmp/twitter/firehose/2018/02/02/00/twitterstream-1-2018-02-02-00-09-10-724faefa-dc3a-4eb2-a092-2e5ce0b1b8c7")
// MAGIC )

// COMMAND ----------

// MAGIC %python
// MAGIC schema = tw1.schema

// COMMAND ----------

// MAGIC %python
// MAGIC tw1.count()

// COMMAND ----------

// MAGIC %md Now, let's read them all.

// COMMAND ----------

// MAGIC %python
// MAGIC tw = spark.read.schema(schema).json("dbfs:/tmp/twitter/firehose/2018/*/*/*/*")

// COMMAND ----------

// MAGIC %python
// MAGIC tw.count()

// COMMAND ----------

// MAGIC %python
// MAGIC display(tw)

// COMMAND ----------

// MAGIC %python
// MAGIC tw.write.mode("overwrite").parquet("dbfs:/tmp/tweets.parquet")

// COMMAND ----------

// MAGIC %python
// MAGIC twp = spark.read.parquet("dbfs:/tmp/tweets.parquet")

// COMMAND ----------

// MAGIC %python
// MAGIC display(
// MAGIC   twp.select(col('lang'), col('user.name'), col('text'))
// MAGIC      .where(col('lang') == 'en')
// MAGIC )

// COMMAND ----------

// MAGIC %fs ls dbfs:/tmp/tweets.parquet

// COMMAND ----------

dbutils.fs.ls("dbfs:/tmp/tweets.parquet")
  .filter { entry => entry.name.startsWith("part-") }
  .length

