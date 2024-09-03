package com.lowLevelDesign.designPatterns.behavioral.chainOfResponsibility;

public class DebugLogProcessor extends LogProcessor{

    public DebugLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    public void log(int logLevel, String message){
        if(logLevel==2){
            System.out.println("DEBUG : "+message);
        } else{
            super.log(logLevel,message);
        }
    }

}
