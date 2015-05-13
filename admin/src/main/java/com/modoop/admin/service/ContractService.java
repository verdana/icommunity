package com.modoop.admin.service;

import com.modoop.admin.exception.EntityNotFoundException;
import com.modoop.data.entity.Contract;
import com.modoop.data.repository.ContractDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Roger Lee
 */
@Service
public class ContractService extends AbstractService
{
    @Autowired
    private ContractDao dao;

    public Page<Contract> search(Map<String, Object> searchParams, int pageNumber, int pageSize)
    {
        Map<String, Object> parameters = buildParameters(searchParams, pageNumber, pageSize);
        Pageable pageable = buildPageRequest(pageNumber, pageSize);

        List<Contract> list = dao.search(parameters);
        long total = dao.count(parameters);

        return new PageImpl<>(list, pageable, total);
    }

    public Contract find(final Long id)
    {
        Contract contract = dao.find(id);
        if (contract == null) throw new EntityNotFoundException(Contract.KEY, id);
        return contract;
    }
}
