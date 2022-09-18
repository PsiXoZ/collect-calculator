package ru.psixoz.lineage2.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.psixoz.lineage2.model.user.CollectionStatus;
import ru.psixoz.lineage2.port.out.CollectionStatusRepository;

public interface CollectionStatusAdapter extends CollectionStatusRepository, JpaRepository<CollectionStatus, Long> {
}
