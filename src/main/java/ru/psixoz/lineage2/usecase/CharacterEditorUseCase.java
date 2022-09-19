package ru.psixoz.lineage2.usecase;

import lombok.RequiredArgsConstructor;
import ru.psixoz.lineage2.model.ref.LineageServer;
import ru.psixoz.lineage2.model.user.Account;
import ru.psixoz.lineage2.model.user.Character;
import ru.psixoz.lineage2.port.in.CharacterEditorPort;
import ru.psixoz.lineage2.port.out.AccountRepository;
import ru.psixoz.lineage2.port.out.CharacterRepository;
import ru.psixoz.lineage2.port.out.ref.ServerRepository;
import ru.psixoz.lineage2.usecase.common.UseCase;

import java.util.Optional;

import static java.lang.String.format;

@UseCase
@RequiredArgsConstructor
public class CharacterEditorUseCase implements CharacterEditorPort {
    final AccountRepository accountRepository;
    final ServerRepository serverRepository;
    final CharacterRepository characterRepository;


    @Override
    public CreateCharacterResponse createCharacter(CreateCharacterRequest request) {
        Account account = accountRepository.findByIdOrThrow(request.getAccountId());
        LineageServer lineageServer = serverRepository.findByCodeOrThrow(request.getServerCode());

        Optional<Character> characterOp = characterRepository.findByNameIgnoreCaseAndServer(request.getName(), request.getServerCode());
        if (characterOp.isPresent()) {
            Character character = characterOp.get();
            if (character.getAccount().getId().equals(account.getId()) && character.getServer().getServerType().equals(request.getServerType())) {
                throw new RuntimeException(format("Character with name: %s and sever: %s with type: %s already created in another account", request.getName(), lineageServer.getDescription(), request.getServerType()));
            }

        }

        account.getCharacters().addCharacter(request.getName(), lineageServer);
        accountRepository.save(account);
        return CreateCharacterResponse.builder()
                .id(account.getCharacters().getCharacter(request.getName(), lineageServer).getId())
                .build();

    }
}
