package at.itkollegimst.Hain.pos1makro.test2.druckerei.infrastructure.brokers.rabittmq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface BestellungEventBinding {

    String  BESTELLUNG = "bestellungChannel";

    @Input(BESTELLUNG)
    SubscribableChannel bestellungChannel();

    @Output("buchdruckAbgeschlossenChannel")
    MessageChannel buchdruckAbgeschlossenChannel();
}
