package ru.psixoz.lineage2.adapter.out.ref;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.psixoz.lineage2.model.template.CollectionBonus;
import ru.psixoz.lineage2.port.out.ref.CollectionBonusRepository;

public interface CollectionBonusAdapter extends CollectionBonusRepository, JpaRepository<CollectionBonus, Long> {
}
