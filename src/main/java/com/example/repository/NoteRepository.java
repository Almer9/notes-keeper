package com.example.repository;

import com.example.core.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface NoteRepository extends JpaRepository<Note,Long>{
    Collection<Note> getByAuthor(String author);
}
