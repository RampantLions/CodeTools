package io.github.rampantlions.codetools.hibernate.processors;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.source.AnnotationSource;
import org.jboss.forge.roaster.model.source.FieldSource;
import org.jboss.forge.roaster.model.source.JavaClassSource;

import io.github.rampantlions.codetools.CommonProcessor;
import io.github.rampantlions.codetools.ModelGenUtils;
import io.github.rampantlions.codetools.ProcessorFacade;
import io.github.rampantlions.codetools.ProcessorSettings;

/**
 * The Class HibernateProcessor.
 *
 * @author Wiechman, Joshua <josh.wiechman@gmail.com>
 */
public class HibernateProcessor extends CommonProcessor implements ProcessorFacade {

	/** The Constant Annotation_Class_Collection_Table. */
	public static final Class<javax.persistence.CollectionTable> Annotation_Class_Collection_Table = javax.persistence.CollectionTable.class;

	/** The Constant Annotation_Class_Column. */
	public static final Class<javax.persistence.Column> Annotation_Class_Column = javax.persistence.Column.class;

	/** The Constant Annotation_Class_Element_Collection. */
	public static final Class<javax.persistence.ElementCollection> Annotation_Class_Element_Collection = javax.persistence.ElementCollection.class;

	/** The Constant Annotation_Class_Entity. */
	public static final Class<javax.persistence.Entity> Annotation_Class_Entity = javax.persistence.Entity.class;

	/** The Constant Annotation_Class_Join_Column. */
	public static final Class<javax.persistence.JoinColumn> Annotation_Class_Join_Column = javax.persistence.JoinColumn.class;

	/** The Constant Annotation_Class_Join_Table. */
	public static final Class<javax.persistence.JoinTable> Annotation_Class_Join_Table = javax.persistence.JoinTable.class;

	/** The Constant Annotation_Class_Many_To_One. */
	public static final Class<javax.persistence.ManyToOne> Annotation_Class_Many_To_One = javax.persistence.ManyToOne.class;

	/** The Constant Annotation_Class_Map_Key_Column. */
	public static final Class<javax.persistence.MapKeyColumn> Annotation_Class_Map_Key_Column = javax.persistence.MapKeyColumn.class;

	/** The Constant Annotation_Class_Map_Key_Join_Column. */
	public static final Class<javax.persistence.MapKeyJoinColumn> Annotation_Class_Map_Key_Join_Column = javax.persistence.MapKeyJoinColumn.class;

	/** The Constant Annotation_Class_Named_Queries. */
	public static final Class<javax.persistence.NamedQueries> Annotation_Class_Named_Queries = javax.persistence.NamedQueries.class;

	/** The Constant Annotation_Class_Named_Query. */
	public static final Class<javax.persistence.NamedQuery> Annotation_Class_Named_Query = javax.persistence.NamedQuery.class;

	/** The Constant Annotation_Class_One_To_Many. */
	public static final Class<javax.persistence.OneToMany> Annotation_Class_One_To_Many = javax.persistence.OneToMany.class;

	/** The Constant Annotation_Class_One_To_One. */
	public static final Class<javax.persistence.OneToOne> Annotation_Class_One_To_One = javax.persistence.OneToOne.class;

	/** The Constant Annotation_Class_Order_Column. */
	public static final Class<javax.persistence.OrderColumn> Annotation_Class_Order_Column = javax.persistence.OrderColumn.class;

	/** The Constant Annotation_Class_Primary_Key_Join_Column. */
	public static final Class<javax.persistence.PrimaryKeyJoinColumn> Annotation_Class_Primary_Key_Join_Column = javax.persistence.PrimaryKeyJoinColumn.class;

	/** The Constant Annotation_Class_Table. */
	public static final Class<javax.persistence.Table> Annotation_Class_Table = javax.persistence.Table.class;

	/** The Constant Annotation_Class_Transient. */
	public static final Class<javax.persistence.Transient> Annotation_Class_Transient = javax.persistence.Transient.class;

	/** The Constant Annotation_Class_Type. */
	public static final Class<org.hibernate.annotations.Type> Annotation_Class_Type = org.hibernate.annotations.Type.class;

	/** The Constant Annotation_Class_Unique_Constraint. */
	public static final Class<javax.persistence.UniqueConstraint> Annotation_Class_Unique_Constraint = javax.persistence.UniqueConstraint.class;

	/** The Constant List_Hibernate_Fields. */
	@SuppressWarnings("serial")
	public static final List<String> List_Hibernate_Fields = new ArrayList<String>() {
		{
			add("");
			add("id__");
			add("version__");
		}
	};

	/** The Constant Literal_Class_Default_List. */
	public static final String Literal_Class_Default_List = "java.util.ArrayList";

	/** The Constant Literal_Class_Default_Map. */
	public static final String Literal_Class_Default_Map = "java.util.HashMap";

	/** The Constant Literal_Class_Default_Set. */
	public static final String Literal_Class_Default_Set = "java.util.HashSet";

	/** The Constant Literal_Class_Join_Column. */
	public static final String Literal_Class_Join_Column = "javax.persistence.JoinColumn";

	/** The Constant Literal_Class_Named_Query. */
	public static final String Literal_Class_Named_Query = "javax.persistence.NamedQuery";

