package study.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;

public class BallTest {

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

}
