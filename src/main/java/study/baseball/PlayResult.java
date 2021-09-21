package study.baseball;

public class PlayResult {
	private int ball;
	private int strike;
	private boolean gameSet = true;

	public int getBall(){
		return this.ball;
	};

	public int getStrike(){
		return this.strike;
	};

	public void report(BallStatus status) {
		if(status.isStrike()){
			this.strike += 1;
		}
		if(status.isBall()){
			this.ball += 1;
		}
	}

	public void checkGameProgress() {
		if(getStrike() == 3){
			gameSet = false;
			System.out.println(">>> 정답입니다! ");
		}
	}

	public boolean isGameSet() {
		return gameSet;
	}

	public void printResult() {
		System.out.printf("[%d] strike [%d] ball ! \n\n",getStrike(),getBall());
	}
}
