package ru.psixoz.lineage2.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.psixoz.lineage2.adapter.out.CharacterAdapter;
import ru.psixoz.lineage2.model.ref.EnchantType;
import ru.psixoz.lineage2.port.in.CharacterViewerPort;
import ru.psixoz.lineage2.port.out.CharacterRepository;
import ru.psixoz.lineage2.usecase.common.QueryUseCase;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static ru.psixoz.lineage2.adapter.out.CharacterAdapter.GetCharacterCollectionDto;
import static ru.psixoz.lineage2.model.ref.EnchantType.*;

@QueryUseCase
@RequiredArgsConstructor
public class CharacterViewerUseCase implements CharacterViewerPort {
    final CharacterRepository characterRepository;

    @Override
    public GetCharacterCollectionStatusResponse getCharacterCollections(Long characterId) {
        Map<Long, List<GetCharacterCollectionDto>> collectionById = characterRepository.getCharacterCollection(characterId).stream()
                .collect(groupingBy(GetCharacterCollectionDto::getCollectionId));
        return GetCharacterCollectionStatusResponse.builder()
                .characterId(characterId)
                .collections(collectionById.entrySet().stream()
                        .map(pair -> CollectionStatusProjection.builder()
                                .collectionId(pair.getKey())
                                .collectionBonus(pair.getValue().get(0).getCollectionBonus())
                                .collectionName(pair.getValue().get(0).getCollectionName())
                                .collectionType(pair.getValue().get(0).getCollectionType())
                                .complete(pair.getValue().get(0).isCollectionComplete())
                                .items(pair.getValue().stream()
                                        .map(item -> ItemStatusProjection.builder()
                                                .itemId(item.getItemId())
                                                .itemName(buildItemName(item))
                                                .complete(item.isItemComplete())
                                                .build())
                                        .collect(Collectors.toList()))
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }

    private String buildItemName(GetCharacterCollectionDto item) {
        //TODO: Подумать как правильно собирать имя
        if (EQUIPMENT.equals(item.getItemEnchantType())) {
            if ("0".equals(item.getItemEnchant())) {
                return item.getItemName();
            } else {
                return item.getItemEnchant() + " " + item.getItemName();
            }
        }
        return null;
    }
}
