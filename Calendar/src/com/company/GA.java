package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import com.company.Genetic.Chromosome;
import com.company.Genetic.Population;

import Domain.Calendar;
import Domain.Exam;
import Domain.Student;
import Utils.Utils;

public class GA {
	double mutation;
	double crossover;
	double elitist;
	int n_pop;
	int n_days;
	Calendar calendar;
	Population population;
	int iteration;

	public GA(int n_days) {
		this.n_pop = 10;
		this.mutation = 0.7;
		this.crossover = 0.5;
		this.n_days = n_days;
		this.iteration = 10;
	}

	public Population getPopulation() {
		return population;
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
		start();
	}

	public void start() {
		//population = new Population(n_pop, calendar.getNumberOfExams(), n_days);

		for (Chromosome c : population.getPopulation()) {
			this.checkChromosomeStrength(c);
		}
		population.calculateFittest();
	}

	public void checkChromosomeStrength(Chromosome chromosome) {
		System.out.println("CHROMOSOME: " + chromosome);

		double strength = chromosome.getCurrentStrength();
		int overlapFlag = 1; // flag=0 se houver exames sobrepostos
		for (int i = 0; i < calendar.getStudents().size(); i++) {
			double space = calculateSpaceBetweenExams(calendar.getStudents().get(i), chromosome);
			if (space == -1) {
				overlapFlag = 0;
			}
			double examsInDay = calendar.getStudents().get(i).calculateExamsInDay();
			strength += space * examsInDay;
		}

		strength = (strength / calendar.getStudents().size()) * overlapFlag;
		chromosome.setCurrentStrength(strength);
		System.out.println("Strength: " + chromosome.getCurrentStrength());
	}

	public double calculateSpaceBetweenExams(Student s, Chromosome chromosome) {
		Integer[] slots = new Integer[s.getExams().size()];
		for (int i = 0; i < s.getExams().size(); i++) {
			slots[i] = Integer.parseInt(chromosome.getSlotFromGene(s.getExams().get(i).getId()), 2);
		}
		Arrays.sort(slots);

		int x = 0;
		for (int i = 0; i < slots.length - 1; i++) {
			if ((slots[i + 1] - slots[i]) > 0) {
				x += (slots[i + 1] - slots[i]);
			} else {
				return -1;
			}

		}
		return x / slots.length;
	}

	public Object[][] getTab() {
		Object[][] tabela = new Object[3][n_days + 1];
		tabela[0][0] = "09h00";
		tabela[1][0] = "14h00";
		tabela[2][0] = "18h00";
		int exam;
		for (int i = 0; i < calendar.getExams().size(); i++) {
			exam = Integer.parseInt(population.getFittest().getSlotFromGene(calendar.getExams().get(i).getId()), 2);
			int[] slot = Utils.convertSlotToDate(exam);
			if (tabela[slot[0]][slot[1]] == null) {
				tabela[slot[0]][slot[1]] = calendar.getExams().get(i).getName();
			} else {
				tabela[slot[0]][slot[1]] += "/" + calendar.getExams().get(i).getName();
			}
		}
		return tabela;
	}

	public String[] getHeaders() {
		String[] novo = new String[n_days + 1];
		for (int i = 0; i < novo.length; i++) {
			if (i == 0) {
				novo[i] = "Hora";
			} else {
				novo[i] = "Dia " + i;
			}
		}
		return novo;
	}

	public void geraMutante() {
		
		System.out.println("\n\nALGORITMO GENETICO");
		int x = this.iteration;
		while (x > 0) {
			//crossoverPopulation();
			x--;
		}
	}
/**
	public void crossoverPopulation() {
		Population population1 = this.population;

		int n_exams = calendar.getNumberOfExams();

		for (int i = 0; i < this.n_pop; i++) {
			Chromosome c = population1.getFittest();
			if (Math.random() > this.crossover) {
				//Chromosome new_chromosome = new Chromosome(this.n_days, n_exams);
				Chromosome c2 = getCrossoverParent(c);

				int breakIndex = (int) (Math.random() * n_exams);
				for (int j = 0; j < n_exams; j++) {
					if (j < breakIndex) {
						new_chromosome.setGeneInPosition(j, c.getGeneByPosition(j));
					} else {
						new_chromosome.setGeneInPosition(j, c2.getGeneByPosition(j));
					}
				}
				new_chromosome = mutateChromosome(new_chromosome);
				population.addChromosome(new_chromosome);
				population.calculateFittest();

			}
		}
	}**/

	public Chromosome getCrossoverParent(Chromosome c) {
		ArrayList<Chromosome> chromosomes = population.getPopulation();
		double rouletta = Math.random() * population.getFittest().getCurrentStrength();
		//Collections.shuffle(chromosomes);
		for (int i = 0; i < chromosomes.size(); i++) {
			if (chromosomes.get(i).getCurrentStrength() >= rouletta && chromosomes.get(i) != c) {
				return chromosomes.get(i);
			}
		}
		return c;
	}

	public Chromosome mutateChromosome(Chromosome c) {
		Chromosome chromo = c;
		double roulette = Math.random();
		if (roulette > this.mutation) {
			chromo.mutateChromosome();
		}
		return chromo;
	}
}