package ru.psixoz.lineage2.model.user;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.psixoz.lineage2.model.BaseEntity;
import ru.psixoz.lineage2.model.ref.LineageServer;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "CHARACTER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Character extends BaseEntity {

    @Column(name = "CHARACTER_NAME")
    @Setter
    String name;

    @OneToOne(fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "SERVER_CODE", referencedColumnName = "CODE")
    LineageServer server;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ACCOUNT_ID")
    Account account;

    public Character(Account account, String name, LineageServer server) {
        this.account = account;
        this.name = name;
        this.server = server;
    }

}
