package io.github.rampantlions.codetools.swagger.generators;

import org.jboss.forge.roaster.model.source.AnnotationSource;
import org.jboss.forge.roaster.model.source.FieldSource;
import org.jboss.forge.roaster.model.source.JavaClassSource;

import io.github.rampantlions.codetools.CommonProcessor;
import io.github.rampantlions.codetools.ProcessorFacade;
import io.github.rampantlions.codetools.ProcessorSettings;

public class SwaggerRemover extends CommonProcessor implements ProcessorFacade {

	public SwaggerRemover(final ProcessorSettings config) {
		super(config);
	}

	/**
	 * processFields (non-Javadoc).
	 *
	 * @param javaClass
	 *            the java class
	 * @see io.github.rampantlions.codetools.CommonProcessor#processFields(org.jboss.forge.roaster.model.source.JavaClassSource)
	 */
	@Override
	public void processFields(final JavaClassSource javaClass) {
		for (FieldSource<JavaClassSource> field : javaClass.getFields()) {
			for (AnnotationSource<JavaClassSource> annotation : field.getAnnotations()) {
				switch (annotation.getQualifiedName()) {
				case "com.wordnik.swagger.annotations.ApiModel":
				case "com.wordnik.swagger.annotations.ApiModelProperty":
					field.removeAnnotation(annotation);
					changeMade = true;
					break;
				default:
					break;
				}
			}
		}
	}

	/**
	 * processMainClass (non-Javadoc).
	 *
	 * @param javaClass
	 *            the java class
	 * @see io.github.rampantlions.codetools.CommonProcessor#processMainClass(org.jboss.forge.roaster.model.source.JavaClassSource)
	 */
	@Override
	public void processMainClass(final JavaClassSource javaClass) {
		for (AnnotationSource<JavaClassSource> annotation : javaClass.getAnnotations()) {
			switch (annotation.getQualifiedName()) {
			case "com.wordnik.swagger.annotations.ApiModel":
			case "com.wordnik.swagger.annotations.ApiModelProperty":
				javaClass.removeAnnotation(annotation);
				changeMade = true;
				break;
			default:
				break;
			}
		}
	}

}
