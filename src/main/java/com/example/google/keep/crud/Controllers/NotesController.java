package com.example.google.keep.crud.Controllers;

import com.example.google.keep.crud.Model.NoteModel;
import com.example.google.keep.crud.Repositories.NoteRepository;
import com.example.google.keep.crud.Services.NotesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class NotesController {
    Logger logger= LoggerFactory.getLogger(NotesController.class);
    @Autowired
     NoteRepository repository;

    @Autowired
     NotesService notesService;

    @PostMapping("/createNote")
    public ResponseEntity<?> createNote(@RequestBody NoteModel model){
        logger.info("Creating new note");
      return  notesService.createNote(model);

    }
    @GetMapping("/getByTitle/{title}")
    public  ResponseEntity<?> getByTitle(@PathVariable String title){
        logger.info("fetching by title");
        return notesService.getByTitle(title);
    }

    @GetMapping("/getNotes")
    public  ResponseEntity<?> getAllNotes(){
        logger.info("fetching all the notes");
        return notesService.getAllNotes();
    }

    @PutMapping ("/updateNotes/{id}")
    public ResponseEntity<?> updateNotes(@PathVariable String id,@RequestBody NoteModel model){
        logger.info("Updating the notes");
        return notesService.updateNote(id,model);
    }

    @DeleteMapping("/deletingNote/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable String id){
        logger.info("Deleting a note");
        return notesService.deleteNote(id);
    }
}
