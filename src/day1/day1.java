package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class day1 {
    public static void main(String[] args) {
        List<String> caloriesList = getListInput("resources/day1.txt");

        ArrayList<Integer> sumCaloriesList = getSumCaloriesList(caloriesList);

        int maxCalories = Collections.max(sumCaloriesList);
        System.out.println(maxCalories);

        Collections.sort(sumCaloriesList);
        Collections.reverse(sumCaloriesList);
        int sumTopThree = 0;
        for (int i = 0; i < 3; i++) {
            sumTopThree += sumCaloriesList.get(i);
        }
        System.out.println(sumTopThree);
    }

    private static ArrayList<Integer> getSumCaloriesList(List<String> caloriesList) {
        int currentCalories = 0;
        ArrayList<Integer> sumCaloriesList = new ArrayList<>();
        for (String calories : caloriesList) {
            if (calories.equals("")) {
                sumCaloriesList.add(currentCalories);
                currentCalories = 0;
            } else {
                currentCalories += Integer.parseInt(calories);
            }
        }
        return sumCaloriesList;
    }

    private static List<String> getListInput(String filePath) {
        ArrayList<String> inputList = new ArrayList<>();
        File file = new File(filePath);
        try (Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()) {
                inputList.add(scanner.nextLine());
            }
            return inputList;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
