//Christopher de la Iglesia

public class main {


    public main() {
	
    }

    public static void main(String[] args) {
	main m = new main();
	main.start();
    }

    public void start() {
	double time = getTime();
	double oldTick = getTime();
	double oldBlit = getTime();
	while(true) {
	    time = getTime();
	    if(time - oldTick > 0.5) {
		wor.tick();
		oldTick = getTime();
	    }

	    if(time - oldBlit > 0.010) {
		scr.update(wor);
		oldBlit = getTime();
	    }

	}

    }

    public double getTime() {return System.nanoTime()/1000000000.0;}

}