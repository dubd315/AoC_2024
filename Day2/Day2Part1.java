package AoC_2024.Day2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Day2Part1 {
    public static void main(String[] args) throws IOException {
        String filepath = "AoC_2024/Day2/inputs/Day2Part1Input.txt";
        boolean bool = true;
        int numSafe = 0;
        ArrayList<ArrayList<Integer>> levelList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            while (bool){
                String currentLine = reader.readLine();
                if(currentLine == null){
                    bool = false;
                    reader.close();
                } else {
                    //parsing will happen here
                    String[] vals = currentLine.split(" ");
                    ArrayList<Integer> tmplist = new ArrayList<>();

                    //add current level to integer array
                    for(String val:vals){
                        tmplist.add(Integer.parseInt(val));
                    }
                    levelList.add(tmplist);
                }
            }

            for(ArrayList<Integer> list:levelList){
                boolean check = isSafe(list);
                if(check){
                    numSafe += 1;
                }

            }
            System.out.println(numSafe);



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static boolean isSafe(ArrayList<Integer> level){
        boolean safe = true;
        boolean increasing = false;
        boolean decreasing = false;
        for(int i=0; i < level.size() - 1; i++){

            if (Objects.equals(level.get(i), level.get(i + 1))) {
                safe = false;
            //can't have a difference greater than 3
            } else if (Math.abs(level.get(i) - level.get(i+1)) > 3){
                safe = false;
            } else if (level.get(i) > level.get(i+1)){
                decreasing = true;
                if(increasing){
                    //theres a conflict
                    safe = false;
                }
            } else if (level.get(i) < level.get(i+1)){
                increasing = true;
                if(decreasing){
                    safe = false;
                }
            }
            //check if were comparing to the last item in the list
            if(i+1 == level.size()){
                //just return the value of safe
                return safe;
            }
        }
        return safe;
    }
}