package ru.psixoz.lineage2.port.in;

import lombok.Builder;
import lombok.Value;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Collection;

@Validated
public interface AccountViewerPort {

    GetAccountCharactersResponse getAccountCharacters(@NotNull Long accountId);

    @Value
    @Builder
    class GetAccountCharactersResponse {
        Long accountId;
        Collection<AccountCharacterProjection> characters;
    }

    @Value
    @Builder
    class AccountCharacterProjection {
        Long id;
        String name;
    }
}
