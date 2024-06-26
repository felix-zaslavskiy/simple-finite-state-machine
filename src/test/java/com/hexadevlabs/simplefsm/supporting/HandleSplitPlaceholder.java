package com.hexadevlabs.simplefsm.supporting;

import com.hexadevlabs.simplefsm.ProcessingData;
import com.hexadevlabs.simplefsm.SimpleFSM;
import com.hexadevlabs.simplefsm.SplitHandler;
import com.hexadevlabs.simplefsm.State;

import java.util.Collection;

/**
 * Used as a placeholder.
 * The persistence will be stored to a static member variable.
 * This is essentially the simplest possible working Split Handler we can make for testing.
 */
public class HandleSplitPlaceholder implements SplitHandler {


    @Override
    public void handleSplit(SimpleFSM simpleFSM, ProcessingData data, Collection<String> splitTransitions) {
        // Normally will persist State machine and data.

        // Trigger processing of all the split states.
        for(String splitState: splitTransitions){
            simpleFSM.continueOnSplitState(splitState, data);
        }

    }

    @Override
    public boolean getAndUpdateStateAndData(SimpleFSM simpleFSM, ProcessingData currentData, String splitSourceState, String completedSplitState) {

        simpleFSM.recordCompletionSplitState(completedSplitState);
        int totalSplitStatesCompleted = simpleFSM.getCompletionSplitStates().size();

        // Get the expected # of total transitions
        State source = simpleFSM.getState(splitSourceState);
        int totalSplitTransitionsExpected = source.getSplitTransitions().size();

        return  totalSplitStatesCompleted == totalSplitTransitionsExpected;

    }


}
