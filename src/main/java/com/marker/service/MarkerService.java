package com.marker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marker.models.MarkerEntity;
import com.marker.repository.MarkerRepository;

@Service
public class MarkerService {
    @Autowired
    private MarkerRepository markerRepository;

    public List<MarkerEntity> getAllMarkers() {
        return markerRepository.findAll();
    }

    public MarkerEntity getMarkerById(Long id) {
        return markerRepository.findById(id).orElse(null);
    }

    public MarkerEntity addMarker(MarkerEntity marker) {
        return markerRepository.save(marker);
    }

    public MarkerEntity updateMarker(Long id, MarkerEntity marker) {
        MarkerEntity existingMarker = markerRepository.findById(id).orElse(null);
        if (existingMarker != null) {
            existingMarker.setTitle(marker.getTitle());
            existingMarker.setDescription(marker.getDescription());
            existingMarker.setLatitude(marker.getLatitude());
            existingMarker.setLongitude(marker.getLongitude());
            return markerRepository.save(existingMarker);
        }
        return null;
    }

    public void deleteMarker(Long id) {
        markerRepository.deleteById(id);
    }
}
