package at.itkollegimst.Hain.pos1makro.test2.buchhandlung.interfaces.rest;


import at.itkollegimst.Hain.pos1makro.test2.buchhandlung.application.internal.commandservices.BuchBestellungCommandService;
import at.itkollegimst.Hain.pos1makro.test2.buchhandlung.domain.model.aggregates.Bestellid;
import at.itkollegimst.Hain.pos1makro.test2.buchhandlung.domain.model.aggregates.Bestellung;
import at.itkollegimst.Hain.pos1makro.test2.buchhandlung.domain.model.commands.BuchBestellCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bestellung")
public class BuchBestellungsController {

    @Autowired
    private BuchBestellungCommandService buchBestellungCommandService;

    @GetMapping
    public List<Bestellung> getBestellung() {return  buchBestellungCommandService.listAll();}

    @PostMapping
    @ResponseBody
    public String bestellen(){
        Bestellid id =new Bestellid(buchBestellungCommandService.bestellen(new BuchBestellCommand()));
        System.out.println("Buch bestellung gestartet" + id.getBestellid());
        return id.getBestellid();
    }
}
