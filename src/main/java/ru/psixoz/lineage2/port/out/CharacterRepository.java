package ru.psixoz.lineage2.port.out;

import ru.psixoz.lineage2.model.ref.CollectionType;
import ru.psixoz.lineage2.model.ref.EnchantType;
import ru.psixoz.lineage2.model.ref.LineageServerType;
import ru.psixoz.lineage2.model.user.Character;

import java.util.Collection;
import java.util.Optional;

import static java.lang.String.format;

public interface CharacterRepository {

    Character save(Character character);

    Optional<Character> findById(Long id);

    Collection<Character> findByAccountId(Long accountId);

    Optional<Character> findByNameIgnoreCaseAndServer(String characterName, String serverCode);

    default Character findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(() -> new RuntimeException(format("Character with id: %s not found", id)));
    }

    Collection<GetCharacterCollectionDto> getCollectionsByServerType(String serverType);


    interface GetCharacterCollectionDto {
        Long getCollectionId();
        String getCollectionName();
        String getCollectionBonus();

        CollectionType getCollectionType();
        Long getItemId();
        String getItemName();
        String getItemEnchant();
        EnchantType getItemEnchantType();
    }}
