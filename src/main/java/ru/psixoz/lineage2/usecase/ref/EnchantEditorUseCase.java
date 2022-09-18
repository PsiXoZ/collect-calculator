package ru.psixoz.lineage2.usecase.ref;

import lombok.RequiredArgsConstructor;
import ru.psixoz.lineage2.model.ref.Enchant;
import ru.psixoz.lineage2.model.ref.EnchantType;
import ru.psixoz.lineage2.port.in.ref.EnchantEditorPort;
import ru.psixoz.lineage2.port.out.ref.EnchantRepository;
import ru.psixoz.lineage2.port.out.ref.EnchantTypeRepository;
import ru.psixoz.lineage2.usecase.common.CommandUseCase;

import java.util.Optional;

import static java.lang.String.format;

@CommandUseCase
@RequiredArgsConstructor
public class EnchantEditorUseCase implements EnchantEditorPort {
    final EnchantRepository enchantRepository;
    final EnchantTypeRepository enchantTypeRepository;
    @Override
    public void createEnchant(CreateEnchantRequest request) {
        Optional<Enchant> enchantOp = enchantRepository.findByCodeIgnoreCase(request.getCode());

        enchantOp.ifPresent(enchant -> {
            throw new RuntimeException(format("Enchant with code: %s already exist. Existing name: %s, current name: %s", request.getCode(), enchant.getDescription(), request.getDescription()));
        });
        Optional<EnchantType> enchantTypeOp = enchantTypeRepository.findByCodeIgnoreCase(request.getEnchantTypeCode());
        if (enchantTypeOp.isPresent()){
            enchantRepository.save(new Enchant(request.getCode(), request.getDescription(), enchantTypeOp.get()));
        }else {
            throw new RuntimeException(format("Cannot create enchant cause enchantTypeCode: %s not found", request.getEnchantTypeCode()));

        }


    }
}
