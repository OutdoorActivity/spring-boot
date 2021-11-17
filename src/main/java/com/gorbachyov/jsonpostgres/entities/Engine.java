package com.gorbachyov.jsonpostgres.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "json", name = "engines")
public class Engine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String engineType;

    @Override
    public String toString() {
        return engineType;
    }
}
