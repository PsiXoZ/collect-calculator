package ru.psixoz.lineage2.port.out.ref;

import ru.psixoz.lineage2.model.template.CollectionTemplate;

import java.util.Optional;

public interface CollectionRepository {

    CollectionTemplate save(CollectionTemplate collection);

    Optional<CollectionTemplate> findByNameIgnoreCase(String name);
}
