package nu.westlin.springtipsspringmodulith.orders

import org.springframework.modulith.events.Externalized

@Externalized(target = AmqpIntegrationsConfiguration.ORDERS_DESTINATION)
data class OrderPlacedEvent(
    val orderId: Int
)