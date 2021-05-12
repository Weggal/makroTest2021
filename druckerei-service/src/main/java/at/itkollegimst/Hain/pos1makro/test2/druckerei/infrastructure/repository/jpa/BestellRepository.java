package at.itkollegimst.Hain.pos1makro.test2.druckerei.infrastructure.repository.jpa;

import at.itkollegimst.Hain.pos1makro.test2.druckerei.domain.model.aggregates.Bestellid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BestellRepository extends JpaRepository<Bestellid, Long> {
}
