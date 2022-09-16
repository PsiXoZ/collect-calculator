package ru.psixoz.lineage2.port.in;

import lombok.Builder;
import lombok.Value;
import org.springframework.validation.annotation.Validated;
import ru.psixoz.lineage2.model.ref.CollectionType;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Validated
public interface CollectionEditorService {

    CreateCollectionResponse createCollection(@Valid CreateCollectionRequest request);

    @Value
    @Builder
    class CreateCollectionResponse {
        Long id;
    }

    @Value
    @Builder
    class CreateCollectionRequest {
        @NotNull
        String name;
        @NotNull
        CollectionType collectionType;
        @NotNull
        String description;
        @NotEmpty
        Collection<ItemProjection> items;

    }

    @Value
    @Builder
    class ItemProjection {
        Long itemId;
        String enchantCode;
        String typeCode;
    }
}
