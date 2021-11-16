package com.gorbachyov.jsonpostgres.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "json", name = "manuals")
public class Manual {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String manualType;
}
