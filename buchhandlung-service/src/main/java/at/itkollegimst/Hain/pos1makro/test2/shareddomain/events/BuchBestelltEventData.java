package at.itkollegimst.Hain.pos1makro.test2.shareddomain.events;

public class BuchBestelltEventData {
    private long id;

    public BuchBestelltEventData(long id){
        this.id=id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
