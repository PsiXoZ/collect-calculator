package ru.psixoz.lineage2.usecase;

import lombok.RequiredArgsConstructor;
import ru.psixoz.lineage2.model.template.CollectionTemplate;
import ru.psixoz.lineage2.port.in.CollectionViewerPort;
import ru.psixoz.lineage2.port.out.ref.CollectionRepository;
import ru.psixoz.lineage2.usecase.common.QueryUseCase;

import java.util.Collection;
import java.util.stream.Collectors;

@QueryUseCase
@RequiredArgsConstructor
public class CollectionViewerUseCase implements CollectionViewerPort {
    final CollectionRepository collectionRepository;

    @Override
    public GetAllCollectionsResponse getAllCollections() {
        Collection<CollectionTemplate> collections = collectionRepository.findAll();

        return GetAllCollectionsResponse.builder()
                .collections(collections.stream()
                        .map(collectionTemplate -> CollectionProjection.builder()
                                .id(collectionTemplate.getId())
                                .bonus(BonusProjection.builder()
                                        .id(collectionTemplate.getCollectionBonus().getId())
                                        .description(collectionTemplate.getCollectionBonus().getBonusDescription())
                                        .build())
                                .name(collectionTemplate.getName())
                                .type(CollectionTypeProjection.builder()
                                        .code(collectionTemplate.getCollectionType().name())
                                        .build())
                                .items(collectionTemplate.getItemsCollection().getItems().stream()
                                        .map(itemTemplate -> ItemProjection.builder()
                                                .id(itemTemplate.getId())
                                                .name(itemTemplate.getItem().getName())
                                                .type(itemTemplate.getType().getDescription())
                                                .enchant(itemTemplate.getEnchant().getDescription())
                                                .build()).collect(Collectors.toList()))
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }
}
