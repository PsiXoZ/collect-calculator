package ru.psixoz.lineage2.adapter.out.ref;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.psixoz.lineage2.model.ref.BonusDescription;
import ru.psixoz.lineage2.port.out.ref.BonusDescriptionRepository;

public interface BonusDescriptionAdapter extends BonusDescriptionRepository, JpaRepository<BonusDescription, String> {
}
