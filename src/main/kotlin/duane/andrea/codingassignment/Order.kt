package duane.andrea.codingassignment
import duane.andrea.codingassignment.domain.Customer
import duane.andrea.codingassignment.domain.CustomerType
import duane.andrea.codingassignment.service.BillCalculatorServiceImpl
import org.joda.time.DateTime
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/order1")
class Order {

    //@GetMapping("")
    fun MakeOrder():Double{
        val listItem = listOf<Double>(7653.877,9876.98,87632.78)
        return BillCalculatorServiceImpl.calculateTotalPayableAmount(
            Customer(
            CustomerType.CUSTOMER,"1432321","Simbarashe Duane Andrea",
            DateTime().toDateTime()
        ),listItem)
    }

}
