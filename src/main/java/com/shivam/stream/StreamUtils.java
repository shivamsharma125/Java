package com.shivam.stream;

import com.shivam.models.Student;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamUtils {
    Optional<Student> findSpecificElementFromList(List<Student> students, long marksId){
        return students.stream()
                .filter(student -> student.getMarks().stream()
                        .anyMatch(marks -> marks.getId() == marksId))
                .findFirst();
    }

    public int sumSpecificElementFromList(List<Student> students){
        // sum of all age of students
        return students.stream().mapToInt(Student::getAge).sum();
    }
}
