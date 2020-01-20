# s3 make bucket (create bucket)
aws s3 mb s3://tgsbucket --region us-west-2

# s3 remove bucket
aws s3 rb s3://tgsbucket
aws s3 rb s3://tgsbucket --force

# s3 ls commands
aws s3 ls
aws s3 ls s3://tgsbucket
aws s3 ls s3://tgsbucket --recursive
aws s3 ls s3://tgsbucket --recursive  --human-readable --summarize

# s3 cp commands
aws s3 cp getdata.php s3://tgsbucket
aws s3 cp /local/dir/data s3://tgsbucket --recursive
aws s3 cp s3://tgsbucket/getdata.php /local/dir/data
aws s3 cp s3://tgsbucket/ /local/dir/data --recursive
aws s3 cp s3://tgsbucket/init.xml s3://backup-bucket
aws s3 cp s3://tgsbucket s3://backup-bucket --recursive

# s3 mv commands
aws s3 mv source.json s3://tgsbucket
aws s3 mv s3://tgsbucket/getdata.php /home/project
aws s3 mv s3://tgsbucket/source.json s3://backup-bucket
aws s3 mv /local/dir/data s3://tgsbucket/data --recursive
aws s3 mv s3://tgsbucket s3://backup-bucket --recursive

# s3 rm commands
aws s3 rm s3://tgsbucket/queries.txt
aws s3 rm s3://tgsbucket --recursive

# s3 sync commands
aws s3 sync backup s3://tgsbucket
aws s3 sync s3://tgsbucket/backup /tmp/backup
aws s3 sync s3://tgsbucket s3://backup-bucket

# s3 bucket website
aws s3 website s3://tgsbucket/ --index-document index.html --error-document error.html

# s3 presign url (default 3600 seconds)
aws s3 presign s3://tgsbucket/dnsrecords.txt
aws s3 presign s3://tgsbucket/dnsrecords.txt --expires-in 60
1. Create New S3 Bucket
Use mb option for this. mb stands for Make Bucket.

The following will create a new S3 bucket

$ aws s3 mb s3://tgsbucket
make_bucket: tgsbucket
In the above example, the bucket is created in the us-east-1 region, as that is what is specified in the user’s config file as shown below.

$ cat ~/.aws/config
[profile ramesh]
region = us-east-1