	/** The Constant Literal_Class_Unique_Constraint. */
	public static final String Literal_Class_Unique_Constraint = "javax.persistence.UniqueConstraint";

	/** The Constant Literal_Enum_Cascade_Type_All. */
	public static final String Literal_Enum_Cascade_Type_All = "javax.persistence.CascadeType.ALL";

	/** The Constant Literal_Enum_Fetch_Type_Eager. */
	public static final String Literal_Enum_Fetch_Type_Eager = "javax.persistence.FetchType.EAGER";

	/** The Constant Literal_Enum_Fetch_Type_Lazy. */
	public static final String Literal_Enum_Fetch_Type_Lazy = "javax.persistence.FetchType.LAZY";

	/** The Constant Literal_Set_Cascade_Type_PersistAndMerge. */
	public static final String Literal_Set_Cascade_Type_PersistAndMerge = "{javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.MERGE}";

	/** The Constant String_Hibernate_System_Id. */
	public static final String String_Hibernate_System_Id = "Hibernate__ID";

	/** The Constant String_Mapped_By. */
	public static final String String_Mapped_By = "mappedBy";

	/** The Constant String_Name. */
	public static final String String_Name = "name";

	/** The Constant String_Suffix_Foreign_Key. */
	public static final String String_Suffix_Foreign_Key = "__fk";

	/** The Constant String_Suffix_Id. */
	public static final String String_Suffix_Id = "_id";

	/** The Constant String_Suffix_Join_Table. */
	public static final String String_Suffix_Join_Table = "__jt";

	/** The Constant String_Suffix_Reference. */
	public static final String String_Suffix_Reference = "__href";

	/**
	 * Default initializer.
	 *
	 * @param field
	 *            the field
	 * @return true, if successful
	 */
	public boolean defaultInitializer(final FieldSource<JavaClassSource> field) {
		boolean changeMade = false;
		validate_parameters(field);

		if ((field.getLiteralInitializer() == null) || (field.getLiteralInitializer().isEmpty())) {
			if (ModelGenUtils.isCollection(field)) {
				String qname = field.getType().getQualifiedName();
				String newType = field.getType().getQualifiedNameWithGenerics();

				switch (qname) {
				case "java.util.List":
					newType = HibernateProcessor.Literal_Class_Default_List + "<>";
					break;
				case "java.util.Set":
					newType = HibernateProcessor.Literal_Class_Default_Set + "<>";
					break;
				case "java.util.Map":
					newType = HibernateProcessor.Literal_Class_Default_Map + "<>";
					break;
				default:
					break;
				}
				field.setLiteralInitializer("new " + newType + "()");
				if (!field.getOrigin().hasImport(qname)) {
					field.getOrigin().addImport(qname);
				}
				changeMade = true;
			}
		}
		return changeMade;

	}

	/**
	 * Entity.
	 *
	 * @param field
	 *            the field
	 * @return the class
	 */
	@SuppressWarnings("rawtypes")
	public HibernateProcessor entity(final FieldSource<JavaClassSource> field) {
		validate_parameters(null, false, this.config.getSettings().get("systemName"), field);

		ModelGenUtils.addAnnotation(field, HibernateProcessor.Annotation_Class_Primary_Key_Join_Column);
		AnnotationSource annotation = ModelGenUtils.addAnnotation(field,
				HibernateProcessor.Annotation_Class_One_To_One);
		ModelGenUtils.setAnnotationValue(annotation, "cascade", HibernateProcessor.Literal_Enum_Cascade_Type_All, true,
				true, true);

		return this;
	}

	/**
	 * Generate foreign key.
	 *
	 * @param field
	 *            the field
	 * @return the string
	 */
	public String generateForeignKey(final FieldSource<JavaClassSource> field) {
		validate_parameters(field);

		String returnvalue = null;
		returnvalue = ((this.config.getSettings().get("systemName") == null) ? ""
				: this.config.getSettings().get("systemName") + "_") + field.getOrigin().getName() + "_"
				+ field.getName() + HibernateProcessor.String_Suffix_Foreign_Key;
		return returnvalue;
	}

	/**
	 * Generate mapped by.
	 *
	 * @param field
	 *            the field
	 * @param local
	 *            the local
	 * @return the string
	 */
	public String generateMappedBy(final FieldSource<JavaClassSource> field, final boolean local) {
		validate_parameters(field);

		String returnvalue = null;
		if (local) {
			returnvalue = StringUtils.uncapitalize(field.getOrigin().getName())
					+ HibernateProcessor.String_Suffix_Reference;
		} else {
			returnvalue = StringUtils.uncapitalize(field.getType().getName())
					+ HibernateProcessor.String_Suffix_Reference;
		}
		return returnvalue;
	}

