package at.itkollegimst.Hain.pos1makro.test2.buchhandlung.application.internal.commandservices;

import at.itkollegimst.Hain.pos1makro.test2.buchhandlung.domain.model.aggregates.Bestellid;
import at.itkollegimst.Hain.pos1makro.test2.buchhandlung.domain.model.valueObjects.BestellungStatus;
import at.itkollegimst.Hain.pos1makro.test2.buchhandlung.infrastructure.repository.jpa.BestellungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class BuchdruckAbgeschlossenCommandService {

    @Autowired
    private BestellungRepository bestellungRepository;

    @Transactional
    public void buchWurdeGedruckt(String bestellid){
        bestellungRepository.updateStatus(BestellungStatus.ABHOLBEREIT, new Bestellid(bestellid));
    }
}
