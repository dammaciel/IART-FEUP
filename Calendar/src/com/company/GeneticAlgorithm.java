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
		this.iteration = 100;
	}

	public Population getPopulation() {
		return population;
	}

	public void fullAutofill() {
		

		Exam e1 = new Exam(0, "MEST", 1);
		Exam e2 = new Exam(1, "PROG", 1);
		Exam e3 = new Exam(2, "FISI1", 1);
		Exam e4 = new Exam(3, "CMAT", 1);
		Exam e5 = new Exam(4, "MPCP", 1);

		Exam e6 = new Exam(5, "BDAD", 2);
		Exam e7 = new Exam(6, "CAL", 2);
		Exam e8 = new Exam(7, "CGRA", 2);
		Exam e9 = new Exam(8, "SOPE", 2);
		Exam e10 = new Exam(9, "LPOO", 2);

		Exam e11 = new Exam(10, "LBAW", 3);
		Exam e12 = new Exam(11, "IART", 3);
		Exam e13 = new Exam(12, "COMP", 3);
		Exam e14 = new Exam(13, "SDIS", 3);
		Exam e15 = new Exam(14, "PPIN", 3);

		Exam e16 = new Exam(15, "IOPE", 4);
		Exam e17 = new Exam(16, "LGPR", 4);
		Exam e18 = new Exam(17, "ASSO", 4);
		Exam e19 = new Exam(18, "ERSS", 4);
		Exam e20 = new Exam(19, "MARK", 4);

		Student s1 = new Student(0, "Daniel Maciel", 1);
		Student s2 = new Student(1, "Pedro Teles", 2);
		Student s3 = new Student(2, "Maria Duarte", 3);
		Student s4 = new Student(3, "Rafael Medeiros", 4);
		Student s5 = new Student(4, "Gabriela Miranda", 4);

		calendar = new Calendar(this.n_days);
		//Teste 1 Todos os estudantes tem as cadeiras em dia
		associateExamAndStudent(s1, e1);
		associateExamAndStudent(s1, e2);
		associateExamAndStudent(s1, e3);
		associateExamAndStudent(s1, e4);
		associateExamAndStudent(s1, e5);
		associateExamAndStudent(s2, e6);
		associateExamAndStudent(s2, e7);
		associateExamAndStudent(s2, e8);
		associateExamAndStudent(s2, e9);
		associateExamAndStudent(s2, e10);
		associateExamAndStudent(s3, e11);
		associateExamAndStudent(s3, e12);
		associateExamAndStudent(s3, e13);
		associateExamAndStudent(s3, e14);
		associateExamAndStudent(s3, e15);
		associateExamAndStudent(s4, e16);
		associateExamAndStudent(s4, e17);
		associateExamAndStudent(s4, e18);
		associateExamAndStudent(s4, e19);
		associateExamAndStudent(s4, e20);
		associateExamAndStudent(s5, e18);
		associateExamAndStudent(s5, e19);
		associateExamAndStudent(s5, e12);
		associateExamAndStudent(s5, e16);
		associateExamAndStudent(s5, e20);
		
		//Teste 2 Metade dos estudantes tem as cadeiras em dia
		/*associateExamAndStudent(s1, e1);
		associateExamAndStudent(s1, e2);
		associateExamAndStudent(s1, e3);
		associateExamAndStudent(s1, e4);
		associateExamAndStudent(s1, e5);
		associateExamAndStudent(s2, e6);
		associateExamAndStudent(s2, e3);
		associateExamAndStudent(s2, e4);
		associateExamAndStudent(s2, e5);
		associateExamAndStudent(s2, e10);
		associateExamAndStudent(s3, e11);
		associateExamAndStudent(s3, e12);
		associateExamAndStudent(s3, e6);
		associateExamAndStudent(s3, e4);
		associateExamAndStudent(s3, e5);
		associateExamAndStudent(s4, e12);
		associateExamAndStudent(s4, e13);
		associateExamAndStudent(s4, e18);
		associateExamAndStudent(s4, e19);
		associateExamAndStudent(s4, e20);
		associateExamAndStudent(s5, e18);
		associateExamAndStudent(s5, e19);
		associateExamAndStudent(s5, e12);
		associateExamAndStudent(s5, e16);
		associateExamAndStudent(s5, e20);*/
		
		//Teste 3 Todos tem cadeiras em atraso
		/*associateExamAndStudent(s1, e1);
		associateExamAndStudent(s1, e2);
		associateExamAndStudent(s1, e3);
		associateExamAndStudent(s1, e4);
		associateExamAndStudent(s1, e5);
		associateExamAndStudent(s2, e1);
		associateExamAndStudent(s2, e3);
		associateExamAndStudent(s2, e4);
		associateExamAndStudent(s2, e5);
		associateExamAndStudent(s2, e2);
		associateExamAndStudent(s3, e3);
		associateExamAndStudent(s3, e6);
		associateExamAndStudent(s3, e7);
		associateExamAndStudent(s3, e10);
		associateExamAndStudent(s3, e9);
		associateExamAndStudent(s4, e12);
		associateExamAndStudent(s4, e13);
		associateExamAndStudent(s4, e11);
		associateExamAndStudent(s4, e5);
		associateExamAndStudent(s4, e1);
		associateExamAndStudent(s5, e1);
		associateExamAndStudent(s5, e6);
		associateExamAndStudent(s5, e10);
		associateExamAndStudent(s5, e11);
		associateExamAndStudent(s5, e15);*/
		
		calendar.addExam(e1);
		calendar.addExam(e2);
		calendar.addExam(e3);
		calendar.addExam(e4);
		calendar.addExam(e5);
		calendar.addExam(e6);
		calendar.addExam(e7);
		calendar.addExam(e8);
		calendar.addExam(e9);
		calendar.addExam(e10);
		calendar.addExam(e11);
		calendar.addExam(e12);
		calendar.addExam(e13);
		calendar.addExam(e14);
		calendar.addExam(e15);
		calendar.addExam(e16);
		calendar.addExam(e17);
		calendar.addExam(e18);
		calendar.addExam(e19);
		calendar.addExam(e20);

		calendar.addStudent(s1);
		calendar.addStudent(s2);
		calendar.addStudent(s3);
		calendar.addStudent(s4);
		calendar.addStudent(s5);
		start();
	}

	public void associateExamAndStudent(Student s, Exam e) {
		e.addStudent(s);
		s.addExame(e);
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

	public ArrayList<Student> getStudents() {
		return this.calendar.getStudents();
	}

	public void start() {
		population = new Population(n_pop, calendar.getNumberOfExams(), n_days, this.calendar, true);

		for (Chromosome c : population.getPopulation()) {
			c.calculateStrength();
		}
		population.calculateFittest();
	}

	public Object[][] getTab(Student combobox) {
		Object[][] tabela = new Object[3][n_days + 1];
		tabela[0][0] = "09h00";
		tabela[1][0] = "14h00";
		tabela[2][0] = "18h00";
		int exam;
		if (combobox == null) {
			for (int i = 0; i < calendar.getExams().size(); i++) {
				exam = Integer.parseInt(population.getFittest().getSlotFromGene(calendar.getExams().get(i).getId()), 2);
				int[] slot = Utils.convertSlotToDate(exam);
				if (tabela[slot[0]][slot[1]] == null) {
					tabela[slot[0]][slot[1]] = calendar.getExams().get(i).getName();
				} else {
					tabela[slot[0]][slot[1]] += "/" + calendar.getExams().get(i).getName();
				}
			}
		} else {
			for (int i = 0; i < calendar.getExams().size(); i++) {
				if (combobox.getExams().contains(calendar.getExams().get(i))) {
					exam = Integer.parseInt(population.getFittest().getSlotFromGene(calendar.getExams().get(i).getId()),
							2);
					int[] slot = Utils.convertSlotToDate(exam);
					if (tabela[slot[0]][slot[1]] == null) {
						tabela[slot[0]][slot[1]] = calendar.getExams().get(i).getName();
					} else {
						tabela[slot[0]][slot[1]] += "/" + calendar.getExams().get(i).getName();
					}
				}
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

	public void solveAlgoritmo() {
		Chromosome elitist = new Chromosome(this.n_days, this.calendar.getNumberOfExams(), this.calendar, false);
		elitist.setChromosome(this.population.getFittest().getChromosome());
		elitist.calculateStrength();
		Population new_population = new Population(n_pop, calendar.getNumberOfExams(), n_days, this.calendar, false);
		for (Chromosome c : population.getPopulation()) {
			new_population.addChromosome(c);
		}
		new_population.calculateFittest();
		elitist = new_population.getFittest();
		new_population.cleanPopulation();
		crossover(new_population, elitist);
		new_population.calculateFittest();
		mutate(new_population);
		for (Chromosome c : new_population.getPopulation()) {
			this.population.addChromosome(c);
		}
		population.calculateFittest();
	}

	public void solveAlgoritmo100() {
		int x = this.iteration;
		while (x > 0) {

			Chromosome elitist = new Chromosome(this.n_days, this.calendar.getNumberOfExams(), this.calendar, false);
			elitist.setChromosome(this.population.getFittest().getChromosome());
			elitist.calculateStrength();
			Population new_population = new Population(n_pop, calendar.getNumberOfExams(), n_days, this.calendar,
					false);
			for (Chromosome c : population.getPopulation()) {
				new_population.addChromosome(c);
			}
			new_population.calculateFittest();
			elitist = new_population.getFittest();
			new_population.cleanPopulation();
			crossover(new_population, elitist);
			new_population.calculateFittest();
			mutate(new_population);
			for (Chromosome c : new_population.getPopulation()) {
				this.population.addChromosome(c);
			}
			population.calculateFittest();
			x--;
		}
	}

	/**
	 * Acrescenta à população um individuo resultante do cruzamento entre o
	 * Elitista e um outro Indivíduo;
	 * 
	 * @param pop
	 *            - Population
	 * @param elitist
	 *            - Elitist
	 */
	public void crossover(Population pop, Chromosome elitist) {
		int n_exams = calendar.getNumberOfExams();
		for (int i = 0; i < this.n_pop; i++) {
			Chromosome c = elitist;
			// Gera um número entre 0 e 1 e se for superior ao valor mínimo
			// estipulado executa-se o cruzamento
			if (Math.random() > this.crossover) {
				Chromosome new_chromosome = new Chromosome(this.n_days, n_exams, this.calendar, true);
				Chromosome c2 = getCrossoverParent(c);
				// Posição aleatório que determina o ponto do cruzameto
				int breakIndex = (int) (Math.random() * n_exams);
				for (int j = 0; j < n_exams; j++) {
					// (À esquerda do posição gerada é elitista e à direita será
					// genes do outro pai)
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

	/**
	 * Retorna o Pai que vai cruzar com o Elitista;
	 * 
	 * @param c
	 *            - Elitist
	 * @return 2nd Parent
	 */
	public Chromosome getCrossoverParent(Chromosome c) {
		ArrayList<Chromosome> chromosomes = population.getPopulation();

		// Gere um número entre 0 e a Força do Elitista;
		double rouletta = Math.random() * population.getFittest().getCurrentStrength();
		Collections.shuffle(chromosomes);
		for (int i = 0; i < chromosomes.size(); i++) {
			// O primeiro com Força superior ao número gerado será o pai, exceto
			// o próprio elitista
			if (chromosomes.get(i).getCurrentStrength() >= rouletta && chromosomes.get(i) != c) {
				return chromosomes.get(i);
			}
		}
		return c;
	}

	/**
	 * Da população de indivíduos cruzamentos executa mutações em certos genes
	 * 
	 * @param pop
	 *            - População dos individuos cruzados
	 */
	public void mutate(Population pop) {
		int pop_size = pop.getPopulation().size();
		Population new_population = new Population(n_pop, calendar.getNumberOfExams(), n_days, this.calendar, false);
		int n_exams = calendar.getNumberOfExams();
		int block_size = Utils.getBlocksSize(n_days);

		for (int i = 0; i < pop_size; i++) {
			Chromosome c = pop.getPopulation().get(i);
			// Gera um número entre 0 e 1 e se for superior ao valor mínimo
			// estipulado executa-se a mutação
			if (Math.random() > this.mutation) {
				Chromosome new_chromosome = new Chromosome(this.n_days, n_exams, this.calendar, true);
				for (int j = 0; j < n_exams; j++) {
					// Caso seja permitida a mutação haverá 50% de probabilidade
					// de haver mutação em cada Gene
					if (Math.random() > 0.5) {
						new_chromosome.setGeneInPosition(j, c.getGeneByPosition(j));
					} else {
						Gene y = new Gene(block_size, n_days);
						Integer[] new_gene = new Integer[block_size];
						// Inverte os valores do bloco (p.ex 1001->0110)
						for (int k = 0; k < block_size; k++) {
							new_gene[k] = 1 - c.getGeneByPosition(j).getGene()[k];
						}
						y.setGene(new_gene);
						// Com a mutação pode ser gerados Genes com valores não
						// permitidos, se não for válido cancela-se a mutação
						if (!y.validateGene()) {
							y = c.getGeneByPosition(j);
						}
						new_chromosome.setGeneInPosition(j, y);
					}
				}
				new_chromosome.calculateStrength();
				new_population.addChromosome(new_chromosome);
			} else {
				new_population.addChromosome(c);
			}
		}
		pop.setPopulation(new_population.getPopulation());
	}

}
