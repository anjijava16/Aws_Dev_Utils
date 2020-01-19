#AWS Developer UTILS(Bigdata,ML and Web Utils)

#VPC Peering:
	It is Jst networking connection between 2 VPCS.
	and not between yours on premises data center and VPC.
	You can create a VPC peering connection between your own VPCs with a VPC in another AwS account or with VPC in different AWS region
	Doesn't support Edge to Edge routing 

#Egress Only Internet Gateway :
	this works like a NAT gateway but for IPV6 traffic only.an egress only internet gateway is a horizontally scaled ,redundat,and highly avaiable VPC componets that allows outbound communications over IPV6 from instances in yours VPC to the internet  and prevent the internet from initiating an IPV6 connection with yours instancess.

#Virtaul Private Gateway : 
	Can link  your data center(or network) to yours amazon vpc .
	A Custom Gateway is the another or your side of the Connection it can be a phiscial or software application the anchor on the AWS side of the VPN Connection is called Virtaul private Gateway VPC 


