package com.example.api_takesample.Controller;

import com.example.api_takesample.Model.Account;
import com.example.api_takesample.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/account")
public class AccountController {

private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<Account> getAccount() {
        return accountService.getAccount();
    }

    @PostMapping
    public void registerNewAccount(@RequestBody Account account) {
        accountService.addNewAccount(account);
    }

    @DeleteMapping(path = "{accountId}")
    public void deleteAccount(@PathVariable("accountId") Long accountId) {
        accountService.deleteAccount(accountId);
    }

    @PutMapping(path = "{accountId}")
    public void updatePassword(
            @PathVariable("accountId") Long accountId,
            @RequestParam(required = false) String password
    ) {
        accountService.updatePassword(accountId, password);
    }

}
