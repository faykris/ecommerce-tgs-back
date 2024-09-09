# Spring Boot: Ecommerce Inventory Project - REST API

This project demonstrates how to manages products from a shoes' ecommerce that allows ship orders and more.

## Overview

This project shows the interaction between users, inventories, products and orders. Even some promos are stored in a parametric table.

Technologies used:
- Spring Boot 3
- Spring Security 6
- jsonwebtoken

## Installation

Follow these steps to install and run the project:

1. Create a database named `ecommerce` in PostgreSQL
2. Clone the repository: `git clone https://github.com/faykris/ecommerce-tgs-back.git`
3. Navigate to the project directory: `cd your-repo`
4. Change your respective DB credentials in `application.properties` file
4. Build the project using Maven:: `mvn clean install`
5. Run the project: `mvn spring-boot:run`
6. Perform the database inserts specified below these instructions (Optional)
7. Test the API Rest using Postman or another application at `http://localhost:8080`

## Queries in database
