package at.itkollegimst.Hain.pos1makro.test2.buchhandlung.infrastructure.brokers.rabittmq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface BestellungEventSource {

    String GEDRUCKT = "buchdruckAbgeschlossenChannel";

    @Input(GEDRUCKT)
    SubscribableChannel buchdruckAbgeschlossenChannel();

    @Output("bestellungChannel")
    MessageChannel bestellungChannel();

}
