package nu.westlin.springtipsspringmodulith.orders.internal

import io.github.oshai.kotlinlogging.KLogger
import io.github.oshai.kotlinlogging.KotlinLogging
import nu.westlin.springtipsspringmodulith.orders.OrderPlacedEvent
import nu.westlin.springtipsspringmodulith.orders.internal.LineItem
import org.springframework.context.ApplicationEventPublisher
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class OrderService(
    private val orderRepository: OrderRepository,
    private val applicationEventPublisher: ApplicationEventPublisher
) {
    private val logger: KLogger = KotlinLogging.logger {}

    fun place(order: Order) {
        val savedOrder = orderRepository.save(order)
        applicationEventPublisher.publishEvent(OrderPlacedEvent(savedOrder.id))
        logger.info { "Order $savedOrder saved" }
    }
}

interface OrderRepository : CrudRepository<Order, Int>

// Order is the aggregate that contains line items.
@Table("orders")
data class Order(@get:Id val id: Int, val lineItems: Set<LineItem>)

@Table("orders_line_items")
data class LineItem(@get:Id val id: Int, val product: Int, val quantity: Int)