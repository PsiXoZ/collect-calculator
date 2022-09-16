package ru.psixoz.lineage2.adapter.out.ref;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.psixoz.lineage2.model.ref.LineageServer;
import ru.psixoz.lineage2.port.out.ref.ServerRepository;

public interface ServerAdapter extends ServerRepository, JpaRepository<LineageServer, String> {
}
