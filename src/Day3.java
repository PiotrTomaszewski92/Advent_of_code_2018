import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day3 {

    int maxSquares = 0;
    Map<String,List<Integer>> area = new HashMap<>();

    public static void main(String[] args) {

        Day3 day3 = new Day3();
        List<Day3_claim> claims = new ArrayList<>();
        try {
            for(String s : ReadFile.readFile("input_files/day3.txt")){
                claims.add(day3.makeClaimFromString(s));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        day3.setClaimsOnArea(claims);

        day3.checkMerged();

        System.out.println("Merged: "+day3.maxSquares);


    }

    private void checkMerged() {
        for (List<Integer> values : area.values()){
            if (values.size() > 1)
                maxSquares++;
        }
    }


    private void setClaimsOnArea(List<Day3_claim> claims) {
        int i, j, c1, c2;


        for (Day3_claim claim : claims) {
            for (i = 0; i < claim.getWeight(); i++) {
                for (j = 0; j < claim.getHeight(); j++) {
                    String id = claim.getLeft() + i + "x" + claim.getTop() + j;

                    if (area.get(id) == null)
                        area.put(id, new ArrayList<>());
                    area.get(id).add(claim.getId());
                }
            }
        }
    }



    private Day3_claim makeClaimFromString(String claim){

        claim = claim.replace(" ","");
//        #id @ left,top: wide x tall
//        Day3_claim(int id, int top, int left, int weight, int height)
        String[] id = claim.split("@");
        String[] size = id[1].split(":");
        String[] startPoint = size[0].split(",");
        String[] weghtHeight = size[1].split("x");

        return new Day3_claim(
                Integer.parseInt(id[0].replace("#","")),
                Integer.parseInt(startPoint[0]),
                Integer.parseInt(startPoint[1]),
                Integer.parseInt(weghtHeight[0]),
                Integer.parseInt(weghtHeight[1])
                );
    }
}
