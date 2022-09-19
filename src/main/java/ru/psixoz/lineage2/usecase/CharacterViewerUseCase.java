package ru.psixoz.lineage2.usecase;

import lombok.RequiredArgsConstructor;
import ru.psixoz.lineage2.model.user.Character;
import ru.psixoz.lineage2.port.in.CharacterViewerPort;
import ru.psixoz.lineage2.port.out.CharacterRepository;
import ru.psixoz.lineage2.port.out.CollectionStatusRepository;
import ru.psixoz.lineage2.usecase.common.QueryUseCase;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.groupingBy;
import static ru.psixoz.lineage2.adapter.out.CharacterAdapter.GetCharacterCollectionDto;
import static ru.psixoz.lineage2.model.ref.EnchantType.*;
import static ru.psixoz.lineage2.port.out.CollectionStatusRepository.*;

@QueryUseCase
@RequiredArgsConstructor
public class CharacterViewerUseCase implements CharacterViewerPort {
    final CharacterRepository characterRepository;
    final CollectionStatusRepository collectionStatusRepository;

    @Override
    public GetCharacterCollectionStatusResponse getCharacterCollections(Long characterId) {
        //Get all collection for character server type ang group by collectionId;
        Character character = characterRepository.findByIdOrThrow(characterId);
        Map<Long, List<GetCharacterCollectionDto>> collectionById = characterRepository.getCollectionsByServerType(character.getServer().getServerType().name()).stream()
                .collect(groupingBy(GetCharacterCollectionDto::getCollectionId));
        //Find all rows for collection status
        Map<Long, List<CollectionStatusShortInfo>> collectionStatusById = collectionStatusRepository.getCollectionsStatusByCharacterIdAndServerType(characterId, character.getServer().getServerType().name()).stream()
                .collect(groupingBy(CollectionStatusShortInfo::getCollectionTemplateId));

        return GetCharacterCollectionStatusResponse.builder()
                .characterId(characterId)
                .collections(collectionById.entrySet().stream()
                        .map(pair -> CollectionStatusProjection.builder()
                                .collectionId(pair.getKey())
                                .collectionBonus(pair.getValue().get(0).getCollectionBonus())
                                .collectionName(pair.getValue().get(0).getCollectionName())
                                .collectionType(pair.getValue().get(0).getCollectionType())
                                .complete(getCompleteStatus(pair.getKey(), collectionStatusById))
                                .items(pair.getValue().stream()
                                        .map(item -> ItemStatusProjection.builder()
                                                .itemId(item.getItemId())
                                                .itemName(buildItemName(item))
                                                .complete(getItemCompleteStatus(item.getCollectionId(), item.getItemId(), collectionStatusById))
                                                .build())
                                        .collect(Collectors.toList()))
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }

    private boolean getItemCompleteStatus(Long collectionId, Long itemId, Map<Long, List<CollectionStatusShortInfo>> collectionStatusById) {
        List<CollectionStatusShortInfo> collectionStatusShortInfos = collectionStatusById.get(collectionId);
        if (collectionStatusShortInfos != null) {
            return collectionStatusShortInfos.stream().anyMatch(itemStatus -> itemStatus.getItemTemplateId().equals(itemId));
        }
        return false;
    }

    private boolean getCompleteStatus(Long collectionId, Map<Long, List<CollectionStatusShortInfo>> collectionStatusById) {
        List<CollectionStatusShortInfo> collectionStatusShortInfos = collectionStatusById.get(collectionId);
        if (collectionStatusShortInfos != null) {
            return collectionStatusShortInfos.iterator().next().isCollectionComplete();
        }
        return false;
    }

    private String buildItemName(GetCharacterCollectionDto item) {
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
