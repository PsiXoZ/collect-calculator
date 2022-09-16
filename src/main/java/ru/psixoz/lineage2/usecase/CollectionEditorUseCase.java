package ru.psixoz.lineage2.usecase;

import lombok.RequiredArgsConstructor;
import ru.psixoz.lineage2.model.template.CollectionTemplate;
import ru.psixoz.lineage2.port.in.CollectionEditorPort;
import ru.psixoz.lineage2.port.out.ref.CollectionRepository;
import ru.psixoz.lineage2.service.CollectionBonusService;
import ru.psixoz.lineage2.service.CollectionItemsService;
import ru.psixoz.lineage2.usecase.common.CommandUseCase;

import java.util.Optional;

import static java.lang.String.format;

@CommandUseCase
@RequiredArgsConstructor
public class CollectionEditorUseCase implements CollectionEditorPort {
    final CollectionRepository collectionRepository;
    final CollectionItemsService collectionItemsService;
    final CollectionBonusService bonusService;

    @Override
    public CreateCollectionResponse createCollection(CreateCollectionRequest request) {
        Optional<CollectionTemplate> collectionOp = collectionRepository.findByNameIgnoreCase(request.getName());

        if (collectionOp.isPresent()) {
            throw new RuntimeException(format("Collection with name: %s already exist", request.getName()));
        }

        CollectionTemplate template = new CollectionTemplate();
        template.setName(request.getName());
        template.setCollectionType(request.getCollectionType());
        bonusService.addCollectionBonus(template, request.getCollectionBonusId());
        collectionItemsService.addCollectionItems(template.getItemsCollection(), request.getItems());
        collectionRepository.save(template);

        return CreateCollectionResponse.builder()
                .id(collectionRepository.save(template).getId())
                .build();
    }
}
