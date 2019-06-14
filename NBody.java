public class NBody{
	public static double readRadius(String filename){
		In in = new In(filename);
		int firstInt = in.readInt();
		double firstDouble = in.readDouble();
		return firstDouble;
	}
	public static Body[] readBodies(String filename){
		In in = new In(filename);
		int numOfPlanets = in.readInt();
		Body[] bodies = new Body[numOfPlanets];
		double firstDouble = in.readDouble();
		int i = 0;
		while(i < numOfPlanets){
			bodies[i] = new Body(in.readDouble(),in.readDouble(),in.readDouble(),
									in.readDouble(),in.readDouble(), in.readString());
			i = i + 1;
		}
		return bodies;
	}
	public static void main(String[] args){
		double t = Double.parseDouble(args[0]); 
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double radius = NBody.readRadius(filename);
		//Set Scale and Background
		StdDraw.setScale(-radius , radius);
		StdDraw.picture(0 ,0 ,"images/starfield.jpg");	
		Body[] bodies = NBody.readBodies(filename);

		for(Body b : bodies){
			b.draw();
		}
		StdDraw.enableDoubleBuffering();
		double time = 0;
		while(time < t){
			double[] xForces = new double[bodies.length];
			double[] yForces = new double[bodies.length];

			for(int i = 0 ; i < bodies.length; i++){
					xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
					yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
			}
			for(int i = 0 ; i < bodies.length; i++){
					bodies[i].update(dt, xForces[i], yForces[i]);
			}

			StdDraw.picture(-100 ,100 ,"images/starfield.jpg");
			 for(Body b : bodies){
			 	b.draw();
			 }

			StdDraw.show();
			StdDraw.pause(1);

			time = time + dt;
 
			}

			StdOut.printf("%d\n", bodies.length);
			StdOut.printf("%.2e\n", radius);
			for (int i = 0; i < bodies.length; i++) {
    			 StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                 bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
                 bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName); 

			
		 
		}
	}	
}