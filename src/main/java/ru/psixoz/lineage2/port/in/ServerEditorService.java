package ru.psixoz.lineage2.port.in;

import lombok.Builder;
import lombok.Value;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Validated
public interface ServerEditorService {

    void createServer(CreateServerRequest request);

    @Value
    @Builder
    class CreateServerRequest {
        @NotNull
        String code;
        String serverName;
    }
}
