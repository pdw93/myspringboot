package com.ssnail.myspringboot.domain.model.user;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author pengdengwang
 * @since 2021/8/4
 */
public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findUserEntityByName(String name);
}
