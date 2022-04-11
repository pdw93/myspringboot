package com.ssnail.myspringboot.mybatis.dao;

import com.ssnail.myspringboot.mybatis.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @author pengdengwang
 * @since 2021/8/7
 */
@Repository
public interface UserDao {
    public User getUser(Long id);
}
