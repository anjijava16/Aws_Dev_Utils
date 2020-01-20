# AWS Developer UTILS(Bigdata,ML and Web Utils)

# Lambda: Server less based architectures .

	AWS Lambda is a compute service where you can upload your code and create a Lambda function. 
	AWS Lambda takes care of provisioning and managing the servers that you use to run the code. 
	You don’t have tow orry about operting systems, patching, scaling, etc.
	Lambda scales out automatically. Supported languages: Node.js, Java, Python, C#, Go and Powershell. 
	The AWS X-Ray service is used to troubleshot issues with lambda functions.

	The exact ratio of cores to memory has varied over time for Lambda instances,
	however Lambda like EC2 and ECS supports hyper-threading on one or more virtual CPUs (if your code supports hyper-threading).

# How lambda is triggered:

	As an event-driven in responde to events. These events could be changes to data in S3 bucket or an Amazon DynamoDB table.
	As a compute service to run your code in response to HTTP requests using Amazon API gateway or API calls made using AWS SDKs.
	One lambda function can trigger other lambda functions.
	
# Pricing
	By number of requests: first 1 million requests are free. Then $0.20 per 1 million requests thereafter. By duration which is calculated from the time your code begins executing until it returns or otherwise terminates, rounded up to the nearest 100ms. The price depends on the amount of memory you allocate to your function. You are charged $0.00001667 for  every GB-second used.	