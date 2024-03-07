package com.example.service;

import com.example.core.Note;
import com.example.repository.NoteRepository;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.http.ResponseEntity;

import java.util.Collection;
@Named
public class NoteServiceImpl implements NoteService{
    @Inject
    private NoteRepository noteRepository;
    @Override
    public Collection<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Collection<Note> getNotesByAuthor(String author) {
        return noteRepository.getByAuthor(author);
    }

    @Override
    public ResponseEntity<String> addNote(Note note){
        try {
            noteRepository.save(note);
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.accepted().header("location","note/"+note.getId()).build();
    }
}
