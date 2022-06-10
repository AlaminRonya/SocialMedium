package com.alamin.services;

import com.alamin.converter.LocationConverter;
import com.alamin.dao.LocationDAO;
import com.alamin.dto.LocationsDto;
import com.alamin.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationService {
    @Autowired
    private LocationDAO locationDAO;

    private LocationConverter locationConverter;

    public LocationService() {
        locationConverter = new LocationConverter();
    }

    public void insert(LocationsDto locationsDto){
        final Location location = locationConverter.dtoToEntity(locationsDto);
        locationDAO.insert(location);
    }
    public List<LocationsDto> getAllLocationDto(){
        return locationConverter.entityToDto(locationDAO.getAll());
    }

    public List<String> getAllLocation(){
        return getAllLocationDto().stream().map(LocationsDto::getLocationName).collect(Collectors.toList());
    }
}
