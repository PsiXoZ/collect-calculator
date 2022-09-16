package ru.psixoz.lineage2.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.psixoz.lineage2.port.in.L2ServerService;

import static ru.psixoz.lineage2.port.in.L2ServerService.*;

@RestAdapter(path = "/api/l2server")
@RequiredArgsConstructor
public class ServerController {
    final L2ServerService serverService;

    @PostMapping(name = "/addServer")
    public void addServer(@RequestBody CreateServerRequest request) {
        serverService.createServer(request);
    }

}
