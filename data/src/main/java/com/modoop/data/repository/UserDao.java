package com.modoop.data.repository;

import com.modoop.data.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Roger Lee
 */
@Repository
public interface UserDao
{
    List<User> search(Map<String, Object> parameters);

    long count(Map<String, Object> parameters);

    User find(Long id);

    void create(User user);

    int update(User user);

    void delete(Long id);
}