	/**
	 * List entity.
	 *
	 * @param field
	 *            the field
	 * @param this.config.getSettings().get(
	 *            "rootFolder" ) the root folder
	 * @return the class
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@SuppressWarnings("rawtypes")
	public HibernateProcessor listEntity(final FieldSource<JavaClassSource> field) throws IOException {
		validate_parameters(java.util.List.class, false, this.config.getSettings().get("systemName"), field);

		AnnotationSource annotation = ModelGenUtils.addAnnotation(field,
				HibernateProcessor.Annotation_Class_One_To_Many);
		ModelGenUtils.setAnnotationValue(annotation, HibernateProcessor.String_Mapped_By, generateMappedBy(field, true),
				true, true, false);
		// ModelGenUtils.setAnnotationValue( annotation, "cascade",
		// Literal_Enum_Cascade_Type_All, true, true, true );
		// ModelGenUtils.setAnnotationValue( annotation, "fetch",
		// Literal_Enum_Fetch_Type_Lazy, true, true, true );
		// ModelGenUtils.setAnnotationValue( annotation, "orphanRemoval",
		// "true", true, true, true );

		annotation = ModelGenUtils.addAnnotation(field, HibernateProcessor.Annotation_Class_Order_Column);
		ModelGenUtils.setAnnotationValue(annotation, HibernateProcessor.String_Name, field.getName() + "_index", true,
				true, false);

		// Alt for Annotation_Class_Order_Column, @OrderBy("number")

		JavaClassSource javaClass = ModelGenUtils.getOrCreateClass(field.getOrigin().getPackage(),
				ModelGenUtils.getCollectionType(field, true), new File(this.config.getSettings().get("rootFolder") + "/"
						+ ModelGenUtils.getCollectionType(field, true) + ".java"));

		// Roaster.parse( JavaClassSource.class, new FileInputStream( new File(
		// this.config.getSettings().get( "rootFolder" ) + "/" +
		// ModelGenUtils.getCollectionType( field, true ) + ".java" ) ) );

		if (!ModelGenUtils.hasField(javaClass, generateMappedBy(field, true), field.getOrigin().getQualifiedName())) {
			FieldSource<JavaClassSource> refField = javaClass.addField();
			refField.setName(generateMappedBy(field, true));
			refField.setProtected();
			refField.setType(field.getOrigin().getQualifiedName());
		}
		FieldSource<JavaClassSource> refField = ModelGenUtils.getField(javaClass, generateMappedBy(field, true),
				field.getOrigin().getQualifiedName());
		validate_parameters(null, false, this.config.getSettings().get("systemName"), refField);

//		ModelGenUtils.addAnnotation(refField, Jackson1Processor.Annotation_Class_Json_Ignore);
//		ModelGenUtils.addAnnotation(refField, Jackson2Processor.Annotation_Class_Json_Ignore);
//		ModelGenUtils.addAnnotation(refField, GsonProcessor.Annotation_Class_Gson_Exclude);
//		ModelGenUtils.addAnnotation(refField, JaxBProcessor.Annotation_Class_Xml_Transient_Element);

		listEntityEntry(refField);

		ModelGenUtils.saveFile(javaClass, new File(this.config.getSettings().get("rootFolder") + "/"
				+ ModelGenUtils.getCollectionType(field, true) + ".java"));

		return this;
	}

	/**
	 * List entity entry.
	 *
	 * @param field
	 *            the field
	 * @return the class
	 */
	public HibernateProcessor listEntityEntry(final FieldSource<JavaClassSource> field) {
		validate_parameters(null, false, this.config.getSettings().get("systemName"), field);

		ModelGenUtils.addAnnotation(field, HibernateProcessor.Annotation_Class_Many_To_One);

		return this;
	}

	/**
	 * List primitive.
	 *
	 * @param field
	 *            the field
	 * @return the class
	 */
	@SuppressWarnings("rawtypes")
	public HibernateProcessor listPrimitive(final FieldSource<JavaClassSource> field) {
		validate_parameters(java.util.List.class, true, this.config.getSettings().get("systemName"), field);

		ModelGenUtils.addAnnotation(field, HibernateProcessor.Annotation_Class_Element_Collection);
		AnnotationSource annotation = ModelGenUtils.addAnnotation(field,
				HibernateProcessor.Annotation_Class_Collection_Table);
		ModelGenUtils.setAnnotationValue(annotation, HibernateProcessor.String_Name,
				((this.config.getSettings().get("systemName") == null) ? ""
						: this.config.getSettings().get("systemName") + "_") + field.getOrigin().getName() + "_"
						+ field.getName(),
				true, true, false);
		// ModelGenUtils.setAnnotationValue( annotation, "joinColumns", "{ @" +
		// Literal_Class_Join_Column + "( name = \"" +
		// String_Hibernate_System_Id + "\" ) }", true, true, true );
		annotation = ModelGenUtils.addAnnotation(field, HibernateProcessor.Annotation_Class_Column);
		ModelGenUtils.setAnnotationValue(annotation, HibernateProcessor.String_Name, field.getName(), true, true,
				false);

		annotation = ModelGenUtils.addAnnotation(field, HibernateProcessor.Annotation_Class_Order_Column);
		ModelGenUtils.setAnnotationValue(annotation, HibernateProcessor.String_Name, field.getName() + "_index", true,
				true, false);

		return this;
	}

