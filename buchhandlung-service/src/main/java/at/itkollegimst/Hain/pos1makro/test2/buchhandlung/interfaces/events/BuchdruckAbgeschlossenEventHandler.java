package at.itkollegimst.Hain.pos1makro.test2.buchhandlung.interfaces.events;

import at.itkollegimst.Hain.pos1makro.test2.buchhandlung.application.internal.commandservices.BuchdruckAbgeschlossenCommandService;
import at.itkollegimst.Hain.pos1makro.test2.buchhandlung.infrastructure.brokers.rabittmq.BestellungEventSource;
import at.itkollegimst.Hain.pos1makro.test2.shareddomain.events.BuchdruckAbgeschlossenEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(BuchdruckAbgeschlossenCommandService.class)
public class BuchdruckAbgeschlossenEventHandler {

    @Autowired
    private BuchdruckAbgeschlossenCommandService buchdruckAbgeschlossenCommandService;

    @StreamListener(target = BestellungEventSource.GEDRUCKT)
    public void receiveEvent(BuchdruckAbgeschlossenEvent buchdruckAbgeschlossenEvent){
        buchdruckAbgeschlossenCommandService.buchWurdeGedruckt(buchdruckAbgeschlossenEvent.getBestellid());
    }
}
