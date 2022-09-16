package ru.psixoz.lineage2.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.psixoz.lineage2.port.in.AccountEditorPort;

import static ru.psixoz.lineage2.port.in.AccountEditorPort.*;
import static ru.psixoz.lineage2.port.in.AccountEditorPort.CreateAccountRequest;

@RestAdapter(path = "/api/account")
@RequiredArgsConstructor
public class AccountController {
    final AccountEditorPort accountEditorPort;

    @PostMapping("/createAccount")
    public CreateAccountResponse createAccount(@RequestBody CreateAccountRequest request) {
        return accountEditorPort.createAccount(request);
    }
}
