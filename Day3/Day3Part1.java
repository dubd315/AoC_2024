package AoC_2024.Day3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3Part1 {
    public static void main(String[] args) throws IOException {
        String filepath = "AoC_2024/Day3/inputs/Day3Part1Input.txt";
        Pattern pattern = Pattern.compile("mul\\([1-9]?[0-9]{0,2},[1-9]?[0-9]{0,2}\\)");
        Pattern numPattern = Pattern.compile("\\b(\\d{1,3}|1000)\\b");
        boolean bool = true;
        int count = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            while (bool){
                String currentLine = reader.readLine();
                if(currentLine == null){
                    bool = false;
                    reader.close();
                } else {
                    Matcher m = pattern.matcher(currentLine);
                    while(m.find()){
                        System.out.println(m.group(0));
                        Matcher numMatch = numPattern.matcher(m.group(0));
                        int x = 0;
                        int y = 0;
                        while(numMatch.find()){
                            if(x == 0){
                                x = Integer.parseInt(numMatch.group(0));
                            } else if (y == 0) {
                                y = Integer.parseInt(numMatch.group(0));
                            }
                        }
                        count += mul(x,y);
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int mul(int x, int y){
        return x * y;
    }

}