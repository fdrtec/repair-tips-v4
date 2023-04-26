package com.api.repairtips.controller.docs;

import com.api.repairtips.domain.model.dto.TypeDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface TypeControllerDocs {
    @Operation(summary = "Create a new type")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Type create")
    })
    public TypeDTO create(TypeDTO dto);

}
