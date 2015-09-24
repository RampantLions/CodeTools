package io.github.rampantlions.codetools.hibernate.processors;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.jboss.forge.roaster.model.source.AnnotationSource;
import org.jboss.forge.roaster.model.source.FieldSource;
import org.jboss.forge.roaster.model.source.JavaClassSource;
import org.jboss.forge.roaster.model.source.MethodSource;

import io.github.rampantlions.codetools.CommonProcessor;
import io.github.rampantlions.codetools.ProcessorFacade;
import io.github.rampantlions.codetools.ProcessorSettings;

public class HibernateRemover extends CommonProcessor implements ProcessorFacade {

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
	 * Instantiates a new hibernate processor.
	 *
	 * @param this.config.getSettings().get(
	 *            "rootFolder" ) the root folder
	 */
	public HibernateRemover(final ProcessorSettings config) {
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
				case "javax.persistence.CollectionTable":
				case "javax.persistence.Column":
				case "javax.persistence.ElementCollection":
				case "javax.persistence.Entity":
				case "javax.persistence.JoinColumn":
				case "javax.persistence.JoinTable":
				case "javax.persistence.ManyToOne":
				case "javax.persistence.MapKeyColumn":
				case "javax.persistence.MapKeyJoinColumn":
				case "javax.persistence.NamedQueries":
				case "javax.persistence.NamedQuery":
				case "javax.persistence.OneToMany":
				case "javax.persistence.OneToOne":
				case "javax.persistence.OrderColumn":
				case "javax.persistence.PrimaryKeyJoinColumn":
				case "javax.persistence.Table":
				case "javax.persistence.Transient":
				case "org.hibernate.annotations.Type":
				case "javax.persistence.UniqueConstraint":
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
			case "javax.persistence.CollectionTable":
			case "javax.persistence.Column":
			case "javax.persistence.ElementCollection":
			case "javax.persistence.Entity":
			case "javax.persistence.JoinColumn":
			case "javax.persistence.JoinTable":
			case "javax.persistence.ManyToOne":
			case "javax.persistence.MapKeyColumn":
			case "javax.persistence.MapKeyJoinColumn":
			case "javax.persistence.NamedQueries":
			case "javax.persistence.NamedQuery":
			case "javax.persistence.OneToMany":
			case "javax.persistence.OneToOne":
			case "javax.persistence.OrderColumn":
			case "javax.persistence.PrimaryKeyJoinColumn":
			case "javax.persistence.Table":
			case "javax.persistence.Transient":
			case "org.hibernate.annotations.Type":
			case "javax.persistence.UniqueConstraint":
				javaClass.removeAnnotation(annotation);
				changeMade = true;
				break;
			default:
				break;
			}
		}

		for (FieldSource<JavaClassSource> field : javaClass.getFields()) {
			if (field.getName().endsWith(String_Suffix_Reference)) {

				for (MethodSource<JavaClassSource> method : javaClass.getMethods()) {
					if (method.getName().equals("get" + StringUtils.capitalize(field.getName()))
							|| method.getName().equals("set" + StringUtils.capitalize(field.getName()))) {
						javaClass.removeMethod(method);
					}
				}

				javaClass.removeField(field);
				changeMade = true;
			}
		}
	}
}
