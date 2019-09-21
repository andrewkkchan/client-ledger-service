#!/usr/bin/env bash
#Backup, have no effect on Maria Core, but trigger save to disk on Redis Core
GREEN='\033[0;32m'
NC='\033[0m' # No Color
echo -e "${GREEN}Top Up Payer Account with USD 1,000,000${NC}"
curl -X POST \
  http://localhost:3003/transaction/event \
  -H 'Content-Type: application/json' \
  -d '{
	"type" : "back-up",
    "request" : {}
}'
echo '\n'
