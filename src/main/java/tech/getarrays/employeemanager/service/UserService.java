package tech.getarrays.employeemanager.service;

import tech.getarrays.employeemanager.model.User;
import tech.getarrays.employeemanager.model.UserRole;

import java.util.Set;

public interface UserService {
    //creating user
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    public User getUser(String username);
    public void deleteUser(Long userId);
}
