package com.client.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.*;

import java.util.UUID;

@Accessors(chain = true)
@Data
public class AccountRequest {

    @NotEmpty(message = "Enter nickname")
    @Size(min = 3, max = 15, message = "Size invalid")
    private String nickname;

    private String password;

    private Integer profileId;
    private UUID walletUUID;
}
