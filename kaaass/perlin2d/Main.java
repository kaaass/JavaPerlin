package kaaass.perlin2d;

import kaaass.perlin2d.math.Perlin;
import kaaass.perlin2d.random.RandomGenerator;

public class Main {

	public static void main(String[] args) {
		test();
	}

	public static void test() {
		long t;
		// ===
		t = System.currentTimeMillis();
		System.out.println("Start testing randomWH().");
		for (int i = 1; i <= 10000; i++) {
			RandomGenerator.randomWH(i);
		}
		System.out.println("Testing randomWH() completed, using time: "
				+ (System.currentTimeMillis() - t) + " ms.\n");
		// ===
		t = System.currentTimeMillis();
		System.out.println("Start testing randomRSA().");
		for (int i = 1; i <= 10000; i++) {
			RandomGenerator.randomRSA(i);
		}
		System.out.println("Testing randomRSA() completed, using time: "
				+ (System.currentTimeMillis() - t) + " ms.\n");
		// ===
		t = System.currentTimeMillis();
		System.out.println("Start testing randomBasic().");
		for (int i = 1; i <= 10000; i++) {
			RandomGenerator.randomBasic(i);
		}
		System.out.println("Testing randomBasic() completed, using time: "
				+ (System.currentTimeMillis() - t) + " ms.\n");
		// ===
		t = System.currentTimeMillis();
		System.out.println("Start testing randomJava().");
		for (int i = 1; i <= 10000; i++) {
			RandomGenerator.randomJava(i);
		}
		System.out.println("Testing randomJava() completed, using time: "
				+ (System.currentTimeMillis() - t) + " ms.\n");
		// ===
		t = System.currentTimeMillis();
		System.out.println("Start testing randomDoNet().");
		for (int i = 1; i <= 10000; i++) {
			RandomGenerator.randomDoNet(i);
		}
		System.out.println("Testing randomDoNet() completed, using time: "
				+ (System.currentTimeMillis() - t) + " ms.\n");
		// =======
		t = System.currentTimeMillis();
		System.out.println("Start testing perlin(x).");
		for (int i = 1; i <= 1000; i++) {
			Perlin.perlin(i / 10, 0.25F, 4);
		}
		System.out.println("Testing perlin(x) completed(1000), using time: "
				+ (System.currentTimeMillis() - t) + " ms.\n");
		// =======
		t = System.currentTimeMillis();
		System.out.println("Start testing perlin(x,y).");
		for (int i = 1; i <= 500; i++) {
			for (int ii = 1; ii <= 500; ii++) {
				Perlin.perlin(i / 10, ii / 10, 0.25F, 4);
			}
		}
		System.out
				.println("Testing perlin(x,y) completed(500*500), using time: "
						+ (System.currentTimeMillis() - t) + " ms.\n");
	}
}
