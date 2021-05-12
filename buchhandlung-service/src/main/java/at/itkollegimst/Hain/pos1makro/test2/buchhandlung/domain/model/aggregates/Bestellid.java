package at.itkollegimst.Hain.pos1makro.test2.buchhandlung.domain.model.aggregates;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Bestellid implements Serializable {

    @Column(name = "bestellid")
    private String bestellid;


    public Bestellid(){}

    public Bestellid(String bestellid){
        this.bestellid=bestellid;
    }

    public void setBestellid(String bestellid) {
        this.bestellid = bestellid;
    }

    public String getBestellid() {
        return bestellid;
    }
}
