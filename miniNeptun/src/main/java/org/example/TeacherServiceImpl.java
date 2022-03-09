package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class TeacherServiceImpl implements TeacherService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    private final Long teacher_id;
    private final int COURSE_NUMBER_LIMIT = 10;
    private final int STUDENT_NUMBER_LIMIT = 10;

    public TeacherServiceImpl(StudentRepository studentRepository, CourseRepository courseRepository, Long teacher_id) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.teacher_id = teacher_id;
    }

    @Override
    public List<StudentDto> getMyStudents() {
        List<CourseDto> courseListByTeacher = courseRepository.findByTeacher(teacher_id);

        return studentRepository.findByCourseId(courseListByTeacher.stream()
                .map(course -> course.getId())
                .collect(Collectors.toList()));
    }

    @Override
    public boolean shouldBeTired() {
        return courseRepository.getElementCount(teacher_id) > COURSE_NUMBER_LIMIT || getMyStudents().size() > STUDENT_NUMBER_LIMIT;
    }
}
