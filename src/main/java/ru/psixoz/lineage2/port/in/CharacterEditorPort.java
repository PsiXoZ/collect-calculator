package ru.psixoz.lineage2.port.in;

import lombok.Builder;
import lombok.Value;
import org.springframework.validation.annotation.Validated;
import ru.psixoz.lineage2.model.ref.LineageServerType;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
public interface CharacterEditorPort {

    CreateCharacterResponse createCharacter(@Valid CreateCharacterRequest request);

    @Value
    @Builder
    class CreateCharacterRequest {
        @NotNull
        Long accountId;
        @NotNull
        String name;
        @NotNull
        String serverCode;
        @NotNull LineageServerType serverType;
    }

    @Value
    @Builder
    class CreateCharacterResponse {
        @NotNull
        Long id;
    }
}
