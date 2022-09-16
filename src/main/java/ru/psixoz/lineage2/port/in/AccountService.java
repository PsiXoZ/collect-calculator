package ru.psixoz.lineage2.port.in;

import lombok.Builder;
import lombok.Value;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
public interface AccountService {
    CreateAccountResponse createAccount(@Valid CreateAccountRequest request);

    @Value
    @Builder
    class CreateAccountRequest {
        @NotNull
        String login;
        @NotNull
        String password;
        @NotNull
        String fullName;
    }

    @Value
    @Builder
    class CreateAccountResponse {
        Long accountId;
    }
}
