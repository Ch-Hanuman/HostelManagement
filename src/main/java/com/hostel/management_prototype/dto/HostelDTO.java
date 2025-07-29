package com.hostel.management_prototype.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.hostel.management_prototype.utilities.HostelType;
import com.hostel.management_prototype.utilities.Views;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Data
@Slf4j
public class HostelDTO {
    @JsonView(Views.BasicHostel.class)
    private int id;

    @JsonView(Views.BasicHostel.class)
    private String name;

    @JsonView(Views.BasicHostel.class)
    private String address;

    @JsonView(Views.BasicHostel.class)
    private String area;

    @JsonView(Views.BasicHostel.class)
    private String city;

    @JsonView(Views.BasicHostel.class)
    private String state;

    @JsonView(Views.BasicHostel.class)
    private String pincode;

    @JsonView(Views.BasicHostel.class)
    private String contact;

    @JsonView(Views.BasicHostel.class)
    private String email;

    @JsonView(Views.BasicHostel.class)
    private String website;

    @JsonView(Views.BasicHostel.class)
    private HostelType type;

    @JsonView({Views.HostelRooms.class, Views.HostelRoomsAmenities.class, Views.BasicRoom.class})
    private List<RoomDTO> rooms;

    @JsonView({Views.HostelAmenities.class, Views.HostelRoomsAmenities.class, Views.BasicAmenity.class})
    private List<String> amenities;
}
