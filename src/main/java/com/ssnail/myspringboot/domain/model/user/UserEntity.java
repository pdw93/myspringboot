package com.ssnail.myspringboot.domain.model.user;

import com.ssnail.myspringboot.domain.model.convert.SexConverter;
import com.ssnail.myspringboot.domain.model.enums.SexEnum;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/**
 * 用户
 *
 * @author pengdengwang
 * @since 2020/4/19
 */
@Data
@Entity(name = "user")
@Table(name = "ss_user")
public class UserEntity {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 用户名
     */
    private String name;
    /**
     * 性别 1：男；2：女
     */
    @Convert(converter = SexConverter.class)
    private SexEnum sex;
    /**
     * 密码
     */
    private String password;
    /**
     * 创建时间
     */
    private Date dateCreate;
    /**
     * 修改时间
     */
    private Date dateUpdate;
}