	/**
	 * Map entity entity.
	 *
	 * @param field
	 *            the field
	 * @return the class
	 */
	@SuppressWarnings("rawtypes")
	public HibernateProcessor mapEntityEntity(final FieldSource<JavaClassSource> field) {
		validate_parameters_map(false, false, this.config.getSettings().get("systemName"), field);

		AnnotationSource annotation = ModelGenUtils.addAnnotation(field, HibernateProcessor.Annotation_Class_Column);
		ModelGenUtils.setAnnotationValue(annotation, HibernateProcessor.String_Name, field.getName(), true, true,
				false);

		annotation = ModelGenUtils.addAnnotation(field, HibernateProcessor.Annotation_Class_Map_Key_Join_Column);
		ModelGenUtils.setAnnotationValue(annotation, HibernateProcessor.String_Name,
				field.getName() + HibernateProcessor.String_Suffix_Id, true, true, false);

		annotation = ModelGenUtils.addAnnotation(field, HibernateProcessor.Annotation_Class_Join_Table);
		ModelGenUtils.setAnnotationValue(annotation, HibernateProcessor.String_Name,
				((this.config.getSettings().get("systemName") == null) ? ""
						: this.config.getSettings().get("systemName") + "_") + field.getOrigin().getName() + "_"
						+ field.getName(),
				true, true, false);
		ModelGenUtils.setAnnotationValue(annotation, "joinColumns",
				"{ @" + HibernateProcessor.Literal_Class_Join_Column + "( name = \""
						+ StringUtils.uncapitalize(field.getOrigin().getName()) + HibernateProcessor.String_Suffix_Id
						+ "\", referencedColumnName=\"" + HibernateProcessor.String_Hibernate_System_Id + "\" ), @"
						+ HibernateProcessor.Literal_Class_Join_Column + "( name = \""
						+ StringUtils.uncapitalize(field.getName()) + HibernateProcessor.String_Suffix_Id
						+ "\", referencedColumnName=\"" + field.getName() + "\" ) }",
				true, true, true);

		return this;
	}

	/**
	 * Map entity primitive.
	 *
	 * @param field
	 *            the field
	 * @return the class
	 */
	@SuppressWarnings("rawtypes")
	public HibernateProcessor mapEntityPrimitive(final FieldSource<JavaClassSource> field) {
		validate_parameters_map(false, true, this.config.getSettings().get("systemName"), field);

		AnnotationSource annotation = ModelGenUtils.addAnnotation(field,
				HibernateProcessor.Annotation_Class_Element_Collection);
		annotation = ModelGenUtils.addAnnotation(field, HibernateProcessor.Annotation_Class_Column);
		ModelGenUtils.setAnnotationValue(annotation, HibernateProcessor.String_Name, field.getName(), true, true,
				false);

		annotation = ModelGenUtils.addAnnotation(field, HibernateProcessor.Annotation_Class_Map_Key_Join_Column);
		ModelGenUtils.setAnnotationValue(annotation, HibernateProcessor.String_Name,
				field.getName() + HibernateProcessor.String_Suffix_Id, true, true, false);

		annotation = ModelGenUtils.addAnnotation(field, HibernateProcessor.Annotation_Class_Collection_Table);
		ModelGenUtils.setAnnotationValue(annotation, HibernateProcessor.String_Name,
				((this.config.getSettings().get("systemName") == null) ? ""
						: this.config.getSettings().get("systemName") + "_") + field.getOrigin().getName() + "_"
						+ field.getName(),
				true, true, false);

		ModelGenUtils.setAnnotationValue(annotation, "joinColumns",
				"{ @" + HibernateProcessor.Literal_Class_Join_Column + "( name = \""
						+ StringUtils.uncapitalize(field.getOrigin().getName()) + HibernateProcessor.String_Suffix_Id
						+ "\", referencedColumnName=\"" + HibernateProcessor.String_Hibernate_System_Id + "\" ), @"
						+ HibernateProcessor.Literal_Class_Join_Column + "( name = \""
						+ StringUtils.uncapitalize(field.getName()) + HibernateProcessor.String_Suffix_Id
						+ "\", referencedColumnName=\"" + field.getName() + "\" ) }",
				true, true, true);

		return this;
	}

	/**
	 * Map primitive entity.
	 *
	 * @param field
	 *            the field
	 * @return the class
	 */
	@SuppressWarnings("rawtypes")
	public HibernateProcessor mapPrimitiveEntity(final FieldSource<JavaClassSource> field) {
		validate_parameters_map(true, false, this.config.getSettings().get("systemName"), field);

		ModelGenUtils.addAnnotation(field, HibernateProcessor.Annotation_Class_One_To_Many);

		// Begin Try
		AnnotationSource annotation = ModelGenUtils.addAnnotation(field,
				HibernateProcessor.Annotation_Class_Element_Collection);
		ModelGenUtils.setAnnotationValue(annotation, "fetch", HibernateProcessor.Literal_Enum_Fetch_Type_Eager, true,
				true, true);

		annotation = ModelGenUtils.addAnnotation(field, HibernateProcessor.Annotation_Class_Column);
		ModelGenUtils.setAnnotationValue(annotation, HibernateProcessor.String_Name, field.getName(), true, true,
				false);
		// End Try

		annotation = ModelGenUtils.addAnnotation(field, HibernateProcessor.Annotation_Class_Join_Table);
		ModelGenUtils.setAnnotationValue(annotation, HibernateProcessor.String_Name,
				((this.config.getSettings().get("systemName") == null) ? ""
						: this.config.getSettings().get("systemName") + "_") + field.getOrigin().getName() + "_"
						+ field.getName(),
				true, true, false);
		// ModelGenUtils.setAnnotationValue( annotation, "joinColumns", "{ @" +
		// Literal_Class_Join_Column + "( name = \"" +
		// String_Hibernate_System_Id + "\" ) }", true, true, true );

		annotation = ModelGenUtils.addAnnotation(field, HibernateProcessor.Annotation_Class_Map_Key_Column);
		ModelGenUtils.setAnnotationValue(annotation, HibernateProcessor.String_Name,
				StringUtils.uncapitalize(ModelGenUtils.getMapType(field, 1, true))
						+ HibernateProcessor.String_Suffix_Id,
				true, true, false);

		return this;
	}

