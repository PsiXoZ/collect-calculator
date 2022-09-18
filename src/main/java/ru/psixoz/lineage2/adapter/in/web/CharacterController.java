package ru.psixoz.lineage2.adapter.in.web;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.psixoz.lineage2.port.in.CharacterEditorPort;
import ru.psixoz.lineage2.port.in.CharacterViewerPort;

import static ru.psixoz.lineage2.port.in.CharacterEditorPort.*;
import static ru.psixoz.lineage2.port.in.CharacterViewerPort.*;

@RestAdapter(path = "/api/character")
@RequiredArgsConstructor
public class CharacterController {
    final CharacterEditorPort characterEditorPort;
    final CharacterViewerPort characterViewerPort;

    @PostMapping("/addCharacter")
    public CreateCharacterResponse addCharacter(@RequestBody CreateCharacterRequest request) {
        return characterEditorPort.createCharacter(request);
    }

    @GetMapping("/{characterId}/collections")
    public GetCharacterCollectionStatusResponse getCharacterCollectionsStatus(@PathVariable Long characterId) {
        return characterViewerPort.getCharacterCollections(characterId);
    }
}
