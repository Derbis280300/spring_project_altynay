package com.example.spring_project_altynay.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "task")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
     private String description;

//    @Column(name="deadlineDate")
//    private String deadlineDate;



//    @Column (name="isCompleted")
//    private boolean isCompleted;

}
