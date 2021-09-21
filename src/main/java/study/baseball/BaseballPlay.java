package study.baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BaseballPlay {
	PlayResult result;
	PlayInput input;
	int replay;

	public BaseballPlay() {
		this.input = new PlayInput();
	}

	void gameStart() {
		this.result = new PlayResult();
		input.printNavigate("start");

		Balls computer = new Balls(setInitAnswer());
		while (result.isGameSet()) {
			result = computer.judgeBall(input.getUserInput());
			result.printResult();
			result.checkGameProgress();
		}

		if (input.printReplayFlag() == 1) {
			gameStart();
		};

		input.printNavigate("end");

	}

	private List<Integer> setInitAnswer() {
		List<Integer> answerList = new ArrayList<Integer>();
		Random random = new Random();

		while (answerList.size() < 3) {
			addAnswer(answerList,random);
		}
		return answerList;
	}

	private List<Integer> addAnswer(List<Integer> answerList, Random random) {
		int answer = random.nextInt(9) + 1;
		if (!answerList.contains(answer)) {
			answerList.add(answer);
		}

		return answerList;

	}

	public int getReplay() {
		return replay;
	}

	public void setReplay(int replay) {
		this.replay = replay;
	}

	public static void main(String[] args) {
		BaseballPlay baseballGame = new BaseballPlay();
		baseballGame.gameStart();
	}

}
