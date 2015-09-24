/* @(#)ProcessorSettings.java Sep 14, 2015
 *
 * Copyright (c) 2015. All rights reserved.
 */

package io.github.rampantlions.codetools;

import java.util.HashMap;
import java.util.Map;

/**
 * The Class ProcessorSettings.
 *
 * @author Wiechman, Joshua <josh.wiechman@gmail.com>
 */
public class ProcessorSettings
{

	/** The settings. */
	protected Map< String, String > settings = new HashMap<>();

	/**
	 * Gets the settings.
	 *
	 * @return the settings
	 */
	public Map< String, String > getSettings()
	{
		return settings;
	}

	/**
	 * Sets the settings.
	 *
	 * @param settings the settings
	 */
	public void setSettings( Map< String, String > settings )
	{
		this.settings = settings;
	}

}
