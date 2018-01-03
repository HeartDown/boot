package com.zh.dao;

import com.zh.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zhangheng on 2017/12/11.
 */
public interface UserRepository extends JpaRepository<User,Long> {
}
