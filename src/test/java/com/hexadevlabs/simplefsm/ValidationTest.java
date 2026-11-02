package com.hexadevlabs.simplefsm;

import com.hexadevlabs.simplefsm.testSteps.Step1;
import com.hexadevlabs.simplefsm.testSteps.Step2;
import com.hexadevlabs.simplefsm.testSteps.Step3;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidationTest {

    @Test
    public void finalStatesMustBeDefined(){

        SimpleFSM simpleFSM = new SimpleFSM.Builder()
                .state("START", new Step1())
                    .conditional().goTo("STEP2")
                    .conditional().goTo("STEP3")
                .state("STEP2", new Step2(), true)
                    .on("proceed").goTo("STEP3")
                    .on("alt_proceed").goTo("STEP3")
                .state("STEP3", new Step3())
                    .auto().goTo("START")
                .build();
        simpleFSM.addFinalState("notexist");
        assertThrows(SimpleFSMValidationException.class, () -> simpleFSM.start("START", null) );
    }

    @Test
    public void transitionsMustPointToDefinedStates() {

        assertThrows(SimpleFSMValidationException.class, () -> {
            new SimpleFSM.Builder()
                    .state("START", new Step1())
                        .conditional().goTo("STEP2")
                        .conditional().goTo("STEP3")
                    .state("STEP2", new Step2(), true)
                        .on("proceed").goTo("STEP3")
                        .on("alt_proceed").goTo("undefinedState") // Invalid transition
                    .state("STEP3", new Step3())
                    .   auto().goTo("START")
                    .build();
        });

    }

    @Test
    public void onExceptionStateMustBeDefined() {
        assertThrows(SimpleFSMValidationException.class, () -> {
            new SimpleFSM.Builder()
                    .state("START", new Step1())
                        .conditional().goTo("STEP2")
                    .state("STEP2", new Step2(), true)
                        .on("error").goTo("START")
                    .onExceptionGoTo("notDefinedExceptionState") // Invalid exception state
                    .build();
        });

    }

}
