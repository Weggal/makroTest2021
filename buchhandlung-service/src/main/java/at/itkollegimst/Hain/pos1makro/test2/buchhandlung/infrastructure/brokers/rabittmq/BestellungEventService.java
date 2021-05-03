package at.itkollegimst.Hain.pos1makro.test2.buchhandlung.infrastructure.brokers.rabittmq;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface BestellungEventService {
    @Output("bestellungChannel")
    MessageChannel bestellungChannel();
}
