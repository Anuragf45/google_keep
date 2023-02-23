package com.example.google.keep.crud.Repositories;

import com.example.google.keep.crud.Model.NoteModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends MongoRepository<NoteModel,String> {

}
