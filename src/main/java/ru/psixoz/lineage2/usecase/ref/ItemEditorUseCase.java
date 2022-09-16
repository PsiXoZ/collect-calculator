package ru.psixoz.lineage2.usecase.ref;

import lombok.RequiredArgsConstructor;
import ru.psixoz.lineage2.model.template.Item;
import ru.psixoz.lineage2.port.in.ItemEditorService;
import ru.psixoz.lineage2.port.out.ref.ItemRepository;
import ru.psixoz.lineage2.usecase.common.CommandUseCase;

import java.util.Optional;

import static java.lang.String.format;

@CommandUseCase
@RequiredArgsConstructor
public class ItemEditorUseCase implements ItemEditorService {
    final ItemRepository itemRepository;

    @Override
    public CreateItemResponse createItem(CreateItemRequest request) {
        Optional<Item> itemOp = itemRepository.findByNameIgnoreCase(request.getName());

        if (itemOp.isPresent()) {
            throw new RuntimeException(format("Item with name: %s already exist", request.getName()));
        }
        Item item = new Item();
        item.setName(request.getName());

        return CreateItemResponse.builder()
                .id(itemRepository.save(item).getId())
                .build();
    }
}
