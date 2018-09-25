package tirav3t4_not_a_countingsort;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Qmppu842
 */
public class TiraV3T4_not_a_countingsort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // init test data
        int size = 10;
        int offsetOfValues = 1;
        int valuesMax = 10;
        int[] monaLisa = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            monaLisa[i] = rand.nextInt(valuesMax) + offsetOfValues;
        }

        int[] clearlyMonaLisa = monaLisa.clone();
        int[] fakeMonaLisa = monaLisa.clone();
        
        
        // Do the dinosaur
        
        
        long bigBang = System.nanoTime();
        
        long sunDies = System.nanoTime();
        Arrays.sort(fakeMonaLisa);
        long heatDeathOfUniverse = System.nanoTime();
        
        // Validate tables
        boolean museumCurator = true;
        
        for (int i = 0; i < size; i++) {
            if (clearlyMonaLisa[i] != fakeMonaLisa[i]) {
                museumCurator = false;
                break;
            }
        }
        
        if (museumCurator) {
            System.out.println("No problems. These both are clearly original Mona Lisa paintings.");
            System.out.println("\033[32;1m"+"Wait a minute..." + "\033[0m");
        }else{
            System.out.println("This is forgery! " +"\033[34;1m" + "POLICE!!!" + "\033[0m");
        
        }
    }
    
    
    

}
