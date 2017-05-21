package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import com.company.Genetic.Chromosome;
import com.company.Genetic.Gene;
import com.company.Genetic.Population;

import Domain.Calendar;
import Domain.Exam;
import Domain.Student;
import Utils.Utils;

/**
 * Created by danma on 12/05/2017.
 */
public class GeneticAlgorithm {
	double mutation;
	double crossover;
	double elitist;
	int n_pop;
	int n_days;
	Calendar calendar;
	Population population;
	int iteration;

	public GeneticAlgorithm(int n_days) {
		this.n_pop = 10;
		this.mutation = 0.7;
		this.crossover = 0.5;
		this.n_days = n_days;
		this.iteration = 1000;
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
		population = new Population(n_pop, calendar.getNumberOfExams(), n_days, this.calendar, true);

		for (Chromosome c : population.getPopulation()) {
			c.calculateStrength();
		}
		population.calculateFittest();
	}

	public Object[][] getTab() {
		Object[][] tabela = new Object[3][n_days + 1];
		tabela[0][0] = "09h00";
		tabela[1][0] = "14h00";
		tabela[2][0] = "18h00";
		int exam;
		//System.out.println(this.population.getFittest() + " - " + this.population.getFittest().getCurrentStrength());
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
	
	public void solveAlgoritmo(){
		Chromosome elitist = new Chromosome (this.n_days, this.calendar.getNumberOfExams(), this.calendar, false);
		elitist.setChromosome(this.population.getFittest().getChromosome());
		elitist.calculateStrength();
		Population new_population = new Population(n_pop, calendar.getNumberOfExams(), n_days, this.calendar, false);
		for(Chromosome c: population.getPopulation()){
			new_population.addChromosome(c);
		}
		new_population.calculateFittest();
		elitist = new_population.getFittest();
		new_population.cleanPopulation();
		crossover(new_population, elitist);
		new_population.calculateFittest();
		mutate(new_population);
		for(Chromosome c: new_population.getPopulation()){
			this.population.addChromosome(c);
		}
		population.calculateFittest();
	}
	
	public void solveAlgoritmo100(){
		int x = this.iteration;
		while (x > 0) {
		
		Chromosome elitist = new Chromosome (this.n_days, this.calendar.getNumberOfExams(), this.calendar, false);
		elitist.setChromosome(this.population.getFittest().getChromosome());
		elitist.calculateStrength();
		Population new_population = new Population(n_pop, calendar.getNumberOfExams(), n_days, this.calendar, false);
		for(Chromosome c: population.getPopulation()){
			new_population.addChromosome(c);
		}
		new_population.calculateFittest();
		elitist = new_population.getFittest();
		new_population.cleanPopulation();
		crossover(new_population, elitist);
		new_population.calculateFittest();
		mutate(new_population);
		for(Chromosome c: new_population.getPopulation()){
			System.out.println(c.getCurrentStrength());
			this.population.addChromosome(c);
		}
		population.calculateFittest();
		x--;
		}
	}
	
	public void crossover(Population pop, Chromosome elitist){
		int n_exams = calendar.getNumberOfExams();
		for (int i = 0; i < this.n_pop; i++) {
			Chromosome c = elitist;
			if (Math.random() > this.crossover) {
				Chromosome new_chromosome = new Chromosome(this.n_days, n_exams, this.calendar, true);
				Chromosome c2 = getCrossoverParent(c);
				
				int breakIndex = (int) (Math.random() * n_exams);
				for (int j = 0; j < n_exams; j++) {
					if (j < breakIndex) {
						new_chromosome.setGeneInPosition(j, c.getGeneByPosition(j));
					} else {
						new_chromosome.setGeneInPosition(j, c2.getGeneByPosition(j));
					}
				}

				new_chromosome.calculateStrength();
				pop.addChromosome(new_chromosome);
			}
		}
		
	}

	public void mutate(Population pop){
		int pop_size= pop.getPopulation().size();
		Population new_population = new Population(n_pop, calendar.getNumberOfExams(), n_days, this.calendar, false);
		int n_exams = calendar.getNumberOfExams();
		for (int i = 0; i < pop_size; i++) {
			System.out.println("Inciio");

			Chromosome c = pop.getPopulation().get(i);
			System.out.println(c);
			if (Math.random() > this.mutation) {
				Chromosome new_chromosome = new Chromosome(this.n_days, n_exams, this.calendar, true);
				for (int j = 0; j < n_exams; j++) {
					if (Math.random() > 0.5) {
						new_chromosome.setGeneInPosition(j, c.getGeneByPosition(j));
					} else {
						Gene y  = new Gene(Utils.getBlocksSize(n_days), n_days);
						Integer[] new_gene = new Integer[Utils.getBlocksSize(n_days)];
						for(int k =0; k<Utils.getBlocksSize(n_days); k++ ){
							new_gene[k]=1 - c.getGeneByPosition(j).getGene()[k];
						}
						y.setGene(new_gene);
						if(!y.validateGene()){
							y = c.getGeneByPosition(j);
						}
						new_chromosome.setGeneInPosition(j, y);
					}
				}
				System.out.println(new_chromosome);
				new_chromosome.calculateStrength();
				new_population.addChromosome(new_chromosome);
			}else{
				new_population.addChromosome(c);
			}
		}
		pop.setPopulation(new_population.getPopulation());
	}
	
	public Chromosome getCrossoverParent(Chromosome c) {
		ArrayList<Chromosome> chromosomes = population.getPopulation();
		double rouletta = Math.random() * population.getFittest().getCurrentStrength();
		Collections.shuffle(chromosomes);
		for (int i = 0; i < chromosomes.size(); i++) {
			if (chromosomes.get(i).getCurrentStrength() >= rouletta && chromosomes.get(i) != c) {
				return chromosomes.get(i);
			}
		}
		return c;
	}

}
