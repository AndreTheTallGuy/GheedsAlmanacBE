package com.GheedsAlmanac.GheedsAlmanac.repos;
import com.GheedsAlmanac.GheedsAlmanac.models.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RecordRepo extends JpaRepository<Record, Integer> {

    @Query("SELECT r FROM Record r WHERE upper(r.itemA) LIKE upper(?1) OR upper(r.itemB) LIKE upper(?1)")
    Set<Record> getItems(String itemName);

}
