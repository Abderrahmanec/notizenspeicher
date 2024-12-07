package org.bootstmytool.notizenspeicher.controller;

import org.bootstmytool.notizenspeicher.dto.NoteDTO;
import org.bootstmytool.notizenspeicher.model.Note;
import org.bootstmytool.notizenspeicher.model.User;
import org.bootstmytool.notizenspeicher.service.NoteService;
import org.bootstmytool.notizenspeicher.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @Autowired
    private UserService userService;

    @PostMapping
    public Note createNote(@RequestBody NoteDTO noteDTO, @RequestParam String username) {
        User user = userService.getUserByUsername(username);
        return noteService.createNote(noteDTO, user);
    }

    @GetMapping
    public List<Note> getNotes(@RequestParam String username) {
        User user = userService.getUserByUsername(username);
        return noteService.getNotesByUser(user);
    }
}
