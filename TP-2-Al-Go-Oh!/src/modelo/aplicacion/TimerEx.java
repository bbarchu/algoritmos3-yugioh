package modelo.aplicacion;
import java.util.Timer;
import java.util.TimerTask;


public class TimerEx {
	public static void main(String arglist[]) {
	    
		
		
	    Timer timer = new Timer();

	    TimerTask evento = new TimerTask() {
	       

	      

			@Override
	        public void run()
	        {
	            System.out.println("Se termino el tiempo");
	            timer.cancel();
	            
	           
	        }
	        };
	        // Empezamos ya y  lanzamos el evento cada 150000ms
	    timer.schedule(evento, 0, 150000);
	    }
	
	
}
