package at.itkollegimst.Hain.pos1makro.test2.buchhandlung.domain.model.commands;

import at.itkollegimst.Hain.pos1makro.test2.buchhandlung.domain.model.aggregates.Bestellid;

public class BuchBestellCommand {

    private String bestellid;
    public BuchBestellCommand(){
    }

    public void setBestellid(String bestellid) {
        this.bestellid = bestellid;
    }

    public String getBestellid() {
        return bestellid;
    }
}

