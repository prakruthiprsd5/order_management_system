package com.dhinesh.ordermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dhinesh.ordermanagement.model.User;
import com.dhinesh.ordermanagement.service.UserService;

@Controller
public class UserController {

  @Autowired
  UserService userService;

  /**
   * This Get api is responsible to view User List
   * @return ModelAndView
   */
  @GetMapping("/admin/user/list")
  public ModelAndView list() {
    List<User> uList = userService.get();
    ModelAndView modelAndView = new ModelAndView("/admin/user/list");
    modelAndView.addObject("uList", uList);
    return modelAndView;
  }
}
