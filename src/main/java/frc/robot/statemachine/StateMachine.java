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

	public void add(State state) {
		int index = states.size();
		states.add(index, state);
		stateTree.add(index, new ArrayList<Integer>());
	}

	public void connect(int source, int target) {
		// TODO: Check if source exists or not.
		for(int i = stateTree.get(source).size()-1; i >= 0; i--) {
			if(stateTree.get(source).get(i) == target) {
				return;
			}
		}

		stateTree.get(source).add(target);
	}
	public void disconnect(int source, int target) {
		// TODO: Check if source exists or not.
		for(int i = stateTree.get(source).size()-1; i >= 0; i--) {
			if(stateTree.get(source).get(i) == target) {
				stateTree.get(source).remove(target);
				return;
			}
		}
	}

	public void printStates() {
			System.out.println("State Machine:");
			for(int i = states.size()-1; i >= 0; i--) {
			System.out.println("State["+i+"]");
		}
	}

	public void printStatesAndConnections() {
			System.out.println("State Machine:");
			for(int i = states.size()-1; i >= 0; i--) {
			System.out.print("State["+i+"]: ");
			for(int j = stateTree.get(i).size()-1; j >= 0; j--) {
				System.out.print(stateTree.get(i).get(j)+", ");
			}
			System.out.println("\b");
		}
	}
}