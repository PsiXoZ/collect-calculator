package ru.psixoz.lineage2.model.template;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Parent;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CollectionItems {

    @OneToMany(mappedBy = "collectionTemplate", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    final Set<ItemTemplate> items = new HashSet<>();


    @Parent
    @Getter
    @Setter
    CollectionTemplate collectionTemplate;

    public CollectionItems(CollectionTemplate collectionTemplate) {
        this.collectionTemplate = collectionTemplate;
    }
}
