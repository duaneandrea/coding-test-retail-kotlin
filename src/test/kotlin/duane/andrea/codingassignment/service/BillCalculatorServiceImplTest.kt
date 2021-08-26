package duane.andrea.codingassignment.service

import duane.andrea.codingassignment.domain.Customer
import duane.andrea.codingassignment.domain.Item
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import duane.andrea.codingassignment.service.billCalculatorService


class BillCalculatorServiceImplITest {
    private var billCalculatorService: BillCalculatorService? = null
    private var items: List<Item>? = null
    @Before
    fun setUp() {
        billCalculatorService = BillCalculatorServiceImpl()
        items = BillingSystemBuilder.getItemListWithMultipleProducts()
    }

    @Test
    fun shouldCalculateBillForDiscountEligibleCustomer() {
        val customer: Customer = BillingSystemBuilder.getCustomerWithMoreThanTwoYearOldRegistration()
        Assert.assertEquals(761.00, billCalculatorService.calculateTotalPayableAmount(customer, items), 0)
    }

    @Test
    fun shouldCalculateBillForNonEligibleCustomer() {
        val customer: Customer = BillingSystemBuilder.getCustomerWithLessThanTwoYearOldRegistration()
        Assert.assertEquals(790.00, billCalculatorService.calculateTotalPayableAmount(customer, items), 0)
    }

    @Test
    fun shouldCalculateBillforAffiliateCustomer() {
        val affiliateCustomer: Customer = BillingSystemBuilder.getAffiliateCustomer()
        Assert.assertEquals(737.00, billCalculatorService.calculateTotalPayableAmount(affiliateCustomer, items), 0)
    }

    @Test
    fun shouldCalculateBillForEmployeeCustomer() {
        val employeeCustomer: Customer = BillingSystemBuilder.getEmployeeCustomer()
        Assert.assertEquals(626.00, billCalculatorService.calculateTotalPayableAmount(employeeCustomer, items), 0)
    }
}