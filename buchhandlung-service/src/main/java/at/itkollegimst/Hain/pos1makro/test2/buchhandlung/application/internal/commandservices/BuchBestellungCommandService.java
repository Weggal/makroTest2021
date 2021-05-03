package at.itkollegimst.Hain.pos1makro.test2.buchhandlung.application.internal.commandservices;

import at.itkollegimst.Hain.pos1makro.test2.buchhandlung.domain.model.aggregates.Bestellung;
import at.itkollegimst.Hain.pos1makro.test2.buchhandlung.domain.model.commands.BuchBestellCommand;
import at.itkollegimst.Hain.pos1makro.test2.buchhandlung.infrastructure.repository.jpa.BestellungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuchBestellungCommandService {

    @Autowired
    private BestellungRepository bestellungRepository;

    public Long bestellen(BuchBestellCommand buchBestellCommand){
        Bestellung bestellung = new Bestellung(buchBestellCommand);
        bestellungRepository.save(bestellung);
        return bestellung.getId();
    }
}
