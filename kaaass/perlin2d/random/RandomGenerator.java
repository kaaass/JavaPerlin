package kaaass.perlin2d.random;

public class RandomGenerator {
	private static int[] seedWH = { 13, 97, 223 };
	private static int[] seedRSA = { 26, 20011 };

	/*
	 * x input
	 */

	/**
	 * This is a method of Wichman-Hill random number generator.
	 * 
	 * @param x
	 *            A seed for generator.
	 * @return A float random value between [0.0,1.0)
	 */
	public static float randomWH(int x) {
		int[] seed = new int[3];
		for (int i = 0; i <= Math.abs(x); i++) {
			seed[0] = (171 * seedWH[0]) % 30269;
			seed[1] = (172 * seedWH[1]) % 30307;
			seed[2] = (170 * seedWH[2]) % 30323;
		}
		return (x / Math.abs(x))
				* (seed[0] / 30269.0F + seed[1] / 30307.0F + seed[2] / 30323.0F)
				% 1.0F;
	}

	/**
	 * This is a method of RSA.
	 * 
	 * @param x
	 *            A seed for generator.
	 * @return A float random value between [0.0,1.0)
	 */
	public static float randomRSA(int x) {
		return (float) (x * Math.exp(seedRSA[0]) % seedRSA[1] / seedRSA[1]);
	}

	/**
	 * This is a method of basic random generator.
	 * 
	 * @param x
	 *            A seed for generator.
	 * @return A float random value between [0.0,1.0)
	 */
	public static float randomBasic(int x) {
		x = (x << 13) ^ x;
		return (float) (1.0 - Float.floatToIntBits((x
				* (x * x * 15731 + 789221) + 1376312589) & 0x7fffffff) / 1073741824.0);
	}

	/**
	 * This is a method of Java random number generator.
	 * 
	 * @param x
	 *            A seed for generator.
	 * @return A float random value between [0.0,1.0)
	 */
	public static float randomJava(int x) {
		return (float) (new java.util.Random(x).nextDouble() * 2 - 1);
	}
	
	/**
	 * This is a method of doNet random number generator.
	 * 
	 * @param x
	 *            A seed for generator.
	 * @return A float random value between [0.0,1.0)
	 */
	public static float randomDoNet(int x) {
		return (float) new DotNetRandom(x).rand();
	}

	/*
	 * x-y input
	 */

	/**
	 * This is a method of Wichman-Hill random number generator.
	 * 
	 * @param x
	 *            A seed for generator.
	 * @param y
	 *            A seed for generator.
	 * @return A float random value between [0.0,1.0)
	 */
	public static float randomWH(int x, int y) {
		return (randomWH(x) + randomWH(y)) / 2;
	}

	/**
	 * This is a method of RSA.
	 * 
	 * @param x
	 *            A seed for generator.
	 * @param y
	 *            A seed for generator.
	 * @return A float random value between [0.0,1.0)
	 */
	public static float randomRSA(int x, int y) {
		return (randomRSA(x) + randomRSA(y)) / 2;
	}

	/**
	 * This is a method of basic random generator.
	 * 
	 * @param x
	 *            A seed for generator.
	 * @param y
	 *            A seed for generator.
	 * @return A float random value between [0.0,1.0)
	 */
	public static float randomBasic(int x, int y) {
		x += y * 57;
		x = (x << 13) ^ x;
		return (float) (1.0 - Float.floatToIntBits((x
				* (x * x * 15731 + 789221) + 1376312589) & 0x7fffffff) / 1073741824.0);
	}

	/**
	 * This is a method of Java random number generator.
	 * 
	 * @param x
	 *            A seed for generator.
	 * @param y
	 *            A seed for generator.
	 * @return A float random value between [0.0,1.0)
	 */
	public static float randomJava(int x, int y) {
		return (float) (new java.util.Random(x).nextDouble()
				+ new java.util.Random(y).nextDouble() - 1);
	}
	
	/**
	 * This is a method of doNet random number generator.
	 * 
	 * @param x
	 *            A seed for generator.
	 * @param y
	 *            A seed for generator.
	 * @return A float random value between [0.0,1.0)
	 */
	public static float randomDoNet(int x, int y) {
		return (randomDoNet(x) + randomDoNet(y)) / 2;
	}
}
