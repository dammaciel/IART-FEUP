package Domain;

import java.util.ArrayList;

/**
 * Created by danma on 12/05/2017.
 */
public class Calendar {

    private ArrayList<Exam> exams;
    private ArrayList<Student> students;
    private int days;

    public Calendar(int days){
        this.exams = new ArrayList<Exam>();
        this.students = new ArrayList<Student>();
        this.days = days;
    }

    public void addExam(Exam e){
        this.exams.add(e);
    }

    public void addStudent(Student s){
        this.students.add(s);
    }
}
