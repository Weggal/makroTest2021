package at.itkollegimst.Hain.pos1makro.test2.druckerei.application.internal.commandservices;

import at.itkollegimst.Hain.pos1makro.test2.druckerei.domain.model.aggregates.Bestellid;
import at.itkollegimst.Hain.pos1makro.test2.druckerei.infrastructure.repository.jpa.BestellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class BuchdruckCommandService {

    @Autowired
    private BestellRepository bestellRepository;

    @Transactional
    public void startBuchdruck(String bestellid){

        Bestellid bestellid1 = new Bestellid(bestellid);
        bestellRepository.save(bestellid1);

        System.out.println(bestellid+" wird gedruckt");

    }
}
