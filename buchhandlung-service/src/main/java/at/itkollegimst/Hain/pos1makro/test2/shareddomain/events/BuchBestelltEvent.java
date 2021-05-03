package at.itkollegimst.Hain.pos1makro.test2.shareddomain.events;

public class BuchBestelltEvent {
    private long id;
    public  BuchBestelltEvent(){}
    public  BuchBestelltEvent(long id){
        this.id=id;
    }

    public long getId() {
        return id;
    }
}
