package ru.psixoz.lineage2.usecase.ref;

import lombok.RequiredArgsConstructor;
import ru.psixoz.lineage2.model.ref.LineageServer;
import ru.psixoz.lineage2.port.in.ServerEditorPort;
import ru.psixoz.lineage2.port.out.ref.ServerRepository;
import ru.psixoz.lineage2.usecase.common.CommandUseCase;

import java.util.Optional;

import static java.lang.String.format;

@CommandUseCase
@RequiredArgsConstructor
public class ServerEditorUseCase implements ServerEditorPort {
    final ServerRepository serverRepository;

    @Override
    public void createServer(CreateServerRequest request) {
        Optional<LineageServer> lineageServerOp = serverRepository.findByCodeIgnoreCase(request.getCode());
        if (lineageServerOp.isPresent()) {
            LineageServer server = lineageServerOp.get();
            throw new IllegalArgumentException(format("Server with code: %s already exist, Existing name: %s, current name: %s ", request.getCode(), server.getDescription(), request.getServerName()));
        }
        serverRepository.save(new LineageServer(request.getCode(), request.getServerName()));

    }
}