	/**
	 * Map primitive entity entry.
	 *
	 * @param field
	 *            the field
	 * @return the class
	 */
	public HibernateProcessor mapPrimitiveEntityEntry(final FieldSource<JavaClassSource> field) {
		validate_parameters(null, false, this.config.getSettings().get("systemName"), field);

		ModelGenUtils.addAnnotation(field, HibernateProcessor.Annotation_Class_Many_To_One);

		return this;
	}

	/**
	 * Map primitive primitive.
	 *
	 * @param field
	 *            the field
	 * @return the class
	 */
	@SuppressWarnings("rawtypes")
	public HibernateProcessor mapPrimitivePrimitive(final FieldSource<JavaClassSource> field) {
		validate_parameters_map(true, true, this.config.getSettings().get("systemName"), field);

		AnnotationSource annotation = ModelGenUtils.addAnnotation(field,
				HibernateProcessor.Annotation_Class_Element_Collection);
		ModelGenUtils.setAnnotationValue(annotation, "fetch", HibernateProcessor.Literal_Enum_Fetch_Type_Lazy, true,
				true, true);

		annotation = ModelGenUtils.addAnnotation(field, HibernateProcessor.Annotation_Class_Column);
		ModelGenUtils.setAnnotationValue(annotation, HibernateProcessor.String_Name, field.getName(), true, true,
				false);

		annotation = ModelGenUtils.addAnnotation(field, HibernateProcessor.Annotation_Class_Collection_Table);
		ModelGenUtils.setAnnotationValue(annotation, HibernateProcessor.String_Name,
				((this.config.getSettings().get("systemName") == null) ? ""
						: this.config.getSettings().get("systemName") + "_") + field.getOrigin().getName() + "_"
						+ field.getName(),
				true, true, false);
		ModelGenUtils.setAnnotationValue(annotation, "joinColumns", "{ @" + HibernateProcessor.Literal_Class_Join_Column
				+ "( name = \"" + field.getName() + HibernateProcessor.String_Suffix_Id + "\" ) }", true, true, true);
		// @CollectionTable(name="example_attributes",
		// joinColumns=@JoinColumn(name="example_id"))
		annotation = ModelGenUtils.addAnnotation(field, HibernateProcessor.Annotation_Class_Map_Key_Column);
		ModelGenUtils.setAnnotationValue(annotation, HibernateProcessor.String_Name,
				StringUtils.uncapitalize(field.getType().getName()) + HibernateProcessor.String_Suffix_Id, true, true,
				false);

		return this;
	}

	/**
	 * Primitive.
	 *
	 * @param field
	 *            the field
	 * @return the class
	 */
	@SuppressWarnings("rawtypes")
	public HibernateProcessor primitive(final FieldSource<JavaClassSource> field) {
		validate_parameters(null, true, this.config.getSettings().get("systemName"), field);

		AnnotationSource annotation = ModelGenUtils.addAnnotation(field, HibernateProcessor.Annotation_Class_Column);
		ModelGenUtils.setAnnotationValue(annotation, HibernateProcessor.String_Name, field.getName(), true, true,
				false);

		switch (field.getType().getQualifiedName()) {
		case "boolean":
		case "java.lang.Boolean":
			annotation = ModelGenUtils.addAnnotation(field, HibernateProcessor.Annotation_Class_Type);
			ModelGenUtils.setAnnotationValue(annotation, "type", "true_false", true, true, false);
			break;
		case "java.util.Date":
			annotation = ModelGenUtils.addAnnotation(field, HibernateProcessor.Annotation_Class_Type);
			ModelGenUtils.setAnnotationValue(annotation, "type", "java.sql.Timestamp", true, true, false);
			break;
		case "java.util.Calendar":
		case "java.sql.Date":
		case "java.sql.Time":
		case "java.sql.Timestamp":
		case "java.util.Locale":
		case "java.util.TimeZone":
		case "java.util.Currency":
		case "java.lang.Class":
		default:
			break;
		}

		return this;
	}

