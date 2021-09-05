package study;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BaseballGame {

	public List<Integer> answer;

	public BaseballGame() {
		answer = new ArrayList<Integer>();
		setAnswer();
	}

	private void setAnswer() {
		while (answer.size() < 3) {
			addBalls();
		}
	}

	private void addBalls() {
		Random random = new Random();
		int ball = random.nextInt(9) + 1;

		if (!answer.contains(ball)) {
			this.answer.add(ball);
		}
	}
}
