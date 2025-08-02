package com.hostel.management.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.hostel.management.utilities.Views;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@AllArgsConstructor
public class ErrorResponseDTO {
    @JsonView({Views.BasicHostel.class, Views.BasicRoom.class, Views.BasicAmenity.class})
    private boolean ok;

    @JsonView({Views.BasicHostel.class, Views.BasicRoom.class, Views.BasicAmenity.class})
    private int statusCode;

    @JsonView({Views.BasicHostel.class, Views.BasicRoom.class, Views.BasicAmenity.class})
    private String errorMessage;
}
