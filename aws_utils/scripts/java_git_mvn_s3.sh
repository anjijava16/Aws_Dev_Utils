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
# wget https://github.com/simplesteph/ec2-masterclass-sampleapp/releases/download/v1.0/ec2-masterclass-sample-app.jar

# Test the app
#java -Xmx700m -jar ec2-masterclass-sample-app.jar

# Login AS SU User 
sudo su 

# Install Git 
yum install git -y

# Install Maven 
yum install maven -y

exit

git clone https://github.com/anjijava16/spark-java-microservice.git

cd spark-java-microservice

mvn clean install

cd /home/ec2-user/

mkdir mmtech-services
cd mmtech-services
mkdir lib
mkdir log
mkdir conf
mkdir bin

#cd lib 

# cp /home/ec2-user/spark-java-microservice/
# cd /home/ec2-user/mmtech-services/lib

cp /home/ec2-user/spark-java-microservice/target/*.jar /home/ec2-user/mmtech-services/lib/

cd /home/ec2-user/mmtech-services/bin

echo "java -jar /home/ec2-user/mmtech-services/lib/spark-java-microservice-1.0-SNAPSHOT.jar" > /home/ec2-user/mmtech-services/bin/start.sh

chmod 777 start.sh

sh start.sh 

cd  /home/ec2-user/

rm -r -f spark-java-microservice/
 
zip -r mmtechservices.zip mmtech-services/
 
mmtechservices.zip

current_date="$(date +'%m-%d-%Y')"

aws s3 cp  mmtechservices.zip "s3://mmtech-ec2-data/"$current_date"/"




