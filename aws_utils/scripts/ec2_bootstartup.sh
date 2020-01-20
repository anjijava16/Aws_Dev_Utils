#!/bin/bash


########################################################
##### USE THIS FILE IS YOU Start HTTPServer #####
########################################################

yum install httpd -y
yum update -y
service httpd start
chkconfig httpd on
echo "<html><h1> Welcome to MMTECH </h1></html>" > /var/www/html/index.html




########################################################
##### USE THIS FILE IS YOU LAUNCHED AMAZON LINUX 1 #####
########################################################

# upgrade machine
sudo yum update -y

# install java 8 jdk
sudo yum install -y java-1.8.0-openjdk-devel

# set java jdk 8 as default
sudo /usr/sbin/alternatives --config java
sudo /usr/sbin/alternatives --config javac

# verify java 8 is the default
java -version

# Download app
cd /home/ec2-user
wget https://github.com/simplesteph/ec2-masterclass-sampleapp/releases/download/v1.0/ec2-masterclass-sample-app.jar

# Test the app
java -Xmx700m -jar ec2-masterclass-sample-app.jar

sudo yum install git -y
sudo yum install maven -y

cd /home/ec2-user/
mkdir lib
mkdir log
mkdir conf
cd lib 

git clone https://github.com/anjijava16/spark-java-microservice.git
cd spark-java-microservice

cd target

mvn dependency:copy-dependencies



