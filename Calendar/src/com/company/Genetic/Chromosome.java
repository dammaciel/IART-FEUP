package com.company;

/**
 * Created by danma on 12/05/2017.
 */
public class Chromosome {
    private Integer[] chromosome;

    public Chromosome(int size){
        this.chromossome = new Integer[size];
        initiateChromosome();
    }

    public void initiateChromosome(){
        for (int i = 0; i < chromossome.length; i++) {
            if(Math.random() < 0.5){
                this.chromosome[i]=1;
            }else{
                this.chromosome[i]=0;
            }
        }
    }

    publicc int translateSlot(){
        StringBuilder binary = new StringBuilder();
        for (int digit : chromosome)
        {
            binary.append(digit);
        }
        return Integer.parseInt(binary.toString());
    }
}
