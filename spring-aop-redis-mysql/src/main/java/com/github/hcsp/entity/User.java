package com.github.hcsp.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class User implements Serializable{
    Integer id;
    String name;
}
