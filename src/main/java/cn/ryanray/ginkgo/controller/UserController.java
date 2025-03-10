package cn.ryanray.ginkgo.controller;

import cn.ryanray.ginkgo.dao.po.User;
import cn.ryanray.ginkgo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "用户管理")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "获取所有用户信息")
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

@Operation(summary = "创建用户")
    @PostMapping(value = "/createUser")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

@Operation(summary = "根据id获取用户信息")
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

@Operation(summary = "根据id删除用户信息")
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

@Operation(summary = "通过邮箱获取所有用户信息")
    @GetMapping("/email/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }
}