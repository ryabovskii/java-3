import java.util.List;

/**
 * Класс который анализирует различные List на быстродействие
 * @autor Дмитрий Рябовский
 * @version 1.0
 */
public class ListAnalyzer {

    /** Поле листа */
    private List<Integer> list;

    /**
     * Массив результатов прогонов (в милисекундах)
     * testTime[0] - результат add
     * testTime[1] - результат get
     * testTime[2] - результат remove
     */
    private long[] testTime;

    /** Количество итераций для тестов */
    private int numberTimes;

    /**
     * Основная функция, вызывающая все тесты по отдельности
     * задает значение {@link ListAnalyzer#list}
     * задает значение {@link ListAnalyzer#testTime}
     * задает значение {@link ListAnalyzer#numberTimes}
     * Вызывает функцию {@link ListAnalyzer#analyzeAdd()}
     * Вызывает функцию {@link ListAnalyzer#analyzeRemove()}
     * Вызывает функцию {@link ListAnalyzer#analyzeGet()}
     * @param numberTime  - количество итераций
     * @param list  - экземпляр List
     * @return {@link ListAnalyzer#testTime}
     */
    public long[] analyze(int numberTime, List<Integer> list) {
        this.list = list;
        this.testTime = new long[3];
        this.numberTimes = numberTime;
        analyzeAdd();
        analyzeGet();
        analyzeRemove();
        return this.testTime;
    }

    /**
     * Функция - тест List.remove
     * записывает значение в {@link ListAnalyzer#numberTimes}
     */
    private void analyzeRemove() {
        long start;
        long finish;
        start = System.currentTimeMillis();
        for (int i = 0; i < this.numberTimes; i++) {
            this.list.remove(0);
        }
        finish = System.currentTimeMillis();
        this.testTime[2] = finish - start;
    }

    /**
     * Функция - тест List.get
     * записывает значение в {@link ListAnalyzer#numberTimes}
     */
    private void analyzeGet() {
        long start;
        long finish;
        start = System.currentTimeMillis();
        for (int i = 0; i < this.numberTimes; i++) {
            this.list.get(i);
        }
        finish = System.currentTimeMillis();
        this.testTime[1] = finish - start;
    }

    /**
     * Функция - тест List.add
     * записывает значение в {@link ListAnalyzer#numberTimes}
     */
    private void analyzeAdd() {
        long start;
        long finish;
        start = System.currentTimeMillis();
        for (int i = 0; i < this.numberTimes; i++) {
            this.list.add(i);
        }
        finish = System.currentTimeMillis();
        this.testTime[0] = finish - start;
    }

    /**
     * Функция печатает результаты {@link ListAnalyzer#analyze(int, List)}
     * @param result <=> {@link ListAnalyzer#numberTimes}
     * @throws IllegalArgumentException Illegal long[] result
     */
    public void printResult(long[] result) {
        if (result.length < 3)
            throw new IllegalArgumentException(
                    "Illegal long[] result, result.length = " + result.length
            );
        System.out.println(
                "   .add :  " + result[0] + "ms" +
                "\n   .get :  " + result[1] + "ms" +
                "\n.remove :  " + result[2] + "ms");
    }
}
