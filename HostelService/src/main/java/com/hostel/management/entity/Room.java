package com.hostel.management.entity;

import com.hostel.management.utilities.RoomType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Entity
@Data
@Slf4j
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "room_no")
    private String roomNo;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private RoomType type;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "available")
    private int available;

    @Column(name = "filled")
    private int filled;

    @Column(name = "monthly_price")
    private int monthlyPrice;

    @Column(name = "daily_price")
    private int dailyPrice;

    @Column(name = "deposit")
    private int deposit;

    @ManyToOne
    @JoinColumn(name = "hostel_id")
    private Hostel hostel;
}
