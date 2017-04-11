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

    @GetMapping("/{id}")
    public Lesson getLesson(@PathVariable Long id){
        return this.repository.findOne(id);
    }

    @PatchMapping("/{id}")
    public Lesson patchLesson(@RequestBody Lesson lesson){
        return this.repository.save(lesson);
    }

    @DeleteMapping("/{id}")
    public void deleteLesson(@PathVariable Long id){
        this.repository.delete(id);
    }

}
