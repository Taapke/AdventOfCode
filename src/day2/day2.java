package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class day2 {
    public static void main(String[] args) {
        List<String> inputList = getListInput("resources/day2.txt");

        System.out.println("Total score strategy One: " + calculateStrategyOne(inputList));
        System.out.println("Total score strategy Two: " + calculateStrategyTwo(inputList));
    }

    private static int calculateStrategyTwo(List<String> inputList) {
        List<Character> opponentMoves = Arrays.asList('A', 'B', 'C');
        List<Character> outcomes = Arrays.asList('X', 'Y', 'Z');
        int totalScore = 0;
        for (String round : inputList) {
            int opponentIndex = opponentMoves.indexOf(round.charAt(0));

            if (round.charAt(2) == 'Y') {
                totalScore += 3;
                totalScore += opponentIndex + 1;
            }
            else if (round.charAt(2) == 'X') {
                if (opponentIndex == 0) {
                    totalScore += 3;
                } else {
                    totalScore += opponentIndex;
                }
            } else {
                totalScore += 6;
                if (opponentIndex == 2) {
                    totalScore += 1;
                } else {
                    totalScore += opponentIndex + 2;
                }
            }
        }
        return totalScore;
    }

    private static int calculateStrategyOne(List<String> inputList) {
        List<Character> opponentMoves = Arrays.asList('A', 'B', 'C');
        List<Character> playerMoves = Arrays.asList('X', 'Y', 'Z');
        int totalScore = 0;
        for (String round : inputList) {
            int opponentIndex = opponentMoves.indexOf(round.charAt(0));
            int playerIndex = playerMoves.indexOf(round.charAt(2));
            if (opponentIndex == playerIndex) {
                totalScore += 3;
            } else if ((playerIndex - opponentIndex) == 1 || (playerIndex - opponentIndex) == -2) {
                totalScore += 6;
            }
            totalScore += playerIndex + 1;
        }
        return totalScore;
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
