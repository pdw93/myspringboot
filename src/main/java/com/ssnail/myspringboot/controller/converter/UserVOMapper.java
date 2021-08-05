package com.ssnail.myspringboot.controller.converter;

import com.ssnail.myspringboot.controller.vo.UserVO;
import com.ssnail.myspringboot.domain.model.user.UserEntity;
import org.mapstruct.Mapper;

/**
 * @author pengdengwang
 * @since 2021/8/5
 */
@Mapper(componentModel = "spring")
public interface UserVOMapper {

    UserVO fromUserEntity(UserEntity entity);
}