package io.github.rampantlions.codetools.jackson2.processors;


import org.jboss.forge.roaster.model.source.FieldSource;
import org.jboss.forge.roaster.model.source.JavaClassSource;

import io.github.rampantlions.codetools.CommonProcessor;
import io.github.rampantlions.codetools.ModelGenUtils;
import io.github.rampantlions.codetools.ProcessorFacade;
import io.github.rampantlions.codetools.ProcessorSettings;

/**
 * The Class Jackson2Processor.
 *
 * @author Wiechman, Joshua <josh.wiechman@gmail.com>
 */
public class Jackson2Processor extends CommonProcessor implements ProcessorFacade
{

	/** The Constant Annotation_Class_Json_Ignore. */
	public final static Class< com.fasterxml.jackson.annotation.JsonIgnore > Annotation_Class_Json_Ignore = com.fasterxml.jackson.annotation.JsonIgnore.class;

	/** The Constant Annotation_Class_Json_Ignore_Type. */
	public final static Class< com.fasterxml.jackson.annotation.JsonIgnoreType > Annotation_Class_Json_Ignore_Type = com.fasterxml.jackson.annotation.JsonIgnoreType.class;

	/** The Constant Annotation_Class_Json_Include. */
	public final static Class< com.fasterxml.jackson.annotation.JsonInclude > Annotation_Class_Json_Include = com.fasterxml.jackson.annotation.JsonInclude.class;

	/** The Constant Annotation_Class_Json_Property. */
	public final static Class< com.fasterxml.jackson.annotation.JsonProperty > Annotation_Class_Json_Property = com.fasterxml.jackson.annotation.JsonProperty.class;

	/** The Constant Annotation_Class_Json_Property_Order. */
	public final static Class< com.fasterxml.jackson.annotation.JsonPropertyOrder > Annotation_Class_Json_Property_Order = com.fasterxml.jackson.annotation.JsonPropertyOrder.class;

	/** The Constant Literal_Enum_Json_Include_Not_Null. */
	public final static String Literal_Enum_Json_Include_Not_Null = "com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL";

	/**
	 * Instantiates a new jackson2 processor.
	 */
	public Jackson2Processor()
	{
		super();
	}

	/**
	 * Instantiates a new jackson2 processor.
	 *
	 * @param rootFolder the root folder
	 */
	public Jackson2Processor( final ProcessorSettings config )
	{
		super( config );
	}

	// @JsonDeserialize(using = keyDeserializer.class)
	// @JsonSerialize(using = keySerializer.class)

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
			if ( !ModelGenUtils.isAnnotationPresent( field, Jackson2Processor.Annotation_Class_Json_Ignore ) )
			{
				ModelGenUtils.setAnnotationValue( ModelGenUtils.addAnnotation( field, Jackson2Processor.Annotation_Class_Json_Property ), field.getName(), true, false, false );
				changeMade = true;
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
		if ( !ModelGenUtils.isAnnotationPresent( javaClass, Jackson2Processor.Annotation_Class_Json_Ignore_Type ) )
		{

			ModelGenUtils.setAnnotationValue( ModelGenUtils.addAnnotation( javaClass, Jackson2Processor.Annotation_Class_Json_Include ), Jackson2Processor.Literal_Enum_Json_Include_Not_Null, true, false, true );

			StringBuilder fields = new StringBuilder();
			boolean first = true;
			for ( FieldSource< JavaClassSource > field : javaClass.getFields() )
			{
				if ( !ModelGenUtils.hasAnnotation( field, Annotation_Class_Json_Ignore ) )
				{
					fields.append( ( ( first ) ? "" : ", " ) + "\"" + field.getName() + "\"" );
					first = false;
				}
			}
			ModelGenUtils.setAnnotationValue( ModelGenUtils.addAnnotation( javaClass, Jackson2Processor.Annotation_Class_Json_Property_Order ), "{ " + fields.toString() + " }", true, false, true );
			changeMade = true;
		}
	}
}
