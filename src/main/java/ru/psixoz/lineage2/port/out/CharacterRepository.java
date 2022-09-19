package ru.psixoz.lineage2.port.out;

import ru.psixoz.lineage2.model.ref.CollectionType;
import ru.psixoz.lineage2.model.ref.EnchantType;
import ru.psixoz.lineage2.model.user.Character;

import java.util.Collection;
import java.util.Optional;

public interface CharacterRepository {

    Character save(Character character);

    Collection<GetCharacterCollectionDto> getCharacterCollection(Long characterId);


    interface GetCharacterCollectionDto {
        Long getCollectionId();
        String getCollectionName();
        String getCollectionBonus();

        CollectionType getCollectionType();
        Long getItemId();
        String getItemName();
        String getItemEnchant();
        EnchantType getItemEnchantType();
        boolean isCollectionComplete();
        boolean isItemComplete();
    }}