	/**
	 * Sets the entity.
	 *
	 * @param field
	 *            the field
	 * @param this.config.getSettings().get(
	 *            "rootFolder" ) the root folder
	 * @return the class
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@SuppressWarnings("rawtypes")
	public HibernateProcessor setEntity(final FieldSource<JavaClassSource> field) throws IOException {
		validate_parameters(java.util.Set.class, false, this.config.getSettings().get("systemName"), field);

		AnnotationSource annotation = ModelGenUtils.addAnnotation(field,
				HibernateProcessor.Annotation_Class_One_To_Many);
		ModelGenUtils.setAnnotationValue(annotation, HibernateProcessor.String_Mapped_By, generateMappedBy(field, true),
				true, true, false);
		// ModelGenUtils.setAnnotationValue( annotation, "cascade",
		// Literal_Enum_Cascade_Type_All, true, true, true );
		// ModelGenUtils.setAnnotationValue( annotation, "fetch",
		// Literal_Enum_Fetch_Type_Lazy, true, true, true );
		// ModelGenUtils.setAnnotationValue( annotation, "orphanRemoval",
		// "true", true, true, true );

		FileInputStream in = new FileInputStream(new File(this.config.getSettings().get("rootFolder") + "/"
				+ ModelGenUtils.getCollectionType(field, true) + ".java"));
		JavaClassSource javaClass = Roaster.parse(JavaClassSource.class, in);

		if (!ModelGenUtils.hasField(javaClass, generateMappedBy(field, true), field.getOrigin().getQualifiedName())) {
			FieldSource<JavaClassSource> refField = javaClass.addField();
			refField.setProtected();
			refField.setType(field.getOrigin().getQualifiedName());
			refField.setName(generateMappedBy(field, true));
		}
		FieldSource<JavaClassSource> refField = ModelGenUtils.getField(javaClass, generateMappedBy(field, true),
				field.getOrigin().getQualifiedName());
		validate_parameters(null, false, this.config.getSettings().get("systemName"), refField);

//		ModelGenUtils.addAnnotation(refField, Jackson1Processor.Annotation_Class_Json_Ignore);
//		ModelGenUtils.addAnnotation(refField, Jackson2Processor.Annotation_Class_Json_Ignore);
//		ModelGenUtils.addAnnotation(refField, GsonProcessor.Annotation_Class_Gson_Exclude);
//		ModelGenUtils.addAnnotation(refField, JaxBProcessor.Annotation_Class_Xml_Transient_Element);

		listEntityEntry(refField);

		ModelGenUtils.saveFile(javaClass, new File(this.config.getSettings().get("rootFolder") + "/"
				+ ModelGenUtils.getCollectionType(field, true) + ".java"));

		return this;
	}

	/**
	 * Sets the entity entry.
	 *
	 * @param field
	 *            the field
	 * @return the class
	 */
	@SuppressWarnings("rawtypes")
	public HibernateProcessor setEntityEntry(final FieldSource<JavaClassSource> field) {
		validate_parameters(null, false, this.config.getSettings().get("systemName"), field);

		ModelGenUtils.addAnnotation(field, HibernateProcessor.Annotation_Class_Many_To_One);

		AnnotationSource annotation = ModelGenUtils.addAnnotation(field,
				HibernateProcessor.Annotation_Class_Join_Column);
		ModelGenUtils.setAnnotationValue(annotation, HibernateProcessor.String_Name, generateForeignKey(field), true,
				true, false);
		// TODO ModelGenUtils.setAnnotationValue( annotation, String_Name,
		// String_Hibernate_System_Id, true, true, false );
		// ModelGenUtils.setAnnotationValue( annotation, "nullable", "true",
		// true, true, true );

		return this;
	}

	/**
	 * Set-Primitive One_to_many_set_primitive_basic.
	 *
	 * @param field
	 *            the field
	 * @return the class
	 */
	@SuppressWarnings("rawtypes")
	public HibernateProcessor setPrimitive(final FieldSource<JavaClassSource> field) {
		validate_parameters(java.util.Set.class, true, this.config.getSettings().get("systemName"), field);

		AnnotationSource annotation = ModelGenUtils.addAnnotation(field,
				HibernateProcessor.Annotation_Class_Element_Collection);
		// ModelGenUtils.setAnnotationValue( annotation, "fetch",
		// Literal_Enum_Fetch_Type_Lazy, true, true, true );
		// String primClass = ModelGenUtils.getCollectionType( field );
		// primClass = ( primClass.equals( "int" ) ) ? "Integer" : primClass;
		// primClass = ( primClass.contains( "." ) ) ? primClass : "java.lang."
		// + StringUtils.capitalize( primClass );
		// ModelGenUtils.setAnnotationValue( annotation, "targetClass",
		// primClass + ".class", true, true, true );

		annotation = ModelGenUtils.addAnnotation(field, HibernateProcessor.Annotation_Class_Collection_Table);
		ModelGenUtils.setAnnotationValue(annotation, HibernateProcessor.String_Name,
				((this.config.getSettings().get("systemName") == null) ? ""
						: this.config.getSettings().get("systemName") + "_") + field.getOrigin().getName() + "_"
						+ field.getName(),
				true, true, false);
		// ModelGenUtils.setAnnotationValue( annotation, "joinColumns", "{ @" +
		// Literal_Class_Join_Column + "( name = \"" +
		// String_Hibernate_System_Id + "\" ) }", true, true, true );

		annotation = ModelGenUtils.addAnnotation(field, HibernateProcessor.Annotation_Class_Column);
		ModelGenUtils.setAnnotationValue(annotation, HibernateProcessor.String_Name, field.getName(), true, true,
				false);

		return this;
	}

