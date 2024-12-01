package AoC_2024.Day1;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Day1Part2 {
    public static void main(String[] args) throws IOException{
        String filepath = "AoC_2024/Day1/inputs/Day1Input.txt";
        int similarityScore = 0;
        Boolean bool = true;
        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            while (bool == true){
                String currentLine = reader.readLine();
                if(currentLine == null){
                    bool = false;
                    reader.close();
                } else {
                    String[] vals = currentLine.split("   ");
                    int firstNum = Integer.parseInt(vals[0]);
                    leftList.add(firstNum);
                    int secondNum = Integer.parseInt(vals[1]);
                    rightList.add(secondNum);
                }
            }

                Collections.sort(leftList);
                Collections.sort(rightList);

                for(int i = 0; i < leftList.size(); i++){
                    int count = 0;
                    for(int j = 0; j < rightList.size(); j++){
                        int trackedNum = leftList.get(i);
                        if(trackedNum == rightList.get(j)){
                            count += 1;
                        }

                    }
                    similarityScore += leftList.get(i) * count;
                }
        
        System.out.println(similarityScore);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}