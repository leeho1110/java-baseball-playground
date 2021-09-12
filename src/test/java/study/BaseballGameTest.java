package study;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BaseballGameTest {

	private BaseballGame baseballGame;

	@BeforeEach
	void setUp() {
		this.baseballGame = new BaseballGame();
	}

	@Test
	void answer_is_string_that_have_length_of_3_after_setAnswer() {
		assertEquals(baseballGame.getAnswer().size(), 3);
	}

	@Test
	void answer_is_diffrent_each_other() {
		assertEquals(baseballGame.getAnswer().size(),
			baseballGame.getAnswer().stream().distinct().collect(Collectors.toList()).size());
	}

	@ParameterizedTest
	@ValueSource(strings = {"24", "1ㅁ2", "7a26", "asd", "   "})
	void validate_users_input_false(String input) {
		assertThatThrownBy(() -> {
			baseballGame.validate(input);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessage("입력값이 올바르지 않습니다");
	}

	@ParameterizedTest
	@CsvSource(value = {"246:0,0", "245:0,1", "285:0,2", "518:1,2", "185:1,2", "157,1:1", "158:3,0"}, delimiter = ':')
	void checkStrike_and_checkBall(String input, String strikeAndBall) {

		// GIVEN
		String[] result = strikeAndBall.split(",");

		List<Integer> answer = new ArrayList<Integer>();
		answer.add(1);
		answer.add(5);
		answer.add(8);
		baseballGame.setAnswer(answer);

		// WHEN
		baseballGame.count(input);

		// THEN
		assertThat(baseballGame.getStrike()).isEqualTo(Integer.parseInt(result[0]));
		assertThat(baseballGame.getBall()).isEqualTo(Integer.parseInt(result[1]));

	}
}
