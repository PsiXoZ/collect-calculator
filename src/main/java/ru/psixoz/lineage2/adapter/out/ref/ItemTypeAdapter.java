package ru.psixoz.lineage2.adapter.out.ref;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.psixoz.lineage2.model.ref.ItemType;
import ru.psixoz.lineage2.port.out.ref.ItemTypeRepository;

public interface ItemTypeAdapter extends ItemTypeRepository, JpaRepository<ItemType, String> {
}
