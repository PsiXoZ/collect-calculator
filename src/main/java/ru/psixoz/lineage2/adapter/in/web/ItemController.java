package ru.psixoz.lineage2.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.psixoz.lineage2.port.in.ItemStratusEditorPort;

import static ru.psixoz.lineage2.port.in.ItemStratusEditorPort.*;

@RestAdapter(path = "/api/item")
@RequiredArgsConstructor
public class ItemController {
    final ItemStratusEditorPort itemStratusEditorPort;
    @PostMapping("/markComplete")
    public void markComplete(@RequestBody MarkCompleteItemStatusRequest request) {
        itemStratusEditorPort.markComplete(request);
    }
}
