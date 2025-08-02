package com.hostel.management_prototype.service;

import com.hostel.management_prototype.dto.HostelDTO;
import com.hostel.management_prototype.entity.Hostel;

import java.util.List;
import java.util.Map;

public interface HostelService {
    List<String> getDistinctCities();
    List<String> getDistinctAreas(String city);
    List<HostelDTO> getFilteredHostels(Map<String, String> queryParams, int page, int size, List<String> sort);

    HostelDTO getHostelDetails(int id);
}
