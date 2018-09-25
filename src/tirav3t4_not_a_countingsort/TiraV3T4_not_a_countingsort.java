package tirav3t4_not_a_countingsort;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Qmppu842
 */
public class TiraV3T4_not_a_countingsort {

    public static int size = 1000000;
    public static int offsetOfValues = 1;
    public static int valuesMax = 1000000;
    public static int testThisManyTimes = 1000;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // init test data
        int[] monaLisa = generateData();

        int[] clearlyMonaLisa = monaLisa.clone();
        int[] fakeMonaLisa = monaLisa.clone();
        int[] presistenceOfMemory = monaLisa.clone();

        // Do the dinosaur      
        long bigBang = System.nanoTime();
        quickSort(clearlyMonaLisa, 0, size-1);
        long sunDies = System.nanoTime();
        Arrays.sort(fakeMonaLisa);
        long heatDeathOfUniverse = System.nanoTime();
        countingSort(presistenceOfMemory);
        long dinosaursReborn = System.nanoTime();

        /**
         * Quick sort
         */
        long timeToCompleteExams = sunDies - bigBang;
        /**
         * Arrays.sort sort
         */
        long timeToFindJob = heatDeathOfUniverse - sunDies;
        /**
         * Counting sort
         */
        long timeToCountingSort = dinosaursReborn - heatDeathOfUniverse;

        // Validate tables
        boolean museumCurator = true;

        for (int i = 0; i < size; i++) {
            if (clearlyMonaLisa[i] != fakeMonaLisa[i] || presistenceOfMemory[i] != fakeMonaLisa[i]) {
                museumCurator = false;
                break;
            }
        }

        if (museumCurator) {
            System.out.println("No problems. These both are clearly original Mona Lisa paintings.");
            System.out.println("\033[31;1m" + "Wait a minute..." + "\033[0m");
        } else {
            System.out.println("This is forgery! " + "\033[34;1m" + "POLICE!!!" + "\033[0m");

        }

        if (size <= 25) {
            System.out.println("MonaLisa: ");
            System.out.println(Arrays.toString(monaLisa));
            System.out.println();
            System.out.println("End result Quick: ");
            System.out.println(Arrays.toString(clearlyMonaLisa));
            System.out.println("End result Arrays.sort: ");
            System.out.println(Arrays.toString(fakeMonaLisa));
            System.out.println("End result Counting sort: ");
            System.out.println(Arrays.toString(presistenceOfMemory));
            System.out.println("_____________________________");
        }
        System.out.println();
        System.out.println("Lo(n)g time ago: ");
        System.out.println("Quick: " + timeToCompleteExams);
        System.out.println("Quick: " + timeToCompleteExams / 1000000 + "ms");
        System.out.println();
        System.out.println("Counting: " + timeToCountingSort);
        System.out.println("Counting: " + timeToCountingSort / 1000000 + "ms");
        System.out.println();
        System.out.println("Arrays.sort: " + timeToFindJob);
        System.out.println("Arrays.sort: " + timeToFindJob / 1000000 + "ms");
        System.out.println();

        System.out.println("_____________________________");
        avg();

    }

    private static void quickSort(int[] painting, int left, int right) {
        int index = divideEtImpera(painting, left, right);
        if (left < index - 1) {
            quickSort(painting, left, index - 1);
        }
        if (index < right) {
            quickSort(painting, index, right);
        }
    }

    private static int divideEtImpera(int[] painting, int left, int right) {
        int i = left;
        int j = right;
        int swapper;
        int pivot = painting[(left + right) / 2];
        while (i <= j) {
            while (painting[i] < pivot) {
                i++;
            }
            while (painting[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swapper = painting[i];
                painting[i] = painting[j];
                painting[j] = swapper;
                i++;
                j--;
            }
        }
        return i;
    }

    /**
     * Knowing range of values it bit cheating. But Counting sort is still my
     * favorite mind == blown sorting algorithm.
     *
     * @param presistenceOfMemory
     */
    private static void countingSort(int[] presistenceOfMemory) {
        int[] counts = new int[valuesMax - offsetOfValues + 1];
        for (int i = 0; i < presistenceOfMemory.length; i++) {
            int curr = presistenceOfMemory[i];
            counts[curr - offsetOfValues] += 1;
        }
        int indexCounter = 0;
        eka:
        for (int i = 0; i < counts.length; i++) {
            int curr = counts[i];
            for (int j = 0; j < curr; j++) {
                presistenceOfMemory[indexCounter] = i + offsetOfValues;
                indexCounter++;
                if (indexCounter > size) {
                    break eka;
                }
            }
        }
    }

    private static void avg() {
        long countingTime = 0;
        long quickTime = 0;
        long arraySort = 0;

        for (int i = 0; i < testThisManyTimes; i++) {
            int[] data = generateData();
            int[] asd = data.clone();
            int[] zxc = data.clone();
            int[] qwe = data.clone();
            long eka = System.nanoTime();
            countingSort(asd);
            long toka = System.nanoTime();
            quickSort(zxc, 0 , zxc.length-1);
            long kolmas = System.nanoTime();
            Arrays.sort(qwe);
            long nelos = System.nanoTime();
            countingTime += toka - eka;
            quickTime += kolmas - toka;
            arraySort += nelos - kolmas;
        }
        long countingAvg = countingTime / testThisManyTimes;
        long quickAvg = quickTime / testThisManyTimes;
        long arraysAvg = arraySort / testThisManyTimes;
        System.out.println("\033[31;1m" + "Avarage results: " + "\033[0m");
        System.out.println("Counting avg time: " + countingAvg);
        System.out.println("Counting avg time in ms: " + countingAvg / 1000000);
        System.out.println("Quick avg time: " + quickAvg);
        System.out.println("Quick avg time in ms: " + quickAvg / 1000000);
        System.out.println("Arrays avg time: " + arraysAvg);
        System.out.println("Arrays avg time in ms: " + arraysAvg / 1000000);

    }

    private static int[] generateData() {
        int[] monaLisa = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            monaLisa[i] = rand.nextInt(valuesMax) + offsetOfValues;
        }
        return monaLisa;
    }

}
