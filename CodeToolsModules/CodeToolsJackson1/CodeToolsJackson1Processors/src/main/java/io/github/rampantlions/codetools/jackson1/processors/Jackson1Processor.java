package io.github.rampantlions.codetools.jackson1.processors;


import org.jboss.forge.roaster.model.source.FieldSource;
import org.jboss.forge.roaster.model.source.JavaClassSource;

import io.github.rampantlions.codetools.CommonProcessor;
import io.github.rampantlions.codetools.ModelGenUtils;
import io.github.rampantlions.codetools.ProcessorFacade;
import io.github.rampantlions.codetools.ProcessorSettings;

/**
 * The Class Jackson1Processor.
 *
 * @author Wiechman, Joshua <josh.wiechman@gmail.com>
 */
public class Jackson1Processor extends CommonProcessor implements ProcessorFacade
{

	/** The Constant Annotation_Class_Json_Ignore. */
	public final static Class< org.codehaus.jackson.annotate.JsonIgnore > Annotation_Class_Json_Ignore = org.codehaus.jackson.annotate.JsonIgnore.class;

	/** The Constant Annotation_Class_Json_Ignore_Type. */
	public final static Class< org.codehaus.jackson.annotate.JsonIgnoreType > Annotation_Class_Json_Ignore_Type = org.codehaus.jackson.annotate.JsonIgnoreType.class;

	/** The Constant Annotation_Class_Json_Property. */
	public final static Class< org.codehaus.jackson.annotate.JsonProperty > Annotation_Class_Json_Property = org.codehaus.jackson.annotate.JsonProperty.class;

	/** The Constant Annotation_Class_Json_Property_Order. */
	public final static Class< org.codehaus.jackson.annotate.JsonPropertyOrder > Annotation_Class_Json_Property_Order = org.codehaus.jackson.annotate.JsonPropertyOrder.class;

	/** The Constant Annotation_Class_Json_Serialization. */
	public final static Class< org.codehaus.jackson.map.annotate.JsonSerialize > Annotation_Class_Json_Serialization = org.codehaus.jackson.map.annotate.JsonSerialize.class;

	/** The Constant Literal_Enum_Json_Include_Not_Null. */
	public final static String Literal_Enum_Json_Include_Not_Null = "org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.NON_NULL";

	/**
	 * Instantiates a new jackson1 processor.
	 */
	public Jackson1Processor()
	{
		super();
	}

	/**
	 * Instantiates a new jackson1 processor.
	 *
	 * @param rootFolder the root folder
	 */
	public Jackson1Processor( final ProcessorSettings config )
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
			if ( !ModelGenUtils.isAnnotationPresent( field, Jackson1Processor.Annotation_Class_Json_Ignore ) )
			{
				ModelGenUtils.setAnnotationValue( ModelGenUtils.addAnnotation( field, Jackson1Processor.Annotation_Class_Json_Property ), field.getName(), true, false, false );
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
		if ( !ModelGenUtils.isAnnotationPresent( javaClass, Jackson1Processor.Annotation_Class_Json_Ignore_Type ) )
		{
			ModelGenUtils.setAnnotationValue( ModelGenUtils.addAnnotation( javaClass, Jackson1Processor.Annotation_Class_Json_Serialization ), "include", Jackson1Processor.Literal_Enum_Json_Include_Not_Null, true, false, true );

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
			ModelGenUtils.setAnnotationValue( ModelGenUtils.addAnnotation( javaClass, Jackson1Processor.Annotation_Class_Json_Property_Order ), "{ " + fields.toString() + " }", true, false, true );
			changeMade = true;
		}
	}
}
