package study.baseball;

public class PlayResult {
	private int ball;
	private int strike;

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
}
