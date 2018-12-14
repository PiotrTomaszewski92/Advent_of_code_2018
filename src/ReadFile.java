import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

    public static List<String> readFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        List<String> stringList = new ArrayList<>();
        String st;
        while ((st = br.readLine()) != null)
            stringList.add(st);
        return stringList;
    }

}
