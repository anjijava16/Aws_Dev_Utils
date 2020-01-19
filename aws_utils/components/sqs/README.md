# AWS Developer UTILS(Bigdata,ML and Web Utils)

# 1.SQS

	Amazon SQS is a web service that gives you access to a message queue that can be used to store messages while waiting for a computer to process them.

	Amazon SQS is a distributed queue system that enables web service applications to quickly and reliably queue messages that one component in the application generates to be consumed by another component. A queue is a temporary respository for messages that are awaiting processing.

	Using Amazon SQS, you can decouple the components of an application so they run independently, with Amazon SQS easing message management between components. Any component of a distributed application can store messages in a fail-safe queue.

	Messages can contain up to 256KB of text in any format. Any component can later retrieve the messages programmatically using the Amazon SQS API.
		Exam Tip. Remember the fact the message max size is 256KB.

	The queue acts as a buffer between the component producing and saving data, and the component receiving the data for processing.

	This means the queue resolves issues that arise if the producer is producing work faster than the consumer can process it, or if the producer or consumer are only intermittently connected to the network. e.g. autoscaling or fail over
	Amazon SQS ensures delivery of each message at least once, and supports multiple readers and writers interacting with the same queue.

	A single queue can be used simultaneously by many distributed application components, with no need for those components to coordinate with each other to share the queue.

	Amazon SQS is engineered to always be available and deliver messages. One of the resulting tradeoffs is that SQS does not guarantee first in, first out delivery of messages. For many distributed applications, each message can stand on its town, and as long as all messages are delivered, the order is not important.

	If your system requires that order by preserved, you can place sequencing information in each message, so that you can reorder the messages when the queue returns them.

	To illustrate, suppose you have a number of image files to encode. In a Amazon SQS worker queue, you create an Amazon SQS message for each file specifying the command (jpeg-encode) and the location of the file in Amazon S3.

	A pool of Amazon EC2 instances running the needed image processing software does the following:

	Asynchronously pulls the task messages from the queue
	Retrieves the named file
	Processes the conversion
	Writes the image back to Amazon S3.
	Writes a "task complete" message to another queue.
	Deletes the original task message
	Checks for more messages in the worker queue

# 2. SQS Exam Tips

	Does not offer FIFO
	12 hours visibility time out
	Amazon SQS is engineered to provide "at least once" delivery of all messages in its queues. Although most of the time each message will be delivered to your application exactly once, you should design your system so that processing a message more than once does not create any errors or inconsistencies.
	256 KB message size now available
	Billed at 65KB "Chunks" (based on old message sizes)

# 3. SQS Pricing

	Firt 1 million Amazon SQS Requets per month are free
	$0.50 per 1 million Amazon SQS Requests per month thereafter ($0.00000050 per SQS Request)
	A single request can have from to 10 messages, up to a maximum total payload of 256KB.
	Each 64KB 'chunk' of payload is billed as 1 request. For example, a single API call with a 256KB payload will be billed as four requests.

# 4. SQS Developer Exam Tips

	SQS Messages can be delivered multiple times and in any order
	No FIFO
	Default visibility time out is 30 seconds
	Maximum Time out is 12 hours When you receive a message from a queue and begin processing it, you may find the visibility timeout for the queue is insufficient to fully process and delete that message. To give yourself more time to process the message, you can extend its visibility timeout by using the ChangeMessageVisibility action to specify a new timeout value. Amazon SQS restarts the timeout period using the new value.

# 5. SQS Long Polling

	SQS long polling is a way to retrieve messages from your SQS queues. While the traditional SQS short polling returns immediately, even if the queue being polled is empty, SQS long polling doesn't return a response until a message arrives in the queue, or the long poll times out. SQS long polling makes it easy and inexpensive to retrieve messages from your SQS queue as soon as they are available.

	Maximum Long Poll Time Out = 20 seconds

	Example Questions: Polling in a tight loops is burning CPU cycles and costing the company money. How would you fix this? Answer: Enable Long Polling

# 6. Fanning Out
	Create an SNS topic first using sns. Then create and subscribe multiple SQS queues to the SNS topic.

	Now whenever a message is sent to the SNS topic, the message will be fanned out to the SQS queues, i.e. SNS will deliver the message to all the SQS queues that are subscribed to the topic.

#7. Quiz
	SQS was the first service on the AWS platform?
	True
	How large can an SQS message be?
	256 KB
	What is the default visibility time out setting?
	30 seconds
	An SQS message can be delivered multiple times.
	True
	You are designing a new application which involves processing payments and delivering promotional emails to customers. You plan to use SQS to help facilitate this. You need to ensure that the payment process takes priority over the creation and delivery of emails. What is the best way to achieve this.
	Use 2 SQS queues for the platform. Have the Ec2 fleet poll the payment SQS queue first. If the queue is empty, then poll the promotional emails queue.
	Your EC2 instances download jobs from the SQS queue, however they are taking too long to process them. What API call can you use to extend the length of time to process the jobs?
	ChangeMessageVisibility
	What is the default visibility time out?
	30 seconds
	You have a fleet of EC2 instances that are constantly polling empty SQS queues which is burning CPU compute cycles and costing your company money. What should you do?
	Enable SQS Long Polling
	What is the maximum long poll time out?
	20 seconds
	What amazon service can you use in conjunction with SQS to "fan out" SQS messages to multiple queues.
	SNS	