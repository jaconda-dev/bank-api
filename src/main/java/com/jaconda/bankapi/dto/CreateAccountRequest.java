package com.jaconda.bankapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateAccountRequest {

    @NotNull(message = "ID владельца обязателен")
    Long ownerId;

    @NotBlank(message = "Валюта обязательна")
    @Size(min = 3, max = 3, message = "Код валюты должен состоять из 3 символов")
    String currency;
}
