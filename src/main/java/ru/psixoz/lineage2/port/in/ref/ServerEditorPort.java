package ru.psixoz.lineage2.port.in.ref;

import lombok.Builder;
import lombok.Value;
import org.springframework.validation.annotation.Validated;
import ru.psixoz.lineage2.model.ref.LineageServerType;

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
        @NotNull LineageServerType serverType;
        @NotNull
        String serverName;
    }
}
