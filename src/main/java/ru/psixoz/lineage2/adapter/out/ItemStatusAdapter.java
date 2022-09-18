package ru.psixoz.lineage2.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.psixoz.lineage2.model.user.ItemStatus;
import ru.psixoz.lineage2.port.out.ItemStatusRepository;

public interface ItemStatusAdapter extends ItemStatusRepository, JpaRepository<ItemStatus, Long> {
}
