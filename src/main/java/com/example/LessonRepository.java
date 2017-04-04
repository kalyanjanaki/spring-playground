package com.example;

import com.example.entities.Lesson;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by trainer20 on 4/4/17.
 */
public interface LessonRepository extends CrudRepository<Lesson, Long> {

}
