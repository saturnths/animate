# Animate

Simulator of particle animation in a linear chamber.

Maven-based Java project with unit tests.

## Assumptions
* Since values of `speed` less than or equal to 0 and empty `init` are both invalid, we throw an exception in these cases.
* Input's size is assumed to not exceed the maximum integer type value.

## How to run
install: `mvn clean install`

run application: `mvn exec:java`

run tests: `mvn test`

or import as a Maven project in IntelliJ IDEA.