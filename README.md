# Retail Store Discount System

## Overview

This project implements a discount management system for a retail store using Java and Spring Boot.
It calculates the net payable amount for a cart based on various discount rules, 
including percentage-based discounts for employees, affiliates, and long-term customers, 
as well as flat discounts.

## Features

- **Employee Discount**: 30% discount for store employees.
- **Affiliate Discount**: 10% discount for store affiliates.
- **Customer Discount**: 5% discount for customers who have been with the store for over 2 years.
- **Flat Discount**: $5 discount for every $100 on the bill.

## FUNCTIONAL SPECIFICATION
- **Single Discount**: Only one percentage-based discount can be applied per bill.
- **Exclusion**: Percentage-based discounts do not apply to groceries, NOT IMPLEMENTED.

## Architecture

- **Entities**: Represents the core domain objects, such as `User`.
- **DTOs**: Data Transfer Objects used for transferring data between layers.
- **Handlers**: Implements the Chain of Responsibility pattern to apply discounts.
- **Service**: Contains business logic to calculate the final payable amount.
- **Controller**: Exposes endpoints to interact with the system.

## Technologies

- Java 17
- Spring Boot 3.2
- JUnit 5
- Mockito

## Setup

### Prerequisites

- Java 17
- Maven

### Installation

1. **Clone the Repository**

    ```bash
    git clone https://github.com/mohammed-rabee/retail-store-discount-system
    cd retail-store-discount-system
    ```

2. **Build the Project**

   Using Maven:

    ```bash
    mvn clean install
    ```

3. **Run the Application**

    ```bash
    mvn spring-boot:run
    ```

## Running Tests

### Unit Tests

To run unit tests:

Using Maven:

```bash
mvn test