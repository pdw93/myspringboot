package com.ssnail.myspringboot.application.user;

import java.util.Date;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/**
 * 用户
 *
 * @author pengdengwang
 * @since 2020/4/19
 */
@Data
public class User {
    /**
     * 主键
     */
    private Long id;
    /**
     * 用户名
     */
    private String name;
    /**
     * 密码
     */
    @Value("${user.passWord}")
    private String passWord;
    /**
     * 创建时间
     */
    private Date dateCreate;
    /**
     * 修改时间
     */
    private Date dateUpdate;
}
