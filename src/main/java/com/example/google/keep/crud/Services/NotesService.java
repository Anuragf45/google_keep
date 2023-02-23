package com.example.google.keep.crud.Services;

import com.example.google.keep.crud.Exception.NoteException;
import com.example.google.keep.crud.Model.NoteModel;
import com.example.google.keep.crud.Repositories.NoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class NotesService {
    Logger logger= LoggerFactory.getLogger(NotesService.class);
    @Autowired
     NoteRepository repository;
    @Autowired
     NoteException exception;

    public ResponseEntity<List<NoteModel>> getAllNotes(){
        logger.info("Fetching all the notes");
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }
    public ResponseEntity<?> getByTitle(String title){
        logger.info("fetching by title");
        Optional<NoteModel> optional1=repository.searchByTitle(title);
        if(optional1.isPresent()){
            return new ResponseEntity<>(repository.findNoteByRegexString(title),HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No Notes found with this title",HttpStatus.OK);
        }
    }

    public  ResponseEntity<?> createNote(NoteModel model){
        logger.info("creating a note");
        return new ResponseEntity<>(repository.save(model),HttpStatus.OK);
    }

    public  ResponseEntity<?> updateNote(String id, NoteModel UpdateData){
        logger.info("Checking for the user");
        Optional<NoteModel> optional1=repository.findById(id);
        if(optional1.isPresent()){
           NoteModel oldNote=optional1.get();
           oldNote.setDescription(UpdateData.getDescription()!=null?UpdateData.getDescription():oldNote.getDescription());
           logger.info("Saving old data");
           repository.save(oldNote);
           return  new ResponseEntity<>("Data updated successfully",HttpStatus.OK);

        }else{
            return new ResponseEntity<>("No notes found with id "+ id,HttpStatus.OK);
        }
    }
    public ResponseEntity<?> deleteNote(String id){
        logger.info("Checking for note with note id");
        Optional<NoteModel> noteOptional=repository.findById(id);
        if(noteOptional.isPresent()){
            logger.info("deleting the note");
            repository.deleteById(id);
            return new ResponseEntity<>("User Deleted Successfully",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No note found with this id",HttpStatus.OK);
        }
    }

}
