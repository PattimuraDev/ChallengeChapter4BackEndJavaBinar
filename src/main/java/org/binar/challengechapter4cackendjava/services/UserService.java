package org.binar.challengechapter4cackendjava.services;

import org.binar.challengechapter4cackendjava.model.ApplicationUsers;

public interface UserService {
    ApplicationUsers addUser(ApplicationUsers users);
    ApplicationUsers updateUser(Long idUser, ApplicationUsers users);
    boolean deleteUser(Long idUser);
    //ApplicationUsers findUserById(Long idUser);
}
