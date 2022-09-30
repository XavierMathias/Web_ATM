package com.example.demo.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@Controller
@RequestMapping(path = "/api/v1/bank_account")
public class BankAccountController {

    private BankAccountService bankAccountService;

    @GetMapping
    public List<BankAccount> getAllAccounts(){
        return bankAccountService.getAcountList();
    }

    @PutMapping
    public void deleteAccount(@PathVariable(name = "accountId") Long accountId){
        bankAccountService.deleteAccount(accountId);
    }

    @PutMapping
    public void depositIntoAccount(@PathVariable(name = "accountId") Long id, Double amountToDeposit){
        bankAccountService.depositIntoAccount(id, amountToDeposit);
    }

    public void withdrawFromAccount(@PathVariable(name = "accountId") Long id, Double amountToWithdraw){
        bankAccountService.withdrawFromAccount(id, amountToWithdraw);
    }

}
