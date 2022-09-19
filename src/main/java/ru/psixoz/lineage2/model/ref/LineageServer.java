package ru.psixoz.lineage2.model.ref;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "LINEAGE_SERVER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LineageServer extends BaseReference {

    @Column(name = "LINEAGE_TYPE")
    @Enumerated(EnumType.STRING)
    LineageServerType serverType;

    public LineageServer(String code, String name, LineageServerType serverType) {
        super(code, name);
        this.serverType = serverType;
    }

}
