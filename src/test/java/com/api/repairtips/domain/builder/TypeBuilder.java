package com.api.repairtips.domain.builder;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeBuilder {

    @Builder.Default
    private final UUID id = UUID.fromString("0xD46F202DD4A84F129564C22EEFB2C844");

    @Builder.Default
    private final String name = "Laser";    
}
