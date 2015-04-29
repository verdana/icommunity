package com.modoop.admin.service;

import com.modoop.admin.exception.*;
import com.modoop.data.entity.House;
import com.modoop.data.repository.HouseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Add house
 * @author James
 */
@Service
public class HouseService extends AbstractService
{
    @Autowired
    private HouseDao houseDao;

    public Page<House> search(Map<String, Object> searchParams, int pageNumber, int pageSize)
    {
        Map<String, Object> parameters = buildParameters(searchParams, pageNumber, pageSize);
        Pageable pageable = buildPageRequest(pageNumber, pageSize);

        List<House> list = houseDao.search(parameters);
        long total = houseDao.count(parameters);

        return new PageImpl<>(list, pageable, total);
    }

    public House find(final Long id)
    {
        House house = houseDao.find(id);
        if (house == null) throw new EntityNotFoundException(House.KEY, id);
        return house;
    }

    public House findByName(String name)
    {
        House house = houseDao.findByName(name);
        if (house == null) throw new EntityNotFoundException(House.KEY, name);
        return house;
    }

    @Transactional
    public void create(House house)
    {
        House temp = houseDao.findByName(house.getName());
        if (temp != null) throw new EntityAlreadyExistException(House.KEY, house.getName());
        house.setCreateTime(new Date());
        houseDao.create(house);
    }

    @Transactional
    public House update(House house)
    {
        int changes = houseDao.update(house);
        if (changes == 0)
        {
            throw new EntityAlreadyChangedException(House.KEY, house.getName());
        }
        return house;
    }

    @Transactional
    public void delete(Long id)
    {
        houseDao.delete(id);
    }
}
