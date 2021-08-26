package duane.andrea.codingassignment.domain

import org.joda.time.DateTime;

class Customer(
    val customerType: CustomerType,
    val customerID: String,
    val customerName: String,
    private val registrationDate: DateTime
) {
    fun isAvailableForLoyaltyDiscount(): Boolean {
        val dateToCompare = DateTime.now().minusYears(CUSTOMER_LOYALTY_TIME_PERIOD_IN_YRS)
        return registrationDate.isBefore(dateToCompare) && CustomerType.CUSTOMER === customerType
    }

    companion object {
        private const val CUSTOMER_LOYALTY_TIME_PERIOD_IN_YRS = 2
    }
}