package com.gitmuts.testmwallet.entity;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name= "users")
@Entity
@Data
public class User {

    @Id
    @Column
    @GeneratedValue(generator = "key_gen_table", strategy = GenerationType.TABLE)
    @TableGenerator(name = "key_gen_table", allocationSize = 1)
    private long userId;
    @Column
    private String lastNameHere;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "username")
    private String username;
    @CreationTimestamp
    @Column(name="created_at")
    private Timestamp createdAt;
    @UpdateTimestamp
    @Column(name="updated_at")
    private Timestamp updatedAt;
}
