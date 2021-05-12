package at.itkollegimst.Hain.pos1makro.test2.shareddomain.events;

public class BuchdruckAbgeschlossenEvent {
    private String bestellid;
    public BuchdruckAbgeschlossenEvent(){}
    public BuchdruckAbgeschlossenEvent(String bestellid){
        this.bestellid=bestellid;
    }


    public String getBestellid() {
        return bestellid;
    }

    public void setBestellid(String bestellid) {
        this.bestellid = bestellid;
    }
}
