package com.example.taskmanager.notes;

import com.example.taskmanager.tasks.TaskEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "notes")
public class NoteEntity {
    @Id
    Integer id;
    String body;
    @ManyToOne
    TaskEntity task;
}
