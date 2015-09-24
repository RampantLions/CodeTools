package io.github.rampantlions.codetools.jackson1.processors;

import org.jboss.forge.roaster.model.source.AnnotationSource;
import org.jboss.forge.roaster.model.source.FieldSource;
import org.jboss.forge.roaster.model.source.JavaClassSource;

import io.github.rampantlions.codetools.CommonProcessor;
import io.github.rampantlions.codetools.ProcessorFacade;
import io.github.rampantlions.codetools.ProcessorSettings;

public class Jackson1Remover extends CommonProcessor implements ProcessorFacade {
	/**
	 * Instantiates a new hibernate processor.
	 *
	 * @param this.config.getSettings().get(
	 *            "rootFolder" ) the root folder
	 */
	public Jackson1Remover(final ProcessorSettings config) {
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
				case "org.codehaus.jackson.annotate.JsonIgnore":
				case "org.codehaus.jackson.annotate.JsonIgnoreType":
				case "org.codehaus.jackson.annotate.JsonProperty":
				case "org.codehaus.jackson.annotate.JsonPropertyOrder":
				case "org.codehaus.jackson.map.annotate.JsonSerialize":
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
			case "org.codehaus.jackson.annotate.JsonIgnore":
			case "org.codehaus.jackson.annotate.JsonIgnoreType":
			case "org.codehaus.jackson.annotate.JsonProperty":
			case "org.codehaus.jackson.annotate.JsonPropertyOrder":
			case "org.codehaus.jackson.map.annotate.JsonSerialize":
				javaClass.removeAnnotation(annotation);
				changeMade = true;
				break;
			default:
				break;
			}
		}
	}
}
