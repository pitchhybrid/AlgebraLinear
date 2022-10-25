package vector;

import utils.Array;

public class Transform {
	
	private Vector vector;

	public Transform(Vector vector) {
		this.vector = vector;
	}

	// Translação (em 2D e em 3D)
	public Vector translate2D(int dx, int dy) {
		return vector.add(new Vector((double) dx,(double) dy));
	}

	public Vector translate3D(int dx, int dy, int dz) {
		return vector.add(new Vector((double) dx,(double) dy, (double) dz));
	}

	// Rotação (em 2D e em todos os eixos em 3D)
	public Vector rotation2D(int angle) {
		double vangle = 0.01 * angle * -1;
		return vector.transform(new double[][] {
			{0.0,vangle},
			{1.0, 0.0}
		});
	}

	public Vector rotation3DX(int angle) {
		return null;
	}

	public Vector rotation3DY(int angle) {
		return null;
	}

	public Vector rotation3DZ(int angle) {
		return null;
	}

	// Reflexão (em todos os eixos nas dimensões 2D e 3D)
	public Vector reflection2DX() {
		return vector.transform(new double[][] {
			{-1.0,0.0},
			{ 0.0,1.0}
		});
	}

	public Vector reflection2DY() {
		return vector.transform(new double[][] {
			{1.0 ,0.0},
			{0.0,-1.0}
		});
	}

	public Vector reflection3DX() {
		return null;
	}

	public Vector reflection3DY() {
		return null;
	}

	public Vector reflection3DZ() {
		return null;
	}

	// Projeção (em todos os eixos em 2D e m 3D)
	public Vector projection2DX() {
		return null;
	}

	public Vector projection2DY() {
		return null;
	}

	public Vector projection3DX() {
		return null;
	}

	public Vector projection3DY() {
		return null;
	}

	public Vector projection3DZ() {
		return null;
	}

	// Cisalhamento (apenas em 2D)
	public Vector shearing(int kx, int ky) {
		return null;
	}

	public Vector getVector() {
		return vector;
	}
	
	public static void main(String[] args) {
//		System.out.println(new Transform(new Vector(Array.of(5.0,1.0))).rotation2D(-50));
		System.out.println(new Vector(Array.of(5.0,1.0)).add(new Vector(Array.of(50.0,50.0))));
	}
}
