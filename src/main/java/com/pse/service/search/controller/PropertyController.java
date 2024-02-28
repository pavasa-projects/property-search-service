package com.pse.service.search.controller;

import com.pse.service.search.model.Property;
import com.pse.service.search.service.PropertyService;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.data.elasticsearch.core.query.GeoDistanceOrder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/properties")
public class PropertyController {
    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Property> getAllProperties() {
        return propertyService.getProperties();
    }

    @PostMapping
    public void addProperty(@RequestBody Property property) {
        propertyService.addProperty(property);
    }

    @DeleteMapping("/{propertyId}")
    public void deleteProperty(@PathVariable String propertyId) {
        propertyService.deleteProperty(propertyId);
    }

    @PostMapping("/bulk")
    public void bulkAddProperties(@RequestBody List<Property> properties){
        propertyService.bulkAddProperties(properties);
    }

}
