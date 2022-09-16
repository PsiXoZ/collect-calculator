package ru.psixoz.lineage2.port.in;

import lombok.Builder;
import lombok.Value;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface BonusDescriptionEditorPort {

    void createBonusDescription(@Valid CreateBonusDescriptionRequest request);

    @Value
    @Builder
    class CreateBonusDescriptionRequest {
        @NotNull
        String code;
        @NotNull
        String name;
    }
}
