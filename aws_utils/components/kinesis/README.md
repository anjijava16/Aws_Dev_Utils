# AWS Developer UTILS(Bigdata,ML and Web Utils)

# Kinesis 
	Kinesis is a managed alternative to Apache Kafka 
	Generatd for application logs,metrics,IOT ,clickstreams
	Great for real time big data
	Great for streaming processing framework (spark,NIFI)
	Data is automically replicated synchronously to 3 AZ


# 3 Components
   1. Kinesis Streams
		Low Latency Streaming ingest at scale 
   2. Kinesis Anlytics
        Perform real time analytics on streams using SQL 
   3. Kinesis Firehouse 
        Load streams into S3 ,RedShift,ElasticSearch & Splunk
		
# Kinesis Streams overviw
   Streams are divided in ordered Shards/Patitions

 # Note:    Producer ----> Shard1/Shard2/Shard3 -----> Consumer
	# Each shard <<==>> Partiitons
	Data retetion is 24 hours by default ,can go up to 7 days
	Ability to reprocess /replay data 
	Mulitple applications can consume the same stream 
	Once data is inserted in kinesis ,it can't be deleted (Immutability)
	
	One Stream is made of Many different Shards 
	Records are ordered per Shard 
	Producer ===> Shard 1 /Shard 2 / Shard3 ===> Consumers
	
# Kinesis Stream Records 
   Data Blob ===> data being sent ,serilized as bytes Upto 1 MB .can represent anything
   Record Key ===> Sent alongside record, helps to group records in shards .
                  Same Key=Same Shard .
                   Use a higly distributed key to avoid the hot partiiton problem
   Sequence Number: Unique Identifier for each records put in shards .Added by kinesis after ingestion
   
   
   Kinesis  Producers:
         Kinesis SDK :PutRecord,PutRecords
		 Kinesis Producer Library (KPL)
		 Kinesis Agent 
		 Kafka ==> Kinesis 
		 
	Kinesis  Consumers:
         Kinesis  SDK
         Kinesis  Client Library 
         Kinesis Connector Library
         3rd Party Application Spark,Flume,Kafka,other connector
         Kinesis Firehouse
         AWS lambda 
		 
		 
		 
				   