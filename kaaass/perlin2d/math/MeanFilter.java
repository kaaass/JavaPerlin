package kaaass.perlin2d.math;

import kaaass.perlin2d.random.RandomGenerator;

public class MeanFilter {
	public static float noisy(int x) {
		return RandomGenerator.randomRSA(x) / 2
				+ RandomGenerator.randomRSA(x - 1) / 4
				+ RandomGenerator.randomRSA(x + 1) / 4;
	}

	public static float noisy(int x, int y) {
		float a = (RandomGenerator.randomRSA(x - 1, y - 1)
				+ RandomGenerator.randomRSA(x + 1, y - 1)
				+ RandomGenerator.randomRSA(x - 1, y + 1) + RandomGenerator
				.randomRSA(x + 1, y + 1)) / 16;
		float b = (RandomGenerator.randomRSA(x - 1, y)
				+ RandomGenerator.randomRSA(x + 1, y)
				+ RandomGenerator.randomRSA(x, y - 1) + RandomGenerator
				.randomRSA(x, y + 1)) / 8;
		float c = RandomGenerator.randomRSA(x, y) / 4;
		return a + b + c;
	}
}
