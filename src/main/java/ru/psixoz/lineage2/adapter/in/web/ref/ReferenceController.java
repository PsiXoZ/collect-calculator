package ru.psixoz.lineage2.adapter.in.web.ref;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.psixoz.lineage2.adapter.in.web.RestAdapter;
import ru.psixoz.lineage2.port.in.*;

import static ru.psixoz.lineage2.port.in.CollectionEditorService.CreateCollectionRequest;
import static ru.psixoz.lineage2.port.in.CollectionEditorService.CreateCollectionResponse;
import static ru.psixoz.lineage2.port.in.EnchantEditorService.CreateEnchantRequest;
import static ru.psixoz.lineage2.port.in.ItemEditorService.CreateItemRequest;
import static ru.psixoz.lineage2.port.in.ItemTypeEditorService.CreateItemTypeRequest;
import static ru.psixoz.lineage2.port.in.ServerEditorService.CreateServerRequest;

@RestAdapter(path = "/api/reference")
@RequiredArgsConstructor
public class ReferenceController {
    final ServerEditorService serverEditorService;
    final ItemEditorService itemEditorService;
    final ItemTypeEditorService itemTypeEditorService;
    final EnchantEditorService enchantEditorService;
    final CollectionEditorService collectionEditorService;

    @PostMapping("/server/create")
    public void createServer(@RequestBody CreateServerRequest request) {
        serverEditorService.createServer(request);
    }
    @PostMapping("/enchant/create")
    public void createEnchant(@RequestBody CreateEnchantRequest request) {
        enchantEditorService.createEnchant(request);
    }
    @PostMapping("/item/createItemType")
    public void createItemType(@RequestBody CreateItemTypeRequest request) {
        itemTypeEditorService.createItemType(request);
    }
    @PostMapping("/item/create")
    public void createItem(@RequestBody CreateItemRequest request) {
        itemEditorService.createItem(request);
    }
    @PostMapping("/collection/create")
    public CreateCollectionResponse createCollection(@RequestBody CreateCollectionRequest request) {
        return collectionEditorService.createCollection(request);
    }

}
