package study.baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PlayInput {
	Scanner scanner = new Scanner(System.in);

	List<Integer> getUserInput() {
		List<Integer> userBalls = new ArrayList<Integer>();

		for (int i = 0; i < 3; i++) {
			System.out.printf(">>> %d번째 숫자 : ", i + 1);
			String input = scanner.nextLine();

			checkValidate(input);
			userBalls.add(Integer.parseInt(input));
		}

		return userBalls;
	}

	private void checkValidate(String input) {
		if(!Pattern.matches("^[0-9]{1}",input)){
			throw new IllegalArgumentException("1-9 사이의 숫자를 입력해주세요");
		};
	}

	void printNavigate(String type) {
		if ("start".equals(type)) {
			System.out.println(">>> 숫자 야구 게임을 시작합니다!");
			System.out.println(">>> 3자리 숫자를 입력해주세요");
		}
		if ("end".equals(type)) {
			System.out.println(">>> 숫자 야구 게임을 종료합니다!");
		}
	}

	int printReplayFlag(){
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		return Integer.parseInt(scanner.nextLine());
	}
}
