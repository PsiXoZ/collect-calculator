package ru.psixoz.lineage2.usecase.ref;

import lombok.RequiredArgsConstructor;
import ru.psixoz.lineage2.model.ref.BonusDescription;
import ru.psixoz.lineage2.model.ref.Enchant;
import ru.psixoz.lineage2.model.template.CollectionBonus;
import ru.psixoz.lineage2.port.in.ref.CollectionBonusEditorPort;
import ru.psixoz.lineage2.port.out.ref.BonusDescriptionRepository;
import ru.psixoz.lineage2.port.out.ref.CollectionBonusRepository;
import ru.psixoz.lineage2.port.out.ref.EnchantRepository;
import ru.psixoz.lineage2.usecase.common.CommandUseCase;

import javax.validation.Valid;
import java.util.Optional;

import static java.lang.String.format;

@CommandUseCase
@RequiredArgsConstructor
public class CollectionBonusEditorUseCase implements CollectionBonusEditorPort {
    final CollectionBonusRepository bonusRepository;
    final EnchantRepository enchantRepository;
    final BonusDescriptionRepository descriptionRepository;
    @Override
    public void createBonus(@Valid CreateBonusRequest request) {
        Optional<CollectionBonus> bonusOpt = bonusRepository.findByDescriptionAndEnchant(request.getDescriptionCode(), request.getEnchantCode());
        if (bonusOpt.isPresent()) {
            CollectionBonus collectionBonus = bonusOpt.get();
            throw new RuntimeException(format("Bonus with description: %s and enchant: %s already exist.", collectionBonus.getDescription().getDescription(), collectionBonus.getEnchant().getDescription()));
        }
        CollectionBonus collectionBonus = new CollectionBonus();
        Enchant enchant;
        BonusDescription description;
        Optional<Enchant> enchantOp = enchantRepository.findByCodeIgnoreCase(request.getEnchantCode());
        if (enchantOp.isPresent()) {
             enchant = enchantOp.get();
            collectionBonus.setEnchant(enchant);

        } else {
            throw new RuntimeException(format("Cannot create bonus cause cannot find enchant code: %s.", request.getEnchantCode()));
        }

        Optional<BonusDescription> descriptionOp = descriptionRepository.findByCodeIgnoreCase(request.getDescriptionCode());
        if (descriptionOp.isPresent()) {
            description = descriptionOp.get();
            collectionBonus.setDescription(description);
        } else {
            throw new RuntimeException(format("Cannot create bonus cause cannot find description code: %s.", request.getDescriptionCode()));

        }

        bonusRepository.save(collectionBonus);


    }
}
