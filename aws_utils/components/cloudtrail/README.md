# AWS Developer UTILS(Bigdata,ML and Web Utils)

# CloudTrail: Auditing && LOgging

# Automatically identify and respond to anomalous API activity across your accounts.

# Key Points:
   1. CloudTrail is enabled on your AWS accounts when you create it
   2. CloudTrail fouces on auditing API activity
   3. Cloud Trail is a service that enables governacne,complicance,operation auditing and risk auditing of your aws account.
   4. with Cloudtrail you can log,continuously monitor,and retain account activy releated to actions across yours aws infrastracture.
   5. Cloudwatch Logs to monitor log data .Cloud Trail events that are sent to Cloudwatch logs can trigger alarms accoring to the metric filter you define 
   
   
 #Note:
  CloudWatch is monitoting service for AWS Resources and applications .
  CloudTrail is a web Services that records API activity in you aws account 
  Both are useful monitoting tools in AWS 

# 

AWS CloudTrail increases visibility into your user and resource activity by recording AWS Management Console actions and API calls. You can identify which users and accounts called AWS, the source IP address from which the calls were made, and when the calls occurred.


# Trail : to archive ,analyze and respond to changes in your aws resources 
  1. Cloud Trail that applies to all regions
  2. Cloud Trail that applies to one region 
  3. By default cloud trail event log files are encrypted using amazon s3 server side encryption .You can also choose to encrypt your log fils with AWS key Management Service Key
  4. You can store your log files in your S3 Bucket for as long as you want and also define S3 Lifecycle rules to archive or purge or delete log files automtically
  5. CloudTrail publishes log files about every 5 minutes 
  6. Deliver logs to an Amazon S3 bucket. CloudTrail events can be processed by one trail for free. 
  7. Events:
                 Management Events: Logged by default 
				 Data Events:
				    Not by default 
					Data events provide into the resource operations perfomred on or in a resource also know as data plane operations
					Data events are often high volume activites 
					
# Monitoring 
     1. Use CloudWatch Logs to montior log data .Cloud Trail events are sent to cloudwatch logs can trigger alarms accoring to the metric filters you define 
		   