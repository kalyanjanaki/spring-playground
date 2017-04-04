package com.example;

import com.example.entities.Lesson;
import org.springframework.web.bind.annotation.*;

/**
 * Created by trainer20 on 4/4/17.
 */
@RestController
@RequestMapping("/lessons")
public class LessonController {

    private final LessonRepository repository;

    public LessonController(LessonRepository repository){
        this.repository = repository;
    }

    @GetMapping("")
    public Iterable<Lesson> all(){
        return this.repository.findAll();
    }

    @PostMapping("")
    public Lesson create(@RequestBody Lesson lesson){
        return repository.save(lesson);
    }

}
