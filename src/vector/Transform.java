package vector;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

import utils.Array;
public class Transform {
	
	private Vector vector;

	public Transform(Vector vector) {
		this.vector = vector;
	}

	// TODO Translacao (em 2D e em 3D)
	public Vector translate2D(int dx, int dy) {
		return vector.add(new Vector( (double) dx, (double) dy));
	}

	public Vector translate3D(int dx, int dy, int dz) {
		return vector.add(new Vector( (double) dx, (double) dy, (double) dz));
	}

	// TODO Rotacao (em 2D e em todos os eixos em 3D)
	public Vector rotation2D(int angle) {
		return vector.transform(
				new double[][] { 
					{ cos(angle), -sin(angle) }, 
					{ sin(angle), cos(angle) } 
					});
	}

	public Vector rotation3DZ(int angle) {
		return vector.push(1.0).transform(new double[][] {
			{cos(angle), -sin(angle), 0.0, 0.0},
			{sin(angle),  cos(angle), 0.0, 0.0},
			{0.0	   ,         0.0, 1.0, 0.0},
			{0.0       ,         0.0, 0.0, 1.0}
		});
	}

	public Vector rotation3DX(int angle) {
		return vector.push(1.0).transform(new double[][] {
			{1.0,        0.0,         0.0, 0.0},
			{0.0, cos(angle), -sin(angle), 0.0},
			{0.0, sin(angle),  cos(angle), 0.0},
			{0.0,        0.0,         0.0, 1.0}
		});
	}

	public Vector rotation3DY(int angle) {
		return vector.push(1.0).transform(new double[][] {
			{cos(angle), 0.0, sin(angle), 0.0},
			{0.0, 		 1.0, 		 0.0, 0.0},
			{-sin(angle),0.0, cos(angle), 0.0},
			{0.0,        0.0,        0.0, 1.0}
		});
	}


	// TODO Reflexao (em todos os eixos nas dimensões 2D e 3D)
	public Vector reflection2DX() {
		return vector.transform(new double[][] {
			{ 1.0, 0.0},
			{ 0.0,-1.0}
		});
	}

	public Vector reflection2DY() {
		return vector.transform(new double[][] {
			{-1.0,  0.0},
			{ 0.0,  1.0}
		});
	}

	public Vector reflection3DX() {
		return vector.push(1.0).transform(new double[][] { 
			{ -1.0, 0.0, 0.0, 0.0 }, 
			{  0.0, 1.0, 0.0, 0.0 },
			{  0.0, 0.0, 1.0, 0.0 }, 
			{  0.0, 0.0, 0.0, 1.0 } 
		});
	}

	public Vector reflection3DY() {
		return vector.push(1.0).transform(new double[][] { 
			{  1.0,  0.0, 0.0, 0.0 }, 
			{  0.0, -1.0, 0.0, 0.0 },
			{  0.0,  0.0, 1.0, 0.0 }, 
			{  0.0,  0.0, 0.0, 1.0 } 
		});
	}

	public Vector reflection3DZ() {
		return vector.push(1.0).transform(new double[][] { 
			{  1.0, 0.0,  0.0, 0.0 }, 
			{  0.0, 1.0,  0.0, 0.0 },
			{  0.0, 0.0, -1.0, 0.0 }, 
			{  0.0, 0.0,  0.0, 1.0 } 
		});
	}

	// TODO Proje�ao (em todos os eixos em 2D e m 3D)
	public Vector projection2DX() {
		return vector.transform(
			new double[][] {
				{1.0, 0.0},
				{0.0, 0.0}
			});
	}

	public Vector projection2DY() {
		return vector.transform(
			new double[][] {
				{0.0, 0.0},
				{0.0, 1.0}
			});
	}

	public Vector projection3DX() {
		return vector.push(1.0).transform(new double[][] { 
			{  0.0,  0.0, 0.0, 0.0 }, 
			{  0.0,  1.0, 0.0, 0.0 },
			{  0.0,  0.0, 1.0, 0.0 }, 
			{  0.0,  0.0, 0.0, 1.0 } 
		});
	}

	public Vector projection3DY() {
		return vector.push(1.0).transform(new double[][] { 
			{  1.0,  0.0, 0.0, 0.0 }, 
			{  0.0,  0.0, 0.0, 0.0 },
			{  0.0,  0.0, 1.0, 0.0 }, 
			{  0.0,  0.0, 0.0, 1.0 } 
		});
	}

	public Vector projection3DZ() {
		return vector.push(1.0).transform(new double[][] { 
			{  1.0,  0.0, 0.0, 0.0 }, 
			{  0.0,  1.0, 0.0, 0.0 },
			{  0.0,  0.0, 0.0, 0.0 }, 
			{  0.0,  0.0, 0.0, 1.0 } 
		});
	}

	// TODO Cisalhamento (apenas em 2D)
	public Vector shearing(int kx, int ky) {
		return vector.transform(
				new double[][] {
					{1.0	    , (double) kx },
					{(double) ky, 		  0.0 }
				});
	}

	public Vector getVector() {
		return vector;
	}
	
	public static void main(String[] args) {
		System.out.println(new Transform(new Vector(Array.of(5.0,1.0))).shearing(0, 3));
		System.out.println(new Vector(Array.of(1.0,1.0)).push(0.0,0.0));
	}
}
