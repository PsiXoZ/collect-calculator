package ru.psixoz.lineage2.adapter.in.web.ref;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.psixoz.lineage2.adapter.in.web.RestAdapter;
import ru.psixoz.lineage2.port.in.ref.*;

import static ru.psixoz.lineage2.port.in.ref.BonusDescriptionEditorPort.*;
import static ru.psixoz.lineage2.port.in.ref.CollectionBonusEditorPort.*;
import static ru.psixoz.lineage2.port.in.ref.CollectionEditorPort.CreateCollectionRequest;
import static ru.psixoz.lineage2.port.in.ref.CollectionEditorPort.CreateCollectionResponse;
import static ru.psixoz.lineage2.port.in.ref.CollectionViewerPort.*;
import static ru.psixoz.lineage2.port.in.ref.EnchantEditorPort.CreateEnchantRequest;
import static ru.psixoz.lineage2.port.in.ref.EnchantTypeEditorPort.*;
import static ru.psixoz.lineage2.port.in.ref.ItemEditorPort.*;
import static ru.psixoz.lineage2.port.in.ref.ItemEditorPort.CreateItemRequest;
import static ru.psixoz.lineage2.port.in.ref.ItemTypeEditorPort.CreateItemTypeRequest;
import static ru.psixoz.lineage2.port.in.ref.ServerEditorPort.CreateServerRequest;

@RestAdapter(path = "/api/reference")
@RequiredArgsConstructor
public class ReferenceController {
    final ServerEditorPort serverEditorPort;
    final ItemEditorPort itemEditorPort;
    final ItemTypeEditorPort itemTypeEditorPort;
    final EnchantEditorPort enchantEditorPort;
    final EnchantTypeEditorPort enchantTypeEditorPort;
    final CollectionEditorPort collectionEditorPort;
    final CollectionViewerPort collectionViewerPort;
    final CollectionBonusEditorPort collectionBonusEditorPort;
    final BonusDescriptionEditorPort bonusDescriptionEditorPort;

    @PostMapping("/server/create")
    public void createServer(@RequestBody CreateServerRequest request) {
        serverEditorPort.createServer(request);
    }
    @PostMapping("/enchant/create")
    public void createEnchant(@RequestBody CreateEnchantRequest request) {
        enchantEditorPort.createEnchant(request);
    }

    @PostMapping("/enchant/createType")
    public void createEnchantType(@RequestBody CreateEnchantTypeRequest request) {
        enchantTypeEditorPort.createEnchantedType(request);
    }
    @PostMapping("/item/createItemType")
    public void createItemType(@RequestBody CreateItemTypeRequest request) {
        itemTypeEditorPort.createItemType(request);
    }
    @PostMapping("/item/create")
    public CreateItemResponse createItem(@RequestBody CreateItemRequest request) {
        return itemEditorPort.createItem(request);
    }
    @PostMapping("/bonus/create")
    public void createBonus(@RequestBody CreateBonusRequest request) {
        collectionBonusEditorPort.createBonus(request);
    }
    @PostMapping("/bonus/createDescription")
    public void createBonusDescription(@RequestBody CreateBonusDescriptionRequest request) {
        bonusDescriptionEditorPort.createBonusDescription(request);
    }
    @PostMapping("/collection/create")
    public CreateCollectionResponse createCollection(@RequestBody CreateCollectionRequest request) {
        return collectionEditorPort.createCollection(request);
    }
    @GetMapping("/collection/getAll")
    public GetAllCollectionsResponse getAllCollections() {
        return collectionViewerPort.getAllCollections();
    }

}
