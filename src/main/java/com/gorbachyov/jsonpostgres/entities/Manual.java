package com.gorbachyov.jsonpostgres.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@ToString
@Table(schema = "json", name = "manuals")
public class Manual {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String manualType;




}