	/**
	 * Validate_parameters.
	 *
	 * @param collectionType
	 *            the collection type
	 * @param primitive
	 *            the primitive
	 * @param systemName
	 *            the system name
	 * @param field
	 *            the field
	 * @return the class
	 */
	public HibernateProcessor validate_parameters(final Class<?> collectionType, final boolean primitive,
			final String systemName, final FieldSource<JavaClassSource> field) {
		validate_parameters(field);

		switch ((collectionType == null) ? " " : collectionType.getName()) {
		case "java.util.Set":
			if (!ModelGenUtils.isSet(field)) {
				// Throw exception here.
			}
			break;
		case "java.util.List":
			if (!ModelGenUtils.isList(field)) {
				// Throw exception here.
			}
			break;
		default:
			if (ModelGenUtils.isCollection(field)) {
				// Throw exception here.
			}
			break;
		}

		switch ((collectionType == null) ? " " : collectionType.getName()) {
		case "java.util.Set":
		case "java.util.List":
			if (primitive) {
				if (!ModelGenUtils.isCollectionPrimitive(field)) {
					// Throw exception here.
				}
			} else {
				if (ModelGenUtils.isCollectionPrimitive(field)) {
					// Throw exception here.
				}
			}
			break;
		default:
			if (primitive) {
				if (!ModelGenUtils.isPrimitive(field)) {
					// Throw exception here.
				}
			} else {
				if (ModelGenUtils.isPrimitive(field)) {
					// Throw exception here.
				}
			}
			break;
		}

		return this;
	}

	/**
	 * Validate_parameters.
	 *
	 * @param field
	 *            the field
	 * @return the class
	 */
	public HibernateProcessor validate_parameters(final FieldSource<JavaClassSource> field) {
		if (field == null) {
			// Throw exception here.
		}

		if ((field.getName() == null) || (field.getName().isEmpty())) {
			// Throw exception here.
		}

		if (field.getOrigin() == null) {
			// Throw exception here.
		}

		if ((field.getOrigin().getName() == null) || (field.getOrigin().getName().isEmpty())) {
			// Throw exception here.
		}

		return this;
	}

	/**
	 * Validate_parameters_map.
	 *
	 * @param primitiveKey
	 *            the primitive key
	 * @param primitiveValue
	 *            the primitive value
	 * @param systemName
	 *            the system name
	 * @param field
	 *            the field
	 * @return the class
	 */
	public HibernateProcessor validate_parameters_map(final boolean primitiveKey, final boolean primitiveValue,
			final String systemName, final FieldSource<JavaClassSource> field) {
		validate_parameters(field);

		if (!ModelGenUtils.isMap(field)) {
			// Throw exception here.
		}

		if (primitiveKey) {
			if (!ModelGenUtils.isPrimitive(ModelGenUtils.getMapType(field, 0))) {
				// Throw exception here.
			}
		} else {
			if (ModelGenUtils.isPrimitive(ModelGenUtils.getMapType(field, 0))) {
				// Throw exception here.
			}
		}

		if (primitiveValue) {
			if (!ModelGenUtils.isPrimitive(ModelGenUtils.getMapType(field, 1))) {
				// Throw exception here.
			}
		} else {
			if (ModelGenUtils.isPrimitive(ModelGenUtils.getMapType(field, 1))) {
				// Throw exception here.
			}
		}

		return this;
	}

	/**
	 * Instantiates a new hibernate processor.
	 */
	public HibernateProcessor() {
		super();
	}

