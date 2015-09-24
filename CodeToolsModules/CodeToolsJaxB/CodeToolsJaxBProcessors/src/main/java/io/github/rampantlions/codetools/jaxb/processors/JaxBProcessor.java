package io.github.rampantlions.codetools.jaxb.processors;

import org.jboss.forge.roaster.model.source.AnnotationSource;
import org.jboss.forge.roaster.model.source.FieldSource;
import org.jboss.forge.roaster.model.source.JavaClassSource;

import io.github.rampantlions.codetools.CommonProcessor;
import io.github.rampantlions.codetools.ModelGenUtils;
import io.github.rampantlions.codetools.ProcessorFacade;
import io.github.rampantlions.codetools.ProcessorSettings;

/**
 * The Class JaxBProcessor.
 *
 * @author Wiechman, Joshua <josh.wiechman@gmail.com>
 */
public class JaxBProcessor extends CommonProcessor implements ProcessorFacade {

	/** The Constant Annotation_Class_Transient. */
	public final static Class<javax.persistence.Transient> Annotation_Class_Transient = javax.persistence.Transient.class;

	/** The Constant Annotation_Class_Xml_Accessor_Type. */
	public final static Class<javax.xml.bind.annotation.XmlAccessorType> Annotation_Class_Xml_Accessor_Type = javax.xml.bind.annotation.XmlAccessorType.class;

	/** The Constant Annotation_Class_Xml_Attribute. */
	public final static Class<javax.xml.bind.annotation.XmlAttribute> Annotation_Class_Xml_Attribute = javax.xml.bind.annotation.XmlAttribute.class;

	/** The Constant Annotation_Class_Xml_Element. */
	public final static Class<javax.xml.bind.annotation.XmlElement> Annotation_Class_Xml_Element = javax.xml.bind.annotation.XmlElement.class;

	/** The Constant Annotation_Class_Xml_Element_Wrapper. */
	public final static Class<javax.xml.bind.annotation.XmlElementWrapper> Annotation_Class_Xml_Element_Wrapper = javax.xml.bind.annotation.XmlElementWrapper.class;

	/** The Constant Annotation_Class_Xml_Root_Element. */
	public final static Class<javax.xml.bind.annotation.XmlRootElement> Annotation_Class_Xml_Root_Element = javax.xml.bind.annotation.XmlRootElement.class;

	/** The Constant Annotation_Class_Xml_See_Also_Element. */
	public final static Class<javax.xml.bind.annotation.XmlSeeAlso> Annotation_Class_Xml_See_Also_Element = javax.xml.bind.annotation.XmlSeeAlso.class;

	/** The Constant Annotation_Class_Xml_Transient_Element. */
	public final static Class<javax.xml.bind.annotation.XmlTransient> Annotation_Class_Xml_Transient_Element = javax.xml.bind.annotation.XmlTransient.class;

	/** The Constant Annotation_Class_Xml_Type. */
	public final static Class<javax.xml.bind.annotation.XmlType> Annotation_Class_Xml_Type = javax.xml.bind.annotation.XmlType.class;

	/** The Constant Annotation_Class_Xml_Value. */
	public final static Class<javax.xml.bind.annotation.XmlValue> Annotation_Class_Xml_Value = javax.xml.bind.annotation.XmlValue.class;

	/** The Constant Literal_Enum_Xml_Accessor_Type_Field. */
	public final static String Literal_Enum_Xml_Accessor_Type_Field = "javax.xml.bind.annotation.XmlAccessType.FIELD";

	/**
	 * Instantiates a new jax rs processor.
	 */
	public JaxBProcessor() {
		super();
	}

	/**
	 * Instantiates a new jax rs processor.
	 *
	 * @param rootFolder
	 *            the root folder
	 */
	public JaxBProcessor(final ProcessorSettings config) {
		super(config);
	}

	/**
	 * processFields (non-Javadoc).
	 *
	 * @param javaClass
	 *            the java class
	 * @see io.github.rampantlions.codetools.CommonProcessor#processFields(org.jboss.forge.roaster.model.source.JavaClassSource)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void processFields(final JavaClassSource javaClass) {
		for (FieldSource<JavaClassSource> field : javaClass.getFields()) {
			if ((!field.hasAnnotation(JaxBProcessor.Annotation_Class_Xml_Transient_Element))
					&& (!field.hasAnnotation(Annotation_Class_Transient))) {
				if (ModelGenUtils.isList(field) || ModelGenUtils.isSet(field) || ModelGenUtils.isMap(field)) {
					// ModelGenUtils.setAnnotationValue(
					// ModelGenUtils.addAnnotation( field,
					// JaxBProcessor.Annotation_Class_Xml_Element_Wrapper ),
					// "name", field.getName() + "es", true, false, false );
					ModelGenUtils.setAnnotationValue(
							ModelGenUtils.addAnnotation(field, JaxBProcessor.Annotation_Class_Xml_Element), "name",
							field.getName(), true, false, false);
				} else if (!ModelGenUtils.isPrimitive(field)) {
					AnnotationSource annotation = ModelGenUtils.addAnnotation(field,
							JaxBProcessor.Annotation_Class_Xml_Element);
					ModelGenUtils.setAnnotationValue(annotation, "name", field.getName(), true, false, false);
					ModelGenUtils.setAnnotationValue(annotation, "type", field.getType().getQualifiedName() + ".class",
							true, false, true);
				} else {
					ModelGenUtils.setAnnotationValue(
							ModelGenUtils.addAnnotation(field, JaxBProcessor.Annotation_Class_Xml_Attribute), "name",
							field.getName(), true, false, false);
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
		// ModelGenUtils.setAnnotationValue( ModelGenUtils.addAnnotation(
		// javaClass, JaxBProcessor.Annotation_Class_Xml_See_Also_Element ),
		// javaClass.getSuperType() + ".class", true, false, true );
		// ModelGenUtils.setAnnotationValue( ModelGenUtils.addAnnotation(
		// javaClass, JaxBProcessor.Annotation_Class_Xml_Root_Element ), "name",
		// javaClass.getName(), true, false, false );
		ModelGenUtils.setAnnotationValue(
				ModelGenUtils.addAnnotation(javaClass, JaxBProcessor.Annotation_Class_Xml_Accessor_Type),
				JaxBProcessor.Literal_Enum_Xml_Accessor_Type_Field, true, false, true);

		StringBuilder fields = new StringBuilder();
		boolean first = true;
		for (FieldSource<JavaClassSource> field : javaClass.getFields()) {
			if ((!field.hasAnnotation(JaxBProcessor.Annotation_Class_Xml_Transient_Element))
					&& (!field.hasAnnotation(JaxBProcessor.Annotation_Class_Xml_Attribute))) {
				fields.append(((first) ? "" : ", ") + "\"" + field.getName() + "\"");
				first = false;
			}
		}
		ModelGenUtils.setAnnotationValue(
				ModelGenUtils.addAnnotation(javaClass, JaxBProcessor.Annotation_Class_Xml_Type), "propOrder",
				"{ " + fields.toString() + " }", true, false, true);
	}

}
