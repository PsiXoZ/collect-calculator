package ru.psixoz.lineage2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import ru.psixoz.lineage2.model.ref.LineageServer;
import ru.psixoz.lineage2.model.ref.LineageServerType;
import ru.psixoz.lineage2.model.user.Account;
import ru.psixoz.lineage2.model.user.Character;

@SpringBootTest
@ActiveProfiles({"local", "test"})
@Transactional
@AutoConfigureTestEntityManager
public abstract class AbstractSpringBootTest {
    @Autowired
    protected TestEntityManager entityManager;


    protected Character createCharacter(Account account, String name, LineageServer server) {
        Character character = new Character(account, name, server);
        return entityManager.persist(character);
    }

    protected LineageServer createServer(String code, String name, LineageServerType serverType) {
        LineageServer server = new LineageServer(code, name, serverType);
        return entityManager.persist(server);
    }

    protected Account createAccount() {
        return createAccount("Test_Login");
    }

    protected Account createAccount(String login) {
        return createAccount(login, "Test Full Name");
    }


    protected Account createAccount(String login, String fullName) {
        Account account = new Account();
        account.setLogin(login);
        account.setFullName(fullName);
        return entityManager.persist(account);
    }

    protected void flushAndClearSession() {
        entityManager.flush();
        entityManager.clear();
    }
}
