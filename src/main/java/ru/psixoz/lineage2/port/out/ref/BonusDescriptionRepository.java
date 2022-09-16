package ru.psixoz.lineage2.port.out.ref;

import ru.psixoz.lineage2.model.ref.BonusDescription;

import java.util.Optional;

public interface BonusDescriptionRepository {

    BonusDescription save(BonusDescription bonusDescription);

    Optional<BonusDescription> findByCodeIgnoreCase(String code);

    default BonusDescription findByCodeOrThrow(String code) {
        return findByCodeIgnoreCase(code).orElseThrow(() -> new RuntimeException("Cannot find bonus description by code: " + code));
    }
}
