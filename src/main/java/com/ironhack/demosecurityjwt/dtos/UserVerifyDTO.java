package com.ironhack.demosecurityjwt.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVerifyDTO {
    private String name;
    private Long profileId;
}

