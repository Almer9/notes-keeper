package com.example.service;

import com.example.core.Note;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

public interface NoteService {
Collection<Note> getAllNotes();
Collection<Note> getNotesByAuthor(String author);
ResponseEntity<String> addNote(Note note);
}
