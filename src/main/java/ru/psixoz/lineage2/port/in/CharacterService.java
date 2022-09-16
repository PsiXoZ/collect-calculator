package ru.psixoz.lineage2.port.in;

import lombok.Builder;
import lombok.Value;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
public interface CharacterService {

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
    }

    @Value
    @Builder
    class CreateCharacterResponse {
        @NotNull
        Long id;
    }
}
