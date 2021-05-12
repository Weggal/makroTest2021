package at.itkollegimst.Hain.pos1makro.test2.shareddomain.events;

public class BuchBestelltEvent {
    private String bestellid;
    public  BuchBestelltEvent(){}
    public  BuchBestelltEvent(String bestellid){
        this.bestellid=bestellid;
    }


    public String getBestellid() {
        return bestellid;
    }

    public void setBestellid(String bestellid) {
        this.bestellid = bestellid;
    }
}
