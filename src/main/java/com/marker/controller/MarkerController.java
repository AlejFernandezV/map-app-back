package com.marker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marker.models.MarkerEntity;
import com.marker.service.MarkerService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/markers")
public class MarkerController {
    @Autowired
    private MarkerService markerService;

    @GetMapping("/")
    public ResponseEntity<List<MarkerEntity>> getAllMarkers() {
        List<MarkerEntity> markers = markerService.getAllMarkers();
        return new ResponseEntity<>(markers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarkerEntity> getMarkerById(@PathVariable Long id) {
        MarkerEntity marker = markerService.getMarkerById(id);
        if (marker != null) {
            return new ResponseEntity<>(marker, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<MarkerEntity> addMarker(@RequestBody MarkerEntity marker) {
        MarkerEntity newMarker = markerService.addMarker(marker);
        return new ResponseEntity<>(newMarker, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MarkerEntity> updateMarker(@PathVariable Long id, @RequestBody MarkerEntity marker) {
        MarkerEntity updatedMarker = markerService.updateMarker(id, marker);
        if (updatedMarker != null) {
            return new ResponseEntity<>(updatedMarker, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMarker(@PathVariable Long id) {
        markerService.deleteMarker(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
