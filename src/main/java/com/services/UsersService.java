package com.services;

import com.core.annotations.Service;
import com.pojos.user.UserGetDTO;
import com.pojos.user.UserPostDTO;
import org.springframework.web.bind.annotation.*;

import static com.common.Constants.Commons.*;

@Service(name = "Users", url = APP + API + USERS_URI)
public interface UsersService {

    @GetMapping("/{userId}")
    UserGetDTO getUser(@PathVariable("userId") String userId);

    @PostMapping
    UserGetDTO postUser(UserPostDTO userPostDTO);

    @PutMapping("/{userId}")
    UserGetDTO putUser(@PathVariable("userId") String userId, UserPostDTO userPostDTO);

    @DeleteMapping("/{userId}")
    void deleteUser(@PathVariable("userId") String userId);
}
