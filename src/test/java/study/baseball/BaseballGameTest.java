package study.baseball;

import org.junit.jupiter.api.Test;
import study.baseball.Ball;
import study.baseball.BallStatus;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BaseballGameTest {

    @Test
    void check_strike(){
        Ball computer = new Ball(1,1);
        assertThat(computer.judgeBall(new Ball(1,1))).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void check_ball(){
        Ball computer = new Ball(1,1);
        assertThat(computer.judgeBall(new Ball(3,1))).isEqualTo(BallStatus.BALL);
    }

    @Test
    void check_nothing(){
        Ball computer = new Ball(1,1);
        assertThat(computer.judgeBall(new Ball(2,3))).isEqualTo(BallStatus.NOTHING);
    }

}
