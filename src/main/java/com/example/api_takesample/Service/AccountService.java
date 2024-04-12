package com.example.api_takesample.Service;

import com.example.api_takesample.Model.Account;
import com.example.api_takesample.Repository.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void addNewAccount(Account account) {
        Optional<Account> accountOptional = accountRepository
                .findByUsername(account.getUsername());
        if (accountOptional.isPresent()) {
            throw new IllegalStateException("username taken");
        }
        accountRepository.save(account);
    }

    public List<Account> getAccount() {
        return accountRepository.findAll();
    }

    public void deleteAccount(Long accountId) {
        boolean exist = accountRepository.existsById(accountId);
        if (!exist) {
            throw new IllegalStateException(
                    "Account with id " + accountId + " does not exist"
            );
        }
        accountRepository.deleteById(accountId);
    }

    @Transactional
    public void updatePassword(Long accountId, String password) {

        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new IllegalStateException(
                        "Account with id " + accountId + " does not exist"
                ));

        if (password != null && isPasswordValid(password) && !password.equals(account.getPassword())) {
            account.setPassword(password);
        }


    }

    private boolean isPasswordValid(String password) {
        if (password.length() < 8) {
            throw new IllegalStateException(
                    "password invalid"
            );
        }
        return true;
    }

    public List<Account> getAccountById(Long accountId) {
        boolean exist = accountRepository
                .existsById(accountId);
        if (!exist) throw new IllegalStateException(
                "Account with id " + accountId + " does not exist"
        );

        return accountRepository.findAccountByIdAccount(accountId);
    }
}
