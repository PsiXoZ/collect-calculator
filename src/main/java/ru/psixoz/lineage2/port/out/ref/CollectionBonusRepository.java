package ru.psixoz.lineage2.port.out.ref;

import ru.psixoz.lineage2.model.template.CollectionBonus;

import java.util.Optional;

public interface CollectionBonusRepository {

    CollectionBonus save(CollectionBonus bonus);

    Optional<CollectionBonus> findByDescriptionAndEnchant(String descriptionCode, String enchantCode);

    Optional<CollectionBonus> findById(Long id);

    default CollectionBonus findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(() -> new RuntimeException("Cannot find bonus by id: " + id));
    }

}