	/**
	 * Instantiates a new hibernate processor.
	 *
	 * @param this.config.getSettings().get(
	 *            "rootFolder" ) the root folder
	 */
	public HibernateProcessor(final ProcessorSettings config) {
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
			if (!ModelGenUtils.isAnnotationPresent(field, HibernateProcessor.Annotation_Class_Transient)) {
				if (field.getName().endsWith(HibernateProcessor.String_Suffix_Reference)) {
					// We Do Nothing Here. Old code commented out for reference.

					// AnnotationSource annotation =
					// ModelGenUtils.addAnnotation( field,
					// Annotation_Class_Join_Column );
					// ModelGenUtils.setAnnotationValue( annotation,
					// String_Name, String_Hibernate_System_Id, true, true,
					// false );
					// ModelGenUtils.setAnnotationValue( annotation, "nullable",
					// "true", true, true, true );
					//
					// /* If Parent Is List */
					// annotation = ModelGenUtils.addAnnotation( field,
					// Annotation_Class_Many_To_One );
					// ModelGenUtils.setAnnotationValue( annotation, "fetch",
					// Literal_Enum_Fetch_Type_Eager, true, true, true );
					//
					// /* If Parent Is Entity */
					// annotation = ModelGenUtils.addAnnotation( field,
					// Annotation_Class_One_To_One );
					// ModelGenUtils.setAnnotationValue( annotation, "fetch",
					// Literal_Enum_Fetch_Type_Eager, true, true, true );
					//
					// changeMade = true;
				} else {
					if (ModelGenUtils.isPrimitive(field)) {
						primitive(field);
						changeMade = true;
					} else if (ModelGenUtils.isCollection(field)) {
						if (ModelGenUtils.isMap(field)) {
							if (ModelGenUtils.isMapPrimitivePrimitive(field)) {
								mapPrimitivePrimitive(field);
								changeMade = true;
							} else if (ModelGenUtils.isMapPrimitiveEntity(field)) {
								mapPrimitiveEntity(field);
								changeMade = true;
							} else if (ModelGenUtils.isMapEntityPrimitive(field)) {
								mapEntityPrimitive(field);
								changeMade = true;
							} else if (ModelGenUtils.isMapEntityEntity(field)) {
								mapEntityEntity(field);
								changeMade = true;
							}
						} else {
							if (ModelGenUtils.isCollectionPrimitive(field)) {
								if (ModelGenUtils.isList(field)) {
									listPrimitive(field);
									changeMade = true;
								} else if (ModelGenUtils.isSet(field)) {
									setPrimitive(field);
									changeMade = true;
								}
							} else {
								if (ModelGenUtils.isList(field)) {
									try {
										listEntity(field);
									} catch (IOException e) {
										e.printStackTrace();
									}
									changeMade = true;
								} else if (ModelGenUtils.isSet(field)) {
									try {
										setEntity(field);
									} catch (IOException e) {
										e.printStackTrace();
									}
									changeMade = true;
								}
							}
						}
						if (defaultInitializer(field)) {
							changeMade = true;
						}
					} else {
						entity(field);
						changeMade = true;
					}
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
	@SuppressWarnings("rawtypes")
	@Override
	public void processMainClass(final JavaClassSource javaClass) {
		AnnotationSource annotation = ModelGenUtils.addAnnotation(javaClass,
				HibernateProcessor.Annotation_Class_Entity);
		ModelGenUtils
				.setAnnotationValue(annotation, HibernateProcessor.String_Name,
						((this.config.getSettings().get("systemName") == null) ? ""
								: this.config.getSettings().get("systemName") + "_") + javaClass.getName(),
						true, true, false);
		annotation = ModelGenUtils.addAnnotation(javaClass, HibernateProcessor.Annotation_Class_Table);
		ModelGenUtils
				.setAnnotationValue(annotation, HibernateProcessor.String_Name,
						((this.config.getSettings().get("systemName") == null) ? ""
								: this.config.getSettings().get("systemName") + "_") + javaClass.getName(),
						true, true, false);
		ModelGenUtils.setAnnotationValue(
				annotation, "uniqueConstraints", "@" + HibernateProcessor.Literal_Class_Unique_Constraint
						+ "( columnNames = { \"" + HibernateProcessor.String_Hibernate_System_Id + "\"} )",
				true, true, true);

		ModelGenUtils.addAnnotation(javaClass, Annotation_Class_Named_Queries);

		int queryCount = 0;
		try {
			queryCount = javaClass.getAnnotation(Annotation_Class_Named_Queries).getAnnotationArrayValue().length;
		} catch (Exception e) {

		}

		boolean found = false;

		for (String hItem : List_Hibernate_Fields) {
			if (queryCount > 0) {
				AnnotationSource<JavaClassSource>[] queries = javaClass.getAnnotation(Annotation_Class_Named_Queries)
						.getAnnotationArrayValue();
				for (AnnotationSource<JavaClassSource> query : queries) {
					if (query.getStringValue("name").equals(javaClass.getPackage() + "." + javaClass.getName() + "."
							+ ((hItem.isEmpty()) ? "all" : hItem))) {
						found = true;
						break;
					}
				}
			}

			if (!found) {
				AnnotationSource<JavaClassSource> newQ = javaClass.getAnnotation(Annotation_Class_Named_Queries)
						.addAnnotationValue().setName(Literal_Class_Named_Query);
				newQ.setStringValue("name",
						javaClass.getPackage() + "." + javaClass.getName() + "." + ((hItem.isEmpty()) ? "all" : hItem));
				newQ.setStringValue("query", "SELECT a FROM " + javaClass.getName() + " a"
						+ ((hItem.isEmpty()) ? "" : " WHERE a." + hItem + " = " + ":" + hItem));
			}
		}

		for (FieldSource<JavaClassSource> field : javaClass.getFields()) {
			found = false;
			if ((!field.getName().endsWith(String_Suffix_Reference)) && (!ModelGenUtils.isCollection(field))) {
				if (queryCount > 0) {
					AnnotationSource<JavaClassSource>[] queries = javaClass
							.getAnnotation(Annotation_Class_Named_Queries).getAnnotationArrayValue();
					for (AnnotationSource<JavaClassSource> query : queries) {
						if (query.getStringValue("name")
								.equals(javaClass.getPackage() + "." + javaClass.getName() + "." + field.getName())) {
							found = true;
							break;
						}
					}
				}

				if (!found) {
					AnnotationSource<JavaClassSource> newQ = javaClass.getAnnotation(Annotation_Class_Named_Queries)
							.addAnnotationValue().setName(Literal_Class_Named_Query);
					newQ.setStringValue("name",
							javaClass.getPackage() + "." + javaClass.getName() + "." + field.getName());
					newQ.setStringValue("query", "SELECT a FROM " + javaClass.getName() + " a WHERE a."
							+ field.getName() + " = :" + field.getName());
				}
			}
		}

		changeMade = true;
	}

}
