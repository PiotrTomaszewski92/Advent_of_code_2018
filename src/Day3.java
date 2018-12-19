import java.io.IOException;
import java.util.*;

public class Day3 {

    int maxSquares = 0;
    Map<String,List<Integer>> area = new HashMap<>();
    Set<String> oneClaims = new HashSet<>();
    Map<String,Integer> countClaims = new HashMap<>();

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

        //=====bouns============
        day3.findClaimWithOneId();
        System.out.println("Solution bonus: "+day3.checkSize(claims));
        //======================




    }

    private void checkMerged() {
        for (List<Integer> values : area.values()){
            if (values.size() > 1)
                maxSquares++;
        }
    }


    private void setClaimsOnArea(List<Day3_claim> claims) {
        int i, j;
        for (Day3_claim claim : claims) {
            for (i = 0; i < claim.getWeight(); i++) {
                for (j = 0; j < claim.getHeight(); j++) {
                    String id = (claim.getLeft() + i) + "x" + (claim.getTop() + j);

                    if (area.get(id) == null)
                        area.put(id, new ArrayList<>());
                    area.get(id).add(claim.getId());
                }
            }
        }
    }

    //========================BONUS========================

    private void findClaimWithOneId(){

        Set<String> keys = area.keySet();
        for (String key : keys){
            if(area.get(key).size() == 1){
                oneClaims.add(key);

                String id = Integer.toString(area.get(key).get(0));
                int val = (countClaims.get(id) == null) ? 0  : countClaims.get(id);
                countClaims.put(id,val+1);
            }
        }

    }

    private String checkSize(List<Day3_claim> claims) {
        String idSize = null;
        for(Day3_claim claim : claims){
            idSize = Integer.toString(claim.getId());
            if(countClaims.get(idSize) != null && (claim.getWeight() * claim.getHeight()) == countClaims.get(idSize)){
                break;
            }
        }
        return idSize;
    }


    //=====================================================

    private Day3_claim makeClaimFromString(String claim){
        // I know... magic numbers ;)
        claim = claim.replace(" ","");
        String[] id = claim.split("@");
        String[] size = id[1].split(":");
        String[] startPoint = size[0].split(",");
        String[] weightHeight = size[1].split("x");

        return new Day3_claim(
                Integer.parseInt(id[0].replace("#","")),
                Integer.parseInt(startPoint[0]),
                Integer.parseInt(startPoint[1]),
                Integer.parseInt(weightHeight[0]),
                Integer.parseInt(weightHeight[1])
                );
    }
}
