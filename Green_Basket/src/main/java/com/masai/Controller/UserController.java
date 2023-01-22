package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.masai.Exception.UserException;
import com.masai.Model.User;
import com.masai.Services.UserLoginService;




@CrossOrigin
@RestController
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserLoginService userService;
	
	@PostMapping("/userlogin")
    public ResponseEntity<String> logInUserHandler(@RequestBody User user) throws UserException {

        String key = userService.logIntoAccount(user);

        return new ResponseEntity<String>(key, HttpStatus.OK);

    }
	
	@PostMapping("/userlogout")
    public String logoutUserHandler(@RequestParam(required = false) String key) throws UserException {
        
		return userService.logOutFromAccount(key);

    }

}
