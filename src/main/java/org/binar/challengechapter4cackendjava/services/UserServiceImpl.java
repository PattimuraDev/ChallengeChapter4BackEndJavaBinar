package org.binar.challengechapter4cackendjava.services;

import org.binar.challengechapter4cackendjava.model.ApplicationUsers;
import org.binar.challengechapter4cackendjava.repository.ApplicationUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    ApplicationUsersRepository applicationUsersRepository;

    @Override
    public ApplicationUsers addUser(ApplicationUsers users) {
        return applicationUsersRepository.save(users);
    }

    @Override
    public ApplicationUsers updateUser(Long idUser, ApplicationUsers users) {
        final ApplicationUsers result = findUserById(idUser);
        if(result != null){
            result.setEmailAddress(users.getEmailAddress());
            result.setPassword(users.getPassword());
            result.setUsername(users.getUsername());
            return applicationUsersRepository.save(result);
        }
        return null;
    }

    @Override
    public boolean deleteUser(Long idUser) {
        final ApplicationUsers result = findUserById(idUser);
        if(result != null){
            applicationUsersRepository.deleteById(idUser);
            return true;
        }
        return false;
    }

    @Override
    public ApplicationUsers findUserById(Long idUser) {
        Optional<ApplicationUsers> result = applicationUsersRepository.findById(idUser);
        return result.orElse(null);
    }
}
