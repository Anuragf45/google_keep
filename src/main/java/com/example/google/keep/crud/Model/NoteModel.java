package com.example.google.keep.crud.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document(collection = "GK")
@NoArgsConstructor
public class NoteModel {
    @Id
    private String id;
    private String createdBy;
    private String description;
    private String title;
}




