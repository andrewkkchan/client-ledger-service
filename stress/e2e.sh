#!/usr/bin/env bash
#Run an end to end flow, which create accounts, top up the payer, p2p from payer to payee, and then snapshot on all accounts
./create-account.sh
./top-up.sh
./p2p.sh
./back-up.sh
./p2p.sh

