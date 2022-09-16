package ru.psixoz.lineage2.port.in;

import lombok.Builder;
import lombok.Value;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Validated
public interface ItemEditorService {

    CreateItemResponse createItem(@Valid CreateItemRequest request);

    @Value
    @Builder
    class CreateItemResponse {
        Long id;
    }

    @Value
    @Builder
    class CreateItemRequest {
        String name;
    }
}
