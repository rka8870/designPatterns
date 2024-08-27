package com.lowLevelDesign.designPatterns.behavioral.memento.versionControlSystem;

public class InvalidRevertException extends Exception{

    InvalidRevertException(String message){
        super(message);
    }

    InvalidRevertException(String message, Exception exception){
        super(message,exception);
    }

}
