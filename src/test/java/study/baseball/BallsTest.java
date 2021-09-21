package study.baseball;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallsTest {
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

	@Test
	@DisplayName("Ball 객체 3개가 담겨있는 리스트들을 서로 비교 시 nothing")
	void check_3_3_nothing() {
		Balls balls = new Balls(Arrays.asList(1, 2, 3));
		PlayResult result = balls.judgeBall(Arrays.asList(4, 5, 6));
		assertThat(result.getStrike()).isEqualTo(0);
		assertThat(result.getBall()).isEqualTo(0);
	}

	@Test
	@DisplayName("Ball 객체 3개가 담겨있는 리스트들을 서로 비교 시 1볼 1스트라이크")
	void check_3_3_1ball_1strike() {
		Balls balls = new Balls(Arrays.asList(1, 2, 3));
		PlayResult result = balls.judgeBall(Arrays.asList(1, 5, 2));
		assertThat(result.getStrike()).isEqualTo(1);
		assertThat(result.getBall()).isEqualTo(1);
	}

	@Test
	@DisplayName("Ball 객체 3개가 담겨있는 리스트들을 서로 비교 시 3스트라이크")
	void check_3_3_3strike() {
		Balls balls = new Balls(Arrays.asList(1, 2, 3));
		PlayResult result = balls.judgeBall(Arrays.asList(1, 2, 3));
		assertThat(result.getStrike()).isEqualTo(3);
		assertThat(result.getBall()).isEqualTo(0);
	}
}
