package com.hexadevlabs.simplefsm;

public class ExceptionInfo {
    private boolean hadException = false;
    private boolean onHook = false;
    public Exception exception;
    public ExceptionInfo(Exception exception, boolean onHook) {
        this.hadException=true;
        this.onHook = onHook;
        this.exception = exception;
    }

    public ExceptionInfo() {
    }

    boolean hadException() { return hadException; }

    public boolean isOnHook() {
        return onHook;
    }
}
