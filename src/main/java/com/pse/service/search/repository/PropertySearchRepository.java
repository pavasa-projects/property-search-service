package com.pse.service.search.repository;

import com.pse.service.search.model.Property;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertySearchRepository extends ElasticsearchRepository<Property, String> {
    List<Property> getPropertiesByBuilderName(String builderName);

    @Query("{\n" +
            "        \"bool\": {\n" +
            "            \"must\": [\n" +
            "                {\n" +
            "                \"geo_distance\": {\n" +
            "                    \"geoLocation\": {\n" +
            "                    \"lat\": ?0,\n" +
            "                    \"lon\": ?1 \n" +
            "                    },\n" +
            "                    \"distance\": \"?2\"\n" +
            "                }\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    }")
    List<Property> findByGeoLocationCustomQuery(double lat, double lon, String distance);

}
