package nu.westlin.springtipsspringmodulith.orders

import io.github.oshai.kotlinlogging.KLogger
import io.github.oshai.kotlinlogging.KotlinLogging
import nu.westlin.springtipsspringmodulith.orders.internal.Order
import nu.westlin.springtipsspringmodulith.orders.internal.OrderService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/orders")
class OrdersController(
    private val orderService: OrderService
) {
    private val logger: KLogger = KotlinLogging.logger {}

    @PostMapping("")
    fun place(@RequestBody order: Order) {
        orderService.place(order)
    }
}