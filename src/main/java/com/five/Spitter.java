package com.five;


import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Administrator on 2016/8/24 0024.
 * 包含了要提交到Spittle POST请求中的域
 */
@Data
public class Spitter {

    private Long id;

    @NotNull
    @Size(min=5, max=16, message = "{username.size}")
    private String username;

    @NotNull
    @Size(min=5, max=25, message = "{password.size}")
    private String password;

    @NotNull
    @Size(min=2, max=30, message = "{firstName.size}")
    private String firstName;

    @NotNull
    @Size(min=2, max=30, message = "{lastName.size}")
    private String lastName;

    public Spitter() {
    }

    public Spitter(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Spitter(Long id, String username, String password, String firstName, String lastName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
