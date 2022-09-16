package ru.psixoz.lineage2.port.out;

import ru.psixoz.lineage2.model.ref.LineageServer;

import java.util.Optional;

public interface ServerRepository {

    LineageServer save(LineageServer server);
    Optional<LineageServer> findByCode(String code);

    default LineageServer findByCodeOrThrow(String code) {
        return findByCode(code).orElseThrow(() -> new RuntimeException("Cannot find server with code: " + code));
    }
}
