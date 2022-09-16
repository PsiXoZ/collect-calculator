package ru.psixoz.lineage2.model.user;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Parent;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Characters {

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    final Set<Character> characters = new HashSet<>();

    @Parent
    Account account;

    public Characters(Account account) {
        this.account = account;
    }
}
