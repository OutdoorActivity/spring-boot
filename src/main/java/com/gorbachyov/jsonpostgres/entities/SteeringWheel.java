package com.gorbachyov.jsonpostgres.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(schema = "json", name = "steeringWheels")
public class SteeringWheel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String steeringWheelType;
}
