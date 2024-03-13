package com.example.controller;

import com.example.core.Note;
import com.example.service.NoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.Collection;

@RequestMapping("/note")
@RestController
@CrossOrigin
public class NoteController {
    @Inject private NoteService noteService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Note> getAll(){
        return noteService.getAllNotes();
    }
    @GetMapping(path = "/{author}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Note> getNotesByAuthor(@PathVariable("author") String author){
    return noteService.getNotesByAuthor(author);
    }
    @PostMapping
    public ResponseEntity<String> addNote(@RequestBody Note note){
        note.setLocalDateTime(LocalDateTime.now());
        return noteService.addNote(note);
    }

}
