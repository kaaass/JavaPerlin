package kaaass.perlin2d.math;

public class Interpolate {
	public static float linearInterpolate(float a, float b, float x) {
		return a * (1 - x) + b * x;
	}

	public static float cosInterpolate(float a, float b, float x) {
		float f = (float) ((1 - Math.cos(Math.PI * x)) * 0.5F);
		return linearInterpolate(a, b, f);
	}

	public static float cubicInterpolate(float v0, float v1, float v2,
			float v3, float x) {
		float p = (v3 - v2) - (v0 - v1);
		float q = (v0 - v1) - p;
		float r = v2 - v0;
		float s = v1;
		return (float) (p*Math.pow(x,3) + q*Math.pow(x,2) + r*x + s);
	}
}
