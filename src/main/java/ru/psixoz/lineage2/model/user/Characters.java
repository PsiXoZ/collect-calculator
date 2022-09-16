package ru.psixoz.lineage2.model.user;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Parent;
import ru.psixoz.lineage2.model.ref.LineageServer;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

import static java.lang.String.format;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Characters {

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    final Set<Character> characters = new HashSet<>();

    @Parent
    @Getter
    @Setter
    Account account;

    public Characters(Account account) {
        this.account = account;
    }


    public void addCharacter(String name, LineageServer server) {
        boolean exist = characters.stream()
                .anyMatch(character -> (character.getName().equals(name) && character.getServer().getCode().equals(server.getCode())));

        if (exist) {
            throw new IllegalArgumentException(format("Character with name: %s already exist on server: %s", name, server.getDescription()));
        }

        Character character = new Character(account, name, server);
        characters.add(character);
    }

    public Character getCharacter(String name, LineageServer server) {
        return characters.stream()
                .filter(character -> (character.getName().equals(name) && character.getServer().getCode().equals(server.getCode())))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(format("Character with name: %s not found on server: %s", name, server.getDescription())));
    }
}
