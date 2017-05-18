package Utils;

/**
 * Created by danma on 12/05/2017.
 */
public class Utils {

    public static int getBlocksSize(int days){
        int n_slots = days*3; //cada dia tem 3 slots
        return  Integer.toString(n_slots,2).length();
    }    
}
