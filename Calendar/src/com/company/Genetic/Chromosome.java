package com.company.Genetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import Domain.Calendar;
import Domain.Student;

import java.lang.Object;

import Utils.Utils;

public class Chromosome {
	private ArrayList<Gene> chromosome;
	private double currentStrength;
	private int n_genes;
	private Calendar cal;

	public Chromosome(int n_days, int n_exams, Calendar cal, boolean bool) {
		this.cal = cal;
		this.n_genes = n_exams;
		this.chromosome = new ArrayList<Gene>();
		this.currentStrength = -1;
		if (bool) {
			initiateChromosome(Utils.getBlocksSize(n_days), n_days);
		}
	}

	public void initiateChromosome(int c_length, int n_days) {
		for (int i = 0; i < n_genes; i++) {
			chromosome.add(new Gene(c_length, n_days));
		}

	}

	public double getCurrentStrength() {
		return currentStrength;
	}

	public void setCurrentStrength(double currentStrength) {
		this.currentStrength = currentStrength;
	}

	public ArrayList<Gene> getChromosome() {
		return chromosome;
	}

	public void setGenes(ArrayList<Chromosome> chromosomes) {
		this.chromosome = chromosome;
	}

	public String getSlotFromGene(int id_exame) {
		return chromosome.get(id_exame).translateSlot();
	}

	public Gene getGeneByPosition(int index) {
		return chromosome.get(index);
	}

	public void setGeneInPosition(int i, Gene gene) {
		this.chromosome.set(i, gene);
	}

	public void addGene(Gene c) {
		this.chromosome.add(c);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < chromosome.size() - 1; i++) {
			sb.append(chromosome.get(i).toString());
		}
		sb.append(chromosome.get(chromosome.size() - 1));

		return sb.toString();
	}

	/**
	 * Calcula a Força do Indivíduo
	 */
	public void calculateStrength() {
		double strength = getCurrentStrength(); // default=-1
		// flag=0 se houver exames sobrepostos
		int overlapFlag = 1;
		for (int i = 0; i < cal.getStudents().size(); i++) {
			double space = calculateSpaceBetweenExams(cal.getStudents().get(i));
			if (space == -1) {
				overlapFlag = 0;
			}
			// Percentagem de exames que o aluno tem que são do seu ano corrente
			double examsInDay = cal.getStudents().get(i).calculateExamsInDay();
			// Somatório do espaço entre exames de cada Aluno tendo em conta
			// desvalorizações
			strength += space * examsInDay;
		}
		// Força total do Indivíduo, caso haja algum aluno com exames
		// sobrepostos a força será automaticamente 0.
		strength = (strength / cal.getStudents().size()) * overlapFlag;
		setCurrentStrength(strength);
	}

	/**
	 * Calcula espaçamento entre exames do Aluno S
	 * 
	 * @param s - Student
	 * @return Space Average
	 */
	private double calculateSpaceBetweenExams(Student s) {
		Integer[] slots = new Integer[s.getExams().size()];
		for (int i = 0; i < s.getExams().size(); i++) {
			// Guarda a posição do Exame i no Calendário
			slots[i] = Integer.parseInt(getSlotFromGene(s.getExams().get(i).getId()), 2);
		}
		// Ordena os slots para calcular espaçamento entre os exames mais
		// próximos
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

	public void setChromosome(ArrayList<Gene> chromosome) {
		this.chromosome = chromosome;
	}

}
