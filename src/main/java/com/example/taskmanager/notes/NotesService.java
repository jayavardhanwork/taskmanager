package com.example.taskmanager.notes;

import com.example.taskmanager.tasks.TaskEntity;
import com.example.taskmanager.tasks.TasksRepository;
import com.example.taskmanager.tasks.TasksService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service

public class NotesService {
    private NotesRepository notesRepository;

    private TasksService tasksService;
@Autowired
    private TasksRepository tasksRepository;


    public NotesService(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    List<NoteEntity> getAllNotesByTaskId(Long id){
        List<NoteEntity> noteEntities = notesRepository.findAllByTaskId(id);
        return  noteEntities;
    }

    NoteEntity addNewNoteToTask(String body, Long id)  {
        TaskEntity taskEntity =  tasksRepository.findById(id).get();
        NoteEntity newNote = new NoteEntity(body, taskEntity);
        NoteEntity savedNote = notesRepository.save(newNote);
        return savedNote;
    }

    void deleteNote(Long id){
        notesRepository.deleteById(id);
    }
}
