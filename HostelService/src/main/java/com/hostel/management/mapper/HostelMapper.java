package com.hostel.management.mapper;

import com.hostel.management.dto.HostelDTO;
import com.hostel.management.entity.Amenity;
import com.hostel.management.entity.Hostel;
import org.hibernate.Hibernate;

public class HostelMapper {
    public static HostelDTO mapToHostelDTO(Hostel hostel) {
        HostelDTO hostelDTO = new HostelDTO();
        hostelDTO.setId(hostel.getId());
        hostelDTO.setName(hostel.getName());
        hostelDTO.setAddress(hostel.getAddress());
        hostelDTO.setArea(hostel.getArea());
        hostelDTO.setCity(hostel.getCity());
        hostelDTO.setState(hostel.getState());
        hostelDTO.setPincode(hostel.getPincode());
        hostelDTO.setContact(hostel.getContact());
        hostelDTO.setEmail(hostel.getEmail());
        hostelDTO.setWebsite(hostel.getWebsite());
        hostelDTO.setType(hostel.getType());
        if(Hibernate.isInitialized(hostel.getAmenities())) {
            hostelDTO.setRooms(hostel.getRooms().stream().map(RoomMapper::mapToRoomDTO).toList());
        }
        if(Hibernate.isInitialized(hostel.getRooms())) {
            hostelDTO.setAmenities(hostel.getAmenities().stream().map(Amenity::getName).toList());
        }
        return hostelDTO;
    }
}
