package io.github.rampantlions.codetools.jackson2.processors;


import org.jboss.forge.roaster.model.source.AnnotationSource;
import org.jboss.forge.roaster.model.source.FieldSource;
import org.jboss.forge.roaster.model.source.JavaClassSource;

import io.github.rampantlions.codetools.CommonProcessor;
import io.github.rampantlions.codetools.ProcessorFacade;
import io.github.rampantlions.codetools.ProcessorSettings;

public class Jackson2Remover extends CommonProcessor implements ProcessorFacade
{

	public Jackson2Remover( final ProcessorSettings config )
	{
		super( config );
	}

	/**
	 * processFields
	 * (non-Javadoc).
	 *
	 * @param javaClass the java class
	 * @see io.github.rampantlions.codetools.CommonProcessor#processFields(org.jboss.forge.roaster.model.source.JavaClassSource)
	 */
	@Override
	public void processFields( final JavaClassSource javaClass )
	{
		for ( FieldSource< JavaClassSource > field : javaClass.getFields() )
		{
			for ( AnnotationSource< JavaClassSource > annotation : field.getAnnotations() )
			{
				switch ( annotation.getQualifiedName() )
				{
					case "com.fasterxml.jackson.annotation.JsonIgnore":
					case "com.fasterxml.jackson.annotation.JsonIgnoreType":
					case "com.fasterxml.jackson.annotation.JsonInclude":
					case "com.fasterxml.jackson.annotation.JsonProperty":
					case "com.fasterxml.jackson.annotation.JsonPropertyOrder":
						field.removeAnnotation( annotation );
						changeMade = true;
						break;
					default:
						break;
				}
			}
		}
	}

	/**
	 * processMainClass
	 * (non-Javadoc).
	 *
	 * @param javaClass the java class
	 * @see io.github.rampantlions.codetools.CommonProcessor#processMainClass(org.jboss.forge.roaster.model.source.JavaClassSource)
	 */
	@Override
	public void processMainClass( final JavaClassSource javaClass )
	{
		for ( AnnotationSource< JavaClassSource > annotation : javaClass.getAnnotations() )
		{
			switch ( annotation.getQualifiedName() )
			{
				case "com.fasterxml.jackson.annotation.JsonIgnore":
				case "com.fasterxml.jackson.annotation.JsonIgnoreType":
				case "com.fasterxml.jackson.annotation.JsonInclude":
				case "com.fasterxml.jackson.annotation.JsonProperty":
				case "com.fasterxml.jackson.annotation.JsonPropertyOrder":
					javaClass.removeAnnotation( annotation );
					changeMade = true;
					break;
				default:
					break;
			}
		}
	}


}
