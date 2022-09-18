package ru.psixoz.lineage2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.psixoz.lineage2.model.ref.Enchant;
import ru.psixoz.lineage2.model.ref.ItemType;
import ru.psixoz.lineage2.model.template.CollectionItems;
import ru.psixoz.lineage2.model.template.Item;
import ru.psixoz.lineage2.model.template.ItemTemplate;
import ru.psixoz.lineage2.port.out.ref.EnchantRepository;
import ru.psixoz.lineage2.port.out.ref.ItemRepository;
import ru.psixoz.lineage2.port.out.ref.ItemTypeRepository;

import java.util.Collection;

import static java.lang.String.format;
import static ru.psixoz.lineage2.port.in.ref.CollectionEditorPort.*;

@Service
@RequiredArgsConstructor
public class CollectionItemsService {
    final ItemRepository itemRepository;
    final EnchantRepository enchantRepository;
    final ItemTypeRepository itemTypeRepository;
    public void addCollectionItems(CollectionItems itemsCollection, Collection<ItemProjection> requestedItems) {
        for (ItemProjection itemProjection : requestedItems) {
            Item item = itemRepository.findByIdOrThrow(itemProjection.getItemId());
            Enchant enchant = enchantRepository.findByCodeIgnoreCase(itemProjection.getEnchantCode())
                    .orElseThrow(() -> new RuntimeException(format("Cannot find enchant code: %s", itemProjection.getEnchantCode())));
            ItemType itemType = itemTypeRepository.findByCodeIgnoreCase(itemProjection.getTypeCode())
                    .orElseThrow(() -> new RuntimeException(format("Cannot find item type code: %s", itemProjection.getTypeCode())));

            ItemTemplate itemTemplate = itemsCollection.createItemTemplate(item, enchant, itemType);

            itemsCollection.addItem(itemTemplate);

        }
    }
}
