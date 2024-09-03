package com.lowLevelDesign.designPatterns.behavioral.chainOfResponsibility;

public class ErrorLogProcessor extends LogProcessor{
    public ErrorLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    public void log(int logLevel, String message){
        if(logLevel==3){
            System.out.println("ERROR : "+message);
        } else{
            super.log(logLevel,message);
        }
    }


}
