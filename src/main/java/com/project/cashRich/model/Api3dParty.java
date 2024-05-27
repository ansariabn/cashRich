package com.project.cashRich.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
/**
 * @author Nehal Ansari
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Third_Api")

public class Api3dParty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Long userId;
    private String request;
    private String response;

    private LocalDateTime timestamp;
}
