#AWS Developer UTILS(Bigdata,ML and Web Utils)

# Amazon CloudFront
  1. Amazon CloudFront is a fast content delivery network (CDN) service that securely delivers data, videos, applications, and APIs to customers globally with low latency, high transfer speeds, all within a developer-friendly environment. CloudFront is integrated with AWS – both physical locations that are directly connected to the AWS global infrastructure, as well as other AWS services. CloudFront works seamlessly with services including AWS Shield for DDoS mitigation, Amazon S3, Elastic Load Balancing or Amazon EC2 as origins for your applications, and Lambda@Edge to run custom code closer to customers’ users and to customize the user experience. Lastly, if you use AWS origins such as Amazon S3, Amazon EC2 or Elastic Load Balancing, you don’t pay for any data transferred between these services and CloudFront.
  2. You can get started with the Content Delivery Network in minutes, using the same AWS tools that you're already familiar with: APIs, AWS Management Console, AWS CloudFormation, CLIs, and SDKs. Amazon's CDN offers a simple, pay-as-you-go pricing model with no upfront fees or required long-term contracts, and support for the CDN is included in your existing AWS Support subscription.
  3. Amazon CloudFront provides a simple API that lets you:   Distribute content with low latency and high data transfer rates by serving requests using a network of edge locations around the world.Get started without negotiating contracts and minimum commitments.
# Create a CDN:
# # Lab:
	Create bucket in a region far away from your current location (other side of the globe)
	Add image file to bucket
	Make it public
	It should be slow since it's going a far distance.

	We are going to use this S3 bucket as an origin for our CloudFront Distribution

# Two types of Cloud Front Distributions:
    1. Web -> HTTP, .html, .css etc.
	2. RTMP -> Adobe flash media servers RTMP. Used specifically for streaming videos.

For lab, let's create a Web distribution. There are a lot of settings when creating a CloudFront Distribution.

EXAM TIP: Need to know CloudFront at a high level for the exam except for some specific details (which we will go over)

1. Settings:
2.1. Origin Settings

3. Origin domain name:
4. Could use S3 buckets or Elastic Load Balancers.
5. Origin path:

Is a way to add multiple subfolders with the origin.
		Folder within the bucket for example.
		Origin Access Identity:
		Restrict bucket access to stop people from using S3 URL, and use CloudFront. Have to create a New Identity.
		Grant Read Permissions on Bucket:
		Select Yes, Update Bucket Policy. Otherwise you will have to give permissions to the user manually.
7.1.2. Default Cache Behavior Settings
	Path Pattern: Allow us to set different origin. E.g. pictures in a different origin, it will tell you which to go to.

	View Protocol Policy:

		HTTP and HTTPS
		Redirect HTTP to HTTPS
		HTTPS only
		Allowed HTTP Methods:

		GET HEAD
		GET HEAD, OPTIONS
		GET HEAD, OPTIONS, PUT, POST, PATCH, DELETE
	You can post to the bucket in option 3.
	TTL (Time to Live): How long they will live in the Edge Location. Min 0, Max is 365 days.

		TTL is always done in seconds.
		It is important to consider design, and how often we expect objects to be updated.
		TTL is difficult to clear old objects off edge locations since it has to be manually and with a charge.
		Restrict Viewer Access (Use Signed URLs or Signed Cookies):

		Yes or No.
		If you have content you want to restrict to a particular audience. Prevalidated URL, only the one person can view the URL and not share it (it is private). Once it is paid they allow you to use it.

#Note:
# Exam question: How are you going to secure CloudFront or objects in S3 so only paying customers use it?
		Answer: use presigned URL's.

#Distribution Settings:

		Web Application Firewall (WAF):
		At the application layer.
		e.g. Refuse SQL injections.
		WAF Not in Exam
		SSL Certificates:
# Defaults are available involving the *.cloudfront.net
	Custom certificates are possible, but need to be purchased and stored.
	Default for all other options.
	Select Create Distribution.

		It takes a while to provision a distribution, make changes and delete things (15min he estimates).

		Note ID is different to Domain name (can view this in general tab).

		We can create/have multiple origins.

		We can create custom Error Pages.

# Restrictions:
	Can enable GEO restrictions (can only have one):
	White List: List of locations that have access.
	Black List: List of locations that does not have access.
# Invalidations:
	Invalidating objects removes them from CloudFront edge caches/locations.
	E.g. TTL is set to 24hr and you push your objects to your edge locations. You realise you pushed a confidential file. You can't wait 24hr to take it down. You can create an invalidation so it's no longer cached on these edge locations. NB. It will cost you money.

# L52 - S3 - Security & Encryption
	8.1. Securing your buckets
	By default all newly created buckets are PRIVATE
	You can setup access control to your buckets using:
#Bucket Policies.
	Applied to entire bucket
	Access Control Lists
	Can affect specific objects
	S3 buckets can be configured to create access logs which log all requests made to the S3 bucket. This can be done to another bucket.
