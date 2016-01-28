package kaaass.perlin2d.random;

/**
 * This is a random generator which translated from dotNet.
 * 
 * @author dotNet, KAAAsS(Translate)
 *
 */
class DotNetRandom {
	private final static int MBIG = Integer.MAX_VALUE;
	private final static int MSEED = 161803398;

	private int inext, inextp;
	private int[] SeedArray = new int[56];

	public DotNetRandom() {
		this((int) System.currentTimeMillis());
	}

	public DotNetRandom(int Seed) {
		int ii;
		int mj, mk;

		mj = MSEED - Math.abs(Seed);
		SeedArray[55] = mj;
		mk = 1;
		for (int i = 1; i < 55; i++) {
			/*
			 * Apparently the range [1..55] is special (Knuth) and so we're
			 * wasting the 0'th position.
			 */
			ii = (21 * i) % 55;
			SeedArray[ii] = mk;
			mk = mj - mk;
			if (mk < 0)
				mk += MBIG;
			mj = SeedArray[ii];
		}
		for (int k = 1; k < 5; k++) {
			for (int i = 1; i < 56; i++) {
				SeedArray[i] -= SeedArray[1 + (i + 30) % 55];
				if (SeedArray[i] < 0)
					SeedArray[i] += MBIG;
			}
		}
		inext = 0;
		inextp = 21;
		Seed = 1;
	}

	/**
	 * Return a new random number [0,1) and reSeed the Seed array.
	 * @return A double [0,1)
	 */
	protected double rand() {
		int retVal;
		int locINext = inext;
		int locINextp = inextp;
		if (++locINext >= 56)
			locINext = 1;
		if (++locINextp >= 56)
			locINextp = 1;
		retVal = SeedArray[locINext] - SeedArray[locINextp];
		if (retVal < 0)
			retVal += MBIG;
		SeedArray[locINext] = retVal;
		inext = locINext;
		inextp = locINextp;
		/*
		 * Including this division at the end gives us significantly improved
		 * random number distribution.
		 */
		return (retVal * (1.0 / MBIG));
	}

}
