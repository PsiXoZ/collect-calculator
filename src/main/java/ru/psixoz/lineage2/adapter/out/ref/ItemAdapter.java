package ru.psixoz.lineage2.adapter.out.ref;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.psixoz.lineage2.model.template.Item;
import ru.psixoz.lineage2.port.out.ref.ItemRepository;

public interface ItemAdapter extends ItemRepository, JpaRepository<Item, String> {
}
