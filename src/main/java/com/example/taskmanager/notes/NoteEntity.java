package com.example.taskmanager.notes;

import com.example.taskmanager.tasks.TaskEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "notes")
public class NoteEntity {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    String body;
    @ManyToOne
    TaskEntity task;
}
