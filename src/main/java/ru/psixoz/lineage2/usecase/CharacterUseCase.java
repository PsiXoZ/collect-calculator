package ru.psixoz.lineage2.usecase;

import lombok.RequiredArgsConstructor;
import ru.psixoz.lineage2.model.ref.LineageServer;
import ru.psixoz.lineage2.model.user.Account;
import ru.psixoz.lineage2.port.in.CharacterService;
import ru.psixoz.lineage2.port.out.AccountRepository;
import ru.psixoz.lineage2.port.out.ref.ServerRepository;
import ru.psixoz.lineage2.usecase.common.UseCase;

@UseCase
@RequiredArgsConstructor
public class CharacterUseCase implements CharacterService {
    final AccountRepository accountRepository;
    final ServerRepository serverRepository;


    @Override
    public CreateCharacterResponse createCharacter(CreateCharacterRequest request) {
        Account account = accountRepository.findByIdOrThrow(request.getAccountId());
        LineageServer lineageServer = serverRepository.findByCodeOrThrow(request.getServerCode());
        account.getCharacters().addCharacter(request.getName(), lineageServer);
        accountRepository.save(account);
        return CreateCharacterResponse.builder()
                .id(account.getCharacters().getCharacter(request.getName(), lineageServer).getId())
                .build();

    }
}
