package com.hostel.management_prototype.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.hostel.management_prototype.utilities.RoomType;
import com.hostel.management_prototype.utilities.Views;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class RoomDTO {
    @JsonView({Views.BasicRoom.class, Views.HostelRoomsAmenities.class, Views.HostelRooms.class})
    private int id;

    @JsonView({Views.BasicRoom.class, Views.HostelRoomsAmenities.class, Views.HostelRooms.class})
    private String roomNumber;

    @JsonView({Views.BasicRoom.class, Views.HostelRoomsAmenities.class, Views.HostelRooms.class})
    private RoomType roomType;

    @JsonView({Views.BasicRoom.class, Views.HostelRoomsAmenities.class, Views.HostelRooms.class})
    private int capacity;

    @JsonView({Views.BasicRoom.class, Views.HostelRoomsAmenities.class, Views.HostelRooms.class})
    private int available;

    @JsonView({Views.BasicRoom.class, Views.HostelRoomsAmenities.class, Views.HostelRooms.class})
    private int filled;

    @JsonView({Views.BasicRoom.class, Views.HostelRoomsAmenities.class, Views.HostelRooms.class})
    private int monthlyPrice;

    @JsonView({Views.BasicRoom.class, Views.HostelRoomsAmenities.class, Views.HostelRooms.class})
    private int dailyPrice;

    @JsonView({Views.BasicRoom.class, Views.HostelRoomsAmenities.class, Views.HostelRooms.class})
    private int deposit;
}
