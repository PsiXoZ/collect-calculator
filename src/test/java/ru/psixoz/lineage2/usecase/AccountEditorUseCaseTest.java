package ru.psixoz.lineage2.usecase;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.psixoz.lineage2.AbstractSpringBootTest;
import ru.psixoz.lineage2.port.in.AccountEditorPort;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.psixoz.lineage2.port.in.AccountEditorPort.*;

public class AccountEditorUseCaseTest extends AbstractSpringBootTest {
    @Autowired
    AccountEditorPort accountEditorPort;


    @Test
    void test_create_account() {
        CreateAccountResponse account = accountEditorPort.createAccount(CreateAccountRequest.builder()
                .fullName("test test")
                .login("test")
                .password("test")
                .build());

        flushAndClearSession();

        assertThat(account).isNotNull();
    }

    @Test
    void test_account_already_exist() {
        createAccount("test", "test");
        flushAndClearSession();
        Throwable thrown = assertThrows(RuntimeException.class, () -> accountEditorPort.createAccount(CreateAccountRequest.builder()
                .fullName("test")
                .login("test")
                .password("test")
                .build()));

        assertThat(thrown.getMessage()).isEqualTo("Account with login: test already exist");

    }
}
