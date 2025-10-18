package io.github.mxyz.SimpleNote.controller;


import io.github.mxyz.SimpleNote.service.ITblUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mxyz
 * @since 2025-10-18
 */
@RestController
@RequestMapping("/tbl-user")
public class TblUserController {
    @Autowired
    private ITblUserService tblUserService;

    @GetMapping("/list")
    public String list() {
        return tblUserService.list().toString();
    }
}
