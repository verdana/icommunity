package com.modoop.admin.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Map;

/**
 * @author Genkyo Lee
 */
public abstract class AbstractService
{
    protected Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 合并分页和排序信息到查询参数里。
     *
     * @param searchParams 查询参数
     * @param pageNumber   当前查询页数
     * @param pagzSize     每页显示条数
     * @return 返回合并后参数
     */
    protected Map<String, Object> buildParameters(Map<String, Object> searchParams, int pageNumber, int pagzSize)
    {
        searchParams.put("limit", pagzSize);
        searchParams.put("offset", (pageNumber - 1) * pagzSize);
        return searchParams;
    }

    /**
     * 创建分页请求。
     */
    protected Pageable buildPageRequest(int pageNumber, int pagzSize)
    {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return new PageRequest(pageNumber - 1, pagzSize, sort);
    }
}
