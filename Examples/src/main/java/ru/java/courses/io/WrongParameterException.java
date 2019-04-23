package ru.java.courses.io;

public class WrongParameterException extends RuntimeException {

    public String paramName;
    public String paramValue;

    public WrongParameterException(String paramName, String paramValue) {
        super("Invalid parameter");
        this.paramName = paramName;
        this.paramValue = paramValue;
    }
}
