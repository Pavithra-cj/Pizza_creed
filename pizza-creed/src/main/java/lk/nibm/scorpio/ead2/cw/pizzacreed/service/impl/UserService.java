package lk.nibm.scorpio.ead2.cw.pizzacreed.service.impl;

import lk.nibm.scorpio.ead2.cw.pizzacreed.model.User;
import lk.nibm.scorpio.ead2.cw.pizzacreed.repository.UserRepo;
import lk.nibm.scorpio.ead2.cw.pizzacreed.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepo userRepo;

    //method for find user by username
    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    //method for save user
    @Override
    public User save(User user) {
        User dao = null;
        if(user.getId() == null){
            dao = new User();
        }
        else {
            Optional<User> optionalUser = userRepo.findById(user.getId());
            if(optionalUser.isPresent()){
                dao = optionalUser.get();
            }
        }
        BeanUtils.copyProperties(user,dao);
        dao = userRepo.save(dao);
        user.setId(dao.getId());
        return user;
    }

}
