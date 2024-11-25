package nu.westlin.springtipsspringmodulith.orders.internal

import io.github.oshai.kotlinlogging.KLogger
import io.github.oshai.kotlinlogging.KotlinLogging
import nu.westlin.springtipsspringmodulith.orders.OrderPlacedEvent
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

