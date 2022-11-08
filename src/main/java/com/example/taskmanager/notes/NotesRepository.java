package com.example.taskmanager.notes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotesRepository extends JpaRepository<NoteEntity, Long> {
    List<NoteEntity> findAllByTaskId(Long taskId);
}
