package ru.psixoz.lineage2.usecase;

import lombok.RequiredArgsConstructor;
import ru.psixoz.lineage2.model.user.Account;
import ru.psixoz.lineage2.port.in.AccountEditorPort;
import ru.psixoz.lineage2.port.out.AccountRepository;
import ru.psixoz.lineage2.usecase.common.CommandUseCase;

import java.util.Optional;

import static java.lang.String.format;

@CommandUseCase
@RequiredArgsConstructor
public class AccountEditorUseCase implements AccountEditorPort {
    final AccountRepository accountRepository;
    @Override
    public CreateAccountResponse createAccount(CreateAccountRequest request) {
        Optional<Account> accountOp = accountRepository.findByLogin(request.getLogin());

        if (accountOp.isPresent()) {
            throw new RuntimeException(format("Account with login: %s already exist", request.getLogin()));
        }

        Account account = new Account();
        account.setLogin(request.getLogin());
        account.setFullName(request.getFullName());
        Long id = accountRepository.save(account).getId();
        return CreateAccountResponse.builder()
                .accountId(id)
                .build();
    }
}
