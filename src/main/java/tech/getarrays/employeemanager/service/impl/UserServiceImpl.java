package tech.getarrays.employeemanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.employeemanager.model.User;
import tech.getarrays.employeemanager.model.UserRole;
import tech.getarrays.employeemanager.repo.RoleRepo;
import tech.getarrays.employeemanager.repo.UserRepo;
import tech.getarrays.employeemanager.service.UserService;

import java.util.Set;
@Service
public class UserServiceImpl implements UserService {



    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;


    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {

        User local = this.userRepo.findByUsername(user.getUsername());
        if(local!=null)
        {
            System.out.println("User is already there.");
            throw new Exception("User already present.");
        }
        else{
           //create user
            for(UserRole ur:userRoles)
            {
                roleRepo.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            local = this.userRepo.save(user);
        }
        return local;
    }

    @Override
    public User getUser(String username) {
        return this.userRepo.findByUsername(username);
    }

    @Override
    public void deleteUser(Long userId) {
        this.userRepo.deleteById(userId);
    }

}
