package at.itkollegimst.Hain.pos1makro.test2.buchhandlung.application.internal.commandservices;

import at.itkollegimst.Hain.pos1makro.test2.buchhandlung.domain.model.aggregates.Bestellid;
import at.itkollegimst.Hain.pos1makro.test2.buchhandlung.domain.model.aggregates.Bestellung;
import at.itkollegimst.Hain.pos1makro.test2.buchhandlung.domain.model.commands.BuchBestellCommand;
import at.itkollegimst.Hain.pos1makro.test2.buchhandlung.infrastructure.repository.jpa.BestellungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BuchBestellungCommandService {

    @Autowired
    private BestellungRepository bestellungRepository;

    public String bestellen(BuchBestellCommand buchBestellCommand){
        String radID= UUID.randomUUID().toString().toLowerCase();
        buchBestellCommand.setBestellid(radID);
        Bestellung bestellung = new Bestellung(buchBestellCommand);
        bestellungRepository.save(bestellung);
        return radID;
    }

    public List<Bestellung> listAll(){
        return bestellungRepository.findAll();
    }
}
