package vector;
import java.util.Arrays;
import java.util.stream.IntStream;

import utils.NumberUtils;

public class Vector {

	public final double[] v;
	
	public Vector(double ... v){
		this.v = v;
	}

	private double[] multiply(double[][] matrix, double[] vector) {
	    return Arrays.stream(matrix)
	            .mapToDouble(row -> IntStream.range(0, row.length)
	                    .mapToDouble(col -> row[col] * vector[col])
	                    .sum()).toArray();
	}
	
	public Vector transform(double t[][]) {
		return new Vector(multiply(t, this.v));
	}
	
	public Vector add(Vector a){
		double b[] = new double[a.v.length];
		for(int i=0;i<a.v.length; i++) {
			b[i] = a.v[i] + v[i];
		}
		return new Vector(b);
	}
	
	public Vector push(double ... vs) {
		int len = this.v.length + vs.length;
		double v[] = new double[len];
		for( int i = 0; i < len; i++) {
			if(i < this.v.length) {
				v[i] = this.v[i];				
			}else {
				v[i] = vs[i - i];
			}
		}
		return new Vector(v);
	}
	private boolean valid(int len) {
		if(v != null && v.length >= len) {
			return true;
		}
		return false;
	}
	
	public boolean isValid2D() {
		return valid(2);
	}
	
	public boolean isValid3D() {
		return valid(3);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("( ");
		Arrays.stream(v).forEachOrdered((a) ->{
			sb.append(NumberUtils.format(a).replace(",", ".")).append(", ");
		});
		return sb.replace(sb.length() -2, sb.length(), " )").toString();
	}
}
