package com.marker.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Markers")
public class MarkerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name="marker_id")
    private Long id;
    @Column(nullable = false, name="marker_title")
    private String title;
    @Column(nullable = false, name="marker_description")
    private String description;
    @Column(nullable = false, name="marker_lat")
    private double latitude;
    @Column(nullable = false, name="marker_lng")
    private double longitude;
}
