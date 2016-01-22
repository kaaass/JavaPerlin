package kaaass.perlin2d;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import kaaass.perlin2d.math.Perlin;
import kaaass.perlin2d.random.RandomGenerator;

public class Main {

	public static void main(String[] args) {
		testRandom("randomWH");
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

	public static void testRandom(String method) {
		RandomGenerator obj = new RandomGenerator();
		Method m;
		try {
			long t;
			// ===
			m = RandomGenerator.class.getMethod(method, Integer.class);
			t = System.currentTimeMillis();
			System.out.println("Start testing " + method
					+ "(), test: Generate 10000 numbers(1D).");
			for (int i = 1; i <= 10000; i++) {
				m.invoke(obj, i);
			}
			System.out.println("Testing " + method
					+ "() completed, using time: "
					+ (System.currentTimeMillis() - t) + " ms.\n");
			// ===
			m = RandomGenerator.class.getMethod(method, Integer.class,
					Integer.class);
			t = System.currentTimeMillis();
			System.out.println("Start testing " + method
					+ "(), test: Generate 10000 numbers(2D).");
			for (int i = 1; i <= 100; i++) {
				for (int ii = 1; ii <= 100; ii++) {
					m.invoke(obj, i, ii);
				}
			}
			System.out.println("Testing " + method
					+ "() completed, using time: "
					+ (System.currentTimeMillis() - t) + " ms.\n");
			// Generate data
			m = RandomGenerator.class.getMethod(method, Integer.class);
			String s1 = "";
			String s2 = "";
			for (int i = 1; i <= 1000; i++) {
				if (s1.equals("")) {
					s1 = String.valueOf((float) i / 100);
				} else {
					s1 = s1 + "," + String.valueOf((float) i / 100);
				}
				if (s2.equals("")) {
					s2 = "" + (float) m.invoke(obj, i);
				} else {
					s2 = s2 + "," + (float) m.invoke(obj, i);
				}
			}
			System.out.println(s1);
			System.out.println(s2);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			return;
		} catch (IllegalAccessException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
