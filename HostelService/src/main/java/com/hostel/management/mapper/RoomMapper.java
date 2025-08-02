package com.hostel.management.mapper;

import com.hostel.management.dto.RoomDTO;
import com.hostel.management.entity.Room;

public class RoomMapper {
    public static RoomDTO mapToRoomDTO(Room room) {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setId(room.getId());
        roomDTO.setRoomNumber(room.getRoomNo());
        roomDTO.setRoomType(room.getType());
        roomDTO.setCapacity(room.getCapacity());
        roomDTO.setAvailable(room.getAvailable());
        roomDTO.setFilled(room.getFilled());
        roomDTO.setMonthlyPrice(room.getMonthlyPrice());
        roomDTO.setDailyPrice(room.getDailyPrice());
        roomDTO.setDeposit(room.getDeposit());
        return roomDTO;
    }
}
