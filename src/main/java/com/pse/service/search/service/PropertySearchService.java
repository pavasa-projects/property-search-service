package com.pse.service.search.service;

import com.pse.service.search.model.Property;
import com.pse.service.search.repository.PropertySearchRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.data.elasticsearch.core.query.GeoDistanceOrder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertySearchService {

    private final PropertySearchRepository propertySearchRepository;

    public PropertySearchService(PropertySearchRepository propertySearchRepository) {
        this.propertySearchRepository = propertySearchRepository;
    }

    public Optional<Property> getProperty(String propertyId) {
        return propertySearchRepository.findById(propertyId);
    }

    public List<Property> getPropertiesByBuilderName(String builderName){
        return propertySearchRepository.getPropertiesByBuilderName(builderName);
    }

    public List<Property> searchNearestProperties(GeoPoint geoLocation) {
        return propertySearchRepository.findByGeoLocationCustomQuery(geoLocation.getLat(), geoLocation.getLon(), "30 km");
    }
}
