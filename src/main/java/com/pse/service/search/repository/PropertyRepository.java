package com.pse.service.search.repository;

import com.pse.service.search.model.Property;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.util.List;

@Repository
public interface PropertyRepository extends ElasticsearchRepository<Property, String> {

}
