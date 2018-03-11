# AWS Dev Utils(EC2,EMR,S3,Lambda,SES,SQS,SNS,RDS,API GateWay,DyanamoDB,ELB,Glacier,Kinesis,ElasticBeanStalk,Route 53)



 ## Week1 (AWS EC2,EBS(Elastic Black Storage)
1)Region: Area Physical location which consists of 2 or more availiabity zones 
2)Avaiablity ZOne: Data Ceneters,each with reduandant power,networking and connectivty and housed in separate facititles(Data Centers)
3)Edge Location : are endpoints for aws which are used for caching content .
   Typally the consists of cloud front ,amazon contenet delivery contenet (CDN) Contenet Delivery network
    

what is the difference between edge and avaliablity zone

Edge: Cache

avaliablity zone: DataCenter

EC2 

i)EC2 --Windows /Linux

ii) Limits ==> EC2 is allowin the requesting the 

8 CPUS
32 GB RAM

m5.16

General Purpose
T2
M4
 large
 xlarge
 2xlarge
 4xlarge
 10xlarge
M4


Compute-optimized instances
C4

C4 instances types:
 large
 xlarge
 2xlarge
 4xlarge
 8xlarge

Memory Optimized
X1
R3

GPU 
 G2

Storage Optimized 
  I2

Dense-storage Instances
  D2
  
  Vigiza: aws (subNet) 
  
   yum install java
   useradd  abc
    passwd abc
	yum repolist all

============================================================================================
# Password Change in AWS Server restarting  in sshd service 

Step 1) sudo su

vi /etc/ssh/sshd_config

 2 changes 
1)uncommant permitRootLogin(PermitRootLogin yes)
2)PasswordAu  yes (no to Yes) 


Step 2:  Restart the sshd service
Syntax: service sshd restart




yum install http* -y
service httpd restart



Step 4: http URL :
54.144.181.173

===========================================================================================
# Week 2: (Load Balancer & Auto Scalling Configuration )

HardDisk

fdisk -l

sudo su -
fdisk -l

How to add volume 10 GB Data
Goto--> View -->Volume

Volume Type==> 
 Gp2: General
 Provisioned IOPS : (Database Interaction)
 Cold HDD : N (Complete HardDisk)
 Throughput Optimized HDD
  Availability ZONE * 
  
  Volume must be same dataCenter
  
  Click Attach Volume ==>
  
  fdisk /dev/xvdf
  mkdir /apps
  mount /dev/xvdf1 /apps
  mkfs  /dev/xvdf1 (formated)
  
  Increase the Volume : In Volume add Volume >>>Modified 
   Adding 5GB (Increasing the Volume(exising Volume)) take 6 hours time
   
   umount /apps
   fdisk -l
   
   
   mount /dev/xvdf1 /apps
   cd /apps
   
   umount /apps/
   Change Auto -Enable IO Settings: Add more
   
   WIndows --> Server Manager --> File And Storage--> Disks -->Bring Online ---> Format the Disk -->New Volume -->Next -->Create ...
   
   Elastic IP: Charge IPS
   (Fixed IPS )
   
   Network Interface ::
   ifconfig -a
   Create Serer --> Goto Network Interface --> attache here
   
   ifconfig -a
     Here 2 interface 
	 
	 
	 Load Balancer
	 
	 WebServer Server --> Role --> IIS 
	 
	 
	 Linxu Server ::==> 
	 yum install http* -y
	 sudo su -
	 service httpd restart
	 
	 Create Load Balacer 
	   i)Application Load Balncer
	   ii) Net
	   
	   Step4 : Configure Health Check
	   
	   http
	   
	   Server Manager:
	   
	   IIS : Ine
	   
	   yum install http* -y
	   cp -rf * /var/ww
	 
	 ====================================================================================
	 
	 http: Round Robin Alogrithm
	 
	 Creating Target Group :==>
	  
	 
   
   Auto Scaling Group
   
   i)Create Launch Configuration
    
   ii)Create Auto Scaling Group
   
   IIS Server Instation
   Step1 :Add roles and features
3 next
4 Next Slect IIS
next next nxt install
   
   IIS --RightClick _Internet


   https://docs.aws.amazon.com/systems-manager/latest/userguide/sysman-install-startup-linux.html
   
   
   /bin/bash
cd /tmp
sudo yum install -y https://s3.amazonaws.com/ec2-downloads-windows/SSMAgent/latest/linux_amd64/amazon-ssm-agent.rpm
sudo systemctl start amazon-ssm-agent

yum install java 



Auto Scaling Group
i) Launch configuration
ii)Create Auto Scalling Group


#!/bin/bash
yum install httpd* -y
yum update -y
aws s3 cp s3://mybucket/index.html /var/www/html/
service httpd start
chkconfig httpd on


HardDisk

fdisk -l

sudo su -
fdisk -l

How to add volume 10 GB Data
Goto--> View -->Volume

