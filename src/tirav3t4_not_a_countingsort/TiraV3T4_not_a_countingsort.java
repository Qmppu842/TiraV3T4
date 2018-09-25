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
        radixSort(clearlyMonaLisa);
        long sunDies = System.nanoTime();
        Arrays.sort(fakeMonaLisa);
        long heatDeathOfUniverse = System.nanoTime();
        
        long timeToCompleteExams = sunDies - bigBang;
        long timeToFindJob = heatDeathOfUniverse - sunDies;
        
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
        
        if (size <= 25) {
            System.out.println("MonaLisa: ");
            System.out.println(Arrays.toString(monaLisa));
            System.out.println();
            System.out.println("End result radix: ");
            System.out.println(Arrays.toString(clearlyMonaLisa));
            System.out.println("End result Arrays.sort: ");
            System.out.println(Arrays.toString(fakeMonaLisa));
        }
        System.out.println();
        System.out.println("Lo(n)g time ago: ");
        System.out.println("Radix: " + timeToCompleteExams);
        System.out.println("Radix: " + timeToCompleteExams /1000000 + "ms");
        System.out.println();
        System.out.println("Arrays.sort: " + timeToFindJob);        
        System.out.println("Arrays.sort: " + timeToFindJob / 1000000 + "ms");
        System.out.println();
        
    }
    
    private static void radixSort(int[] painting){
    
    }
    

}
