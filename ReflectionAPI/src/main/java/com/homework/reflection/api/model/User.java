package com.homework.reflection.api.model;

import javax.persistence.*;
import java.time.LocalDate;


/*
*   User
*   Важно: дописывать классу дополнительный функционал нельзя!

 * */
@Entity
public class User {

    @Id
    @SequenceGenerator(name = "userSeq", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSeq")
    private Long id;

    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    private LocalDate birthDate;
    private String testFieldWithManyManyWords;
}
