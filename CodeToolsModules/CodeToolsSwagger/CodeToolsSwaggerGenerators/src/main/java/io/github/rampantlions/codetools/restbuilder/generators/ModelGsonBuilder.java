package io.github.rampantlions.codetools.restbuilder.generators;

import com.google.gson.ExclusionStrategy;
import com.google.gson.GsonBuilder;

import io.github.rampantlions.codetools.gson.utils.GsonExclusionStrategy;

public class ModelGsonBuilder {
	public static final ExclusionStrategy exs = new GsonExclusionStrategy(null);

	public static GsonBuilder defaultBuilder() {
		// .serializeNulls()
		return new GsonBuilder().setExclusionStrategies(exs);
	}
}
