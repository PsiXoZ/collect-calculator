package ru.psixoz.lineage2.port.out;

import ru.psixoz.lineage2.model.user.Account;

public interface AccountRepository {

    Account save(Account account);
}
