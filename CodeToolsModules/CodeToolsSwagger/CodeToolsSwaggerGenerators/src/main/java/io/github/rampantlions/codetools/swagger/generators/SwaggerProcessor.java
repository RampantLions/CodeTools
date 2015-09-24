package io.github.rampantlions.codetools.swagger.generators;

import org.jboss.forge.roaster.model.source.AnnotationSource;
import org.jboss.forge.roaster.model.source.FieldSource;
import org.jboss.forge.roaster.model.source.JavaClassSource;

import io.github.rampantlions.codetools.CommonProcessor;
import io.github.rampantlions.codetools.ModelGenUtils;
import io.github.rampantlions.codetools.ProcessorFacade;
import io.github.rampantlions.codetools.ProcessorSettings;

/**
 * The Class SwaggerProcessor.
 *
 * @author Wiechman, Joshua <josh.wiechman@gmail.com>
 */
public class SwaggerProcessor extends CommonProcessor implements ProcessorFacade
{

	/** The Constant Annotation_Class_Api_Model. */
	public final static Class< com.wordnik.swagger.annotations.ApiModel > Annotation_Class_Api_Model = com.wordnik.swagger.annotations.ApiModel.class;

	/** The Constant Annotation_Class_Api_Model_Property. */
	public final static Class< com.wordnik.swagger.annotations.ApiModelProperty > Annotation_Class_Api_Model_Property = com.wordnik.swagger.annotations.ApiModelProperty.class;

	/**
	 * Instantiates a new swagger processor.
	 */
	public SwaggerProcessor()
	{
		super();
	}

	/**
	 * Instantiates a new swagger processor.
	 *
	 * @param rootFolder the root folder
	 */
	public SwaggerProcessor( final ProcessorSettings config )
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
	@SuppressWarnings( "rawtypes" )
	@Override
	public void processFields( final JavaClassSource javaClass )
	{
		for ( FieldSource< JavaClassSource > field : javaClass.getFields() )
		{
			AnnotationSource annotation = ModelGenUtils.addAnnotation( field, SwaggerProcessor.Annotation_Class_Api_Model_Property );
			ModelGenUtils.setAnnotationValue( annotation, "value", field.getName() + " entry.", true, true, false );
			ModelGenUtils.setAnnotationValue( annotation, "notes", " ", true, true, false );
			ModelGenUtils.setAnnotationValue( annotation, "required", "true", true, true, true );
		}
	}

	/**
	 * processMainClass
	 * (non-Javadoc).
	 *
	 * @param javaClass the java class
	 * @see io.github.rampantlions.codetools.CommonProcessor#processMainClass(org.jboss.forge.roaster.model.source.JavaClassSource)
	 */
	@SuppressWarnings( "rawtypes" )
	@Override
	public void processMainClass( final JavaClassSource javaClass )
	{
		AnnotationSource annotation = ModelGenUtils.addAnnotation( javaClass, SwaggerProcessor.Annotation_Class_Api_Model );
		ModelGenUtils.setAnnotationValue( annotation, "value", javaClass.getName(), true, true, false );
		ModelGenUtils.setAnnotationValue( annotation, "description", ( ( this.config.getSettings().get( "systemName" ) == null ) ? "" : this.config.getSettings().get( "systemName" ) + " " ) + javaClass.getName() + " model.", true, true, false );
		ModelGenUtils.setAnnotationValue( annotation, "discriminator", CommonProcessor.COMMONMODEL + ".class", true, true, false );
		ModelGenUtils.setAnnotationValue( annotation, "parent", CommonProcessor.COMMONMODEL + ".class", true, true, true );
		changeMade = true;
	}
}
