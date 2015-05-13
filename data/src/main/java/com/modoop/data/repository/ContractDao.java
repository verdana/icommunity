package com.modoop.data.repository;

import com.modoop.data.entity.Admin;
import com.modoop.data.entity.Contract;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Roger Lee
 */
@Repository
public interface ContractDao
{
    List<Contract> search(Map<String, Object> parameters);

    long count(Map<String, Object> parameters);

    Contract find(Long id);

    void create(Contract contract);

    void delete(Long id);
}
