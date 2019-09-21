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

## Why Event Sourcing?

The above is a basic set up for mobile/web environment to install event sourcing ledger functionality. And even with such a primitive set up, the http endpoint can easily handle 1,000 transactions per second.

