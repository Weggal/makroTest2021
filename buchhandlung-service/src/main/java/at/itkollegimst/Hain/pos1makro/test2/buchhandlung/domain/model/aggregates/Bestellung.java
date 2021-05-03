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

    public Bestellung() {
        status = BestellungStatus.UNKNOWN;

    }

    public Bestellung(BuchBestellCommand command) {
        status = BestellungStatus.UNKNOWN;
        addDomainEvent(new BuchBestelltEvent());
        status = BestellungStatus.BESTELLT;
    }

    public void addDomainEvent(Object event) {
        registerEvent(event);
    }

    public Long getId() {
        return id;
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
