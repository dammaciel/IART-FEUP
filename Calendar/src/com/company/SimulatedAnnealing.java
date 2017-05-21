package com.company;

import java.util.ArrayList;
import java.util.Random;

import com.company.Genetic.Chromosome;
import com.company.Genetic.Population;

import Domain.Calendar;
import Domain.Exam;
import Domain.Student;

public class SimulatedAnnealing {
	Calendar calendar;
	int iterations;
	int n_days;
	private Random random;
	private ArrayList<Integer> solution;
	private double T;
	
	public SimulatedAnnealing(int n_days){
		
		this.n_days =  n_days;
		this.iterations = 10;
		
		autofillCalendar();	
	}
	
	public void autofillCalendar() {
		Exam e1 = new Exam(0, "IART", 3);
		Exam e2 = new Exam(1, "SDIS", 3);
		Exam e3 = new Exam(2, "MEST", 1);
		Exam e4 = new Exam(3, "ASSO", 4);
		Exam e5 = new Exam(4, "CMAT", 1);
		Exam e6 = new Exam(5, "IOPE", 4);
		Exam e7 = new Exam(6, "ERSS", 4);
		Exam e8 = new Exam(7, "LGP", 4);

		Student s1 = new Student(0, "Daniel Maciel", 4);
		Student s2 = new Student(1, "Pedro Teles", 4);
		Student s3 = new Student(2, "Maria Duarte", 4);
		Student s4 = new Student(3, "Rafael Medeiros", 3);

		calendar = new Calendar(this.n_days);

		s1.addExame(e1);
		s1.addExame(e2);
		s1.addExame(e3);
		s1.addExame(e4);
		s1.addExame(e5);
		s1.addExame(e6);
		s2.addExame(e1);
		s2.addExame(e5);
		s2.addExame(e6);
		s2.addExame(e7);
		s2.addExame(e8);
		s3.addExame(e4);
		s3.addExame(e6);
		s3.addExame(e7);
		s3.addExame(e8);
		s4.addExame(e1);
		s4.addExame(e2);
		s4.addExame(e3);
		s4.addExame(e5);

		e1.addStudent(s1);
		e1.addStudent(s2);
		e1.addStudent(s4);
		e2.addStudent(s1);
		e2.addStudent(s4);
		e3.addStudent(s1);
		e3.addStudent(s4);
		e4.addStudent(s1);
		e4.addStudent(s1);
		e5.addStudent(s1);
		e5.addStudent(s2);
		e5.addStudent(s4);
		e6.addStudent(s1);
		e6.addStudent(s2);
		e6.addStudent(s3);
		e7.addStudent(s2);
		e7.addStudent(s3);
		e8.addStudent(s2);
		e8.addStudent(s3);

		calendar.addExam(e1);
		calendar.addExam(e2);
		calendar.addExam(e3);
		calendar.addExam(e4);
		calendar.addExam(e5);
		calendar.addExam(e6);
		calendar.addExam(e7);
		calendar.addExam(e8);

		calendar.addStudent(s1);
		calendar.addStudent(s2);
		calendar.addStudent(s3);
		calendar.addStudent(s4);
	}
	
	

}
