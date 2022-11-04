package org.binar.ChallengeChapter4BackEndJava.services;

import org.binar.ChallengeChapter4BackEndJava.model.ApplicationUsers;
import org.binar.ChallengeChapter4BackEndJava.repository.ApplicationUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    ApplicationUsersRepository applicationUsersRepository;

    /**
     * Fungsi untuk menambah user
     * @param users parameter objek user yang ingin ditambahkan
     * @return user yang telah ditambahkan
     */
    @Override
    public ApplicationUsers addUser(ApplicationUsers users) {
        return applicationUsersRepository.save(users);
    }

    /**
     * Fungsi untuk mengupdate data user
     * @param idUser parameter untuk idUser
     * @param users parameter untuk objek user
     * @return user yang sudah diupdate
     */
    @Override
    public ApplicationUsers updateUser(Long idUser, ApplicationUsers users) {
        Optional<ApplicationUsers> usersOptional = applicationUsersRepository.findById(idUser);
        final ApplicationUsers result = usersOptional.get();
        result.setEmailAddress(users.getEmailAddress());
        result.setPassword(users.getPassword());
        result.setUsername(users.getUsername());
        return applicationUsersRepository.save(result);
    }

    /**
     * Fungsi untuk menghapus delete user
     * @param idUser parameter untuk id dari user
     * @return boolean, true untuk berhasil, false jika gagal
     */
    @Override
    public boolean deleteUser(Long idUser) {
        Optional<ApplicationUsers> usersOptional = applicationUsersRepository.findById(idUser);
        final ApplicationUsers result = usersOptional.get();
        applicationUsersRepository.deleteById(idUser);
        return true;
    }

//
//    @Override
//    public ApplicationUsers findUserById(Long idUser) {
//        Optional<ApplicationUsers> result = applicationUsersRepository.findById(idUser);
//        return result.orElse(null);
//    }
}
