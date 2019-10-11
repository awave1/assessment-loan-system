# Assessment Loan System

User based loan system.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

* Ensure you're using Java 8
* (Optional) Install [gradle](https://gradle.org)

### Eclipse support

After importing the project to Eclipse, ensure that Gradle is configured. To configure it, do the following

- Right click on the project in the eclipse project explorer
- Select "Configure"
- Select "Add Gradle Nature"

### Installing

A step by step series of examples that tell you how to get a development env running

Building the project

```bash
./gradlew build
```

Running the project

```bash
./gradlew run --console=plain
```

Example of running the program:

```bash
$ ./gradlew run --console=plain
> Task :compileJava UP-TO-DATE
> Task :processResources NO-SOURCE
> Task :classes UP-TO-DATE

> Task :run
Please enter your username.
admin
Please enter your password.
password
*** Administrative Options ***
a) Search Catalogue
b) View Loans
c) Create User
d) List Users
e) Create Stock
f) Edit Stock
g) List Stock
h) Record Loan
i) Record Return
j) Edit Profile
k) Logout
l) Exit Application

Please enter a menu option.
l

BUILD SUCCESSFUL in 15s
2 actionable tasks: 1 executed, 1 up-to-date
```

Additional users can be found in [`com.keirnellyer.glencaldy.runtime.Model` class](https://github.com/awave1/assessment-loan-system/blob/refactor/src/main/java/com/keirnellyer/glencaldy/runtime/Model.java#L28)

## Running the tests

The project contains some tests. Testing is done via JUnit5. To run the tests, run the following command in the project directory:

```bash
./gradlew clean test
```

## Built With

* [JUnit 5](https://junit.org/junit5) - Testing framework
* [gradle](https://gradle.org) - Build System

## Authors

* **Keir Nellyer** - *Original work* - [iKeirNez](https://github.com/iKeirNez)
* **Artem Golovin** - *Refactoring* - [awave1](https://github.com/awave1)

