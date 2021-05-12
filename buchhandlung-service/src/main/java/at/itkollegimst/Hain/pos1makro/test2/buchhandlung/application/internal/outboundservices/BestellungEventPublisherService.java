package at.itkollegimst.Hain.pos1makro.test2.buchhandlung.application.internal.outboundservices;

import at.itkollegimst.Hain.pos1makro.test2.buchhandlung.infrastructure.brokers.rabittmq.BestellungEventSource;
import at.itkollegimst.Hain.pos1makro.test2.shareddomain.events.BuchBestelltEvent;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
@EnableBinding(BestellungEventSource.class)
public class BestellungEventPublisherService {

    private BestellungEventSource bestellungEventSource;

    public BestellungEventPublisherService(BestellungEventSource bestellungEventSource){
        this.bestellungEventSource = bestellungEventSource;
    }

    @TransactionalEventListener
    public void handleBuchBestelltEvent(BuchBestelltEvent event){
        bestellungEventSource.bestellungChannel().send(MessageBuilder.withPayload(event).build());
    }
}
