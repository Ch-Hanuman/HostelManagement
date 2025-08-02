package com.hostel.management.service;

import com.hostel.management.dto.HostelDTO;

import java.util.List;
import java.util.Map;

public interface HostelService {
    List<String> getDistinctCities();
    List<String> getDistinctAreas(String city);
    List<HostelDTO> getFilteredHostels(Map<String, String> queryParams, int page, int size, List<String> sort);

    HostelDTO getHostelDetails(int id);
}
