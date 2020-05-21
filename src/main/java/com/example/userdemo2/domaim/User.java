package com.example.userdemo2.domaim;

import java.io.Serializable;
import lombok.Data;

@Data
public class User implements Serializable {
    private Integer id;

    private String username;

    private String password;

    private String role;

    private static final long serialVersionUID = 1L;
}