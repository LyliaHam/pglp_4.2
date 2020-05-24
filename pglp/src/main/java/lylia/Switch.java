package rpn;

public class Switch {
	private boolean swiitch;

	public Switch() {
		this.swiitch = true;
	}
	
	public boolean state () {
		return swiitch;
	}
	
	public void Off() {
		swiitch = false;
	}	
	
	public void On () {
		swiitch = true;
	}	
}
