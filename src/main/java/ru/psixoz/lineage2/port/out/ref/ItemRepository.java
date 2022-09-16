package ru.psixoz.lineage2.port.out.ref;

import ru.psixoz.lineage2.model.template.Item;

import java.util.Optional;

import static java.lang.String.format;

public interface ItemRepository {

    Item save(Item item);

    Optional<Item> findById(Long id);
    Optional<Item> findByNameIgnoreCase(String name);

    default Item findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(() -> new RuntimeException(format("Cannot find item with id: %s", id)));
    }
}
