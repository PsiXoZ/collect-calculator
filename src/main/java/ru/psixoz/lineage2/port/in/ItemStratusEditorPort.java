package ru.psixoz.lineage2.port.in;

import lombok.Builder;
import lombok.Value;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
public interface ItemStratusEditorPort {

    void markComplete(@Valid MarkCompleteItemStatusRequest request);

    @Value
    @Builder
    class MarkCompleteItemStatusRequest {
        @NotNull
        Long characterId;
        @NotNull
        Long collectionTemplateId;
        @NotNull
        Long itemTemplateId;
    }
}
