package ru.psixoz.lineage2.adapter.out.ref;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.psixoz.lineage2.model.ref.Enchant;
import ru.psixoz.lineage2.port.out.ref.EnchantRepository;

public interface EnchantAdapter extends EnchantRepository, JpaRepository<Enchant, String> {
}
