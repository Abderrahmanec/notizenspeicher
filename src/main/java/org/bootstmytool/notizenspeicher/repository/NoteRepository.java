package org.bootstmytool.notizenspeicher.repository;

import org.bootstmytool.notizenspeicher.model.Note;

import org.bootstmytool.notizenspeicher.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findAllByUserId(Long userId);



}
