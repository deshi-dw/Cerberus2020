package frc.robot.statemachine;

import java.util.ArrayList;
import java.util.List;

public class StateMachine {
	private List<State> states;
	private List<List<Integer>> stateTree;
	private int nextState;

	public StateMachine() {
		states = new ArrayList<State>();
		stateTree = new ArrayList<List<Integer>>();
	}

	public List<State> getStates() {
		return states;
	}

	public void connect() {}
	public void disconnect() {}

	public void printStates() {
			System.out.println("State Machine:");
			for(int i = states.size()-1; i >= 0; i--) {
			System.out.print("State["+i+"]: ");
			for(int j = stateTree.get(i).size()-1; i >= 0; i--) {
				System.out.print(stateTree.get(i).get(j)+", ");
			}
			System.out.println("\b");
		}
	}
}