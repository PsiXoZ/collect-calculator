package ru.psixoz.lineage2.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.psixoz.lineage2.model.template.CollectionBonus;
import ru.psixoz.lineage2.model.template.CollectionTemplate;
import ru.psixoz.lineage2.port.out.ref.CollectionBonusRepository;

@Service
@RequiredArgsConstructor
public class CollectionBonusService {
    final CollectionBonusRepository bonusRepository;

    public void addCollectionBonus(CollectionTemplate template, Long bonusId) {
        CollectionBonus bonus = bonusRepository.findByIdOrThrow(bonusId);
        template.setCollectionBonus(bonus);
    }
}
