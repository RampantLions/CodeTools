/* @(#)GsonProcessor.java Sep 12, 2015
*
* Copyright (c) 2015. All rights reserved.
*/
package io.github.rampantlions.codetools.gson.processors;

import org.jboss.forge.roaster.model.source.FieldSource;
import org.jboss.forge.roaster.model.source.JavaClassSource;

import io.github.rampantlions.codetools.CommonProcessor;
import io.github.rampantlions.codetools.ModelGenUtils;
import io.github.rampantlions.codetools.ProcessorFacade;
import io.github.rampantlions.codetools.ProcessorSettings;

/**
* The Class GsonProcessor.
*
* @author Wiechman, Joshua <josh.wiechman@gmail.com>
*/
public class GsonProcessor extends CommonProcessor implements ProcessorFacade
{
	
	/** The Constant Annotation_Class_Gson_Exclude. */
	public final static Class< io.github.rampantlions.codetools.gson.annotations.GsonExclude > Annotation_Class_Gson_Exclude = io.github.rampantlions.codetools.gson.annotations.GsonExclude.class;
	
	/** The Constant Annotation_Class_Gson_Expose. */
	public final static Class< com.google.gson.annotations.Expose > Annotation_Class_Gson_Expose = com.google.gson.annotations.Expose.class;
	
	/** The Constant Annotation_Class_Serialized_Name. */
	public final static Class< com.google.gson.annotations.SerializedName > Annotation_Class_Serialized_Name = com.google.gson.annotations.SerializedName.class;

	/**
	 * Instantiates a new gson processor.
	 */
	public GsonProcessor()
	{
		super();
	}

	/**
	 * Instantiates a new gson processor.
	 *
	 * @param rootFolder the root folder
	 */
	public GsonProcessor( final ProcessorSettings config )
	{
		super( config );
	}

	/**
	 * processFields
	 * (non-Javadoc)
	 * 
	 * @param javaClass
	 * @see io.github.rampantlions.codetools.CommonProcessor#processFields(org.jboss.forge.roaster.model.source.JavaClassSource)
	 */
	@Override
	public void processFields( final JavaClassSource javaClass )
	{
		for ( FieldSource< JavaClassSource > field : javaClass.getFields() )
		{
			if ( !ModelGenUtils.isAnnotationPresent( field, GsonProcessor.Annotation_Class_Gson_Exclude ) )
			{

				ModelGenUtils.addAnnotation( field, GsonProcessor.Annotation_Class_Gson_Expose );
				ModelGenUtils.setAnnotationValue( ModelGenUtils.addAnnotation( field, GsonProcessor.Annotation_Class_Serialized_Name ), field.getName(), true, false, false );
				changeMade = true;
			}
		}
	}
}
