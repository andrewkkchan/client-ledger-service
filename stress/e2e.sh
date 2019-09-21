#!/usr/bin/env bash
#Run an end to end flow, which create accounts, top up the payer, p2p from payer to payee, and then snapshot on all accounts
kafka-topics --zookeeper localhost:2181 --delete --topic Transaction_Event
kafka-topics --zookeeper localhost:2181 --delete --topic Transaction_Result_Maria
kafka-topics --zookeeper localhost:2181 --delete --topic Transaction_Result_Redis
ulimit -n 4096
sleep 5
kafka-topics --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic Transaction_Event
kafka-topics --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic Transaction_Result_Maria
kafka-topics --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic Transaction_Result_Redis
./create-account.sh
./top-up.sh
./p2p.sh
./back-up.sh
./p2p.sh

