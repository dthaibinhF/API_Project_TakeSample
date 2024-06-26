package com.example.api_takesample.Service;

import com.example.api_takesample.Model.Account;
import com.example.api_takesample.Model.User;
import com.example.api_takesample.Repository.AccountRepository;
import com.example.api_takesample.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public UserService(UserRepository userRepository, AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }

    public List<User> getUser() {
        return userRepository.findAll();
    }


    public List<User> getUserById(Long idUser) {
        boolean exist = userRepository.existsById(idUser);
        if (!exist) throw new IllegalStateException(
                "Id user " + idUser + " does not exist"
        );
        return userRepository.findByIdUser(idUser);
    }

    public void deleteUser(Long userId) {
        boolean exist = userRepository.existsById(userId);

        if (!exist) {
            throw new IllegalStateException(
                    "User with id " + userId + " does not exist"
            );
        }

        userRepository.deleteById(userId);
    }

    @Transactional
    public void updateUser(Long userId, String name, String address, String email, String phoneNumber) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException(
                "User with id " + userId + " does not exist"
        ));

        if (name != null &&
                !name.isEmpty() &&
                !Objects.equals(user.getName(), name)) {
            user.setName(name);
        }

        if (address != null &&
                !address.isEmpty() &&
                !Objects.equals(user.getAddress(), address)) {
            user.setAddress(address);
        }

        if (email != null &&
                !email.isEmpty() &&
                !Objects.equals(user.getEmail(), email)) {
            Optional<User> userOptional = userRepository
                    .findUserByEmail(email);
            if (userOptional.isPresent())
                throw new IllegalStateException(
                        "email taken"
                );
            user.setEmail(email);
        }

        if (phoneNumber != null &&
                phoneNumber.length() == 10 &&
                !Objects.equals(user.getPhoneNumber(), phoneNumber)
        ) {
            Optional<User> userOptional = userRepository
                    .findUserByPhoneNumber(phoneNumber);
            if (userOptional.isPresent())
                throw new IllegalStateException(
                        "phone number taken"
                );
            user.setPhoneNumber(phoneNumber);
        }

    }

    public void addNewUser(User user) {
        Optional<User> userOptional = userRepository
                .findUserByPhoneNumber(user.getPhoneNumber());
        if (userOptional.isPresent())
            throw new IllegalStateException(
                    "phone number taken"
            );

        Optional<Account> account = accountRepository.findByUsername(user.getPhoneNumber());
        user.setAccount(account.get());
        userRepository.save(user);
    }

}
