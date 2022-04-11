package com.ssnail.myspringboot.controller;

import com.ssnail.myspringboot.controller.mapper.UserVOMapper;
import com.ssnail.myspringboot.controller.vo.Result;
import com.ssnail.myspringboot.controller.vo.UserVO;
import com.ssnail.myspringboot.domain.model.user.UserEntity;
import com.ssnail.myspringboot.domain.model.user.UserEntityRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author pengdengwang
 * @since 2021/8/4
 */
@Controller
@RequestMapping("/jpa")
public class JpaController {
    @Autowired
    private UserEntityRepository userEntityRepository;
    @Autowired
    private UserVOMapper userVOMapper;

    @RequestMapping("/getUser")
    @ResponseBody
    public Result<UserVO> getUser(Long id) {
        UserEntity userEntity = userEntityRepository.findById(id).orElse(null);
        return Result.success(userVOMapper.fromUserEntity(userEntity));
    }

    @RequestMapping(path = "/addUser", method = RequestMethod.POST)
    @ResponseBody
    public Result<Long> addUser(UserVO userVO) {
        UserEntity userEntity = userEntityRepository.save(userVOMapper.fromUserVO(userVO));
        return Result.success(userEntity.getId());
    }

    @RequestMapping("/findUserByName")
    @ResponseBody
    public Result<List<UserVO>> findUserByName(String name) {
//        List<UserEntity> entityList = userEntityRepository.findUserEntityByName(name);
        List<UserEntity> entityList = userEntityRepository.findUserEntityByNameLike("%" + name + "%");
        return Result.success(userVOMapper.fromUserEntity(entityList));
    }

    @RequestMapping(path = "/deleteUser", method = RequestMethod.DELETE)
    @ResponseBody
    public Result<Boolean> deleteUser(Long id) {
        userEntityRepository.deleteById(id);
        return Result.success(true);
    }


    @RequestMapping(path = "/updateUser", method = RequestMethod.PATCH)
    @ResponseBody
    public Result<Boolean> updateUser(UserVO userVO) {
        UserEntity entity = userEntityRepository.findById(userVO.getId()).orElseThrow(() -> new IllegalArgumentException(String.valueOf(userVO.getId())));

        return Result.success(true);
    }
}
