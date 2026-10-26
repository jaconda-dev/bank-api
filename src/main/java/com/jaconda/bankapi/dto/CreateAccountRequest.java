package com.jaconda.bankapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAccountRequest {

    @NotNull(message = "ID владельца обязателен")
    private Long ownerId;

    @NotBlank(message = "Валюта обязательна")
    @Size(min = 3, max = 3, message = "Код валюты должен состоять из 3 символов")
    private String currency;
}
