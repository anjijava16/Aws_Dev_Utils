# Encryption In Transit
---> Traffic between your local host and S3 is achieved via SSL/TLS

Server Side Encrption (SSE) --> Encryption At Rest

i.  SSE-AES(S3 Handles all Keys,uses AES-256 algorithm)
ii. SSE-KMS Envelope encrption,AWS KMS and you manage the Kes

iii.SSE-C Customer Provided Key (you manage the Keys)

Client Side Encryption:
You encrypt your own files before uploading them to S3