Volume Type==> 
 Gp2: General
 Provisioned IOPS : (Database Interaction)
 Cold HDD : N (Complete HardDisk)
 Throughput Optimized HDD
  Availability ZONE * 
  
  Volume must be same dataCenter
  
  Click Attach Volume ==>
  
  fdisk /dev/xvdf
  mkdir /apps
  mount /dev/xvdf1 /apps
  mkfs  /dev/xvdf1 (formated)
  
  Increase the Volume : In Volume add Volume >>>Modified 
   Adding 5GB (Increasing the Volume(exising Volume)) take 6 hours time
   
   umount /apps
   fdisk -l
   
   
   mount /dev/xvdf1 /apps
   cd /apps
   
   umount /apps/
   Change Auto -Enable IO Settings: Add more
   
   WIndows --> Server Manager --> File And Storage--> Disks -->Bring Online ---> Format the Disk -->New Volume -->Next -->Create ...
   
   Elastic IP: Charge IPS
   (Fixed IPS )
   
   Network Interface ::
   ifconfig -a
   Create Serer --> Goto Network Interface --> attache here
   
   ifconfig -a
     Here 2 interface 
	 
	 
	 Load Balancer
	 
	 WebServer Server --> Role --> IIS 
	 
	 
	 Linxu Server ::==> 
	 yum install http* -y
	 sudo su -
	 service httpd restart
	 
	 Create Load Balacer 
	   i)Application Load Balncer
	   ii) Net
	   
	   Step4 : Configure Health Check
	   
	   http
	   
	   Server Manager:
	   
	   IIS : Ine
	   
	   yum install http* -y
	   cp -rf * /var/ww
	 
	 
	 http: Round Robin Alogrithm
	 
	 Creating Target Group :==>
	  
	 
   
   Auto Scaling Group
   
   i)Create Launch Configuration
    
   ii)Create Auto Scaling Group
   
   IIS Server Instation
   Step1 :Add roles and features
3 next
4 Next Slect IIS
next next nxt install
   
   IIS --RightClick _Internet


   https://docs.aws.amazon.com/systems-manager/latest/userguide/sysman-install-startup-linux.html
   
   
   /bin/bash
cd /tmp
sudo yum install -y https://s3.amazonaws.com/ec2-downloads-windows/SSMAgent/latest/linux_amd64/amazon-ssm-agent.rpm
sudo systemctl start amazon-ssm-agent

yum install java 



Auto Scaling Group
i) Launch configuration
ii)Create Auto Scalling Group


#!/bin/bash
yum install httpd* -y
yum update -y
service httpd start
aws s3 cp s3://mybucket/index.html /var/www/html/
service httpd start
chkconfig httpd on


sqoop import  
--connect jdbc:oracle:thin:@server1.companyxyz.com:4567/prod/DATABASE=schema1
--username xyz 
--password xyz 
--table customers
--columns cust_id, name, address, date, history, occupation  
--where item>=1234 
--target-dir /tmp//customers
--m 8
--split-by cust_id
--fields-terminated-by , 
--escaped-by \ 
--hive-drop-import-delims  
--map-column-java
  cust_id=string, name=string, address=string, date=string, history=string, occupation=string
  
=============================================================================================================
# Week 3 ::IAM Rules Engine 

Super User
Adminstar
Normal User

--------------------------
IAM ---> Dashboard -->
Groups:->> Create New Group 

Policies ===>


# Policy Generaor : 
https://awspolicygen.s3.amazonaws.com/policygen.html

=============================================================================

AWSAccessKeyId=AKIAJ4TTQPWNHRAVGFEAZZZ
AWSSecretKey=ryjOAU0GVXagdDigiYlj1DqCDDDFjlCtr2uznYu1C67
https://cloudcraft.co/pricing
morganmine


   Elastic BeansStalk
i)Elastic beansstalk from computDomain
ii)Create new appplication and select environment
iii) create small web applications and from ecplise deploy war file in aws

iv)AWS CodeCommit: Source
v)Aws CodeBuild: Build
vi)Aws BeansStalk: Deploy
vii)AWS CloudWatch: Montioring

Instance Types
i) General purposes
 T2,T1  M3 and M4
ii)Compute optimised
C3,C4 ,C1,cC2
iii) Storage and IO optimised
I2,D2,HS1
iv) GPU enabled
G2,CG1
v) Memory optimised
R3,M2,CR1

C4.xlarge (Compute -Optimized)

C ==> Family 
4 ==> Generation
xLarge: Types
Compute-Optimized ==> Family

Tomcat ::
sudo yum install tomcat8

sudo service tomcat start

100 Buckets for account

5GB File directly More than 5 GB : Multiple Upload API


Secuirty --> IAM --> Delete yours root access Keys -->Manage Secuirty Creds --> Get Stared with IAM Users-->

Next Permission -->


create new Role --> RoleName --> Ex: ec2-s3-fullaccess


Create Role ==> EC2-s3 polices

Predefined Polices

{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": "s3:*",
            "Resource": "*" 
        }
    ]
}


S3 CLI Commands
Help: aws s3 help
Help on command Level: aws s3 mb
aws s3 mb s3://anjim2018feb18
aws s3 ls elasticbeanstalk-us-east-1-281776252949
aws s3 ls jaisriramsri-2018feb1702 --recursive
aws s3 ls jaisriramsri-2018feb1702 --recursive --human-readable --summarize
pip install awscli
sudo pip install awscli
pip install --upgrade awscli


