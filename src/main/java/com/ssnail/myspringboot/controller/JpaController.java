package com.ssnail.myspringboot.controller;

import com.ssnail.myspringboot.controller.converter.UserVOMapper;
import com.ssnail.myspringboot.controller.vo.Result;
import com.ssnail.myspringboot.controller.vo.UserVO;
import com.ssnail.myspringboot.domain.model.user.UserEntity;
import com.ssnail.myspringboot.domain.model.user.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
