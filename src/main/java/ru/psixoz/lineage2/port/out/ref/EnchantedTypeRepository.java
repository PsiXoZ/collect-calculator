package ru.psixoz.lineage2.port.out.ref;

import ru.psixoz.lineage2.model.ref.EnchantType;

import java.util.Optional;

public interface EnchantedTypeRepository {

    EnchantType save(EnchantType type);

    Optional<EnchantType> findByCodeIgnoreCase(String code);
}
