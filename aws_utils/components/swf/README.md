# AWS Developer UTILS(Bigdata,ML and Web Utils)

# SWF Amazon Simple Workflow Service (Amazon SWF)
  IT is a web service that makes it easy to coordinate work across distributed application components. Amazon SWF enables applications for a range of use cases, including media processing, web application back-ends, business process workflows, and analytics pipelines, to be designed as a coordination of tasks.
  
  Tasks represent invocations of various processing steps in an application which can be performed by executable code, web service calls, human actions and scripts.
1. SWF Workers
Workers are programs that interact with Amazon SWF to get tasks, process received tasks, and return the results

2. SWF Decider
	The decider is a program that controls the coordination of tasks i.e their ordering, concurrency and scheduling according to the application logic.

3. SWF Workers & Deciders
	The workers and the decider can run on cloud infrastructure, such as Amazon EC2, or on machines behind firewalls. Amazon SWF brokers the interactions between workers and the decider. It allows the decider to get consistent views into the progress of tasks and to initiate new taks in an ongoing manner.

	At the same time, Amazon SWF stores tasks, assigns them to workers when they are ready, and monitors their progress. It ensures that a task is assigned only once and is never duplicated. Since Amazon SWF maintains the application's state durably, workers, and deciders don't have to keep track of execution state. They can run independently, and scale quickly.

	NB. SWF a task is only assigned once and never duplicated.

	SQS a task can be done more than once and duplicated.

4. SWF Domains
	Your workflow and activity types and the workflow execution itself are all scoped to a domain. Domains isolate a set of types, executions, and task lists from others within the same account.

	You can register a domain by using the AWS Management Console or by using the RegisterDomain action in the Amazon SWF API.

	The parameters are specified in JSON format.

	https://swf.us-1-east.amazonaws.com

	Register Domain

	{

	"name": "8123124"

	"description" : "music"

	"workflorwExecutionRetentionPeriodInDays": "60

	}

	# Exam Question: Maximum Workflow can be 1 year and the value is always measured in seconds.

5. SWF vs. SQS
	i.	Amazon SWF presents a task-oriented API, whereas Amazon SQS offers a message-oriented API.
	ii.	Amazon SWF ensures that a task is assigned only once and is never duplicated. With Amazon SQS, you need to handle duplicated messages and may also need to ensure that a message is processed only once.
	iii. Amazon SWF keeps track of all the tasks and events in an application. With Amazon SQS you need to implement your own application-level tracking, especially if your application uses multiple queues.

6. QUIZ
	SWF consists of a domain, workers and deciders?
	True.
	Maintaining your application’s execution state (e.g. which steps have completed, which ones are running, etc.) is a perfect use case for SWF.
	True
	Amazon SWF is useful for automating workflows that include long-running human tasks (e.g. approvals, reviews, investigations, etc.) Amazon SWF reliably tracks the status of processing steps that run up to several days or months.
	True
	In Amazon SWF what is a worker?
	Workers are programs that interact with Amazon SWF to get tasks, process recieved tasks, and return results.
	In Amazon SWF what is a decider.
	The decider is a program that controls the coordination of tasks, i.e. their ordering, concurrency and scheduling according to the application logic.  