Local to S3 
aws s3 ls s3://ac --recurive

aws s3 mb s3://chenat2018 --region us-west-1

aws s3 cp sriram.perm s3://mywelcme

aws s3 ls s3://myworkwelcome20171212
aws s3 rb s3://welcomedev-driramsri-15022019
aws s3 rm s3://myworkwelcome20171212/sriramsri_old.pem
 
S3 to Local
 aws s3 mv s3://myworkwelcome20171212/sriramsri_old.pem .
 aws s3 rm s3://myworkwelcome20171212/sriramsri_old.pem
 
 
 Single Local File and S3 Object Operations
  cp
  mv
  rm
  
  Directory and S3 Prefix Operations
  sync
  rb
  mb
  ls
  aws s3 cp /tmp/foo/ s3://bucket/ --recursive --exclude "*" --include "*.jpg"
  
  aws s3 cp /tmp/foo/ s3://bucket/ --recursive    --exclude "*" --include "*.jpg" --include "*.txt"
  
  ========================================================
  
  ARN: Amazon Resource Name
  arn:aws:iam::aws:policy/AdministratorAccess
  
  
  ==========================
  pip install boto3
  
  RDS
  DynamicDB
  ElasticCache: Keep inside the Cache (perfomance Increase)
  RedShift(Data WareHouse)
  
  
  package shade:shade

#########################################################################################
########################### Lambda +RDS /DynamicDB +GateWay   ############################
#########################################################################################  
AWS +API GateWay==>Lambda===> RDS 
https://www.youtube.com/watch?v=VW8aejQO-YI&t=322s  --->1 RDS 
https://www.youtube.com/watch?v=opFFz6QNiSg         --->2 RDS +Lambda 
https://www.youtube.com/watch?v=zSOGyHSsSH4         ---> 3 API-GateWay+RDS +Lambda

POC: 
 
create tabl emp(empid varchar(20),name varchar(60));
  
 Role : Roles --> AWS Lambda--> Search AWSLambdaVPCAccessExecutionRole (MysqlTest)---> Attached Policy -->Amazon RDSFullAccess (policy) 
 AWS +API GateWay==>Lambda===> DynamicDB
  https://www.youtube.com/watch?v=n9xewGY2DIY&t=18s  1
  https://www.youtube.com/watch?v=uxWq3z5KD_U&t=1s  2
  https://www.youtube.com/watch?v=wCzydRR8cbE&t=2s  3
  
  
  
 
#########################################################################################
########################### Lambda +RDS /DynamicDB +GateWay   ############################
#########################################################################################  
 
=============================================================================
# AWS Project Intergration

#EC2(Event Stopped) ---> Lambda --> SNS(Topic)---> SNS Subscribers 

Requird AWS Resources
i)EC2
ii)SNS Topic
iii)IAM Role for Lambda SNS Topic and CloudWatch Logs
iv)Lambda (Python)
v)CloudWatch Events - to Schedule

================================================
Create SNS Topic ::

Crate new Topic 
  TopicName: prod_alerts
  DisplaName prod_alerts

AddSubScruber to Topic:
  Select Topic(prod_alerts)->Actions (subscribe to topic) -> 
  Create Subscription:
   Protocal : Email
   Endpoint: anjaiahspr@gmail.com

================================================
IAM Role 
  IAM--> Policies -->Create Polices ---> Search 
SNS --->
  Action: Manula Actions
Resournces : all resources 
One more is Cloud Watch Giving 
   Action: All Cloud Actissources
Review the policy :
  Name: SNS_CloudWathc_logs_Prod_alerts
  create Policy

Roles ==> Aws Services (EC2,Lambad)==>Lambda
Attached role


================================================
Lambda :

Step 1::
===================
Create a New function
Name: prod_alerts
RuneTime: Python3.6
Role: Choose an exisiting role
Existing role: sns_cloudwatch_logs_prod_alerts


python:
import boto3
sns= boto3.client('sns')
def lambda_handler(event,context):
 topic_arn='arn:aws:sns:ap-south-1:281776252949:Stop-7the_Instance'
 message='Prod serve stopped ,please took'
client:publish(TopicArn=topic_arn,Message=message)

Step 2::
===================
Add Triger:==> Select Cloud Watch Events
 Create new rule
  RuleName: prod_alerts
  Rule Type : EVent Pattern
  EventPattern: EC2
  AllEvents : EC2 Instacs State-change notification
Details
State
 Sto xss118
  ADD


prod_alerts: Lambda
CloudWatch_Events: Event Sources
SNS/CloudWatchLogs:pubshlier



import boto3
client=boto3.client('sns')


def lambda_handler(event, context):
    
     topic_arn='arn:aws:sns:ap-south-1:281776252949:Stop-7the_Instance'
    
     message='Prod serve stopped'
    
     client.publish(TopicArn=topic_arn,Message=message)
==============================================================================================================
