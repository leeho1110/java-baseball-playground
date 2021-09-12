package study;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BaseballGame {

	private List<Integer> answer;
	private int strike;
	private int ball;


	public BaseballGame() {
		this.answer = new ArrayList<Integer>();

		while (getAnswer().size() < 3) {
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

	public void count(String input) {
		// TODO Auto-generated method stub

	}
}
