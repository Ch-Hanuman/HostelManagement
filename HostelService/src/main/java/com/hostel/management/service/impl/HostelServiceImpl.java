package com.hostel.management.service.impl;

import com.hostel.management.dao.HostelRepository;
import com.hostel.management.dto.HostelDTO;
import com.hostel.management.entity.Hostel;
import com.hostel.management.exceptionhandling.ResourceNotFound;
import com.hostel.management.mapper.HostelMapper;
import com.hostel.management.service.HostelService;
import jakarta.persistence.criteria.Predicate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class HostelServiceImpl implements HostelService {

    @Autowired
    private HostelRepository hostelRepository;

    @Override
    public List<String> getDistinctCities() {
        return hostelRepository.getDistinctCities();
    }

    @Override
    public List<String> getDistinctAreas(String city) {
        return hostelRepository.getDistinctAreas(city);
    }

    @Override
    public List<HostelDTO> getFilteredHostels(Map<String, String> queryParams, int page, int size, List<String> sort) {
        Pageable pageable = buildPageable(page, size, sort);
        Specification<Hostel> specification = buildSpecification(queryParams);
        return hostelRepository.findAll(specification, pageable).stream().map(HostelMapper::mapToHostelDTO).toList();
    }

    @Override
    public HostelDTO getHostelDetails(int id) {
        Hostel hostel = hostelRepository.findById(id).orElse(null);
        if(hostel == null) {
            throw new ResourceNotFound("Hostel with id: " + id + " not found");
        }
        return HostelMapper.mapToHostelDTO(hostel);
    }

    private Pageable buildPageable(int page, int size, List<String> sortParams) {
        if(sortParams == null || sortParams.isEmpty()) {
            return PageRequest.of(page, size);
        }
        List<Sort.Order> sortOrders = sortParams.stream().filter(
                param -> {
                    String[] parts = param.split(":");
                    return parts.length != 2 && List.of("name", "city", "area", "address", "state", "pincode", "type").contains(parts[0]);
                }).map(
                param -> {
                    String[] parts = param.split(":");
                    Sort.Direction direction = parts[1].equals("dsc") ? Sort.Direction.DESC : Sort.Direction.ASC;
                    return new Sort.Order(direction, parts[0]);
                }
        ).toList();
        return PageRequest.of(page, size, Sort.by(sortOrders));
    }

    private Specification<Hostel> buildSpecification(Map<String, String> queryParams) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            for(Map.Entry<String, String> entry: queryParams.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if(key.equals("sort") || key.equals("page") || key.equals("size")) continue;
                switch (key) {
                    case "city" -> predicates.add(cb.equal(root.get("city"), value));
                    case "area" -> predicates.add(cb.equal(root.get("area"), value));
                    case "name" -> predicates.add(cb.like(root.get("name"), "%" + value + "%"));
                    case "address" -> predicates.add(cb.like(root.get("address"), "%" + value + "%"));
                    case "state" -> predicates.add(cb.equal(root.get("state"), value));
                    case "pincode" -> predicates.add(cb.equal(root.get("pincode"), value));
                    case "type" -> predicates.add(cb.equal(root.get("type"), value));
                }
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
