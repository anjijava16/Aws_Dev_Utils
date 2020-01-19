#AWS Developer UTILS(Bigdata,ML and Web Utils)

# Route53

Elastic Load Balancers do not have pre-defined IPv4 addresses, you resolve to them using a DNS name.
The CNAME record maps a name to another name. It should only be used when there are no other records on that name. Use a CNAME record if you want to alias one name to another name.
The ALIAS record maps a name to another name, but can coexist with other records on that name. Use an ALIAS record if you’re trying to alias the root domain (apex zone).
More commonly used DNS record types:

# Record Type	Description
	A	Host Address
	AAAA	IPv6 host address
	ALIAS	Auto resolved alias
	CNAME	Canonical name for an alias
	MX	Mail eXchange
	NS	Name Server
	PTR	Pointer
	SOA	Start Of Authority
	SRV	Location of service
	TXT	Descriptive text

	Register a new domain:
	Go to Route53 > Register Domain
	Search for your domain
	Fill out the registrant contact
	Purchase your new domain
	It takes some time to register the domain… between a few hours up to 3 days.

Routing Policies
	First, let’s see how to configure routing policies:

Go to Route53 > Your domain
# Create Record Set
	Select the DNS record type.
	Also, we can set health checks on individual record sets. If a record set fails a health check it will be removed from Route53 until it passes the health check. We can set SNS notifications to alert you if health check is failing.

# Simple Routing Policy
	One record with multiple IP addresses. If you specify multiple values in a record, Route53 returns all values to the user in a random order.

# Weighted Routing Policy
	Allows you split your traffic based on different weights assigned. For example, you can set 10% of your traffict to go to US-EAST-1 and 90% to EU-WEST-1.

# Letancy Routing Policy
	Allows you to route your traffic based on the lowest network latency for your end user (ie which region will give them the fastest response time).
     To use latency-based routing, we need to create a latency resource record set for EC2 or ELB resource in each region that hosts your website.

# Fallover Routing Policy
	This is used when you want to create an active/passive set up. For example, you may want your primary site to be in EU-WEST-2 and your secondary DR Site in AP-SOUTHEAST-2. Route53 will monitor the health or your primary site using health checks.

# Geolocation Routing Policy
	Depending on our final users location.
	Geoproximity Routing Policy (Traffict Flow Only)
	Geoproximity routing lets Route53 route traffic to your resources based on the geographic location of your users and your resources. You can also optionally choose to route more traffic or less to a given resource by specifying a value, known as a bias. A bias expands or shrinks the size of the geographic region from which traffic ir routed to a resource.

# Multivalue Answer Policy
	It lets you configure Route53 to return multiple values, such as IP addresses for your web servers, in response to DNS queries. You can specify multiple values for almost any record, but multivalue answer routing also lets you check the health of each resource, so Route53 returns only values for healthy resources.

	Similar to simple routing but with health checks on each record set.

