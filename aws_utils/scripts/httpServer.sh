#!/bin/bash


########################################################
##### USE THIS FILE IS YOU Start HTTPServer #####
########################################################

sudo yum install httpd -y
sudo yum update -y
sudo service httpd start
chkconfig httpd on
echo "<html><h1> Welcome to MMTECH </h1></html>" > /var/www/html/index.html

service httpd restart
chkconfig httpd on

