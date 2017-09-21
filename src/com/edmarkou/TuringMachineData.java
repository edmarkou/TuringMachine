package com.edmarkou;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TuringMachineData {

    private String line;
    private String[] testers;
    private boolean didNotReachEnd = true;
    private String lineNumber;

    public TuringMachineData() throws FileNotFoundException {
    }

        public String getLine () {
            try {
                BufferedReader fileReader = new BufferedReader(new FileReader("texts.txt"));
                lineNumber = fileReader.readLine();
                line = fileReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return line;
        }

        public int getLineNumber(){
            try {
                BufferedReader fileReader = new BufferedReader(new FileReader("texts.txt"));
                lineNumber = fileReader.readLine();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return Integer.parseInt(lineNumber);
        }

    public String getTesters(int number) {
        testers = getTesters();
        return testers[number];
    }



    public String[] getTesters() {
        String test;
        int end = 0;
        ArrayList<String> list = new ArrayList<>();
        while (didNotReachEnd) {
            try {
                BufferedReader fileReader = new BufferedReader(new FileReader("texts.txt"));
                lineNumber = fileReader.readLine();
                line = fileReader.readLine();
                try{
                while(didNotReachEnd) {
                    test = fileReader.readLine();
                    if(test.equals(null) || test.equals("")){
                        test = fileReader.readLine();
                        end++;
                        if(test.equals(null) || test.equals("")){
                            end++;
                        }
                    }
                    if(end < 2) {
                        list.add(test);
                        end = 0;
                    } else didNotReachEnd = false;

                }}catch (NullPointerException n){
                    testers = list.toArray(new String[list.size()]);
                    break;
                }
                testers = list.toArray(new String[list.size()]);
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
        return testers;
    }
}