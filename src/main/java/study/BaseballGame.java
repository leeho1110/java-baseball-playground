package study;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BaseballGame {

	private List<Integer> answer;
	private int strike;
	private int ball;

	private boolean gameSet;

	public BaseballGame() {
		this.answer = new ArrayList<Integer>();

		while (getAnswer().size() < 3) {
			addBalls();
		}
	}

	private void addBalls() {
		Random random = new Random();
		int ball = random.nextInt(9) + 1;

		if (!getAnswer().contains(ball)) {
			this.getAnswer().add(ball);
		}
	}

	public void gameStart() {
		InputView inputView = new InputView();
		ResultView resultView = new ResultView();

		while (!gameSet) {
			String input = inputView.getInput();

			// validate
			validate(input);

			// count
			count(input);

			// result
			System.out.println(resultView.printResult(this.strike, this.ball));
		}
	}

	public void validate(String input) {
		if (!input.matches("^[0-9]{3}")) {
			throw new IllegalArgumentException("입력값이 올바르지 않습니다");
		}
	}

	public void count(String input) {
		for (int idx = 0; idx < answer.size(); idx++) {
			int inputInt = Integer.parseInt(String.valueOf(input.charAt(idx)));
			checkStrike(inputInt, idx);
			checkBall(inputInt);
		}
	}

	public void checkStrike(int input, int idx) {
		if (input == answer.get(idx)) {
			this.strike = getStrike() + 1;
		}
	}

	public void checkBall(int input) {
		if (answer.contains(input)) {
			this.ball = getBall() + 1;
		}
	}

	public void setAnswer(List<Integer> answer) {
		this.answer = answer;
	}

	public List<Integer> getAnswer() {
		return this.answer;
	}

	public int getStrike() {
		return strike;
	}

	public int getBall() {
		return ball;
	}
}
