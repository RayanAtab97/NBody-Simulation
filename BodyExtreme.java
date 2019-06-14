public class Body{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	private static final double gC = 6.67e-11;

	public Body(double xP, double yP, double xV,
					double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Body(Body b){
		xxPos = b.xxPos;
		yyPos = b.yyPos;
		xxVel = b.xxVel;
		yyVel = b.yyVel;
		mass = b.mass;
	    imgFileName = b.imgFileName;

	}

	public double calcDistance(Body b){
		double dx = this.xxPos - b.xxPos;
		double dy = this.yyPos - b.yyPos;
		return Math.sqrt(dx * dx + dy * dy);
	}

	public double calcForceExertedBy(Body b){
		double r = this.calcDistance(b);
		return Body.gC * this.mass * b.mass / (r * r);
	}

	public double calcForceExertedByX(Body b){
		double force = this.calcForceExertedBy(b);
		double dx = b.xxPos - this.xxPos;
		double r = this.calcDistance(b);
		return force * dx / r;

	}

	public double calcForceExertedByY(Body b){
		double force = this.calcForceExertedBy(b);
		double dy = b.yyPos - this.yyPos;
		double r = this.calcDistance(b);
		return force * dy / r;
	}

	public double calcNetForceExertedByX(Body[] allBodys){
		double result = 0;
		for(Body b : allBodys){
			if (b.equals(this)){
				continue;
			}
			result += this.calcForceExertedByX(b);
		}
		return result;
	}

	public double calcNetForceExertedByY(Body[] allBodys){
		double result = 0;
		for(Body b : allBodys){
			if (b.equals(this)){
				continue;
			}
			result += this.calcForceExertedByY(b);
		}
		return result;
	}

	public void update(double dt, double fX, double fY){
		double accX = fX / this.mass;
		double accY = fY / this.mass;
		xxVel = xxVel + dt * accX;
		yyVel = yyVel + dt * accY;
		xxPos = xxPos + dt * xxVel;
		yyPos = yyPos + dt * yyVel;
	}

	public void draw(){
		StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
	}

}