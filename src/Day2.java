import sun.misc.CharacterEncoder;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day2 {
    Map<Integer, Integer> mapAmountLetter = new HashMap<>();

    public static void main(String[] args) {

        Day2 day2 = new Day2();

        try {
            List<String> abc = ReadFile.readFile("input_files/day2.txt");
            for(String s : abc){
                char[] tablica = s.toCharArray();
                day2.checksum(tablica);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(day2.mapAmountLetter.get(2) * day2.mapAmountLetter.get(3));
    }

    private Map<Character,Integer> setCharMap(char[] charArray){
        Map<Character, Integer> mapChar = new HashMap<Character, Integer>();
        for(char letter : charArray){

            Integer count = mapChar.get(letter);
            if (count == null) {
                mapChar.put(letter, 1);
            }
            else {
                mapChar.put(letter, count + 1);
            }
        }
        return mapChar;
    }

    private int countLetters(Map<Character, Integer> mapChar, int number){
        int count = 0;
        for (Character c : mapChar.keySet()){
            if (mapChar.get(c) == number)
                count++;
        }
        return count;
    }

    private void setAmountLetterToMap(int countLetters, int identifier){
        Integer amount =mapAmountLetter.get(identifier);

        if (amount == null && countLetters > 0) {
            mapAmountLetter.put(identifier, 1);
        }
        if (amount != null && countLetters > 0) {
            mapAmountLetter.put(identifier, amount + 1);
        }
    }

    private void checksum(char[] charArray){

        Map<Character, Integer> mapChar = setCharMap(charArray);

        int countTwo = countLetters(mapChar,2);
        int countThree = countLetters(mapChar,3);;

        setAmountLetterToMap(countTwo, 2);
        setAmountLetterToMap(countThree, 3);

    }



}
