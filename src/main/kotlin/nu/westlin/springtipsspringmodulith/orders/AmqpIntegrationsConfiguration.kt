package nu.westlin.springtipsspringmodulith.orders

import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.Exchange
import org.springframework.amqp.core.ExchangeBuilder
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.QueueBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AmqpIntegrationsConfiguration {

    @Bean
    fun binding(queue: Queue, exchange: Exchange): Binding {
        return BindingBuilder.bind(queue).to(exchange).with(ORDERS_DESTINATION).noargs()
    }

    @Bean
    fun ordersQueue(): Queue = QueueBuilder.durable().build()

    @Bean
    fun exchange(): Exchange {
        return ExchangeBuilder.directExchange(ORDERS_DESTINATION).durable(true).build()
    }
    
    companion object {
        const val ORDERS_DESTINATION = "orders"
    }
}