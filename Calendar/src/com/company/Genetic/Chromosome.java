package com.company.Genetic;

/**
 * Created by danma on 12/05/2017.
 */
public class Chromosome {
    private Integer[] chromosome;

    public Chromosome(int size){
        this.chromosome = new Integer[size];
        initiateChromosome();
    }

    public void initiateChromosome(){
        for (int i = 0; i < chromosome.length; i++) {
            if(Math.random() < 0.5){
                this.chromosome[i]=1;
            }else{
                this.chromosome[i]=0;
            }
        }
    }

    public String translateSlot(){
        StringBuilder binary = new StringBuilder();
        for (int digit : chromosome)
        {
            binary.append(digit);
        }
        return binary.toString().replace(' ', '0');
    }
}
