package ru.psixoz.lineage2.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.psixoz.lineage2.model.user.Account;
import ru.psixoz.lineage2.port.out.AccountRepository;

import java.util.Optional;

public interface AccountAdapter extends AccountRepository, JpaRepository<Account, Long> {

}
