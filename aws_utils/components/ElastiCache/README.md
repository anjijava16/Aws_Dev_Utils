# AWS Developer UTILS(Bigdata,ML and Web Utils)

# What is Elasticache?
	ElastiCache is a web service that makes it easy to deploy, operate, and scale an in-memory cache in the cloud. The service improves the performance of web applications by allowing you to retrieve information from fast, managed, in-memory caches, instead of relying entirely on slower disk-based databases. ElastiCache supports two open-source in-memory caching engines:

1.	Memcached
2.	Redis

	Elasticache is AWS’s caching service. It’s primarily used to improves performance of web applications by allowing retrieval of information from in memory cache instead of hitting slower disk databases.


	Memcached – widely adopted – memcache is compliant.No mutlii AZ support.

	Rediss – open sourced, open sets and lists, multi AZ supported.

	It allows to deploy, operate and scale an in memory cache in the cloud.
	
# Where does Elasticache make sense?
	Any situation where you are retrieving lots of data that doesn’t change that often. Such as for instance Forums or gaming websites where you have a lot more reads than you would writes. Would benefit from a caching solution.

	This is because that data will be retrieved from in memory rather than slower disk reads.

Exam tips:

You’re likely to be asked scenarios around situations where a website is under performing and then you’ll be asked to suggest an AWS service to improve it. You’ll be given options like Elasticache, read replicas and redshift and you will have to chose the most appropriate one.	