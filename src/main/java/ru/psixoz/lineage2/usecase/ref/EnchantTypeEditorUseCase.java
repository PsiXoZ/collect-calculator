package ru.psixoz.lineage2.usecase.ref;

import lombok.RequiredArgsConstructor;
import ru.psixoz.lineage2.model.ref.EnchantType;
import ru.psixoz.lineage2.port.in.EnchantTypeEditorPort;
import ru.psixoz.lineage2.port.out.ref.EnchantTypeRepository;
import ru.psixoz.lineage2.usecase.common.CommandUseCase;

import javax.validation.Valid;
import java.util.Optional;

import static java.lang.String.format;

@CommandUseCase
@RequiredArgsConstructor
public class EnchantTypeEditorUseCase implements EnchantTypeEditorPort {
    final EnchantTypeRepository enchantTypeRepository;
    @Override
    public void createEnchantedType(@Valid CreateEnchantTypeRequest request) {
        Optional<EnchantType> enchantTypeOp = enchantTypeRepository.findByCodeIgnoreCase(request.getCode());
        if (enchantTypeOp.isPresent()) {
            throw new RuntimeException(format("EnchantType with code: %s already exist", request.getCode()));
        }
        enchantTypeRepository.save(new EnchantType(request.getCode(), request.getDescription()));


    }
}
