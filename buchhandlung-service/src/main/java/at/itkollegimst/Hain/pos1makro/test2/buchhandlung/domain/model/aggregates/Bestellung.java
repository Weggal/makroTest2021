package at.itkollegimst.Hain.pos1makro.test2.buchhandlung.domain.model.aggregates;

import javax.persistence.*;


import at.itkollegimst.Hain.pos1makro.test2.buchhandlung.domain.model.commands.BuchBestellCommand;
import at.itkollegimst.Hain.pos1makro.test2.buchhandlung.domain.model.valueObjects.BestellungStatus;
import at.itkollegimst.Hain.pos1makro.test2.shareddomain.events.BuchBestelltEvent;
import org.springframework.data.domain.AbstractAggregateRoot;

@Entity
@Table(name="bestellung")
public class Bestellung extends AbstractAggregateRoot<Bestellung>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "status")
    @Enumerated(value=EnumType.STRING)
    private BestellungStatus status;

    @Embedded
    private Bestellid bestellid;

    public Bestellung() {
        status = BestellungStatus.UNKNOWN;

    }

    public String getBestellid() {
        return bestellid.getBestellid();
    }

    public void setBestellid(Bestellid bestellid) {
        this.bestellid = bestellid;
    }

    public Bestellung(BuchBestellCommand command) {
        this.bestellid = new Bestellid(command.getBestellid());
        status = BestellungStatus.UNKNOWN;
        addDomainEvent(new BuchBestelltEvent(bestellid.getBestellid()));
        status = BestellungStatus.BESTELLT;
    }

    public void addDomainEvent(Object event) {
        registerEvent(event);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BestellungStatus getStatus() {
        return status;
    }

    public void setStatus(BestellungStatus status) {
        this.status = status;
    }
}
