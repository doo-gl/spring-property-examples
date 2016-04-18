This project attempts to show some of the different aspects of the way properties can be used in spring.

It was originally written to accompany a presentation on spring properties and effectively tries to pick out some of the sections described in: https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html and translates them into code.


## Simple-single-property

This is one of the most barebones ways to get a spring property into an application.

It uses a single property called foo that is wired into a class via the @Value annotation.

The app starts a webapp on port 8080.

If one navigates to http://localhost:8080/ then it should simply display the value of the property named 'foo'.

## Simple-config-properties

This module extends on the simple property module by showing how to inject a group of related properties into a configuration properties class.

It also shows how to use previously defined properties to create new properties.

The module starts an app on port 8081 and navigating to http://localhost:8081/ should show the values of 2 defined properties and their combination in a JSON format.

## Relaxed-binding

This module attempts to show the different kinds of property names that can be used when defining properties.

It shows 3 styles of naming properties that are all resolvable by spring to a camel case format.

The module starts a webapp and navigating to http://localhost:8082/ will display the 3 properties that have been defined using different styles in a JSON format.

## Using-yaml-files

This module attempts to show the usage of proerties that have been defined in a .yml format as opposed to the traditional .properties format.

It also shows the usage of random property values.

The webapp defines 3 endpoints on port 8083:

1. /simple - This returns the properties that have been defined in .yml, including some random properties
2. /collections - This returns the contents to 2 collections, one a list of properties, the other a map of properties.
3. /complex - This returns a list of JSON objects that have been mapped to an internal pojo by spring

## Property-profiles

This module attempts to show how different properties can be used by activating profiles

The application.yml file defines a defualt server port but also has 3 sections for profiles dev, test and prod which apply different values for the server port

Activating different profiles with the app will start the app on different ports.

## Property-converters

This module attempts to show how to set up a property converter for a ZonedDateTime

Spring does not automatically convert String -> ZonedDateTime so we need to add our own class for doing the conversion.