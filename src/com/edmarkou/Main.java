package com.edmarkou;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {

        try {
            TuringMachine mTuringMachine = new TuringMachine();

            int number = 0;
            int lineNumber = mTuringMachine.getLineNumber()-1;
            int presentCondition = 0;
            char[] line = mTuringMachine.getLineAsChar();
            int sk = 0;

            outerloop:
            do{
                mTuringMachine.setData(number);
                sk++;

                if (line[lineNumber] == mTuringMachine.getPresentSymbol().charAt(0)) {
                    line[lineNumber] = mTuringMachine.getNewSymbol().charAt(0);
                    System.out.println(line);
                    if (mTuringMachine.getDirection().charAt(0) == 'R') {
                        lineNumber++;
                        if(lineNumber >= line.length) break outerloop;
                    }
                    if (mTuringMachine.getDirection().charAt(0) == 'L') {
                        lineNumber--;
                        if(lineNumber < 0) break outerloop;
                    }
                    try {
                        if (Integer.parseInt(mTuringMachine.getNextPresentCondition((number + 1))) ==
                                Integer.parseInt(mTuringMachine.getNewCondition())
                                && mTuringMachine.getNextPresentSymbol((number + 1)).equalsIgnoreCase(String.valueOf(line[lineNumber]))) {
                            number++;
                        } else if (Integer.parseInt(mTuringMachine.getNextPresentCondition((number + 1))) !=
                                Integer.parseInt(mTuringMachine.getNewCondition())
                                || mTuringMachine.getNextPresentSymbol((number + 1)).equalsIgnoreCase(String.valueOf(line[lineNumber]))) {
                            number = 0;
                            while (Integer.parseInt(mTuringMachine.getNewCondition()) !=
                                    Integer.parseInt(mTuringMachine.getNextPresentCondition((number + 1)))

                                    || mTuringMachine.getNextPresentSymbol((number + 1)).equalsIgnoreCase(String.valueOf(line[lineNumber]))) {
                                number++;
                                if (number >= mTuringMachine.getTesterLength()){
                                    break outerloop;
                                }
                            }
                        }
                    }catch (ArrayIndexOutOfBoundsException e){
                         presentCondition = Integer.parseInt(mTuringMachine.getNewCondition());
                         number = 0;
                         try {
                             while (presentCondition != Integer.parseInt(mTuringMachine.getNextPresentCondition((number + 1)))) {
                                 number++;
                             }
                         }catch(ArrayIndexOutOfBoundsException e1){
                             System.out.println("Array out of bounds, exiting loop.");
                             break outerloop;
                         }
                    }
                }
                else if(line[lineNumber] != mTuringMachine.getPresentSymbol().charAt(0)){
                    number++;
                }
            }while(!mTuringMachine.getNewCondition().equalsIgnoreCase("H") ||
                    number >= mTuringMachine.getTesterLength() ||
                    lineNumber >= line.length);

            System.out.println("Turing machine has ended.");
            System.out.println(sk);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
