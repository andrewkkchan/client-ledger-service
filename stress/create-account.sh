#!/usr/bin/env bash
#Create Payer, Payee, Fee, Tax and Settlement Account
#To support additional features and transactions, create more accounts
GREEN='\033[0;32m'
NC='\033[0m' # No Color
echo -e "${GREEN}Creating Payer Account${NC}"
curl -X POST \
  http://localhost:3003/transaction/event \
  -H 'Content-Type: application/json' \
  -d '{
	"type" : "create-account",
    "request" : {
        "id" : "12345",
        "currency" :"USD",
        "accountName" : "Andrew",
        "accountGroup" : "Customer"
    }
}'
echo '\n'
echo -e "${GREEN}Creating Payee Account${NC}"
curl -X POST \
  http://localhost:3003/transaction/event \
  -H 'Content-Type: application/json' \
  -d '{
	"type" : "create-account",
    "request" : {
        "id" : "23456",
        "currency" :"USD",
        "accountName" : "Tim",
        "accountGroup" : "Customer"
    }
}'
echo '\n'
echo -e "${GREEN}Creating Fee Account${NC}"
curl -X POST \
  http://localhost:3003/transaction/event \
  -H 'Content-Type: application/json' \
  -d '{
	"type" : "create-account",
    "request" : {
        "id" : "34567",
        "currency" :"USD",
        "accountName" : "P2P Fee",
        "accountGroup" : "Fee"
    }
}'
echo '\n'
echo -e "${GREEN}Creating Tax Account${NC}"
curl -X POST \
  http://localhost:3003/transaction/event \
  -H 'Content-Type: application/json' \
  -d '{
	"type" : "create-account",
    "request" : {
        "id" : "45678",
        "currency" :"USD",
        "accountName" : "P2P Tax",
        "accountGroup" : "Tax"
    }
}'
echo '\n'
echo -e "${GREEN}Creating Settlement Account${NC}"
curl -X POST \
  http://localhost:3003/transaction/event \
  -H 'Content-Type: application/json' \
  -d '{
	"type" : "create-account",
    "request" : {
        "id" : "56789",
        "currency" :"USD",
        "accountName" : "Andrew'\''s settlement",
        "accountGroup" : "Settlement"
    }
}'
echo '\n'


