package com.hostel.management_prototype.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Entity
@Data
@Slf4j
@Table(name = "amenity")
public class Amenity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "hostel_id")
    private Hostel hostel;
}
