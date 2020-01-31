# AWS Developer UTILS(Bigdata,ML and Web Utils)
# AWS KMS

aws kms encrypt --key-id 64dbfdcc-8519-4f8f-a1b2-d704e652259b --plaintext file://aws_s3.py


Step 1: GIT Bash 
Step 2:   AWS KMS Encrypt Command

# Encryption Process 
aws kms encrypt --key-id 080fd8f4-816a-4e5a-abbe-b7f24fddb41d --plaintext aws_s3.py

Output:
{
    "CiphertextBlob": "AQICAHinlfOCfr3eatflB9dXM1OKwDO6E98ykRmp3FylYaASdwGjUV6ENaUZ2mMnMK7UNrXOAAAAZzBlBgkqhkiG9w0BBwagWDBWAgEAMFEGCSqGSIb3DQEHATAeBglghkgBZQMEAS4wEQQMgRVNUtJ487VvwhzXAgEQgCSME83edM/6G5282pLTYB5CkoPKuNmWWgWE0mFAIUlmJTXyc0g=",
    "KeyId": "arn:aws:kms:us-east-2:927962363153:key/080fd8f4-816a-4e5a-abbe-b7f24fddb41d",
    "EncryptionAlgorithm": "SYMMETRIC_DEFAULT"
}



Step3: Extracting the CiphertextBlob as text

Syntax: aws kms encrypt --key-id 080fd8f4-816a-4e5a-abbe-b7f24fddb41d --plaintext aws_s3.py --output text --query CiphertextBlob

Output: AQICAHinlfOCfr3eatflB9dXM1OKwDO6E98ykRmp3FylYaASdwFqD/GQu5cS82wJ4lbJzPJBAAAAZzBlBgkqhkiG9w0BBwagWDBWAgEAMFEGCSqGSIb3DQEHATAeBglghkgBZQMEAS4wEQQMQtqKwW/zIW8CvVF9AgEQgCQ7csSkJPOmSP6YglWmqBAaZxfELI+dLQRsD4ScJirbImUpaNk=



Step 4:(Decoding Base64 to Binary)

aws kms encrypt --key-id 080fd8f4-816a-4e5a-abbe-b7f24fddb41d --plaintext aws_s3.py --output text --query CiphertextBlob | base64 --decode > secrets.aws_s3.json
aws kms encrypt --key-id 080fd8f4-816a-4e5a-abbe-b7f24fddb41d --plaintext aws_s3.py --output text --query CiphertextBlob  > secrets.aws_s3.json
# aws kms encrypt --key-id 3e80eed7-2c7e-48a4-8ef2-b4072c33f27b --plaintext file://secrets.json --output text --query CiphertextBlob > secrets.base64.json


# Decrypt Process 

aws kms decrypt --ciphertext-blob secrets_aws_s3.py --output text --query Plaintext | base64 --decode > secrets_aws_s3_decrypted.py

aws kms decrypt --ciphertext-blob secrets.aws_s3.json --output text --query Plaintext | base64 --decode





Keys :


aws kms encrypt --key-id 080fd8f4-816a-4e5a-abbe-b7f24fddb41d --plaintext file://secrets.json --output text --query CiphertextBlob | base64 --decode > secrets.encrypted.json


aws kms encrypt --key-id 080fd8f4-816a-4e5a-abbe-b7f24fddb41d --plaintext file://secrets.json --output text --query CiphertextBlob




$ aws kms encrypt --key-id 080fd8f4-816a-4e5a-abbe-b7f24fddb41d --plaintext file://secrets.json --output text --query CiphertextBlob
AQICAHinlfOCfr3eatflB9dXM1OKwDO6E98ykRmp3FylYaASdwE4wlksvmLlTCK1yRxLKAoEAAABLDCCASgGCSqGSIb3DQEHBqCCARkwggEVAgEAMIIBDgYJKoZIhvcNAQcBMB4GCWCGSAFlAwQBLjARBAxOcCi2mnuxwnl/P7QCARCAgeBtVqt0X8LCwCgDaz8GMUWPp/K2GudyPQnrMr2onZ/UljLs22IVotWyauyj/d9815nxcVZV4gY80aieS3Jn6I5W6pYRauC3/y28hJsm41fBqCtbxZD2wviGMPaGRbmNPuwFyOmM6Z1TUqmVpjJSNWQXjOSW31Yo9WbYuUA5lC9EMnvD8a2/PzsNN1hWdRw04+774nRBZ6jyg6DHF003toqfQOsC0bP0agZmp6JbOJnAPRhJnYqZepk3FytCtQOvQw2/+eq2o000pjUpf8RT9qh8ryke/qIg9k9D82B6puZwHw==

