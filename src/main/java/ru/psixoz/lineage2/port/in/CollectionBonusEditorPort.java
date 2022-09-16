package ru.psixoz.lineage2.port.in;

import lombok.Builder;
import lombok.Value;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
public interface CollectionBonusEditorPort {

    void createBonus(@Valid CreateBonusRequest request);


    @Value
    @Builder
    class CreateBonusRequest {
        @NotNull
        String descriptionCode;
        @NotNull
        String enchantCode;
    }
}
