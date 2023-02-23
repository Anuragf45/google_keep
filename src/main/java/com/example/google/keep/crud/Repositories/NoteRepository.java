package com.example.google.keep.crud.Repositories;

import com.example.google.keep.crud.Model.NoteModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NoteRepository extends MongoRepository<NoteModel,String> {
@Query
Optional<NoteModel> searchByTitle(String title);

//    @Query("{ 'title' : { $regex: ?0 } }")
//    List<NoteModel> findUsersByRegexpName(String title);
@Query("{'title': { $regex: ?0, $options:'i' }}")
List<NoteModel> findNoteByRegexString(final String title);
}
