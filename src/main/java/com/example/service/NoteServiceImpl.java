package com.example.service;

import com.example.core.Note;
import com.example.repository.NoteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class NoteServiceImpl implements NoteService{

    private final NoteRepository noteRepository;

    @Autowired
    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

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
