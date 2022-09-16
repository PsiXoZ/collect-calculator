package ru.psixoz.lineage2.model.template;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Parent;
import ru.psixoz.lineage2.model.ref.Enchant;
import ru.psixoz.lineage2.model.ref.ItemType;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static java.lang.String.format;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CollectionItems {

    @ManyToMany(mappedBy = "collections", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Getter
    final Set<ItemTemplate> items = new HashSet<>();


    @Parent
    @Getter
    @Setter
    CollectionTemplate collectionTemplate;

    public CollectionItems(CollectionTemplate collectionTemplate) {
        this.collectionTemplate = collectionTemplate;
    }

    public ItemTemplate createItemTemplate(Item item, Enchant enchant, ItemType type) {
        ItemTemplate itemTemplate = new ItemTemplate();
        itemTemplate.setItem(item);
        itemTemplate.setEnchant(enchant);
        itemTemplate.setType(type);

        return itemTemplate;
    }

    public void addItem(Collection<ItemTemplate> itemTemplates) {
        itemTemplates.forEach(this::addItem);
    }

    public void addItem(ItemTemplate itemTemplate) {
        if (isItemExist(itemTemplate)) {
            throw new IllegalArgumentException(format("Item with name: %s, enchant: %s, type: %s already exist",
                    itemTemplate.getItem().getName(),
                    itemTemplate.getEnchant().getDescription(),
                    itemTemplate.getType().getDescription()));
        }
        itemTemplate.getCollections().add(collectionTemplate);
        items.add(itemTemplate);
    }

    private boolean isItemExist(ItemTemplate itemTemplate) {
         return items.stream().anyMatch(item -> (
                isItemNameEquals(itemTemplate, item) &&
                        isEnchantCodeEquals(itemTemplate, item) &&
                        isTypeCodeEquals(itemTemplate, item)));
    }

    private boolean isTypeCodeEquals(ItemTemplate itemTemplate, ItemTemplate item) {
        return item.getType().getCode().equals(itemTemplate.getType().getCode());
    }

    private boolean isEnchantCodeEquals(ItemTemplate itemTemplate, ItemTemplate item) {
        return item.getEnchant().getCode().equals(itemTemplate.getEnchant().getCode());
    }

    private boolean isItemNameEquals(ItemTemplate itemTemplate, ItemTemplate item) {
        return item.getItem().getName().equals(itemTemplate.getItem().getName());
    }

}
