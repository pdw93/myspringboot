package com.ssnail.myspringboot.rpc;

import com.ssnail.myspringboot.application.user.Task;
import com.ssnail.myspringboot.application.user.User;

/**
 * @author pengdengwang
 * @since 2021/6/9
 */
public interface IOutService {
    Task getFirstTask();

    User getFirstUser();
}
