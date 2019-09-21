#!/usr/bin/env bash
#Top up the account, balance the entry using a settlement account
GREEN='\033[0;32m'
NC='\033[0m' # No Color
echo -e "${GREEN}Top Up Payer Account with USD 1,000,000${NC}"
curl -X POST \
  http://localhost:3003/transaction/event \
  -H 'Content-Type: application/json' \
  -d '{
	"type" : "top-up",
    "request" : {
        "currency": "USD",
        "amount": 1000000,
        "topUpAccount" : "12345",
        "settlementAccount" : "56789"
    }
}'
echo '\n'

