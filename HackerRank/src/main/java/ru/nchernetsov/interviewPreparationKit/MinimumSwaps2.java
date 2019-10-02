package ru.nchernetsov.interviewPreparationKit;

import java.util.Map;
import java.util.TreeMap;

public class MinimumSwaps2 {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int len = arr.length;
        Map<Integer, Integer> elemIndex = new TreeMap<>();
        Map<Integer, Integer> indexElem = new TreeMap<>();
        boolean[] checked = new boolean[len];
        for (int index = 0; index < arr.length; index++) {
            int elem = arr[index];
            elemIndex.put(elem, index);
            indexElem.put(index, elem);
        }
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : elemIndex.entrySet()) {
            Integer elem = entry.getKey();
            Integer index = entry.getValue();
            if (checked[elem - 1] || index == elem - 1) {
                continue;
            }
            /*
             Основная идея здесь такая: например, первое число в массиве 7. Оно должно стоять на позиции 6. Но на
             этом месте стоит 4. 4 должно быть на позиции 3. Но на этом месте стоит 1. 1 должно быть на позиции 1.
             Но на этом месте 7. Таким образом, мы обнаружили цикл (7 -> 4 -> 1 -> 7). Для упорядочивания цикла нужно
             сделать n - 1 перестановок в нём, где n - длина цикла. Мы находим все такие циклы и суммируем количества
             перестановок в них
             */
            int cycleLen = 0;
            Integer nextElem = indexElem.get(elem - 1);
            while (!checked[nextElem - 1]) {
                checked[nextElem - 1] = true;
                nextElem = indexElem.get(nextElem - 1);
                cycleLen++;
            }
            result += (cycleLen - 1);
        }
        return result;
    }
}
