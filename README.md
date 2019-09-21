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

## What about 1 million per second?
In commercial products with trading, betting and payment enterprises, I have achieved 1 million transaction per second while holding all business rules intact.  A step-by-step customization and specialization on software and hardware is required.

### Step 1: To 10,000 per second
* Replace HTTP endpoint with TCP endpoint. For example, use Kafka/Solace as incoming message handlers -- which would remove the limitation of HTTP protocol and HTTP server overhead.

### Step 2: To 100,000 per second
* Replace Messaging endpoint on TCP with those on UDP.  You will however need to maintain reliable in sequence transfer of events.
* Replace non-positional data encoding (e.g., JSON, XML) for positional data encoding (e.g., protobuf, SBE)
* Install competing consumers, with at least one of which being implemented in-memory, to cope with the burst of events and support query during burst. Persisting consumer will eventually catch up.

### Step 3: To 1,000,000 per second
* Avoid garbage collection using pre-allocated ring buffer and other technique.

### Contact
You can follow me on https://medium.com/@andrewchan_73514

