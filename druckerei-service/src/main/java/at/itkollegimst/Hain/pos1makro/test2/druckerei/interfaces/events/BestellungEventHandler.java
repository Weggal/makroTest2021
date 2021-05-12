package at.itkollegimst.Hain.pos1makro.test2.druckerei.interfaces.events;

import at.itkollegimst.Hain.pos1makro.test2.druckerei.application.internal.commandservices.BuchdruckCommandService;
import at.itkollegimst.Hain.pos1makro.test2.druckerei.infrastructure.brokers.rabittmq.BestellungEventBinding;
import at.itkollegimst.Hain.pos1makro.test2.shareddomain.events.BuchBestelltEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(BestellungEventBinding.class)
public class BestellungEventHandler {

    @Autowired
    private BuchdruckCommandService buchdruckCommandService;

    @StreamListener(target = BestellungEventBinding.BESTELLUNG)
    public void recieveEvent(BuchBestelltEvent buchBestelltEvent){
        buchdruckCommandService.startBuchdruck(buchBestelltEvent.getBestellid());
    }

}
