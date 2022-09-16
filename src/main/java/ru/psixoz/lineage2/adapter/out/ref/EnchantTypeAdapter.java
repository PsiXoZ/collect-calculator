package ru.psixoz.lineage2.adapter.out.ref;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.psixoz.lineage2.model.ref.EnchantType;
import ru.psixoz.lineage2.port.out.ref.EnchantTypeRepository;

public interface EnchantTypeAdapter extends EnchantTypeRepository, JpaRepository<EnchantType, String> {
}
