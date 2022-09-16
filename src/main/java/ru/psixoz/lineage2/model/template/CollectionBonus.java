package ru.psixoz.lineage2.model.template;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.psixoz.lineage2.model.BaseEntity;
import ru.psixoz.lineage2.model.ref.BonusDescription;
import ru.psixoz.lineage2.model.ref.Enchant;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "COLLECTION_BONUS")
public class CollectionBonus extends BaseEntity {

    @Setter
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "BONUS_DESCRIPTION_CODE", referencedColumnName = "CODE")
    BonusDescription description;

    @Setter
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "ENCHANT_CODE", referencedColumnName = "CODE")
    Enchant enchant;

    public String getBonusDescription() {
        return description.getDescription() + ": " + getEnchant().getDescription();
    }

}
