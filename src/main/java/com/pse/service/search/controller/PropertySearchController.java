package com.pse.service.search.controller;

import com.pse.service.search.model.Property;
import com.pse.service.search.service.PropertySearchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/search")
public class PropertySearchController {
    private final PropertySearchService propertySearchService;

    public PropertySearchController(PropertySearchService propertySearchService) {
        this.propertySearchService = propertySearchService;
    }

    @GetMapping("/{propertyId}")
    public Optional<Property> getPropertyById(@PathVariable String propertyId) {
        return propertySearchService.getProperty(propertyId);
    }

    @GetMapping("/builderName")
    public List<Property> getPropertyByBuilderName(@RequestParam String builderName) {
        return propertySearchService.getPropertiesByBuilderName(builderName);
    }

    @GetMapping
    public List<Property> searchNearestProperties(@RequestBody Property property) {
        return propertySearchService.searchNearestProperties(property.getGeoLocation());
    }
}
