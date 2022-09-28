package com.example.demo.account;

import javax.persistence.*;

@Entity
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
    private AccountType accountType;
    private Integer amount;
    private String accountName;

}
