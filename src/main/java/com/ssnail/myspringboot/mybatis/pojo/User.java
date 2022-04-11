package com.ssnail.myspringboot.mybatis.pojo;

import com.ssnail.myspringboot.domain.model.enums.SexEnum;
import java.time.LocalDateTime;
import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * @author pengdengwang
 * @since 2021/8/7
 */
@Alias(value = "user")
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
     * 性别
     */
    private SexEnum sex;
    /**
     * 密码
     */
    private String password;
    /**
     * 创建时间
     */
    private LocalDateTime dateCreate;
    /**
     * 修改时间
     */
    private LocalDateTime dateUpdate;
}
