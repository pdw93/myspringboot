package com.ssnail.myspringboot.rpc;

import com.ssnail.myspringboot.application.user.Task;
import com.ssnail.myspringboot.application.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author pengdengwang
 * @since 2021/6/9
 */
@Service
public class OutServiceImpl implements IOutService{
    @Autowired
    private User user;

    @Autowired
    private Task task;

    @Override
    public Task getFirstTask() {
        return task;
    }

    @Override
    public User getFirstUser() {
        return user;
    }
}
