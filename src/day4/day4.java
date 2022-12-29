package day4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static day1.day1.getInput;

public class day4 {
    public static void main(String[] args) {

        List<String> inputList = getListInput("resources/day4.txt");
        int numberIncluded = getNumberIncluded(inputList);
        int numberOverlap = getNumberOverlap(inputList);
        System.out.println("number overlap: " + numberOverlap);
        System.out.println("Number of included: " + numberIncluded);
    }

    private static int getNumberOverlap(List<String> inputList) {
        int numberOverlap = 0;
        for (String pair : inputList) {
            List<String> parts = List.of(pair.split(","));
            List<Integer> firstNum = Arrays.stream(parts.get(0)
                    .split("-")).map(Integer::parseInt).collect(Collectors.toList());
            List<Integer> secondNum = Arrays.stream(parts.get(1)
                    .split("-")).map(Integer::parseInt).collect(Collectors.toList());
            if (firstNum.get(0) <= secondNum
                    .get(1) && secondNum.get(0) <= firstNum.get(1)) {
                numberOverlap++;
            }
        }
        return numberOverlap;
    }

    private static int getNumberIncluded(List<String> inputList) {
        int numberIncluded = 0;
        for (String pair : inputList) {
            List<String> parts = List.of(pair.split(","));
            List<Integer> firstNum = Arrays.stream(parts.get(0)
                    .split("-")).map(Integer::parseInt).collect(Collectors.toList());
            List<Integer> secondNum = Arrays.stream(parts.get(1)
                    .split("-")).map(Integer::parseInt).collect(Collectors.toList());

            if (firstNum.get(0) >= secondNum.get(0) && firstNum.get(1) <= secondNum.get(1)) {
                numberIncluded++;
                continue;
            }
            if (secondNum.get(0) >= firstNum.get(0) && secondNum.get(1) <= firstNum.get(1)) {
                numberIncluded++;
            }
        }
        return numberIncluded;
    }

    private static List<String> getListInput(String filePath) {
        return getInput(filePath);
    }
}


