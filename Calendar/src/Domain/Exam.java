package Domain;

import java.util.ArrayList;

/**
 * Created by danma on 12/05/2017.
 */
public class Exam {

    private int id;
    private String name;
    private int year;
    private ArrayList<Student> students;

    public Exam(int id, String name, int year){
        this.name = name;
        this.id = id;
        this.year = year;
        this.students = new ArrayList<Student>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public void addStudent(Student s){
        this.students.add(s);
    }
}
