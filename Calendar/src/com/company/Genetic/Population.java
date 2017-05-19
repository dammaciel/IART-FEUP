package com.company.Genetic;

import java.util.ArrayList;

/**
 * Created by danma on 12/05/2017.
 */
public class Population {
    private ArrayList<Chromosome> chromosomes;
    private double currentStrength;

    public Population(int populationSize, int cromossomeLength){
        this.chromosomes = new ArrayList<Chromosome>();
        this.currentStrength = -1;
        initiatePopulation(populationSize, cromossomeLength);
    }

    public void initiatePopulation(int p_size, int c_length){
        for (int i = 0; i < p_size; i++) {
            chromosomes.add(new Chromosome(c_length));
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
}
