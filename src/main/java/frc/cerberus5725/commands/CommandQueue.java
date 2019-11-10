package frc.cerberus5725.commands;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class CommandQueue implements Runnable {
	private Queue<Command> stack = new ArrayBlockingQueue<Command>(16);
	private Queue<Command> runnableStack;
	private Command next;

	private boolean isStopped = false;

	public CommandQueue(Command[] commands) {
		for (int i = 0; i < commands.length; i++) {
			stack.add(commands[i]);
		}
	}

	public void add(Command command) {
		stack.add(command);
	}

	public void stop() {
		isStopped = true;
	}

	public void reset() {
		runnableStack = stack;
		next = runnableStack.poll();
	}

	@Override
	public void run() {
		if (next == null) {
			reset();
		}

		while (next != null) {
			next.run();
			while (next.getIsFinished() == false) {
				if (isStopped) {
					break;
				}
			}

			if (isStopped) {
				break;
			}

			next = runnableStack.poll();
		}
	}
}