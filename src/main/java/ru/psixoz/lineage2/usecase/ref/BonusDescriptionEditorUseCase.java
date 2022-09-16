package ru.psixoz.lineage2.usecase.ref;

import lombok.RequiredArgsConstructor;
import ru.psixoz.lineage2.model.ref.BonusDescription;
import ru.psixoz.lineage2.port.in.BonusDescriptionEditorPort;
import ru.psixoz.lineage2.port.out.ref.BonusDescriptionRepository;
import ru.psixoz.lineage2.usecase.common.CommandUseCase;

import java.util.Optional;

import static java.lang.String.format;

@CommandUseCase
@RequiredArgsConstructor
public class BonusDescriptionEditorUseCase implements BonusDescriptionEditorPort {
    final BonusDescriptionRepository bonusDescriptionRepository;
    @Override
    public void createBonusDescription(CreateBonusDescriptionRequest request) {
        Optional<BonusDescription> bonusDescriptionOp = bonusDescriptionRepository.findByCodeIgnoreCase(request.getCode());

        if (bonusDescriptionOp.isPresent()) {
            throw new RuntimeException(format("Bonus description with code: %s already exist.", request.getCode()));
        }

        bonusDescriptionRepository.save(new BonusDescription(request.getCode(), request.getName()));
    }
}
