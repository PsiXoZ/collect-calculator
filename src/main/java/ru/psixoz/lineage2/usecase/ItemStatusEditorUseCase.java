package ru.psixoz.lineage2.usecase;

import lombok.RequiredArgsConstructor;
import ru.psixoz.lineage2.model.template.CollectionTemplate;
import ru.psixoz.lineage2.model.template.ItemTemplate;
import ru.psixoz.lineage2.model.user.CollectionStatus;
import ru.psixoz.lineage2.model.user.ItemStatus;
import ru.psixoz.lineage2.port.in.ItemStratusEditorPort;
import ru.psixoz.lineage2.port.out.CollectionStatusRepository;
import ru.psixoz.lineage2.port.out.ItemStatusRepository;
import ru.psixoz.lineage2.port.out.ref.CollectionRepository;
import ru.psixoz.lineage2.usecase.common.CommandUseCase;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

import static java.lang.String.format;

@CommandUseCase
@RequiredArgsConstructor
public class ItemStatusEditorUseCase implements ItemStratusEditorPort {
    final CollectionStatusRepository collectionStatusRepository;
    final ItemStatusRepository itemStatusRepository;
    final CollectionRepository collectionRepository;

    @Override
    public void markComplete(MarkCompleteItemStatusRequest request) {
        Optional<CollectionStatus> collectionStatusOp = collectionStatusRepository.findByCharacterIdAndCollectionTemplateId(request.getCharacterId(), request.getCollectionTemplateId());
        CollectionStatus collectionStatus;
        if (collectionStatusOp.isPresent()) {
             collectionStatus = collectionStatusOp.get();
        } else {
            CollectionStatus newCollectionStatus = new CollectionStatus();
            newCollectionStatus.setCollectionTemplateId(request.getCollectionTemplateId());
            newCollectionStatus.setCharacterId(request.getCharacterId());
            collectionStatus = collectionStatusRepository.save(newCollectionStatus);
        }

        Optional<ItemStatus> itemStatusOp = itemStatusRepository.findByCollectionStatusIdAndItemTemplateId(collectionStatus.getId(), request.getItemTemplateId());
        if (itemStatusOp.isPresent()) {
            throw new RuntimeException(format("Item status with collectionStatusId: %s and ItemTemplate: %s already exist", collectionStatus.getId(), request.getItemTemplateId()));
        }

        ItemStatus itemStatus = new ItemStatus();
        itemStatus.setCollectionStatusId(collectionStatus.getId());
        itemStatus.setItemTemplateId(request.getItemTemplateId());
        itemStatus.setComplete(true);
        itemStatusRepository.save(itemStatus);

        //Check all items complete, then complete collection
        CollectionTemplate collectionTemplate = collectionRepository.findByIdOrThrow(request.getCollectionTemplateId());
        Collection<ItemStatus> completeItemStatuses = itemStatusRepository.findByCollectionStatusIdAndComplete(collectionStatus.getId(), true);
        Set<ItemTemplate> items = collectionTemplate.getItemsCollection().getItems();

        if (items.size() == completeItemStatuses.size()) {
            collectionStatus.setComplete(true);
            collectionStatusRepository.save(collectionStatus);
        }
    }
}
