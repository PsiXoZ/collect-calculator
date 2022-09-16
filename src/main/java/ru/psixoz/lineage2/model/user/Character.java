package ru.psixoz.lineage2.model.user;

import lombok.Getter;
import ru.psixoz.lineage2.model.BaseEntity;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "CHARACTER")
public class Character extends BaseEntity {

    @Column(name = "CHARACTER_NAME")
    String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ACCOUNT_ID")
    Account account;

}
