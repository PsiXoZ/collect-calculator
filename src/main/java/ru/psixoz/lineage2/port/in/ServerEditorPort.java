package ru.psixoz.lineage2.port.in;

import lombok.Builder;
import lombok.Value;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
public interface ServerEditorPort {

    void createServer(@Valid CreateServerRequest request);

    @Value
    @Builder
    class CreateServerRequest {
        @NotNull
        String code;
        @NotNull
        String serverName;
    }
}
