package ru.psixoz.lineage2.port.in;

import lombok.Builder;
import lombok.Value;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
public interface ItemTypeEditorService {

    void createItemType(@Valid CreateItemTypeRequest request);

    @Value
    @Builder
    class CreateItemTypeRequest {
        @NotNull
        String code;
        @NotNull
        String description;

    }

}
