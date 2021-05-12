package at.itkollegimst.Hain.pos1makro.test2.druckerei.application.internal.outboundservices;

import at.itkollegimst.Hain.pos1makro.test2.druckerei.infrastructure.brokers.rabittmq.BestellungEventBinding;
import at.itkollegimst.Hain.pos1makro.test2.shareddomain.events.BuchdruckAbgeschlossenEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
@EnableBinding(BestellungEventBinding.class)
public class BuchdruckAbgeschlossenPublisherService {

    private BestellungEventBinding bestellungEventSource;

    public BuchdruckAbgeschlossenPublisherService(BestellungEventBinding bestellungEventSource){
        this.bestellungEventSource = bestellungEventSource;
    }

    @TransactionalEventListener
    public void handleBuchBestelltEvent(Object event){
        bestellungEventSource.buchdruckAbgeschlossenChannel().send(MessageBuilder.withPayload(event).build());
    }
}
