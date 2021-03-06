# coding-test-retail-kotlin
This is a coding Test that i was given to implement in Kotlin so I also implemented it in Java

The Retail Store Discounts
On a retail website, the following discounts apply:
1. If the user is an employee of the store, he gets a 30% discount
2. If the user is an affiliate of the store, he gets a 10% discount
3. If the user has been a customer for over 2 years, he gets a 5% discount.
4. For every $100 on the bill, there would be a $ 5 discount (e.g. for $ 990, you get $ 45
as a discount).
5. The percentage based discounts do not apply on groceries.
6. A user can get only one of the percentage based discounts on a bill.

**SOLUTION**
My Assumptions:

Total discount is a combination of discount on product and discount offered to USER.
Depending on the their type (AFFILIATE, EMPLOYEE, OLD/NEW CUSTOMER), the user gets (10, 30, 5) percent discount.
Depending on the product purchased the user gets either 5% discount if the product is non-grocery product or no discount on the product.
A generic formula for computation of product price can be given as: DISCOUNTED_TOTAL_BILL = QUANTITY * ( (1-USER_DISCOUNT)( (1-PRODUCT_DISCOUNT)(SUM of per unit non-grocery product prices)
(SUM of per unit grocery product prices) ) )
Testcase:

We're assuming the shopper purchases 2 item with unit prices as below:

19.99 4.99 14.99 0.99 -- GROCERY 1.99

Then we have 4 test cases:

CASE 1 >> AFFILIATE (0.9) 2*( 0.9*(0.95*(1.99+14.99+4.99+19.99) + 0.99) ) = 73.5336 discount = 12.3664

CASE 2 >> EMPLOYEE (0.7) 2*( 0.7*(0.95*(1.99+14.99+4.99+19.99) + 0.99) ) = 57.1928 discount = 28.7072

CASE 3 >> CUSTOMER (0.95) (Since more than two years) 2*( 0.95*(0.95*(1.99+14.99+4.99+19.99) + 0.99) ) = 77.6188 discount = 8.2812

CASE 4 >> CUSTOMER (0.95) (Since less than two years) 2*( 0.95*(1.99+14.99+4.99+19.99) + 0.99 ) = 81.704 discount = 4.196

I used the IntelliJ IDEA IDE to implement the solution by creating two sub packages the domain in which it held all the classes that pertained to the Product, Customer, The Customer Type and the Item to be bought. Since in the problem statement the data source was not mentioned i used an item in which i would iterate to collect the product type and the customer type. For test I used JUnit to run the unit tests with Coverage. For testing the endpoints i used Postman which is a great tool for testing RestFul APIs in developemnt mode as well as production mode. I also used swagger UI to test my endpoints in UI mode.

I have used Kotlin and Gradle to build the restful API. The test screenshots are also available. I have build two sub packages that is domain and services. The service has one interface the BillcalculatorInterface which is implemented by the BillCalculator class in the service package that allows us to write three functions which actually calculate the actual discount. The other sub package is the domain sub package and this allows us to define our main classes to instantiate our main objects in the retail shop that is the product, customer, the customer type and the Item class which will be consumed by the BillCalculatorService. Then lastly we run our project from the Order Class in our root package which them is run by the RestController to map the output into Post RESTFUL API.

For Testing and coverage I managed to Run Test With All Coverage to the BillService Class using JUNIT. With Time limits I couldn???t install Swagger UI to run my endpoints on the UI or to Auntheticate my API since it was not requested in the document. Screenshots are also available.

To run the application simply run the main function that is in package duane.andrea.codingassignment and the file name is CodingAssignmentApplication.kt using IntelliJ IDEA. It is a gradle application.
