/* GsonExclusionStrategy.java 1.00 Apr 11, 2015
*
* Copyright (c) 2015. All rights reserved.
* @author <a href="mailto:josh.wiechman@gmail.com">Wiechman, Joshua</a>
* 
*/

package io.github.rampantlions.codetools.gson.utils;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

import io.github.rampantlions.codetools.gson.annotations.GsonExclude;

/**
 * The Class GsonExclusionStrategy.
 */
public class GsonExclusionStrategy implements ExclusionStrategy {

	/** The type to exclude. */
	private final Class<?> typeToExclude;

	/**
	 * Instantiates a new gson exclusion strategy.
	 *
	 * @param clazz
	 *            the clazz
	 */
	public GsonExclusionStrategy(Class<?> clazz) {
		this.typeToExclude = clazz;
	}

	/**
	 * shouldSkipClass (non-Javadoc)
	 * 
	 * @param clazz
	 * @return
	 * @see com.google.gson.ExclusionStrategy#shouldSkipClass(java.lang.Class)
	 */
	@Override
	public boolean shouldSkipClass(Class<?> clazz) {
		return (this.typeToExclude != null && this.typeToExclude == clazz)
				|| clazz.getAnnotation(GsonExclude.class) != null;
	}

	/**
	 * shouldSkipField (non-Javadoc)
	 * 
	 * @param f
	 * @return
	 * @see com.google.gson.ExclusionStrategy#shouldSkipField(com.google.gson.FieldAttributes)
	 */
	@Override
	public boolean shouldSkipField(FieldAttributes f) {
		return f.getAnnotation(GsonExclude.class) != null;
	}

}