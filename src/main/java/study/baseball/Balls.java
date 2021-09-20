package study.baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {
	private final List<Ball> answers;

	public Balls(List<Integer> balls) {
		this.answers = mappingIntegerToBall(balls);
	}

	private List<Ball> mappingIntegerToBall(List<Integer> balls) {
		List<Ball> answers = new ArrayList<Ball>();
		for (int i = 0; i < balls.size(); i++) {
			Ball ball = new Ball(i + 1, balls.get(i));
			answers.add(ball);
		}
		return answers;
	}

	public PlayResult judgeBall(List<Integer> balls) {
		Balls userBall = new Balls(balls);
		PlayResult result = new PlayResult();

		for(Ball ball : answers){
			BallStatus status = userBall.judgeBall(ball);
			result.report(status);
		}

		return result;
	}

	public BallStatus judgeBall(Ball userball) {
		return this.answers.stream()
			.map(ball -> ball.judgeBall(userball))
			.filter(status -> status.isNotNothing())
			.findFirst()
			.orElse(BallStatus.NOTHING);
	}
}
