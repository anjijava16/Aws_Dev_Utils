#AWS Developer UTILS(Bigdata,ML and Web Utils)

# Storage Gateway :

AWS Storage Gateway is a service connecting an on-premises software appliance with cloud-based storage to provide seamless and secure integration between an organization's on-premises IT environment and AWS's storage infrastructure


#Four types of Storage Gateways
	1.File Gateway (NFS)
		1.Word files, pdfs, flat files etc.
		2.stored directly on S3
	2.Volume Gateway (iSCSI)
		1.Block based storage
		2.Virtual hard disks
		3.Not stored in S3.
		4.Stored in Volumes
		5.Cached Volumes
	3.Tape Gateway (VTL)
		1.Archiving solution
		2.Virtual tapes which can be sent to S3.
		



Service that connects an on-premises software appliance with cloud-based storage to provide seamless and secure integration between an organization’s on-premises IT environment and AWS’s storage infrastructure. The service enables you to securely store data to the AWS cloud for scalable and cost-effective storage.

# Type	Description
1.	File Gateway (NFS)	
	Files are stored as objects in your S3 buckets, accessed throught a NFS mount point.

2.	Volume Gateway (iSCSI)	
	Same using virtual directories via iSCSI block protocol. Files are stored in the cloud as Amazon EBS snapshots. Two types: (1) Stored volumnes and (2) Cached volumes.

3.	Type Gateway (VTL)	
	It offers durable, cost-effective solution to archive your data in the AWS Cloud (same mecanism as Volume Gateway).		