package duane.andrea.codingassignment.service

import duane.andrea.codingassignment.domain.Customer
import duane.andrea.codingassignment.domain.CustomerType
import duane.andrea.codingassignment.domain.Item
import kotlin.math.floor
import kotlin.math.roundToInt


class BillCalculatorServiceImpl:billCalculatorService {
    private val DISCOUNT_PER_HUNDRED = 5

    override fun calculateTotalPayableAmount(customer: Customer, items: List<Item>): Double {
        var totalDiscountedPrice = 0.0
        val discountPercentage: Double = getDiscountPercentageForCustomer(customer)
        for (item in items) {
            totalDiscountedPrice += item.getDiscountedPrice(discountPercentage)
        }

        return (totalDiscountedPrice - getDiscountBasedOnTotalAmount(totalDiscountedPrice)).roundToInt().toDouble()
    }

    private fun getDiscountPercentageForCustomer(customer: Customer): Double {
        val customerType = customer.customerType
        return if (customerType === CustomerType.AFFILIATE || customerType === CustomerType.EMPLOYEE || customer.isAvailableForLoyaltyDiscount()) {
            customerType.discountPercentage
        } else 0.0
    }

    private fun getDiscountBasedOnTotalAmount(totalDiscountedPrice: Double): Double {
        return floor(totalDiscountedPrice / 100) * DISCOUNT_PER_HUNDRED
    }


}