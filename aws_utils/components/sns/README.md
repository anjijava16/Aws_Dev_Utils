#AWS Developer UTILS(Bigdata,ML and Web Utils)

# SNS

----------------------------
```
SNS is a web service that makes it easy to set up, operate, and send notifications from the cloud. It provides developers with a highly scalable, flexible, and cost-effective capability to publish messages from an application and immediately deliver them to subscribers or other applications.

```

SNS : EVENT -DRIVEN computing hub that has native integration with a wide variety of 

AWS Event sources: EC2,S3 and RDS

AWS Event Destinations: SQS ,Lambda 

Messaage Filtering

#Message fanout: 
		Occurs when a message is sent to a topic and then repliated ad pushed to multiple endpoints ,
		Fanout provides asynchronous event notifications,which in turn allows for parallel processing 
   

SNS Mobile Notifications

Publisher and Subscribers:


Publisher ---> SNS ---> Subscribers --> (Lambda,SQS,HTTP/S, Email,SMS )

Publisher Create topics to send messages,while subscribers subscribe to topics to receive messages
SNS doesn't support forwarding messages to SQS FIFO queues, you can use SNS to forward messages to Standard Queues


# Limits:
   By Default SNS offers 10 million subscriptions per topic ,and 1000,000 per topics per account
   A single SMS message can contain a max of 140 byes of information
   With the exectptions of SMS messages ,SNS messages can contains upto 256 KB of text data
   
   
#SNS vs. SQS
	Both Messaging Services in AWS
	SNS - Push
	SQS - Polls (pulls)
	Users pay $0.50 per 1 million SNS Requests
	$0.06 per 100, 000 Notification deliveries over HTTP
	$0.075 per 100 Notification deliveries over SMS
	$2.00 per 100,000 Notification deliveries over Email   
   
 # Security 
  SNS Supports VPC endpoints via AWS privateLink ,you can use VPC endpoint to privately publish messages to SNS Topics from a VPC without travesing the public interest.

 # Monitoring
   
   Monitoring SNS topics using CloudWatch:
       CloudWatch: CloudWatch is a monitoring service to monitor your AWS resources, as well as the applications that you run on AWS. Metrics like CPU, network, disk, status check.
			 Dashboards: Creates awesome dashboards to see what is happening with your AWS environment.
			 Alamrs: Allows you to set Alarms that notify you when particular thresholds are hit.
			 Events: Helps you to responde to state changes in your AWS resources.
			 Logs: Aggregates log data.
	   
   
   Logging SNS API call using CloudTrail
   
# Quiz 
	SNS is pull based rather than push based?
	False
	Which of these is a protocol NOT supported by SNS;
	FTP
	Messages cannot be customised for each protocol used in SNS?
	False
	You have a list of subscribers email addresses that you need to push emails out to on a periodic basis. What do you subscribe them to?
	A Topic
	You can use SNS in conjunction with SQS to fan a single message out to multiple SQS queues.
	True

