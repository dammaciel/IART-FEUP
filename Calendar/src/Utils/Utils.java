package Utils;

/**
 * Created by danma on 12/05/2017.
 */
public class Utils {

    public static int getBlocksSize(int days){
        int n_slots = days*3; //cada dia tem 3 slots
        return  Integer.toString(n_slots,2).length();
    }
    
    public static String convertSlotToDate(int d){
    	int dia;
    	String hora="";
    	dia = (d/3)+1;
    	int x = d%3;
    	if(x==0){hora = "9h00";}else if(x==1){hora="14h00";}else if(x==2){hora="16h00";}
    	return ("Dia: " + dia + " - Hora: "+ hora);
    }
}
