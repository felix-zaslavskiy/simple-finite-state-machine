package nfsm;

public class ExceptionHandler extends ProcessingStep {
    @Override
    protected void process(ProcessingData data) {
        data.set("error" , 1);
    }
}
