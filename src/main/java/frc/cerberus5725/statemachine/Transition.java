package frc.cerberus5725.statemachine;

import frc.cerberus5725.util.Condition;

public class Transition {
	public State current;
	public State next;
	public Condition condition;

	public Transition(State current, State next, Condition condition) {
		this.current = current;
		this.next = next;
		this.condition = condition;
	}
}