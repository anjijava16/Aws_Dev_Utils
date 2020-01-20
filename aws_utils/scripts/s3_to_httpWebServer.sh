#!/bin/bash


########################################################
##### USE THIS FILE IS YOU Start HTTPServer #####
########################################################

sudo yum install httpd -y
sudo yum update -y
sudo service httpd start

# Copy Files from S3 to Local 
aws s3 cp s3://mmtechsoft2020/index.html /var/www/html/
chkconfig httpd on

sudo service httpd restart
chkconfig httpd on
