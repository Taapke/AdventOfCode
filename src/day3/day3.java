package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day3 {
    public static void main(String[] args) {
        List<String> inputList = getListInput("resources/day3.txt");

        int sumBadges = getSumBadges(inputList);
        System.out.println("Sum of badges: " + sumBadges);

        int sumPriorities = getSumPrioritiesBothCompartments(inputList);
        System.out.println("Sum of priorities: " + sumPriorities);
    }

    private static int getSumBadges(List<String> inputList) {
        int sumBadges = 0;
        for (int i = 0; i < inputList.size(); i += 3) {
            for (int j = 0; j < inputList.get(i).length(); j++) {
                char item = inputList.get(i).charAt(j);
                if (inputList.get(i + 1).indexOf(item) != -1 && inputList.get(i + 2).indexOf(item) != -1) {
                    sumBadges += getPriorityScore(item);
                    break;
                }
            }
        }
        return sumBadges;
    }

    private static int getSumPrioritiesBothCompartments(List<String> inputList) {
        int sumPriorities = 0;
        for (String ruckSackItems : inputList) {
            String compOne = ruckSackItems.substring(0, ruckSackItems.length() / 2);
            String compTwo = ruckSackItems.substring(ruckSackItems.length() / 2);
            for (int i = 0; i < compOne.length(); i++) {
                if (compTwo.indexOf(compOne.charAt(i)) != -1) {
                    sumPriorities += getPriorityScore(compOne.charAt(i));
                    break;
                }
            }
        }
        return sumPriorities;
    }

    private static int getPriorityScore(char item) {
        if (Character.isUpperCase(item)) {
            return (int) item - 38;
        } else {
            return (int) item - 96;
        }
    }

    private static List<String> getListInput(String filePath) {
        ArrayList<String> inputList = new ArrayList<>();
        File file = new File(filePath);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                inputList.add(scanner.nextLine());
            }
            return inputList;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
