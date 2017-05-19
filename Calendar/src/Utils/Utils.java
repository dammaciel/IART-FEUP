package Utils;

/**
 * Created by danma on 12/05/2017.
 */
public class Utils {

    public static int getBlocksSize(int days){
        int n_slots = (days*3); //cada dia tem 3 slots
        return  Integer.toString((n_slots),2).length();
    }
    
    public static int[] convertSlotToDate(int d){
    	int[] slot = new int[2];
    	slot[0] = (d%3);
    	slot[1] = (d/3)+1;
    	return slot;
    }
}
