package com.shivam.stream;

import com.shivam.models.Student;

import java.util.List;
import java.util.Optional;

public class StreamUtils {
    Optional<Student> findSpecificElementFromList(List<Student> students, long marksId){
        return students.stream()
                .filter(student -> student.getMarks().stream()
                        .anyMatch(marks -> marks.getId() == marksId))
                .findFirst();
    }
}
