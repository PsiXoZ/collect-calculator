package ru.psixoz.lineage2.usecase;

import lombok.RequiredArgsConstructor;
import ru.psixoz.lineage2.model.user.Account;
import ru.psixoz.lineage2.port.in.AccountService;
import ru.psixoz.lineage2.port.out.AccountRepository;
import ru.psixoz.lineage2.usecase.common.CommandUseCase;

@CommandUseCase
@RequiredArgsConstructor
public class CreateAccountUseCase implements AccountService {
    final AccountRepository accountRepository;
    @Override
    public CreateAccountResponse createAccount(CreateAccountRequest request) {
        Account account = new Account();
        account.setLogin(request.getLogin());
        account.setFullName(request.getFullName());
        Long id = accountRepository.save(account).getId();
        return CreateAccountResponse.builder()
                .accountId(id)
                .build();
    }
}
