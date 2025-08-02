package com.hostel.management.utilities;

public class Views {
    public static class BasicHostel{};
    public static class HostelRooms extends BasicHostel{};
    public static class HostelAmenities extends BasicHostel{};
    public static class HostelRoomsAmenities extends HostelRooms{};

    public static class BasicRoom{};
    public static class BasicAmenity{};

}
