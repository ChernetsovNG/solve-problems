package ru.nchernetsov.type_bounds_3_78;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CalorieGrader {

    public static void main(String[] args) {
        CalorieGrader grader = new CalorieGrader();
        List<Cake> cakes = Arrays.asList(new Cake(), new Cake(), new Cake());
        List<Bakery> caloryBakeryCakes = grader.grade(cakes);
    }

    public List grade(List<? extends Calorie> items) {
        return items.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}

interface Calorie extends Comparable<Calorie> {

    int compareTo(Calorie object);

    int getCalories();
}

class Drink implements Calorie {

    @Override
    public int compareTo(Calorie object) {
        return Integer.compare(getCalories(), object.getCalories());
    }

    @Override
    public int getCalories() {
        return 10;
    }
}

class Bakery implements Calorie {

    @Override
    public int compareTo(Calorie object) {
        return Integer.compare(getCalories(), object.getCalories());
    }

    @Override
    public int getCalories() {
        return 50;
    }
}

class Cake extends Bakery {
}
