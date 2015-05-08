package com.modoop.data.repository;

import com.modoop.data.entity.House;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author James
 */
@Repository
public interface HouseDao
{
    List<House> search(Map<String, Object> parameters);

    long count(Map<String, Object> parameters);

    House find(Long id);

    House findByName(String name);

    void create(House house);

    int update(House house);

    void delete(Long id);
}
