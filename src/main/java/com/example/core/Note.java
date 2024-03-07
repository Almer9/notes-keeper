package com.example.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
public class Note {
/*
   * TABLE NOTE
   (
   NOTEID     BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
   TIME    TIMESTAMP NOT NULL,
   AUTHOR    VARCHAR(50) NOT NULL,
   NOTE  VARCHAR(500) NOT NULL,
   );
   */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="NOTEID")
    long id;
    @Column(name = "TIME")
    LocalDateTime localDateTime;
    @Column(name = "AUTHOR")
    String author;
    @Column(name = "NOTE")
    String note;

    public Note(){super();}
    public Note (LocalDateTime localDateTime,String author,String note){
        this.localDateTime = localDateTime;
        this.author = author;
        this.note = note;
    }
}
