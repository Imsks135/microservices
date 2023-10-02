# CGI Core Track Spring Module - Coding Challenge - II

    Duration: 2 hours

## Objective

    As part of this case study, you have to implement Authentication using JWT Token.

    -   Create a Spring Boot application that has a domain class called User and Order. 
    -   Use MongoDB database for storage. 
    -   User should be registered first. (REST API - I)
    -   Registered user can login ( and get the token). ( REST API - II)
    -   User can place orders. ( REST API - III)
    -   Only registered users can fetch their orders ( should not be allowed to fetch other's orders). 
    ( REST API - IV) 
    -   Implement authentication using JWT. 
    -   The APIs should be tested through Postman. 


## Following are the steps:

1. Create the necessary project structure ( Springboot project with classes for different layers)

2. Create the domain ( User, Order) and exception classes as needed.
    -   User Class should have the following fields:
        -   userid
        -   username
        -   password
        -   mobile

    -   Order class should have the following fields:
        -   orderid
        -   ordertotal
        -   userid
        -   orderdatetime


    -   You can decide on the data type of each field

3. Implement the controller, service and repository layer
( Total Apis: 4, user: 2 ( register,login) and order: 2 ( place order, getallorders by userid))

4. Implement Filter to verify the JWT token.

5. Test the REST APIs using postman to make sure the REST APIs for user registration, login and fetch orders ( Authenticated and accessed, authentication fails) works

6. You have to share the screenshot of the tests done through postman
