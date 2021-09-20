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

	public BallStatus judgeBall(Ball userball) {
		return this.answers.stream()
			.map(ball -> ball.judgeBall(userball))
			.filter(status -> status != BallStatus.NOTHING)
			.findFirst()
			.orElse(BallStatus.NOTHING);
	}
}
