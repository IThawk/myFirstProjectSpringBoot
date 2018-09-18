package com.itHawk.springBoot.controller;

import com.itHawk.springBoot.model.User;
import com.itHawk.springBoot.service.UserService;
import com.itHawk.springBoot.utils.HttpCode;
import com.itHawk.springBoot.utils.SessionName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

/***
 * 这是用户管理的contronller
 *
 * @author ithawk
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;
    //    @DeleteMapping
//    @PutMapping
//    @GetMapping
    //日志
    Logger logger = LoggerFactory.getLogger(getClass());


    /***
     * 根据用户登入名和密码进行登入
     * @param username
     * @param password
     */
    //@RequestMapping(value = "/user/login",method = RequestMethod.POST)
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession session) {

        User user = userService.selectByUserNameAndPassWord(username, password);

        logger.info(username + "用户登入系统");

        if (!StringUtils.isEmpty(username) && user != null) {

            //登陆成功，防止表单重复提交，可以重定向到主页
            session.setAttribute("loginUser", username);
            return "redirect:/main.html";
        } else {
            //登陆失败 ，写入登入提示
            map.put("msg", "用户名密码错误");
            return "login";
        }

    }

    /***
     * 跳转到注册页面
     */
    @GetMapping(value = "/user/register")
    public String login() {
        //之间跳转到注册页面
        return "redirect:/success.html";

    }

    /***
     * 注册用户信息
     * @param user 用户信息

     * @param session
     * @return
     */
    @PostMapping(value = "/user/add")
    public String addUser(User user, HttpSession session) {
        userService.addUser(user);
        //登陆成功，防止表单重复提交，可以重定向到主页
        session.setAttribute(SessionName.USER_LOGIN_NAMA, user.getUserName());
        return "redirect:/success.html";

    }

    /***
     * 修改用户信息
     * @param user 用户信息
     * @param oldPassword  用户旧密码
     * @param session
     * @return
     */
    @PostMapping(value = "/user/modify")
    public String modifyUser(User user, String oldPassword, HttpSession session, Map<String, Object> map) {

        int code = userService.updateUser(user, oldPassword);
        //用户密码错误，登陆成功，防止表单重复提交，可以重定向到主页
        if (code == HttpCode.USER_PASSWORD_IS_ERROR) {
            map.put("msg", "密码错误");

            //跳转到修改页面
            return "redirect:/success.html";
        } else if (code == HttpCode.USER_OLDPASSWORD_IS_ERROR_TOO_TIMES) {
            map.put("msg", "旧密码错误次数过多，请重新登入");
            //跳转到登入页面,清空登入信息
            session.removeAttribute(SessionName.USER_LOGIN_NAMA);
            return "redirect:/success.html";
        }
        session.setAttribute(SessionName.USER_LOGIN_NAMA, user.getUserName());
        return "redirect:/success.html";

    }

    /***
     * 用户登出
     * @param session
     * @return
     *
     */
    @PutMapping(value = "/user/logout")
    public String logoutUser(HttpSession session) {

        userService.logoutUser();

        session.removeAttribute(SessionName.USER_LOGIN_NAMA);
        //跳转到登入页面
        return "redirect:/success.html";

    }
}
