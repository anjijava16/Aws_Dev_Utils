# AWS Developer UTILS(Bigdata,ML and Web Utils)

Database Essentials
What is a relational database?

Each field contains the same type.
# Relational Database Types:

	SQL Server
	Oracle
	MYSQL Server
	PostgreSQL
	Aurorar
	MariaDB
# Non Relational Databases
	Database
	Collection (=Table)
	Document (=Row)
	Key Value Pairs (=Fields)
	JSON/NoSQL: {"_id": "123", "firstname": "John"}

#. What is Data Warehousing?
	Used for business intelligence. Tools like Cognos, Japersoft, SQL Server Reporting Services, Oracle Hyperion, SAP NetWeaver.
	Used to pull in very large and complex data sets. Usually used by management to do queries on data (such as current performance vs targets etc).

#. OLTP vs OLAP
	Online Transaction Processing (OLTP) differs from OLAP Online Analytics Processing (OLAP) in terms of the types of queries run.

# Security  Groups 
   i.	DB Secuirty Groups
   ii.  VPC Security Groups
   iii.  EC2 Security Groups 
   
# Amazon RDS Read Replicas    
 Amazon RDS Read Replicas provide enhanced performance and durability for database (DB) instances. This feature makes it easy to elastically scale out beyond the capacity constraints of a single DB instance for read-heavy database workloads. You can create one or more replicas of a given source DB Instance and serve high-volume application read traffic from multiple copies of your data, thereby increasing aggregate read throughput. Read replicas can also be promoted when needed to become standalone DB instances. Read replicas are available in Amazon RDS for MySQL, MariaDB, PostgreSQL and Oracle as well as Amazon Aurora.  
 
 Amazon RDS uses the MariaDB, MySQL, Oracle, and PostgreSQL DB engines' built-in replication functionality to create a special type of DB instance called a Read Replica from a source DB instance. Updates made to the source DB instance are asynchronously copied to the Read Replica. You can reduce the load on your source DB instance by routing read queries from your applications to the Read Replica. Using Read Replicas, you can elastically scale out beyond the capacity constraints of a single DB instance for read-heavy database workloads.
 
 
14.3.1. OLTP Example:
Order number 2120121 Pulls up a row of data such as Name, Date, Address to Deliver to, Delivery Status etc.

14.3.2. OLAP transcation Example:
Net Prodit for EMEA and Pacific for the Digitial Radio Product. Pulls in large numbers of records

Sum of Radios Sold in EMEA
Sum of Radios Sold in Pacific
Unit Cost of Radio in each region
Sales price of each radio
Sales price - unit cost
Data Warehousing databases use different type of architecture both from a database perspective and infrastructure layer.

14.4. What is Elasticache?
ElastiCache is a web service that makes it easy to deploy, operate, and scale an in-memory cache in the cloud. The service improves the performance of web applications by allowing you to retrieve information from fast, managed, in-memory caches, instead of relying entirely on slower disk-based databases. ElastiCache supports two open-source in-memory caching engines:

Memcached
Redis
14.5. What is DMS?
Announced at re:Invent 2015, DMS stands for Database Migration Service. Allows you to migrate your production database to AWS. Once the migration has started, AWS manages all the complexities of the migration process like data type transformation, compression, and parallel transfer (for faster data transfer) while ensuring that data changes to the source database that occur during the migration process are automatically replicated to the target.

AWS schema conversion tool automatically converts the source database schema and a majority of the custom code, including views, stored procedures, and functions, to a format compatible with the target database.

14.6. AWS Database Types - Summary
RDS - OLTP
SQL
MySQL
PostgreSQL
Oracle
Aurora
MariaDB
DynamoDB - No SQL
RedShift - OLAP
Elasticache - In Memory Caching.
Memcahced
Redis
DMS