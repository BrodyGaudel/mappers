# Mappers

Mappers is a Java utility library that provides functionality for mapping entities to Data Transfer Objects (DTOs) and vice versa. It includes methods for copying properties between objects of different classes based on field compatibility.

## Features

- **Entity to DTO Mapping**: Convert entity objects to DTO objects with ease.
- **DTO to Entity Mapping**: Convert DTO objects back to entity objects effortlessly.
- **Field Compatibility**: Copy properties between objects based on compatible fields.
- **Custom Exception Handling**: Includes a custom runtime exception, `MappersException`, for handling mapping errors.

## Getting Started

These instructions will help you include Mappers in your project.

### Prerequisites

- Java Development Kit (JDK) 17 or later
- Apache Maven

## Usage

// Example code demonstrating the usage of Mappers
```java
Mappers<MyEntity, MyDTO> mappers = new Mappers<>();
```

// Entity to DTO mapping
```java
MyEntity entity = new MyEntity();
MyDTO dto = mappers.fromEntity(entity, MyDTO.class);
```

// DTO to Entity mapping
```java
MyDTO dto = new MyDTO();
MyEntity entity = mappers.fromDTO(dto, MyEntity.class);
```

### Installation

To include Mappers in your Maven project, add the following dependency to your project's `pom.xml` file:

```xml
<dependency>
    <groupId>org.brodygaudel</groupId>
    <artifactId>mappers</artifactId>
    <version>1.0</version>
</dependency>


```

## Contributing

If you would like to contribute to the development of Mappers, please follow our Contribution Guidelines.

## Acknowledgments
Inspired by the need for efficient object mapping in Java applications.
Built with passion by BRODY GAUDEL MOUNANGA BOUKA.


