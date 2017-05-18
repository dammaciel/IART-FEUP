package com.company;

/**
 * Created by danma on 12/05/2017.
 */
public class Population {
    private ArrayList<Chromosome> chromosomes;
    private int currentStrength;

    public Population(int populationSize, int cromossomeLength){
        this.chromosomes = new ArrayList<Chromosome>();
        this.currentStrength = -1;
        initiatePopulation(this.populationSize, cromossomeLength);
    }

    public void initiatePopulation(int p_size, int c_length){
        for (int i = 0; i < p_size; i++) {
            chromosomes.add(new Chromosome(c_length));
        }
    }

    public int getCurrentStrength() {
        return currentStrength;
    }

    public void setCurrentStrength(int currentStrength) {
        this.currentStrength = currentStrength;
    }

    public ArrayList<Chromosome> getChromosomes() {
        return chromosomes;
    }

    public void setChromosomes(ArrayList<Chromosome> chromosomes) {
        this.chromosomes = chromosomes;
    }

    public int getSlotFromChromosome (int id_exame){
        chromosomes.get(id_exame);
    }
}
