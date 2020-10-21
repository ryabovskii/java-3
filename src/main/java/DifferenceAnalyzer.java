import java.util.ArrayList;
import java.util.LinkedList;

public class DifferenceAnalyzer {

    private ArrayList<Integer> arrayList;

    /**
      * 0 - add   1 - get   2 - remove
      */
    private long[] arrayListTime;

    private LinkedList<Integer> linkedList;
    private long[] linkedListTime;

    private int numberTimes;


    public DifferenceAnalyzer() {
        this.arrayList = new ArrayList<>();
        this.arrayListTime = new long[3];
        this.linkedList = new LinkedList<>();
        this.linkedListTime = new long[3];
    }


    public void analyze(int numberTime) {
        this.numberTimes = numberTime;
        analyzeAdd();
        analyzeGet();
        analyzeRemove();
    }

    private void analyzeRemove() {
        long start;
        long finish;

        start = System.currentTimeMillis();
        for (int i = 0; i < this.numberTimes; i++) {
            this.arrayList.remove(0);
        }
        finish = System.currentTimeMillis();
        this.arrayListTime[2] = finish - start;

        start = System.currentTimeMillis();
        for (int i = 0; i < this.numberTimes; i++) {
            this.linkedList.remove(0);
        }
        finish = System.currentTimeMillis();
        this.linkedListTime[2] = finish - start;
    }

    private void analyzeGet() {
        long start;
        long finish;

        start = System.currentTimeMillis();
        for (int i = 0; i < this.numberTimes; i++) {
            this.arrayList.get(i);
        }
        finish = System.currentTimeMillis();
        this.arrayListTime[1] = finish - start;

        start = System.currentTimeMillis();
        for (int i = 0; i < this.numberTimes; i++) {
            this.linkedList.get(i);
        }
        finish = System.currentTimeMillis();
        this.linkedListTime[1] = finish - start;
    }

    private void analyzeAdd() {
        long start;
        long finish;

        start = System.currentTimeMillis();
        for (int i = 0; i < this.numberTimes; i++) {
            this.arrayList.add(i);
        }
        finish = System.currentTimeMillis();
        this.arrayListTime[0] = finish - start;

        start = System.currentTimeMillis();
        for (int i = 0; i < this.numberTimes; i++) {
            this.linkedList.add(i);
        }
        finish = System.currentTimeMillis();
        this.linkedListTime[0] = finish - start;
    }

    public void printResult() {
        System.out.println("\nNumber of times = " + numberTimes + "    Result:");
        System.out.println("            .add  .get  .remove");
        System.out.println(" ArrayList:  " + arrayListTime[0] + "ms  " + arrayListTime[1] + "ms    " + arrayListTime[2] + "ms");
        System.out.println(" LinkedList: " + linkedListTime[0] + "ms  " + linkedListTime[1] + "ms  " + linkedListTime[2] + "ms");
    }
}
