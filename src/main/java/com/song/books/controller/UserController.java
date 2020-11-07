package com.song.books.controller;
import com.song.books.entity.BooksUser;
import com.song.books.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;
    /**
     * 登陆接口，先验证用户名密码
     * @param userName 用户名
     * @param passWord 密码
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(@RequestParam(value = "userName",required = true,defaultValue = "") String userName,
                        @RequestParam(value = "passWord",required = true,defaultValue = "") String passWord){
        BooksUser booksUser=userService.selectUser(userName,passWord);
        return "login success";
    }

    /**
     * 注册接口
     * @param user
     * @return
     */
    @PostMapping(value = "/reg",  consumes = "application/json")
    public String regist(@RequestBody BooksUser user){
        userService.insertUser(user);
        return "reg success";
    }

    @PostMapping(value = "/reset",  consumes = "application/json")
    public String reset(@RequestBody BooksUser user){
        userService.updateUser(user.getPassWord(), user.getId());
        return "reset success";
    }
}
