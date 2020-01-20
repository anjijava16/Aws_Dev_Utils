# AWS Developer UTILS(Bigdata,ML and Web Utils)


# Aurora Introduction 
	AWS Aurora is a relational database engine that combines the speed and reliability of high-end commercial databases with the simplicity and cost-effectiveness of open source databases.
	Amazon Aurora (Aurora) is a fully managed, MySQL- and PostgreSQL-compatible, relational database engine i.e. applications developed with MySQL can switch to Aurora with little or no changes
	Aurora delivers up to 5x performance of MySQL without requiring any changes to most MySQL applications
	Aurora PostgreSQL delivers up to 3x performance of PostgreSQL.
	RDS manages the Aurora databases, handling time-consuming tasks such as provisioning, patching, backup, recovery, failure detection and repair.
	Based on the database usage, Aurora storage will automatically grow, from 10GB to 64TB in 10GB increments with no impact to database performance
# Aurora read replicas
	For Aurora there are 2 types of read replicas:

	Aurora replicas – essentially Aurora duplicate database (currently upto 15)
	MySQL Read Replicas (currently 5)

# Key Points

  Aurora automatically maintains 6 copies of your data across 3 AZs and will automatically attempt to recover your database in a healthy AZ with no data loss
  
# Aurora Summary

	2 copies of data in each AZ, with min of 4 AZs so 6 copies of your data
	Supported by read replicas
	Can handle 2 data node losses and still function for effect writes
	Can handle 3 data node losses while maintaining effective reads.
	Supports up to 15 aurora replicas
	Supports up to 5 MySQL replicas
	1 – 35 day backup period
	Encrypted at REST
	Runs on Virtual machine – single point of failure. Although the data is replicated, the instance only running on single node.
	
	Aurora is AWS’s in house relational database implementation. It is MySQL compatible and yet outperforms it by 5 times. Making it a true competitor to the enterprise level databases such as Oracle and MSSQL.

	2 copies of data in each AZ, with min of 4 AZs so 6 copies of your data
	Supported by read replicas
	Can handle 2 data node losses and still function for effect writes
	Can handle 3 data node losses while maintaining effective reads.
	Supports upto 15 aurora replicas
	Supports upto 5 MySQL replicas	