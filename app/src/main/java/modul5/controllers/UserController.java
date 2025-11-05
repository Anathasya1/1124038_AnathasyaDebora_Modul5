package modul5.controllers;
import java.util.ArrayList;
import modul5.models.User;

import modul5.repository.UserRepository;

public class UserController {
    UserRepository userRepository;

    public UserController(){
        this.userRepository = new UserRepository();
    }

    public ArrayList<User> printAllUser(String nama){
        return userRepository.listAllSearchByName(nama);
    }
}
