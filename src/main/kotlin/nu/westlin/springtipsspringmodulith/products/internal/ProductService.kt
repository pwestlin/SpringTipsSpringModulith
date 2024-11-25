package nu.westlin.springtipsspringmodulith.products.internal

import io.github.oshai.kotlinlogging.KLogger
import io.github.oshai.kotlinlogging.KotlinLogging
import nu.westlin.springtipsspringmodulith.orders.OrderPlacedEvent
import org.springframework.modulith.events.ApplicationModuleListener
import org.springframework.stereotype.Service
import java.time.Duration

@Suppress("unused")
@Service
class ProductService {
    private val logger: KLogger = KotlinLogging.logger {}

    @ApplicationModuleListener
    fun orderPlaced(event: OrderPlacedEvent) {
        logger.info { "Starting: $event" }
        Thread.sleep(Duration.ofSeconds(10))
        logger.info { "Stopping: $event" }
    }
}