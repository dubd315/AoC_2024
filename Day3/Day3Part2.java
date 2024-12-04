package AoC_2024.Day3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3Part2 {
    public static void main(String[] args) throws IOException {
        String filepath = "AoC_2024/Day3/inputs/Day3Part1Input.txt";
        Pattern pattern = Pattern.compile("mul\\([1-9]?[0-9]{0,2},[1-9]?[0-9]{0,2}\\)|do\\(\\)|don't\\(\\)");
        ArrayList<String> data = new ArrayList<>();
        boolean bool = true;
        boolean doo = false;
        boolean dont = false;
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
                    while(m.find()) {
                        data.add(m.group(0));
                    }

                }
            }

            for(String item: data){
                if(!(item.equals("do()")) && !(item.equals("don't()"))) {
                    if(doo){
                        count += calc(item);
                    } else if (dont){
                    } else {
                        count += calc(item);
                    }
                } else if (item.equals("do()")) {
                    doo = true;
                    if(dont){
                        dont = false;
                    }
                } else if (item.equals("don't()")){
                    dont = true;
                    if(doo){
                        doo = false;
                    }
                }
            }
            System.out.println(count);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int mul(int x, int y){
        return x * y;
    }

    public static int calc(String input){
        Pattern numPattern = Pattern.compile("\\b(\\d{1,3}|1000)\\b");
        Matcher numMatch = numPattern.matcher(input);
        int x = 0;
        int y = 0;
        while(numMatch.find()){
            if(x == 0){
                x = Integer.parseInt(numMatch.group(0));
            } else if (y == 0) {
                y = Integer.parseInt(numMatch.group(0));
            }
        }
        return mul(x,y);
    }


}