package org.binar.ChallengeChapter4BackEndJava.services;

import org.binar.ChallengeChapter4BackEndJava.model.ApplicationUsers;

public interface UserService {
    ApplicationUsers addUser(ApplicationUsers users);
    ApplicationUsers updateUser(Long idUser, ApplicationUsers users);
    boolean deleteUser(Long idUser);
    //ApplicationUsers findUserById(Long idUser);
}
