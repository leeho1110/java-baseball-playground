package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorSecondTest {

	Calculator calculator;

	@BeforeEach
	void setUp() {
		calculator = new Calculator();
	}

	@DisplayName("split")
	@ParameterizedTest
	@ValueSource(strings = {"2 + 4 -", "1 +", "12- 2", "19 -2 / 4"

	})

	void splitAndValidate(String param) {
		assertThatThrownBy(() -> {
			calculator.split(param);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessage("입력값이 올바르지 않습니다");
	}
}
