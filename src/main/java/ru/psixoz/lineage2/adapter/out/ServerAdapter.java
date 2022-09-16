package ru.psixoz.lineage2.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.psixoz.lineage2.model.ref.LineageServer;
import ru.psixoz.lineage2.port.out.ServerRepository;

public interface ServerAdapter extends ServerRepository, JpaRepository<LineageServer, String> {
}
