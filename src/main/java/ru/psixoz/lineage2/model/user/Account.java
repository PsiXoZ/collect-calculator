package ru.psixoz.lineage2.model.user;

import lombok.Getter;
import ru.psixoz.lineage2.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "ACCOUNT")
public class Account extends BaseEntity {

    @Column(name = "LOGIN")
    String login;

    @Column(name = "FULL_NAME")
    String fullName;

    final Characters chars = new Characters(this);
}
