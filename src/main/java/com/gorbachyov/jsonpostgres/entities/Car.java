package com.gorbachyov.jsonpostgres.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "json", name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String manufacturerName;
    private String modelName;
    private int year;
  /*  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Engine engine;*/


}

