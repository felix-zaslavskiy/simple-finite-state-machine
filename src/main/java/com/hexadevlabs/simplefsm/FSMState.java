package com.hexadevlabs.simplefsm;

import java.util.List;

public class FSMState {
    private String currentState;
    private boolean traceMode;
    private Trace trace;
    private boolean started;

    private List<String> completedSplitStates = null;

    private String name;

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    public boolean isTraceMode() {
        return traceMode;
    }

    public void setTraceMode(boolean traceMode) {
        this.traceMode = traceMode;
    }

    public Trace getTrace() {
        return trace;
    }

    public void setTrace(Trace trace) {
        this.trace = trace;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCompletedSplitStates(){
        return this.completedSplitStates;
    }
    public void completedSplitStates(List<String> completedSplitStates) {
        this.completedSplitStates = completedSplitStates;
    }
}
