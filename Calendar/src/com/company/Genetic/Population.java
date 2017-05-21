package com.company.Genetic;

import java.util.ArrayList;

import Domain.Calendar;
import Utils.Utils;

public class Population {
	ArrayList<Chromosome> population;
	int n_exams;
	int n_days;
	Chromosome fittest;
	Calendar cal;
	boolean bool;

	
	public Population(int populationSize, int n_exams ,int n_days, Calendar cal, boolean bool){
		this.bool=bool;
        this.cal = cal;
		this.population = new ArrayList<Chromosome>();
        this.fittest = new Chromosome(n_days, n_exams, cal, false);
        if(bool){
        initiatePopulation(populationSize, n_days, n_exams);
        }
    }
	
	 public void initiatePopulation(int p_size, int n_days, int n_exams){
	        for (int i = 0; i < p_size; i++) {
	            population.add(new Chromosome(n_days, n_exams, cal, true));
	        }
	    }

	public ArrayList<Chromosome> getPopulation() {
		return population;
	}

	public void setPopulation(ArrayList<Chromosome> population) {
		this.population = population;
	}
	
	public void calculateFittest(){
		for (Chromosome c : population){
			if(c.getCurrentStrength() > fittest.getCurrentStrength()){
				this.fittest = c;
			}
		}
	}
	
	public Chromosome getFittest(){
		return this.fittest;
	}
	
	public void addChromosome (Chromosome c){
		this.population.add(c);
	}
	
	public void cleanPopulation (){
		this.population.clear();
	}
	
	 public String toString(){
	    	StringBuilder sb = new StringBuilder();
	    	
			for(int i = 0; i < population.size() - 1; i++){
				sb.append(population.get(i).toString());
				sb.append(",");
			}
			sb.append(population.get(population.size() - 1));
	    	
	    	return sb.toString();
	    }
	
}
