package ru.psixoz.lineage2.model.ref;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "SERVER_REFERENCE")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LineageServer extends BaseReference {

    public LineageServer(String code, String name) {
        super(code, name);
    }

}
