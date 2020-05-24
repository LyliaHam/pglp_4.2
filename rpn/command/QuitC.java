
public class QuitC implements Command {
	
	private Switch stop;
	
	public QuitC(Switch stop) {
		this.stop = stop;
	}

	@Override
	public void application() {
		stop.turnOff();
	}
}
