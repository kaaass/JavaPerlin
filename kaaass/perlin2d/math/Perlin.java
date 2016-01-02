package kaaass.perlin2d.math;

public class Perlin {
	public static float perlin(float x, float persistence, int octaves) {
		float r = 0;
		for (int i = 0; i < octaves; i++) {
			float a = persistence * i;
			float xx = 2 * i * x;
			int xi = (int) Math.floor(xx);
			r = r
					+ Interpolate.cosInterpolate(MeanFilter.noisy(xi),
							MeanFilter.noisy(xi + 1), xx - xi) * a;
		}
		return r;
	}

	public static float perlin(float x, float y, float persistence, int octaves) {
		float r = 0;
		for (int i = 0; i < octaves; i++) {
			float a = persistence * i;
			float xx = 2 * i * x;
			int xi = (int) Math.floor(xx);
			float yy = 2 * i * y;
			int yi = (int) Math.floor(yy);
			r = r
					+ Interpolate.cosInterpolate(Interpolate.cosInterpolate(
							MeanFilter.noisy(xi, yi),
							MeanFilter.noisy(xi + 1, yi), xx - xi), Interpolate
							.cosInterpolate(MeanFilter.noisy(xi, yi + 1),
									MeanFilter.noisy(xi + 1, yi + 1), xx - xi),
							yy - yi) * a;
		}
		return r;
	}
}
