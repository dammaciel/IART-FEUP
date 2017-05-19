package com.company;

import java.util.Arrays;

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
    int n_days;
    Calendar calendar;
    Population population;
    double strength;

    public GeneticAlgorithm(){
        this.mutation=0.5;
        this.crossover=0.3;
        this.elitist=0.15;
        this.n_days=10;
    }

    public GeneticAlgorithm(double mutation, double crossover, double elitist, int days){
        this.mutation=mutation;
        this.crossover=crossover;
        this.elitist=elitist;
        this.n_days=days;
    }

    public void autofillCalendar(){
        Exam e1 = new Exam(0,"IART",3);
        Exam e2 = new Exam(1,"SDIS",3);
        Exam e3 = new Exam(2,"MEST",1);
        Exam e4 = new Exam(3,"ASSO",4);
        Exam e5 = new Exam(4,"CMAT",1);
        Exam e6 = new Exam(5,"IOPE",4);
        Exam e7 = new Exam(6,"ERSS",4);
        Exam e8 = new Exam(7,"LGP",4);

        Student s1 = new Student(0, "Daniel Maciel", 4);
        Student s2 = new Student(1, "Pedro Teles", 4);
        Student s3 = new Student(2, "Maria Duarte", 4);
        Student s4 = new Student(3, "Rafael Medeiros", 3);

        calendar = new Calendar(this.n_days);

        s1.addExame(e1);s1.addExame(e2);s1.addExame(e3);s1.addExame(e4);s1.addExame(e5);s1.addExame(e6);
        s2.addExame(e1);s2.addExame(e5);s2.addExame(e6);s2.addExame(e7);s2.addExame(e8);
        s3.addExame(e4);s3.addExame(e6);s3.addExame(e7);s3.addExame(e8);
        s4.addExame(e1);s4.addExame(e2);s4.addExame(e3);s4.addExame(e5);

        e1.addStudent(s1);e1.addStudent(s2);e1.addStudent(s4);
        e2.addStudent(s1);e2.addStudent(s4);
        e3.addStudent(s1);e3.addStudent(s4);
        e4.addStudent(s1);e4.addStudent(s1);
        e5.addStudent(s1);e5.addStudent(s2);e5.addStudent(s4);
        e6.addStudent(s1);e6.addStudent(s2);e6.addStudent(s3);
        e7.addStudent(s2);e7.addStudent(s3);
        e8.addStudent(s2);e8.addStudent(s3);

        calendar.addExam(e1);calendar.addExam(e2);calendar.addExam(e3);calendar.addExam(e4);calendar.addExam(e5);calendar.addExam(e6);
        calendar.addExam(e7);calendar.addExam(e8);
        
        calendar.addStudent(s1);calendar.addStudent(s2);calendar.addStudent(s3);calendar.addStudent(s4);
        start();
}

    public void start(){
        int blockSize = Utils.getBlocksSize(n_days);
        population = new Population(calendar.getNumberOfExams() , blockSize, n_days);
        checkCalendarStrength();

    }

    public void checkCalendarStrength(){
        double strength = 0;
        int overlapFlag=1; //flag=0 se houver exames sobrepostos
        for(int i = 0;  i< calendar.getStudents().size();i++){
           double space= calculateSpaceBetweenExams(calendar.getStudents().get(i));
           if(space==-1){
        	   overlapFlag=0;
           }
           double examsInDay = calendar.getStudents().get(i).calculateExamsInDay();
           strength+= space*examsInDay;
        }
        strength=(strength/calendar.getStudents().size())*overlapFlag;
        System.out.println("Força do Calendário: "+strength);
        population.setCurrentStrength(strength);
    }

    public double calculateSpaceBetweenExams(Student s){
        Integer[] slots = new Integer[s.getExams().size()];
        for (int i =0; i< s.getExams().size(); i++){
           slots[i]=Integer.parseInt(population.getSlotFromChromosome(s.getExams().get(i).getId()),2);
        }
        Arrays.sort(slots);
        
        System.out.println("SOU O ESTUDANTE: "+ s.getName());
        for (int i =0; i< s.getExams().size(); i++){
        	System.out.println(slots[i]);
         }
        
        int x=0;
        for (int i =0; i< slots.length-1; i++){
        	if((slots[i+1]-slots[i])>0){
        		x+=(slots[i+1]-slots[i]);
        	}else{
        		System.out.println("Exames Sobrepostos!!");
                System.out.println(" ");
        		return -1;
        	}
        		
        }
        
        System.out.println("Média: " + x/slots.length );
        System.out.println(" ");
        return x/slots.length;
    }
    
    public Object [][] getTab(){
        Object [][] tabela = new Object[3][n_days+1];
        tabela[0][0]="09h00";
        tabela[1][0]="14h00";
        tabela[2][0]="18h00";
        int exam;
        for(int i = 0; i<calendar.getExams().size();i++){
        	exam=Integer.parseInt(population.getSlotFromChromosome(calendar.getExams().get(i).getId()),2);
        	int[] slot=Utils.convertSlotToDate(exam);
        	if(tabela[slot[0]][slot[1]]==null){
        		tabela[slot[0]][slot[1]]= calendar.getExams().get(i).getName();
        	}else{
        		tabela[slot[0]][slot[1]]+="/" + calendar.getExams().get(i).getName();
        	}
        }	
        return tabela;
    }
    
    public String[] getHeaders(){
        String[] novo = new String[n_days+1];
        for(int i=0;i<novo.length;i++){
            if(i==0){novo[i]="Hora";}
            else{novo[i]="Dia "+i;}
        }
        return novo;
    }

}
