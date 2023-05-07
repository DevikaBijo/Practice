package com.UST.Sample_College.Exception;

public class IDNotFoundException extends RuntimeException{
    private static final long serialVersionUID= 1L;
    public IDNotFoundException(String msg){
        super(msg);
    }

}
