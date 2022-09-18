package ru.psixoz.lineage2.port.out.ref;

import ru.psixoz.lineage2.model.template.CollectionTemplate;

import java.util.Collection;
import java.util.Optional;

import static java.lang.String.format;

public interface CollectionRepository {

    CollectionTemplate save(CollectionTemplate collection);

    Optional<CollectionTemplate> findByNameIgnoreCase(String name);

    Optional<CollectionTemplate> findById(Long id);

    Collection<CollectionTemplate> findAll();

    default CollectionTemplate findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(() -> new RuntimeException(format("Cannot find collection template with id: %d", id)));
    }
}
