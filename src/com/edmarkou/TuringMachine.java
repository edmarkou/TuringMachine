package com.edmarkou;

import java.io.FileNotFoundException;

public class TuringMachine {
    private String presentCondition;
    private String presentSymbol;
    private String newSymbol;
    private String direction;
    private String newCondition;

    TuringMachineData mTuringMachineData = new TuringMachineData();

    public TuringMachine() throws FileNotFoundException {

        this.presentCondition = presentCondition;
        this.presentSymbol = presentSymbol;
        this.newSymbol = newSymbol;
        this.direction = direction;
        this.newCondition = newCondition;
    }


    public String getPresentCondition() {
        return presentCondition;
    }

    public String getPresentSymbol() {
        return presentSymbol;
    }

    public String getNewSymbol() {
        return newSymbol;
    }

    public String getDirection() {
        return direction;
    }

    public String getNewCondition() {
        return newCondition;
    }

    public void setPresentCondition(String presentCondition) {
        this.presentCondition = presentCondition;
    }

    public void setPresentSymbol(String presentSymbol) {
        this.presentSymbol = presentSymbol;
    }

    public void setNewSymbol(String newSymbol) {
        this.newSymbol = newSymbol;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setNewCondition(String newCondition) {
        this.newCondition = newCondition;
    }

    public String[] dataRecompiler (int number){
            String[] data;
            data = mTuringMachineData.getTesters(number).split("\\s+");
        return  data;
    }

    public void setData(int number){
        String[] data = dataRecompiler(number);
        setPresentCondition(data[0]);
        setPresentSymbol(data[1]);
        setNewSymbol(data[2]);
        setDirection(data[3]);
        setNewCondition(data[4]);
    }

    public String getNextPresentCondition(int number){
        String[] data;
        data = mTuringMachineData.getTesters(number).split("\\s+");
        return data[0];
    }

    public String getNextPresentSymbol(int number){
        String[] data;
        data = mTuringMachineData.getTesters(number).split("\\s+");
        return data[1];
    }

    public char[] getLineAsChar(){
        return mTuringMachineData.getLine().toCharArray();
    }

    public int getTesterLength(){
        return mTuringMachineData.getTesters().length;
    }

    public String getNewCondition(int number) {
        String[] data;
        data = mTuringMachineData.getTesters(number).split("\\s+");
        return data[4];
    }

    public int getLineNumber(){
        return mTuringMachineData.getLineNumber();
    }
}
