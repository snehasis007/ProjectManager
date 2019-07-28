package com.cts.projectmanager.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import com.cts.projectmanager.model.PmError;

public class PmException extends RuntimeException{
	private static final long serialVersionUID = 5537866808874125010L;
	private PmError error;

    {
        error=new PmError();
    }
    public PmException() {
        //super();
        error.setMessage(getMessage());
        error.setStackTrace(getStackTraceMessage());
    }

    public PmException(String message) {
        super(message);
        error.setMessage(getMessage());
        error.setStackTrace(getStackTraceMessage());
    }

    public PmException(String message, Throwable cause) {
        super(message, cause);
        error.setMessage(getMessage());
        error.setStackTrace(getStackTraceMessage());
    }

    public PmException(Throwable cause) {
        super(cause);
        error.setMessage(getMessage());
        error.setStackTrace(getStackTraceMessage());
    }

    public PmError getError() {
        return error;
    }

    public void setError(PmError error) {
        this.error = error;
    }

    String getStackTraceMessage(){

        StringWriter sw=new StringWriter();
        PrintWriter pw=new PrintWriter(sw);
        printStackTrace(pw);
        return sw.toString();
    }
}
