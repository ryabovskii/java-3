import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        ListAnalyzer analyzer = new ListAnalyzer();
        int numberTimes = 20000;

        System.out.println("\nArrayList results:\n Number of times = " + numberTimes);
        analyzer.printResult(analyzer.analyze(numberTimes, new ArrayList<>()));

        System.out.println("\nLinkedList result:\n Number of times = " + numberTimes);
        analyzer.printResult(analyzer.analyze(numberTimes, new LinkedList<>()));
    }
}
