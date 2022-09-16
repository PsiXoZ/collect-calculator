package ru.psixoz.lineage2.model.ref;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "L2_SERVER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LineageServer extends BaseReference {

    public LineageServer(String code, String name) {
        this.code = code;
        this.description = name;
    }

}
