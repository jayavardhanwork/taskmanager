package com.example.taskmanager.notes;

import com.example.taskmanager.tasks.TasksRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tasks/")
public class NotesController {
    private NotesService notesService;

    public NotesController(NotesService notesService) {
        this.notesService = notesService;
    }

    @GetMapping("{id}/notes/")
    ResponseEntity<List<NoteEntity>> getNotesByTaskId(@PathVariable Long id){
        List<NoteEntity> noteEntities = notesService.getAllNotesByTaskId(id);
        return ResponseEntity.ok(noteEntities);
    }

    @PostMapping("/{id}/notes/")
    ResponseEntity addNewNoteToTask(@RequestBody CreateNoteRequestBody body,@PathVariable Long id) throws Exception {
        NoteEntity noteEntity = notesService.addNewNoteToTask(body.body, id);
        return ResponseEntity.status(200).body(noteEntity);
    }

    @DeleteMapping("{id}/notes/{nid}")
    Map<String,Boolean> deleteNote(@PathVariable Long nid){
        notesService.deleteNote(nid);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted", true);
        return response;
    }
}
