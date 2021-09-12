package study;

import java.util.Map;

public class ResultView {

	Map<String, Integer> strikeAndBall;

	public String printResult(int strike, int ball) {
		String answer = "";

		if (ball != 0) {
			answer += String.format("%d볼 ", ball);
		}

		if (ball != 0) {
			answer += String.format("%d스트라이크", strike);
		}

		return answer;
	}

	public char[] printResult() {
		// TODO Auto-generated method stub
		return null;
	}
}