anjai@DESKTOP-25T44JJ MINGW64 ~/Desktop/AWS/aws_git_utils/Aws_Dev_Utils/aws_utils/components/kms (aws_certifications)
$ aws kms encrypt --key-id 080fd8f4-816a-4e5a-abbe-b7f24fddb41d --plaintext file://secrets.json --output text
AQICAHinlfOCfr3eatflB9dXM1OKwDO6E98ykRmp3FylYaASdwEZwtpIOnwXnMZJEAKUfFaIAAABLDCCASgGCSqGSIb3DQEHBqCCARkwggEVAgEAMIIBDgYJKoZIhvcNAQcBMB4GCWCGSAFlAwQBLjARBAyzgFKPTbD8jMrCq04CARCAgeBOvsnJyYXiqmG4p5LzQsc0cG9MG0RUuWHCSdjb+aWvZDsMMkiAuwSiCOile65tHsBRFxlFZK9URSnN9yXq9t75WtvLzsyTggxA5QNOg9F4WFdQrW80ZTXCsRM5AH12Yp1pLj820d2Xu7hltChblxUDPGHFDOey1cFXszTqtwXD8QcR7sYU7x6qE5WEefZZ4Ri8YaMA04xIEMMt/fe2hNJT7pNTK2C/VwZC5lreUZyETGcA3JeFxv9c3o2QDLlr4udwVG+FqTNJr8VL82ahnzr/CyzGBXbHaneAXhXp/J46CQ==    SYMMETRIC_DEFAULT       arn:aws:kms:us-east-2:927962363153:key/080fd8f4-816a-4e5a-abbe-b7f24fddb41d

anjai@DESKTOP-25T44JJ MINGW64 ~/Desktop/AWS/aws_git_utils/Aws_Dev_Utils/aws_utils/components/kms (aws_certifications)
$ aws kms encrypt --key-id 080fd8f4-816a-4e5a-abbe-b7f24fddb41d --plaintext file://secrets.json
{
    "CiphertextBlob": "AQICAHinlfOCfr3eatflB9dXM1OKwDO6E98ykRmp3FylYaASdwEwpK5Y8EAYB6KRHQo7AaHlAAABLDCCASgGCSqGSIb3DQEHBqCCARkwggEVAgEAMIIBDgYJKoZIhvcNAQcBMB4GCWCGSAFlAwQBLjARBAzAzL2yBc/aHg4OlssCARCAgeBM9zjZnTpLbxcQEwQZ2wMi84EcSrVZBKaSxE12/ECDJqu40ZvXbFsYgZtIvaOcRNc2t5PAzKhSFaUpXAc8GTJAAuwHiNM0s7+kVHhVJ40h0FSQVEKnN/JNHxshhQzjRv/lsQGqoty3X52HG27bsl/shSyrGRQhb5RaPYgbDzfSOdCRR8P5rv7SToYwdnnvkojZWQO190PP96/yCllZsCZUHqdn47V08U+cq82NvTRoRzPHmsszmB0RrZSqhN7FYJtcDW2xxRaN4aaP2WYHL/94vMItc9o+0aQ0zrHb8rMcjw==",
    "KeyId": "arn:aws:kms:us-east-2:927962363153:key/080fd8f4-816a-4e5a-abbe-b7f24fddb41d",
    "EncryptionAlgorithm": "SYMMETRIC_DEFAULT"
}


# Decrypt Process  Commands ::

anjai@DESKTOP-25T44JJ MINGW64 ~/Desktop/AWS/aws_git_utils/Aws_Dev_Utils/aws_utils/components/kms (aws_certifications)
$ aws kms decrypt --ciphertext-blob fileb://secrets.encrypted.json --output text --query Plaintext | base64 --decode > secrets.decrypted2.json
base64: invalid input

anjai@DESKTOP-25T44JJ MINGW64 ~/Desktop/AWS/aws_git_utils/Aws_Dev_Utils/aws_utils/components/kms (aws_certifications)
$ aws kms decrypt --ciphertext-blob fileb://secrets.encrypted.json
{
    "KeyId": "arn:aws:kms:us-east-2:927962363153:key/080fd8f4-816a-4e5a-abbe-b7f24fddb41d",
    "Plaintext": "ewoJIm1vbmdvVXNlcm5hbWUiOiAibW9uZ28tdXNlciIsCgkibW9uZ29QYXNzd29yZCI6ICJJUnJFIWp3Y0prejV3R0ZiJFN4KiROQDheIiwKCSJnb29nbGVBcGlLZXkiOiAiODFjYzk3NzAtYzNiZS00NGQyLWExOGQtOTAzOWRiMWYwNjJiIiwKCSJmYWNlYm9va0FwaUtleSI6ICI2YjQ5NGE4ZS1mOWEyLTQ3NzQtOGNiOS0yODFiZDczZTkyNzAiCn0=",
    "EncryptionAlgorithm": "SYMMETRIC_DEFAULT"
}

aws kms decrypt --ciphertext-blob fileb://secrets.encrypted.json --output text --query Plaintext



aws kms decrypt --ciphertext-blob fileb://secrets.encrypted.json --output text --query Plaintext | base64 --decode