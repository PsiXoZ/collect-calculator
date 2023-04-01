package ru.psixoz.lineage2.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.psixoz.lineage2.port.in.AccountEditorPort;
import ru.psixoz.lineage2.port.in.AccountViewerPort;

import static ru.psixoz.lineage2.port.in.AccountEditorPort.*;
import static ru.psixoz.lineage2.port.in.AccountEditorPort.CreateAccountRequest;
import static ru.psixoz.lineage2.port.in.AccountViewerPort.*;

@RestAdapter(path = "/api/account")
@RequiredArgsConstructor
public class AccountController {
    final AccountEditorPort accountEditorPort;
    final AccountViewerPort accountViewerPort;

    @PostMapping("/createAccount")
    public CreateAccountResponse createAccount(@RequestBody CreateAccountRequest request) {
        return accountEditorPort.createAccount(request);
    }

    @GetMapping("/{accountId}/characters")
    public GetAccountCharactersResponse getAccountCharacters(@PathVariable Long accountId) {
        return accountViewerPort.getAccountCharacters(accountId);
    }
}
