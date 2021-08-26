package duane.andrea.codingassignment.domain

enum class CustomerType(val discountPercentage: Double) {
    AFFILIATE(10.0), EMPLOYEE(30.0), CUSTOMER(5.0);

}