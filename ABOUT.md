# About

## Language / Framework

### [Kotlin](https://kotlinlang.org/)

### [Javalin](https://javalin.io)

## Build & Running

** Note: this project requires Java, but its installation isn't covered here **

### Build

``` shell
./gradlew assemble;
```

### Run

``` shell
./gradlew run;
```

## Samples

There is a `README.md` in the `samples` directory with simple instructions on how to work with the api a bit.

## Data Model

`com.jb.wagner.models` is the home of the underlying model that powers this vending machine.

Under `com.jb.wagner.models.transfer` you will find models used to interact with the api.  Few notes about why transfer objects exist at all :

* A Standardized `Response` object to avoid trying to find perfect HTTP status codes for each API call.
* The underlying data model is very very explicit, but a lot of actions from teh user will be shorter / smaller snippets that are flat.  To keep the API simple and sane, in most cases, I have found a need to maintain objects that are used to send data back and forth from the client as well as different objects to interact with the database itself.
