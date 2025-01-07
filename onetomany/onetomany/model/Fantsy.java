package com.example.onetomany.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Fantsy {

    @Id
    private int id;
    private String img;
    private String title;
    private String author;
    private String name;
    private String name1;
    private String name2;
    private String name3;
    private int price;
}
