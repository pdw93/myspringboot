package com.ssnail.myspringboot.controller.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ssnail.myspringboot.domain.model.enums.SexEnum;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author pengdengwang
 * @since 2021/8/5
 */
@Data
@Accessors(chain = true)
public class UserVO implements Serializable {
    private static final long serialVersionUID = -2284600074749351618L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 用户名
     */
    private String name;
    /**
     * 性别 1：男；2：女
     */
    private SexEnum sex;
    /**
     * 密码
     */
    private String password;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date dateCreate;
    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date dateUpdate;
}
