package ru.psixoz.lineage2.port.in.ref;

import lombok.Builder;
import lombok.Value;

import java.util.Collection;

public interface CollectionViewerPort {

    GetAllCollectionsResponse getAllCollections();

    @Value
    @Builder
    class GetAllCollectionsResponse {
        Collection<CollectionProjection> collections;
    }

    @Value
    @Builder
    class CollectionProjection {
        Long id;
        String name;
        BonusProjection bonus;
        CollectionTypeProjection type;
        Collection<ItemProjection> items;

    }

    @Value
    @Builder
    class BonusProjection {
        Long id;
        String description;
    }

    @Value
    @Builder
    class ItemProjection {
        Long id;
        String name;
        String enchant;
        String type;
    }

    @Value
    @Builder
    class CollectionTypeProjection {
        String code;
    }
}
