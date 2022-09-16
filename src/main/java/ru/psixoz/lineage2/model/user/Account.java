package ru.psixoz.lineage2.model.user;

import lombok.Getter;
import lombok.Setter;
import ru.psixoz.lineage2.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "ACCOUNT")
public class Account extends BaseEntity {

    @Column(name = "LOGIN")
    @Setter
    String login;

    @Column(name = "FULL_NAME")
    @Setter
    String fullName;

    final Characters characters = new Characters(this);
}
