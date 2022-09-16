package ru.psixoz.lineage2.usecase.ref;

import lombok.RequiredArgsConstructor;
import ru.psixoz.lineage2.model.ref.ItemType;
import ru.psixoz.lineage2.port.in.ItemTypeEditorPort;
import ru.psixoz.lineage2.port.out.ref.ItemTypeRepository;
import ru.psixoz.lineage2.usecase.common.CommandUseCase;

import java.util.Optional;

import static java.lang.String.format;

@CommandUseCase
@RequiredArgsConstructor
public class ItemTypeEditorUseCase implements ItemTypeEditorPort {
    final ItemTypeRepository itemTypeRepository;
    @Override
    public void createItemType(CreateItemTypeRequest request) {
        Optional<ItemType> itemTypeOp = itemTypeRepository.findByCodeIgnoreCase(request.getCode());

        if (itemTypeOp.isPresent()) {
            ItemType itemType = itemTypeOp.get();
            throw new RuntimeException(format("Item type with code: %s already exist. Existing description: %s, current description: %s", request.getCode(), itemType.getDescription(), request.getDescription()));
        }

        itemTypeRepository.save(new ItemType(request.getCode(), request.getDescription()));

    }
}
