package duane.andrea.codingassignment.service
import duane.andrea.codingassignment.domain.Customer
import duane.andrea.codingassignment.domain.Item
import org.springframework.stereotype.Service

@Service
interface billCalculatorService {
    fun calculateTotalPayableAmount(customer: Customer, items:List<Item>):Double
}