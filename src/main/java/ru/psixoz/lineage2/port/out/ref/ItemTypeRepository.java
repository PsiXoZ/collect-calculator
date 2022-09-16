package ru.psixoz.lineage2.port.out.ref;

import ru.psixoz.lineage2.model.ref.ItemType;

import java.util.Optional;

public interface ItemTypeRepository {

    ItemType save(ItemType type);

    Optional<ItemType> findByCodeIgnoreCase(String code);
}
