package duane.andrea.codingassignment.domain


class Item(private val product: Product, quantity: Int) {
    private val totalCost: Double = product.price * quantity

    fun getDiscountedPrice(discountPercentage: Double): Double {
        return if (product.isDiscountable && discountPercentage != 0.0) {
            totalCost - totalCost * discountPercentage / 100
        } else totalCost
    }

}