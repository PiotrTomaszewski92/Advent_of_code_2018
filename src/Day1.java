import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day1 {

    private int countNumbers(List<String> numbers){

        int result = 0;
            for (String number : numbers){
                result += (Integer.parseInt(number));
            }
        return result;
    }

    public static void main(String[] args) {
        Day1 day1 = new Day1();
        int solve = 0;
        try {
            solve = day1.countNumbers(ReadFile.readFile("input_files/day1.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(solve);
    }
}
