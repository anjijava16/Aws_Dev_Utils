# AWS Developer UTILS(Bigdata,ML and Web Utils)

# AWS Redhshift

A single RedShift node is 160GB in size. You could run a smaller companies data analysis on a single node.
		
 RedShift can also be setup to use multiple nodes. This scenario is more suited for massive multinational companies that need huge amounts of data analysed.

 Multi Node configurations are composed of:

i.	Leader Node (manages client connections and reviews queries)
ii. Compute Node (store data and perform queries and computations) upto 128 compute nodes

# RedShift doesn’t store data like a traditional RDS

	Rather than using row based storage, RedShift uses columnar storage. This is where data is stored in vertical columns. Advantages of this approach include:

	Faster queries around 10 times faster since when performing queries on columnar data stores the adjacent row data isn’t included.

	Data can be compressed much more effectively since the data is stored in columns we know that the data type is the same for each data value.

	Massive parallel processing MPP – means redshift can distribute query load across all nodes evenly. Meaning that even if your data grows over time, you’re queries should still perform well.

# Wrapping up RedShift

	Redshift is only available in 1 AZ, which makes sense since it’s not the same as a production database that needs to be highly available and running 24/7. Redshift is more suited for management level tasks such as analysing sales figures for products

	Pricing is based per compute nodes, just like all AWS services you pay only for what you use. The pricing structure is 1 unit per node per hour. Where you have a multi node setup, you would not be charged for the leader node.

	Security data is encrypted in transit and encrypted at rest AES 256 encryption. Keys are by default managed for you.

	Exam tips

	Redshift – database warehousing service

	It is very fast

	It is very cheap relative

	It is on of AWS most popular services
		