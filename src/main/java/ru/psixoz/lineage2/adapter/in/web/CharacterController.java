package ru.psixoz.lineage2.adapter.in.web;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.psixoz.lineage2.port.in.CharacterService;

import static ru.psixoz.lineage2.port.in.CharacterService.*;

@RestAdapter(path = "/api/character")
@RequiredArgsConstructor
public class CharacterController {
    final CharacterService characterService;

    @PostMapping(name = "/addCharacter")
    public CreateCharacterResponse addCharacter(@RequestBody CreateCharacterRequest request) {
        return characterService.createCharacter(request);
    }
}
