# AWS Developer UTILS(Bigdata,ML and Web Utils)

#S3
	Secure, durable, highly-scalable object storage. The basics:

	S3 is Object-based. An object is a key (the name), value (the content of the file in bytes), a version ID (important for versioning), some metadata and other subresources (like access control lists and torrent).
	Files can be from 0 Bytes to 5 TB.
	There is unlimited storage.
	The objects are organised in buckets, that are like folders. The bucket name must be unique globally.
	The objects are directly available when adding new objects, but there will be eventual consistencies on updates (PUTS and DELETES).
	99.9(…)% availability and 99.9999999999 durability.
	Tiered Storage available: Store objects in different tiers with different availability configuration (to save up money).
	Lifecycle Management: it allows to move your objects in different tiers depending on the activity and time windows to save up money. It also can be used to configure expiration.
	Versioning: Have multiple versions of objects. Once enabled versioning, it cannot be disabled.
	Encryption: SSL/TLS (transport connection). SS3-S3 (server side encryption)
	MultiFactor authentitcation for deleting objects
	Secure your data using access control lists or using bucket policies.
#Storage Classes
	S3 Standard
	S3 IA: Infrequently Accessed but requires rapid access. Lower fee then standard, but you’re charged a retrieval fee.
	S3 One Zone - IA: Infrequently Accessed and do not require the multiple availability zones. Lowest option.
	S3 Intelligent Tiering: Use machine learning to configure the objects around storage classes to the most cost-effective option.
	S3 Glacier: For data archiving. Secure, durable, low-cost storage. Retrieval times configurable from minutes to hours.
	S3 Glacier Deep Archive: Same as above but it allows retrieval times of 12 hours.
	
# 3. S3 - Exam Tips for S3 101
	Remember that S3 is Object based i.e. allows your to upload files.
	Files can be from 0 Bytes to 5TB
	There is unlimited storage
	Files are stored in Buckets
	S3 is a unviersal namespace, that is, names must be unique globally (and lowercase).
	https://s3-eu-west-1.amazon.com/acloudguru
	Read after Write consistency for PUTS of new Objects
	Eventual Consistency for overwrite PUTS and DELETES (can take some time to propagate)
	S3 Storage Classes/Tiers
	S3 (durable, immediately available, frequently accessed)
	S3 - IA (durable, immediately available, infrequently accessed)
	S3 - Reduced Redundancy Storage (data that is easily reproducible, such as thumb nails etc).
	Glacier - Archived data, where you can wait 3-5 hours before accessing.
	Remember the core fundamentals of S3;
	Key (name)
	Value (data)
	Version ID
	Metadata
	Access Control Lists
	Object based storage only (for files)
	Not suitable to install an operating system on.
# 4. S3 - Versioning
	Stores all version of an object (including all writes and even if you delete an object)
	NB. If you have a 1GB object and you update it 10 times, you will pay for 10GB of storage.
	Great backup tool
	Once enabled, Versioning cannot be disabled, only suspended.
	Integrates with Lifecycle rules
	Versioning's MFA (Multifactor Authentication) Delete capability, which uses multi-factor authentication can be used to provide an additional layer of security.
	Cross Region Replication, requries versioning enabled on the source bucket and destination bucket.
# 5. S3 - Lifecycle Management
	Can be used in conjunction with versioning
	Can be applied to current versions and previous versions
	Following actions can now be done;
	Transition to the Standard - Infrequent Access Storage Class (128KB and 30 days after the creation date)
	Archive to the Glacier Storage Class (30 days after IA, if relevant)
	Permanently Delete	
# 6 Securing your buckets
	By default, all newly created buckets are PRIVATE
	You can setup access control to your buckets using;
	Bucket Policies
	Access Control Lists
	S3 buckets can be configured to create access logs which log all requests made to the S3 bucket. This can be done to another bucket.
# 7 Encryption
	In Transit;
	SSL/TLS
	At Rest
	Server Side Encryption
			  i. 	SSE -S3 (Amazon S3 Managed Keys)
			  ii.   SSE-KMS( AWS KMS Managed Keys)
			  iii.  SSE-C (Customer Provided Keys)
	Client Side Encryption Using   
	         i. AWS KMS Managed Customer master Key 
			 ii. Client Side Master Key 
	
	
# S3 Notifications 
  Can published events : New object create event,object removal event, reduced redunadancy storage(RRS) object lost event 
  Destinations events : SNS Topic,SQS Queue ,AWS lambda 
  
	