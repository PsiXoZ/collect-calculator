package ru.psixoz.lineage2.port.in.ref;

import lombok.Builder;
import lombok.Value;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
public interface EnchantTypeEditorPort {

    void createEnchantedType(@Valid CreateEnchantTypeRequest request);

    @Value
    @Builder
    class CreateEnchantTypeRequest {
        @NotNull
        String code;
        @NotNull
        String description;
    }
}
