package com.example.demo.account;

import com.example.demo.user.AppUser;

import javax.persistence.*;

@Entity
@Table(name = "bank_account")
public class BankAccount {

    @Id
    @SequenceGenerator(
            name = "bankaccount_sequence",
            allocationSize = 1,
            sequenceName = "bankaccount_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "appuser_sequence"
    )
    private Long id;
    @Column(nullable = false, unique = true)
    private AccountType accountType;
    @Column(name = "amount", nullable = false)
    private Integer amount;
    @Column(name = "account_name", nullable = false)
    private String accountName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "client", nullable = false)
    private AppUser appUser;

    public BankAccount() {}

    public BankAccount(AccountType accountType, Integer amount, String accountName) {
        this.accountType = accountType;
        this.amount = amount;
        this.accountName = accountName;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}
