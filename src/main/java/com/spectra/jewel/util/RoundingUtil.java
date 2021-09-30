package com.spectra.jewel.util;

public class RoundingUtil {
	public static double round(final double value) {
		return Math.round(value * 100.0) / 100.0;
	}
}
