# client-ledger-service: a REST endpoint for accepting and generating mutation events

## What does it do

client-ledger-service is part 1 of the 3 parts of a simple ledger demo over event-sourcing, using commoditized software and simple set up

## Quick start

### Step 1

Go to stress test folder
```
cd stress
```

Run Kafka (Assuming you are running on Mac, and you have already installed Apache Kafka)
```
sudo ./kafka.sh
```

### Step 2

Run the End to End Stress Test, which send 1,000 p2p transactions into the http endpoint.
```
./e2e.sh
```

## Abstract

Common practices of relying on ACID properties of database in resolving conflicts and recovering from failure would not scale in high-concurrency, low-latency use cases (e.g., trading, betting, payment).
This sharing offers a quick overview of event sourcing framework, and how one can build a fully working ledger using simply commodity, open sourced products (e.g., Apache Kafka).
This sharing further explores a more complicated use cases, where stochastic scenarios could be baked into traditional event sourcing to produce real time, big data type, operational intelligence. 

## Why Event Sourcing?
Ledger which relies on database ACID properties will handle up to 10-20 transaction per second. When pushed over that, there is a chance that the business rule (e.g., client ledger balance must not be overdrawn, a.k.a., <0) will be broken by racing condition and thread visibility.
This code base is a basic set up for mobile/web environment to install event sourcing ledger functionality. And even with such a primitive set up, the http endpoint can easily handle 1,000 transactions per second, with 100% guarantee of holding business rules.

