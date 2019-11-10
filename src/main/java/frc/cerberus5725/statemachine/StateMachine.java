package frc.cerberus5725.statemachine;

import java.util.HashMap;

public class StateMachine implements Runnable {
	private HashMap<State, Transition> transitions;
	private State current;
	private boolean hasEnteredRun = false;

	public StateMachine(State initialState) {
		transitions = new HashMap<State, Transition>();
		current = initialState;
	}

	public void add(Transition transition) {
		transitions.put(transition.current, transition);
	}

	public void remove(Transition transition) {
		transitions.remove(transition.current);
	}

	public void clear() {
		transitions.clear();
	}

	@Override
	public void run() {
		if(hasEnteredRun == false) {
			current.enter();
			hasEnteredRun = true;
		}

		if(transitions.get(current).condition.isTrue()) {
			current.exit();
			current = transitions.get(current).next;
			hasEnteredRun = false;
		}
		else {
			current.run();
		}
	}
}