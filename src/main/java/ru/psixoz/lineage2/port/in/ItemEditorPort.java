package ru.psixoz.lineage2.port.in;

import lombok.Builder;
import lombok.Value;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
public interface ItemEditorPort {

    CreateItemResponse createItem(@Valid CreateItemRequest request);

    @Value
    @Builder
    class CreateItemResponse {
        Long id;
    }

    @Value
    @Builder
    class CreateItemRequest {
        @NotNull
        String name;
    }
}
