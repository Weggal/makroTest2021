package at.itkollegimst.Hain.pos1makro.test2.druckerei.domain.model.aggregates;

import at.itkollegimst.Hain.pos1makro.test2.shareddomain.events.BuchdruckAbgeschlossenEvent;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "bestellid")
public class Bestellid extends AbstractAggregateRoot<Bestellid> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bestellid")
    private String bestellid;


    public Bestellid(){}

    public Bestellid(String bestellid){
        this.bestellid=bestellid;
        addDomainEvent(new BuchdruckAbgeschlossenEvent(bestellid));
    }

    public void addDomainEvent(BuchdruckAbgeschlossenEvent event) {
        registerEvent(event);
    }
}
