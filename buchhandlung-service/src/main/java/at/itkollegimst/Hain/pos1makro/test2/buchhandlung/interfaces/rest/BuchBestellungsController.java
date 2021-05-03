package at.itkollegimst.Hain.pos1makro.test2.buchhandlung.interfaces.rest;


import at.itkollegimst.Hain.pos1makro.test2.buchhandlung.application.internal.commandservices.BuchBestellungCommandService;
import at.itkollegimst.Hain.pos1makro.test2.buchhandlung.domain.model.commands.BuchBestellCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/bestellung")
public class BuchBestellungsController {

    @Autowired
    private BuchBestellungCommandService buchBestellungCommandService;

    @PostMapping
    @ResponseBody
    public Long bestellen(){
        long id = buchBestellungCommandService.bestellen(new BuchBestellCommand());
        System.out.println("Buch bestellung gestartet" + id);
        return id;
    }
}
