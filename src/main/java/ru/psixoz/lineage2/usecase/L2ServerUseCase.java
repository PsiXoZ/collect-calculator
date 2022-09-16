package ru.psixoz.lineage2.usecase;

import lombok.RequiredArgsConstructor;
import ru.psixoz.lineage2.model.ref.LineageServer;
import ru.psixoz.lineage2.port.in.L2ServerService;
import ru.psixoz.lineage2.port.out.ServerRepository;
import ru.psixoz.lineage2.usecase.common.CommandUseCase;

import java.util.Optional;

@CommandUseCase
@RequiredArgsConstructor
public class L2ServerUseCase implements L2ServerService {
    final ServerRepository serverRepository;

    @Override
    public void createServer(CreateServerRequest request) {
        Optional<LineageServer> lineageServerOp = serverRepository.findByCode(request.getCode());
        if (lineageServerOp.isPresent()) {
            throw new IllegalArgumentException("Server already exist with code: " + request.getCode());
        }
        serverRepository.save(new LineageServer(request.getCode(), request.getServerName()));

    }
}
