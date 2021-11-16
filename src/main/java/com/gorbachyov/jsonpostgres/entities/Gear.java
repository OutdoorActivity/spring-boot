package com.gorbachyov.jsonpostgres.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "json", name = "gears")
public class Gear {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String gearType;
    /*@ManyToOne
    @JoinColumn(name = "ENGINE_ID", referencedColumnName = "ID")
    private Engine engine;*/


}
