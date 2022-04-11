package com.ssnail.myspringboot.controller.mapper;

import com.ssnail.myspringboot.controller.vo.UserVO;
import com.ssnail.myspringboot.domain.model.user.UserEntity;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * @author pengdengwang
 * @since 2021/8/5
 */
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserVOMapper extends DateMapper{

    UserVO fromUserEntity(UserEntity entity);

    List<UserVO> fromUserEntity(List<UserEntity> entity);

    UserEntity fromUserVO(UserVO userVO);

    void updateUser(UserVO source, @MappingTarget UserEntity target);
}
