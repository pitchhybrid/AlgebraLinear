package vector;
import java.util.Arrays;
import java.util.stream.IntStream;

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
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("(");
		Arrays.stream(v).forEachOrdered((a) ->{
			sb.append(a).append(",");
		});
		return sb.replace(sb.length() -1, sb.length(), ")").toString();
	}
}
