package study.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;

public class BaseballGameTest {

	@Test
	@DisplayName("Ball 객체 하나와 하나  비교 시 strike")
	void check_1_1_strike() {
		Ball computer = new Ball(1, 1);
		assertThat(computer.judgeBall(new Ball(1, 1))).isEqualTo(BallStatus.STRIKE);
	}

	@Test
	@DisplayName("Ball 객체 하나와 하나 비교 시 ball")
	void check_1_1_ball() {
		Ball computer = new Ball(1, 1);
		assertThat(computer.judgeBall(new Ball(3, 1))).isEqualTo(BallStatus.BALL);
	}

	@Test
	@DisplayName("Ball 객체 하나와 하나 비교 시 nothing")
	void check_1_1_nothing() {
		Ball computer = new Ball(1, 1);
		assertThat(computer.judgeBall(new Ball(2, 3))).isEqualTo(BallStatus.NOTHING);
	}

	@Test
	@DisplayName("Ball 객체 3개가 담겨있는 리스트를 돌며 하나와 하나 비교 시 nothing")
	void check_3_1_nothing() {
		Balls balls = new Balls(Arrays.asList(1, 2, 3));
		assertThat(balls.judgeBall(new Ball(1, 4))).isEqualTo(BallStatus.NOTHING);
	}

	@Test
	@DisplayName("Ball 객체 3개가 담겨있는 리스트를 돌며 하나와 하나 비교 시 ball")
	void check_3_1_ball() {
		Balls balls = new Balls(Arrays.asList(1, 2, 3));
		assertThat(balls.judgeBall(new Ball(1, 3))).isEqualTo(BallStatus.BALL);
	}

	@Test
	@DisplayName("Ball 객체 3개가 담겨있는 리스트를 돌며 하나와 하나 비교 시 strike")
	void check_3_1_strike() {
		Balls balls = new Balls(Arrays.asList(1, 2, 3));
		assertThat(balls.judgeBall(new Ball(1, 1))).isEqualTo(BallStatus.STRIKE);
	}
}
