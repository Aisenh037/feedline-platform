package com.food_app.FeedLine.service.impl;

import com.food_app.FeedLine.dto.RestaurantDTO;
import com.food_app.FeedLine.entity.Restuarant;
import com.food_app.FeedLine.repository.RestaurantRepository;
import com.food_app.FeedLine.service.RestaurantService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restuarantRepository;
    @Autowired
    private ModelMapper modelMapper;

    public RestaurantServiceImpl(RestaurantRepository restuarantRepository, ModelMapper modelMapper) {
        this.restuarantRepository = restuarantRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * @param restaurantDTO
     * @return
     */
    @Override
    public RestaurantDTO addRestuarant(RestaurantDTO restuarantDTO) {

        restuarantDTO.setId(UUID.randomUUID().toString());

        Restuarant restuarant = modelMapper.map(restuarantDTO, Restuarant.class);

        Restuarant savedRestuarantEntity = restuarantRepository.save(restuarant);
        return modelMapper.map(savedRestuarantEntity, RestaurantDTO.class);
    }

    /**
     * @param pageable
     * @return
     */
    @Override
    public Page<RestaurantDTO> getAllRestaurants(Pageable pageable) {
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public RestaurantDTO getRestaurantById(String id) {
        return null;
    }

    /**
     * @param name
     * @return
     */
    @Override
    public List<RestaurantDTO> searchRestaurantByName(String name) {
        return List.of();
    }

    /**
     * @param pageable
     * @return
     */
    @Override
    public Page<RestaurantDTO> getOpenRestaurants(Pageable pageable) {
        return null;
    }

    /**
     * @param restaurantDTO
     * @param id
     * @return
     */
    @Override
    public RestaurantDTO updateRestaurant(RestaurantDTO restaurantDTO, String id) {

    }

    /**
     * @param id
     */
    @Override
    public void deleteRestaurant(String id) {

    }
}
