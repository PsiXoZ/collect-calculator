package ru.psixoz.lineage2.port.out.ref;

import ru.psixoz.lineage2.model.ref.Enchant;

import java.util.Optional;

public interface EnchantRepository {

    Enchant save(Enchant enchant);
    Optional<Enchant> findByCodeIgnoreCase(String code);
}
