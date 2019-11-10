package frc.cerberus5725.statemachine;

import java.util.HashMap;

public class StateMachine implements Runnable {
	private HashMap<State, Transition> transitions;
	private State currentState;

	public StateMachine(State initialState) {
		transitions = new HashMap<State, Transition>();

		currentState = initialState;
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


		currentState.run();
	}
}