package Generics;

import java.util.*;

// Abstract Course Type
abstract class CourseType {
    String evaluationType;

    public CourseType(String evaluationType) {
        this.evaluationType = evaluationType;
    }

    public String getEvaluationType() {
        return evaluationType;
    }
}

// Different Course Types
class ExamCourse extends CourseType {
    public ExamCourse() {
        super("Exam-Based");
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse() {
        super("Assignment-Based");
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse() {
        super("Research-Based");
    }
}

// Generic Course Class
class Course<T extends CourseType> {

    private String courseName;
    private String department;
    private T courseType;

    public Course(String courseName, String department, T courseType) {
        this.courseName = courseName;
        this.department = department;
        this.courseType = courseType;
    }

    public void displayCourse() {
        System.out.println("Course Name : " + courseName);
        System.out.println("Department  : " + department);
        System.out.println("Evaluation  : " + courseType.getEvaluationType());
        System.out.println();
    }

    public T getCourseType() {
        return courseType;
    }
}

// Main Class
public class UniversityCourseManagementSystem {

    // Wildcard Method
    public static void displayCourseTypes(List<? extends CourseType> list) {
        System.out.println("Available Evaluation Types:");
        for (CourseType type : list) {
            System.out.println(type.getEvaluationType());
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Course<ExamCourse> c1 = new Course<>("Data Structures", "Computer Science", new ExamCourse());

        Course<AssignmentCourse> c2 = new Course<>("Software Engineering", "Computer Science", new AssignmentCourse());

        Course<ResearchCourse> c3 = new Course<>("Machine Learning Research", "AI Department", new ResearchCourse());

        System.out.println("University Course Details:\n");

        c1.displayCourse();
        c2.displayCourse();
        c3.displayCourse();

        List<CourseType> courseTypes = new ArrayList<>();
        courseTypes.add(new ExamCourse());
        courseTypes.add(new AssignmentCourse());
        courseTypes.add(new ResearchCourse());

        displayCourseTypes(courseTypes);
    }
}
