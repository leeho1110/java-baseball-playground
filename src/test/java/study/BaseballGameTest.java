package study;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

// 1. write Failing Test
// 2. write production code that could pass test
// 3. refactoring

class BaseballGameTest {

	private BaseballGame baseballGame;

	@BeforeEach
	void setUp() {
		this.baseballGame = new BaseballGame();
	}

	@Test
	void answer_is_string_that_have_length_of_3_after_setAnswer() {
		assertEquals(baseballGame.answer.size(), 3);
	}

	@Test
	void answer_is_diffrent_each_other() {
		assertEquals(baseballGame.answer.size(),
			baseballGame.answer.stream().distinct().collect(Collectors.toList()).size());
	@ParameterizedTest
	@ValueSource(strings = {"24", "1ㅁ2", "7a26", "asd", "   "})
	void validate_users_input_false(String input) {
		assertThatThrownBy(() -> {
			baseballGame.validate(input);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessage("입력값이 올바르지 않습니다");
	}

}
