package com.company.Genetic;

import java.util.ArrayList;
import Utils.Utils;


/**
 * Created by danma on 12/05/2017.
 */
public class Population {
    private ArrayList<Chromosome> chromosomes;
    private double currentStrength;

    public Population(int populationSize, int n_days){
        this.chromosomes = new ArrayList<Chromosome>();
        this.currentStrength = -1;
        initiatePopulation(populationSize, Utils.getBlocksSize(n_days), n_days);
    }
    
    public Population(){
    	this.chromosomes = new ArrayList<Chromosome>();
        this.currentStrength = -1;
    }

    public void initiatePopulation(int p_size, int c_length, int n_days){
        for (int i = 0; i < p_size; i++) {
            chromosomes.add(new Chromosome(c_length, n_days));
        }
    }

    public double getCurrentStrength() {
        return currentStrength;
    }

    public void setCurrentStrength(double currentStrength) {
        this.currentStrength = currentStrength;
    }

    public ArrayList<Chromosome> getChromosomes() {
        return chromosomes;
    }

    public void setChromosomes(ArrayList<Chromosome> chromosomes) {
        this.chromosomes = chromosomes;
    }

    public String getSlotFromChromosome (int id_exame){
       return chromosomes.get(id_exame).translateSlot();
    }
    
    public Chromosome getChromosomeByPosition(int index){		
		return chromosomes.get(index);
	}
    
    public void addChromosome(Chromosome c){
    	this.chromosomes.add(c);
    }
}
