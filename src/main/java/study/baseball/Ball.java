package study.baseball;

public class Ball {
	private final int position;
	private final int number;

	public Ball(int position, int number) {
		this.position = position;
		this.number = number;
	}

	public BallStatus judgeBall(Ball ball) {
		if (this.equals(ball)) {
			return BallStatus.STRIKE;
		}

		if (isJudgedResultBall(ball)) {
			return BallStatus.BALL;
		}

		return BallStatus.NOTHING;
	}

	private boolean isJudgedResultBall(Ball ball) {
		return this.number == ball.number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Ball ball = (Ball)o;
		return position == ball.position && number == ball.number;
	}
}
