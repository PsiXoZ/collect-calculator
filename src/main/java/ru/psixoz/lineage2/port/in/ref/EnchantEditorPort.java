package ru.psixoz.lineage2.port.in.ref;

import lombok.Builder;
import lombok.Value;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
public interface EnchantEditorPort {

    void createEnchant(@Valid CreateEnchantRequest request);

    @Value
    @Builder
    class CreateEnchantRequest {
        @NotNull
        String code;
        @NotNull
        String enchantTypeCode;
        @NotNull
        String description;
    }

}
