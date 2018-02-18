# Vending Machine API Samples

## HTTPie

HTTPie is much friendlier to use and makes much more sense than curl, so the examples will all be built upon its cli tool.

### Installing

The most common installation methods are below, but if those don't fit your use case, you can check other methods [here](https://httpie.org/#installation)

``` shell
brew install httpie
```

``` shell
pip install httpie
```

## Actions / Commands

### What is in the Machine?

``` shell
http GET http://localhost:8080/inventory
```

### Add some money

``` shell
http --print=hbHB POST http://localhost:8080/payment amount:=2000 currency=usd type=paper
```

#### Sample Body

``` json
{
    "amount":2000,
    "currency":"usd",
    "type":"paper"
}
```