package ru.psixoz.lineage2.adapter.in.web;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.psixoz.lineage2.port.in.ref.CharacterEditorPort;

import static ru.psixoz.lineage2.port.in.ref.CharacterEditorPort.*;

@RestAdapter(path = "/api/character")
@RequiredArgsConstructor
public class CharacterController {
    final CharacterEditorPort characterEditorPort;

    @PostMapping("/addCharacter")
    public CreateCharacterResponse addCharacter(@RequestBody CreateCharacterRequest request) {
        return characterEditorPort.createCharacter(request);
    }
}
