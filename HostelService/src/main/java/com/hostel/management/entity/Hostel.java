package com.hostel.management.entity;

import com.hostel.management.utilities.HostelType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Entity
@Data
@Slf4j
@Table(name = "hostel")
public class Hostel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "area")
    private String area;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "pincode")
    private String pincode;

    @Column(name = "contact")
    private String contact;

    @Column(name = "email")
    private String email;

    @Column(name = "website")
    private String website;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private HostelType type;

    @OneToMany(mappedBy = "hostel")
    List<Room> rooms;

    @OneToMany(mappedBy = "hostel")
    List<Amenity> amenities;
}
