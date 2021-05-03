package at.itkollegimst.Hain.pos1makro.test2.buchhandlung.infrastructure.repository.jpa;

import at.itkollegimst.Hain.pos1makro.test2.buchhandlung.domain.model.aggregates.Bestellung;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BestellungRepository extends JpaRepository<Bestellung, Long> {

}
