package study;

import java.util.Scanner;

public class InputView {

	Scanner scanner = new Scanner(System.in);

	public String getInput() {
		System.out.println("숫자를 입력해주세요: ");
		String input = scanner.nextLine();

		return input;
	}

}
