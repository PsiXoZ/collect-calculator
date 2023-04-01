package ru.psixoz.lineage2.usecase;

import lombok.RequiredArgsConstructor;
import ru.psixoz.lineage2.model.user.Character;
import ru.psixoz.lineage2.port.in.AccountViewerPort;
import ru.psixoz.lineage2.port.out.CharacterRepository;
import ru.psixoz.lineage2.usecase.common.QueryUseCase;

import java.util.Collection;
import java.util.stream.Collectors;

@QueryUseCase
@RequiredArgsConstructor
public class AccountViewerUseCase implements AccountViewerPort {
    final CharacterRepository characterRepository;
    @Override
    public GetAccountCharactersResponse getAccountCharacters(Long accountId) {
        Collection<Character> characters = characterRepository.findByAccountId(accountId);

        return GetAccountCharactersResponse.builder()
                .accountId(accountId)
                .characters(characters.stream()
                        .map(character -> AccountCharacterProjection.builder()
                                .id(character.getId())
                                .name(character.getName())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }
}
