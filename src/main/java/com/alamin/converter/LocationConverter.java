package com.alamin.converter;

import com.alamin.dto.LocationsDto;
import com.alamin.dto.UserDto;
import com.alamin.model.Location;
import com.alamin.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LocationConverter {

    public LocationsDto entityToDto(Location location){
        return new ModelMapper().map(location, LocationsDto.class);
    }
    public Location dtoToEntity(LocationsDto locationsDto){
        return new ModelMapper().map(locationsDto, Location.class);
    }

    public List<LocationsDto> entityToDto(List<Location> locations) {
        return	locations.stream().map(this::entityToDto).collect(Collectors.toList());
    }
}
