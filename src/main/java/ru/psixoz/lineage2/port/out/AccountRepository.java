package ru.psixoz.lineage2.port.out;

import ru.psixoz.lineage2.model.user.Account;

import java.util.Optional;

public interface AccountRepository {

    Account save(Account account);

    Optional<Account> findById(Long accountId);

    default Account findByIdOrThrow(Long accountId) {
        return findById(accountId).orElseThrow(() -> new RuntimeException("Cannot find account with id: " + accountId));
    }
}
