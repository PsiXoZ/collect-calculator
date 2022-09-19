package ru.psixoz.lineage2.usecase;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.psixoz.lineage2.AbstractSpringBootTest;
import ru.psixoz.lineage2.model.ref.LineageServer;
import ru.psixoz.lineage2.model.user.Account;
import ru.psixoz.lineage2.port.in.CharacterEditorPort;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.psixoz.lineage2.port.in.CharacterEditorPort.*;

public class CharacterUseCaseTest extends AbstractSpringBootTest {
    @Autowired
    CharacterEditorPort characterEditorPort;

    @Test
    void test_create_character() {
        Account account = createAccount();
        LineageServer server = createServer("Bartz", "TestServer");
        flushAndClearSession();

        CreateCharacterResponse testCharacter = characterEditorPort.createCharacter(CreateCharacterRequest.builder()
                .accountId(account.getId())
                .name("TestCharacter")
                .serverCode(server.getCode())
                .build());

        assertThat(testCharacter).isNotNull();

    }

    @Test
    void test_character_exist() {
        Account account = createAccount();
        LineageServer server = createServer("Bartz", "TestServer");
        createCharacter(account, "test", server);
        flushAndClearSession();

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> characterEditorPort.createCharacter(CreateCharacterRequest.builder()
                .accountId(account.getId())
                .name("test")
                .serverCode(server.getCode())
                .build()));

        assertThat(thrown.getMessage()).isEqualTo("Character with name: test already exist on server: TestServer");
    }
}
