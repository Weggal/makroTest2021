package at.itkollegimst.Hain.pos1makro.test2.buchhandlung.infrastructure.repository.jpa;

import at.itkollegimst.Hain.pos1makro.test2.buchhandlung.domain.model.aggregates.Bestellid;
import at.itkollegimst.Hain.pos1makro.test2.buchhandlung.domain.model.aggregates.Bestellung;
import at.itkollegimst.Hain.pos1makro.test2.buchhandlung.domain.model.valueObjects.BestellungStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BestellungRepository extends JpaRepository<Bestellung, Long> {

    @Modifying
    @Query("update Bestellung set status = :status WHERE bestellid = :bestellid")
    void updateStatus(@Param("status") BestellungStatus status, @Param("bestellid") Bestellid bestellid);

    List<Bestellung> findAll();

}
