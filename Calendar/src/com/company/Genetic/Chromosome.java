package com.company.Genetic;

/**
 * Created by danma on 12/05/2017.
 */
public class Chromosome {
    private Integer[] chromosome;

    public Chromosome(int size, int n_days){
        this.chromosome = new Integer[size];
        initiateChromosome(n_days);
    }

    public void initiateChromosome(int n_days){
        for (int i = 0; i < chromosome.length; i++) {
            if(Math.random() < 0.5){
                this.chromosome[i]=1;
            }else{
                this.chromosome[i]=0;
            }
        }
        String x = translateSlot();
        if(Integer.parseInt(x)>=Integer.parseInt(Integer.toString((n_days*3),2))){
        	initiateChromosome(n_days);
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
    public int getGeneByPosition(int i){
    	return this.chromosome[i];
    }
    
    public void setGeneInPosition(int i, int gene){
    	this.chromosome[i]=gene;
    }
}
