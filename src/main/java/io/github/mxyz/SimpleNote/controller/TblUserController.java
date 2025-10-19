package io.github.mxyz.SimpleNote.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.github.mxyz.SimpleNote.entity.TblUser;
import io.github.mxyz.SimpleNote.mapper.TblUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mxyz
 * @since 2025-10-19
 */
@RestController
@RequestMapping("/user")
public class TblUserController {
    @Autowired
    private TblUserMapper userMapper;
    @GetMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        TblUser u = userMapper.selectOne(new QueryWrapper<TblUser>().eq("username", username)
                .eq("password", password));
        if (u == null) {
            return "用户名或密码错误";
        }
        return "success";
    }
}
