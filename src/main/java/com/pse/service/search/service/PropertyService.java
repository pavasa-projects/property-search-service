package com.pse.service.search.service;

import com.pse.service.search.model.Property;
import com.pse.service.search.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropertyService {
    private final PropertyRepository propertyRepository;

    @Autowired
    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    public List<Property> getProperties() {
        List<Property> properties = new ArrayList<>();
        propertyRepository.findAll().forEach(properties::add);
        return properties;
    }

    public void addProperty(Property property) {
        propertyRepository.save(property);
    }

    public void deleteProperty(String propertyId) {
        propertyRepository.deleteById(propertyId);
    }

    public void bulkAddProperties(List<Property> properties) {
        propertyRepository.saveAll(properties);
    }

}
