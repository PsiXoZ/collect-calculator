package ru.psixoz.lineage2.adapter.out.ref;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.psixoz.lineage2.model.template.CollectionTemplate;
import ru.psixoz.lineage2.port.out.ref.CollectionRepository;

public interface CollectionAdapter extends CollectionRepository, JpaRepository<CollectionTemplate, Long> {
}
