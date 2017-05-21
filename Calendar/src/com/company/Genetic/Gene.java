package com.company.Genetic;

import java.util.Arrays;

public class Gene {
	private Integer[] gene;
	private int n_days;

	public Gene(int size, int n_days) {
		this.n_days = n_days;
		this.gene = new Integer[size];
		initiateGene(n_days);
	}

	public void initiateGene(int n_days) {
		this.n_days = n_days;
		for (int i = 0; i < gene.length; i++) {
			if (Math.random() < 0.5) {
				this.gene[i] = 1;
			} else {
				this.gene[i] = 0;
			}
		}
		if (!validateGene()) {
			initiateGene(n_days);
		}

	}

	public Integer[] getGene() {
		return gene;
	}

	public boolean validateGene() {
		String x = translateSlot();
		if (Integer.parseInt(x) >= Integer.parseInt(Integer.toString((n_days * 3), 2))) {
			return false;
		} else {
			return true;
		}
	}

	public String translateSlot() {
		StringBuilder binary = new StringBuilder();
		for (int digit : gene) {
			binary.append(digit);
		}
		return binary.toString().replace(' ', '0');
	}

	public String toString() {
		StringBuilder strNum = new StringBuilder();

		for (int num : gene) {
			strNum.append(num);
		}
		int finalInt = Integer.parseInt(strNum.toString(),2);
		String sb = finalInt + ";";
		//String sb = (finalInt % 3) + " - " + (finalInt / 3) + " ; ";
		return sb;
	}

	public void setGene(Integer[] gene) {
		this.gene = gene;
	}

}
