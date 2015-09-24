/* @(#)ModelGenUtils.java Sep 12, 2015
 *
 * Copyright (c) 2015. All rights reserved.
 */

package io.github.rampantlions.codetools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.regex.Pattern;

import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.ValuePair;
import org.jboss.forge.roaster.model.source.AnnotationSource;
import org.jboss.forge.roaster.model.source.AnnotationTargetSource;
import org.jboss.forge.roaster.model.source.FieldSource;
import org.jboss.forge.roaster.model.source.JavaClassSource;
import org.jboss.forge.roaster.model.source.JavaInterfaceSource;
import org.jboss.forge.roaster.model.source.JavaSource;
import org.jboss.forge.roaster.model.source.MethodSource;

/**
 * The Class ModelGenUtils.
 *
 * @author Wiechman, Joshua <josh.wiechman@gmail.com>
 */
public class ModelGenUtils
{

	/**
	 * Adds the annotation.
	 *
	 * @param objectToAnnotate the object to annotate
	 * @param clazz the clazz
	 * @return the annotation source
	 */
	@SuppressWarnings( { "rawtypes" } )
	public static AnnotationSource addAnnotation( AnnotationTargetSource objectToAnnotate, Class< ? extends Annotation > clazz )
	{
		return addAnnotation( objectToAnnotate, clazz, true );
	}

	/**
	 * Adds the annotation.
	 *
	 * @param objectToAnnotate the object to annotate
	 * @param clazz the clazz
	 * @param omitIfPresent the omit if present
	 * @return the annotation source
	 */
	@SuppressWarnings( { "rawtypes", "unchecked" } )
	public static AnnotationSource addAnnotation( AnnotationTargetSource objectToAnnotate, Class< ? extends Annotation > clazz, boolean omitIfPresent )
	{
		AnnotationSource returnvalue = null;
		if ( ( !omitIfPresent ) || ( ( omitIfPresent ) && ( !isAnnotationPresent( objectToAnnotate, clazz ) ) ) )
		{
			returnvalue = objectToAnnotate.addAnnotation().setName( clazz.getCanonicalName() );
		}
		else
		{
			returnvalue = objectToAnnotate.getAnnotation( clazz );
		}
		return returnvalue;
	}

	/**
	 * Adds the import.
	 *
	 * @param <JavaT> the generic type
	 * @param javaClass the java class
	 * @param clazz the clazz
	 * @return the java class source
	 */
	@SuppressWarnings( "rawtypes" )
	public static < JavaT extends JavaSource > JavaT addImport( JavaT javaClass, Class< ? > clazz )
	{
		return addImport( javaClass, clazz, true );
	}

	/**
	 * Adds the import.
	 *
	 * @param <JavaT> the generic type
	 * @param javaClass the java class
	 * @param clazz the clazz
	 * @param omitIfPresent the omit if present
	 * @return the java class source
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" } )
	public static < JavaT extends JavaSource > JavaT addImport( JavaT javaClass, Class< ? > clazz, boolean omitIfPresent )
	{
		if ( ( !omitIfPresent ) || ( ( omitIfPresent ) && ( !isImportPresent( javaClass, clazz ) ) ) )
		{
			javaClass.addImport( clazz );
		}
		return javaClass;
	}

	/**
	 * Gets the collection dt pos.
	 *
	 * @param field the field
	 * @return the collection dt pos
	 */
	public static int getCollectionDtPos( FieldSource< JavaClassSource > field )
	{
		/* Other methods depend on a non collection having a position of < 0. */
		int position = -1;

		if ( isList( field ) )
		{
			position = 0;
		}
		else if ( isSet( field ) )
		{
			position = 0;
		}
		else if ( isMap( field ) )
		{
			position = 1;
		}

		return position;
	}

	/**
	 * Gets the collection type.
	 *
	 * @param field the field
	 * @return the collection type
	 */
	public static String getCollectionType( FieldSource< JavaClassSource > field )
	{
		return getCollectionType( field, false );
	}

	/**
	 * Gets the collection type.
	 *
	 * @param field the field
	 * @param simple the simple
	 * @return the collection type
	 */
	public static String getCollectionType( FieldSource< JavaClassSource > field, boolean simple )
	{
		String returnvalue = null;
		if ( isCollection( field ) )
		{
			if ( simple )
			{
				// returnvalue = field.getType().getTypeArguments().get( getCollectionDtPos( field ) ).getName();
				String split[] = field.getType().getTypeArguments().get( getCollectionDtPos( field ) ).getName().split( Pattern.quote( "." ) );
				returnvalue = split[split.length - 1];
			}
			else
			{
				returnvalue = field.getType().getTypeArguments().get( getCollectionDtPos( field ) ).getQualifiedName();
			}
		}
		return returnvalue;
	}

	/**
	 * Gets the field.
	 *
	 * @param javaClass the java class
	 * @param fieldName the field name
	 * @return the field
	 */
	public static FieldSource< JavaClassSource > getField( JavaClassSource javaClass, String fieldName )
	{
		for ( FieldSource< JavaClassSource > field : javaClass.getFields() )
		{
			if ( field.getName().equals( fieldName ) )
			{
				return field;
			}
		}
		return null;
	}

	/**
	 * Gets the field.
	 *
	 * @param javaClass the java class
	 * @param fieldName the field name
	 * @param fieldType the field type
	 * @return the field
	 */
	public static FieldSource< JavaClassSource > getField( JavaClassSource javaClass, String fieldName, String fieldType )
	{
		for ( FieldSource< JavaClassSource > field : javaClass.getFields() )
		{
			if ( field.getName().equals( fieldName ) )
			{
				if ( field.getType().getQualifiedName().equals( fieldType ) || field.getType().getQualifiedNameWithGenerics().equals( fieldType ) || field.getType().getName().equals( fieldType ) )
				{
					return field;
				}
			}
		}
		return null;
	}

	/**
	 * Gets the map type.
	 *
	 * @param field the field
	 * @param position the position
	 * @return the map type
	 */
	public static String getMapType( FieldSource< JavaClassSource > field, int position )
	{
		return getMapType( field, position, false );
	}

	/**
	 * Gets the map type.
	 *
	 * @param field the field
	 * @param position the position
	 * @param simple the simple
	 * @return the map type
	 */
	public static String getMapType( FieldSource< JavaClassSource > field, int position, boolean simple )
	{
		String returnvalue = null;
		if ( isMap( field ) )
		{
			if ( simple )
			{
				returnvalue = field.getType().getTypeArguments().get( position ).getName();
			}
			else
			{
				returnvalue = field.getType().getTypeArguments().get( position ).getQualifiedName();
			}
		}
		return returnvalue;
	}

	/**
	 * Gets the method.
	 *
	 * @param javaClass the java class
	 * @param methodName the method name
	 * @param returnType the return type
	 * @return the method
	 */
	public static MethodSource< JavaClassSource > getMethod( JavaClassSource javaClass, String methodName, String returnType )
	{
		for ( MethodSource< JavaClassSource > method : javaClass.getMethods() )
		{
			if ( method.getName().equals( methodName ) )
			{
				if ( method.getReturnType().getQualifiedName().equals( returnType ) || method.getReturnType().getQualifiedNameWithGenerics().equals( returnType ) || method.getReturnType().getName().equals( returnType ) )
				{
					return method;
				}
			}
		}
		return null;
	}

	/**
	 * Gets the or create class.
	 *
	 * @param packageName the package name
	 * @param name the name
	 * @param resource the resource
	 * @return the or create class
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static JavaClassSource getOrCreateClass( String packageName, String name, File resource ) throws IOException
	{
		File file = resource;
		if ( !resource.exists() )
		{
			String[] simpleName = name.split( Pattern.quote( "." ) );

			file = saveFile( Roaster.create( JavaClassSource.class ).setPackage( packageName ).setName( simpleName[simpleName.length - 1] ), file );
		}

		if ( !file.isFile() )
		{
			file = new File( file, name + ".java" );
		}

		if ( !file.exists() )
		{
			file = saveFile( Roaster.create( JavaClassSource.class ).setPackage( packageName ).setName( name ), file );
		}

		return Roaster.parse( JavaClassSource.class, new FileInputStream( file ) );
	}

	/**
	 * Gets the or create class.
	 *
	 * @param packageName the package name
	 * @param name the name
	 * @param filename the filename
	 * @return the or create class
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static JavaClassSource getOrCreateClass( String packageName, String name, String filename ) throws IOException
	{
		return getOrCreateClass( packageName, name, new File( filename ) );
	}

	/**
	 * Gets the or create interface.
	 *
	 * @param packageName the package name
	 * @param name the name
	 * @param resource the resource
	 * @return the or create interface
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static JavaInterfaceSource getOrCreateInterface( String packageName, String name, File resource ) throws IOException
	{
		File file = resource;
		if ( !resource.exists() )
		{
			file = saveFile( Roaster.create( org.jboss.forge.roaster.model.source.JavaInterfaceSource.class ).setPackage( packageName ).setName( name ), file );
		}

		if ( !file.isFile() )
		{
			file = new File( file, name + ".java" );
			System.out.println( file.getAbsolutePath() );
		}

		if ( !file.exists() )
		{
			file = saveFile( Roaster.create( org.jboss.forge.roaster.model.source.JavaInterfaceSource.class ).setPackage( packageName ).setName( name ), file );
		}

		return Roaster.parse( JavaInterfaceSource.class, new FileInputStream( file ) );
	}

	/**
	 * Checks for annotation. (Alias Method)
	 * 
	 * @param objectToAnnotate the object to annotate
	 * @param clazz the clazz
	 * @return true, if successful
	 */
	@SuppressWarnings( "rawtypes" )
	public static boolean hasAnnotation( AnnotationTargetSource objectToAnnotate, Class< ? extends Annotation > clazz )
	{
		return isAnnotationPresent( objectToAnnotate, clazz );
	}

	/**
	 * Checks for equals method.
	 *
	 * @param javaClass the java class
	 * @return true, if successful
	 */
	public static boolean hasEqualsMethod( JavaClassSource javaClass )
	{
		return hasMethod( javaClass, "equals" );
	}

	/**
	 * Checks for field.
	 *
	 * @param javaClass the java class
	 * @param fieldName the field name
	 * @return true, if successful
	 */
	public static boolean hasField( JavaClassSource javaClass, String fieldName )
	{
		return ( getField( javaClass, fieldName ) != null );
	}

	/**
	 * Checks for field.
	 *
	 * @param javaClass the java class
	 * @param fieldName the field name
	 * @param fieldType the field type
	 * @return true, if successful
	 */
	public static boolean hasField( JavaClassSource javaClass, String fieldName, String fieldType )
	{
		return ( getField( javaClass, fieldName, fieldType ) != null );
	}

	/**
	 * Checks for hash code method.
	 *
	 * @param javaClass the java class
	 * @return true, if successful
	 */
	public static boolean hasHashCodeMethod( JavaClassSource javaClass )
	{
		return hasMethod( javaClass, "hashCode" );
	}

	/**
	 * Checks for import. (Alias Method)
	 *
	 * @param <JavaT> the generic type
	 * @param javaClass the java class
	 * @param clazz the clazz
	 * @return true, if successful
	 */
	@SuppressWarnings( "rawtypes" )
	public static < JavaT extends JavaSource > boolean hasImport( JavaT javaClass, Class< ? > clazz )
	{
		return isImportPresent( javaClass, clazz );
	}

	/**
	 * Checks for method.
	 *
	 * @param javaClass the java class
	 * @param methodName the method name
	 * @return true, if successful
	 */
	public static boolean hasMethod( JavaClassSource javaClass, String methodName )
	{
		boolean matched = false;
		for ( MethodSource< JavaClassSource > method : javaClass.getMethods() )
		{
			if ( method.getName().equals( methodName ) )
			{
				matched = true;
				break;
			}
		}
		return matched;
	}

	/**
	 * Checks for to string method.
	 *
	 * @param javaClass the java class
	 * @return true, if successful
	 */
	public static boolean hasToStringMethod( JavaClassSource javaClass )
	{
		return hasMethod( javaClass, "toString" );
	}

	/**
	 * Checks if is annotation present.
	 *
	 * @param objectToAnnotate the object to annotate
	 * @param clazz the clazz
	 * @return true, if is annotation present
	 */
	@SuppressWarnings( { "rawtypes", "unchecked" } )
	public static boolean isAnnotationPresent( AnnotationTargetSource objectToAnnotate, Class< ? extends Annotation > clazz )
	{
		return ( objectToAnnotate.getAnnotation( clazz ) != null );
	}

	/**
	 * Checks if is collection.
	 *
	 * @param field the field
	 * @return true, if is collection
	 */
	public static boolean isCollection( FieldSource< JavaClassSource > field )
	{
		return ( getCollectionDtPos( field ) >= 0 );
	}

	/**
	 * Checks if is collection primitive.
	 *
	 * @param field the field
	 * @return true, if is collection primitive
	 */
	public static boolean isCollectionPrimitive( FieldSource< JavaClassSource > field )
	{
		return ( ( isCollection( field ) ) & ( isPrimitive( getCollectionType( field ) ) ) );
	}

	/**
	 * Checks if is import present.
	 *
	 * @param <JavaT> the generic type
	 * @param javaClass the java class
	 * @param clazz the clazz
	 * @return true, if is import present
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" } )
	public static < JavaT extends JavaSource > boolean isImportPresent( JavaT javaClass, Class< ? > clazz )
	{
		return ( javaClass.hasImport( clazz ) );
	}

	/**
	 * Checks if is list.
	 *
	 * @param field the field
	 * @return true, if is list
	 */
	public static boolean isList( FieldSource< JavaClassSource > field )
	{
		boolean isCollection = false;

		switch ( field.getType().getQualifiedName() )
		{
			case "java.util.List":
			case "java.util.LinkedList":
			case "java.util.ArrayList":
			case "java.util.Vector":
			case "java.util.Stack":
				isCollection = true;
				break;
			default:
				break;
		}
		return isCollection;
	}

	/**
	 * Checks if is map.
	 *
	 * @param field the field
	 * @return true, if is map
	 */
	public static boolean isMap( FieldSource< JavaClassSource > field )
	{
		boolean isCollection = false;

		switch ( field.getType().getQualifiedName() )
		{
			case "java.util.Map":
			case "java.util.HashMap":
			case "java.util.TreeMap":
			case "java.util.LinkedHashMap":
			case "java.util.WeakHashMap":
			case "java.util.IdentityHashMap":
				isCollection = true;
				break;
			default:
				break;
		}
		return isCollection;
	}

	/**
	 * Checks if is map object object.
	 *
	 * @param field the field
	 * @return true, if is map object object
	 */
	public static boolean isMapEntityEntity( FieldSource< JavaClassSource > field )
	{
		return ( ( isMap( field ) ) && ( !isPrimitive( getMapType( field, 0 ) ) ) && ( !isPrimitive( getMapType( field, 1 ) ) ) );
	}

	/**
	 * Checks if is map object primitive.
	 *
	 * @param field the field
	 * @return true, if is map object primitive
	 */
	public static boolean isMapEntityPrimitive( FieldSource< JavaClassSource > field )
	{
		return ( ( isMap( field ) ) && ( !isPrimitive( getMapType( field, 0 ) ) ) && ( isPrimitive( getMapType( field, 1 ) ) ) );
	}

	/**
	 * Checks if is map primitive object.
	 *
	 * @param field the field
	 * @return true, if is map primitive object
	 */
	public static boolean isMapPrimitiveEntity( FieldSource< JavaClassSource > field )
	{
		return ( ( isMap( field ) ) && ( isPrimitive( getMapType( field, 0 ) ) ) && ( !isPrimitive( getMapType( field, 1 ) ) ) );
	}

	/**
	 * Checks if is map primitive primitive.
	 *
	 * @param field the field
	 * @return true, if is map primitive primitive
	 */
	public static boolean isMapPrimitivePrimitive( FieldSource< JavaClassSource > field )
	{
		return ( ( isMap( field ) ) && ( isPrimitive( getMapType( field, 0 ) ) ) && ( isPrimitive( getMapType( field, 1 ) ) ) );
	}

	/**
	 * Checks if is primitive.
	 *
	 * @param field the field
	 * @return true, if is primitive
	 */
	public static boolean isPrimitive( FieldSource< JavaClassSource > field )
	{
		return isPrimitive( field.getType().getQualifiedName() );
	}

	/**
	 * Checks if is primitive.
	 *
	 * @param fieldType the field type
	 * @return true, if is primitive
	 */
	public static boolean isPrimitive( String fieldType )
	{
		boolean isPrimitive = false;
		if ( fieldType.startsWith( "java.lang." ) )
		{
			isPrimitive = true;
		}
		if ( !isPrimitive )
		{
			for ( Class< ? > prim : com.google.common.primitives.Primitives.allPrimitiveTypes() )
			{
				if ( prim.toString().equals( fieldType ) )
				{
					isPrimitive = true;
					break;
				}
			}
		}
		return isPrimitive;
	}

	/**
	 * Checks if is sets the.
	 *
	 * @param field the field
	 * @return true, if is sets the
	 */
	public static boolean isSet( FieldSource< JavaClassSource > field )
	{
		boolean isCollection = false;

		switch ( field.getType().getQualifiedName() )
		{
			case "java.util.Set":
			case "java.util.EnumSet":
			case "java.util.HashSet":
			case "java.util.LinkedHashSet":
			case "java.util.TreeSet":
				isCollection = true;
				break;
			default:
				break;
		}
		return isCollection;
	}

	/**
	 * Save file.
	 *
	 * @param javaClass the java class
	 * @param outputFile the output file
	 * @return the file
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static File saveFile( JavaClassSource javaClass, File outputFile ) throws IOException
	{
		File tmp = saveFile( javaClass, outputFile, false );
		return tmp;
	}

	/**
	 * Save file.
	 *
	 * @param javaClass the java class
	 * @param outputFile the output file
	 * @param format the format
	 * @return the file
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static File saveFile( JavaClassSource javaClass, File outputFile, boolean format ) throws IOException
	{
		File file = outputFile;
		if ( !file.exists() )
		{
			if ( file.getAbsoluteFile().toString().toUpperCase().endsWith( ".JAVA" ) )
			{
				if ( !file.getParentFile().exists() )
				{
					file.getParentFile().mkdirs();
				}
			}
			else
			{
				file.mkdirs();
			}
		}

		if ( !file.getAbsoluteFile().toString().toUpperCase().endsWith( ".JAVA" ) )
		{
			file = new File( file, javaClass.getName() + ".java" );
		}
		return saveFile( ( ( format ) ? javaClass.toString() : javaClass.toUnformattedString() ), file );
	}

	/**
	 * Save file.
	 *
	 * @param javaInterface the java interface
	 * @param outputFile the output file
	 * @return the file
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static File saveFile( org.jboss.forge.roaster.model.source.JavaInterfaceSource javaInterface, File outputFile ) throws IOException
	{
		File tmp = saveFile( javaInterface, outputFile, true );
		return tmp;
	}

	/**
	 * Save file.
	 *
	 * @param javaInterface the java interface
	 * @param outputFile the output file
	 * @param format the format
	 * @return the file
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static File saveFile( org.jboss.forge.roaster.model.source.JavaInterfaceSource javaInterface, File outputFile, boolean format ) throws IOException
	{
		File file = outputFile;
		if ( !file.exists() )
		{
			if ( file.getAbsoluteFile().toString().toUpperCase().endsWith( ".JAVA" ) )
			{
				if ( !file.getParentFile().exists() )
				{
					file.getParentFile().mkdirs();
				}
			}
			else
			{
				file.mkdirs();
			}
		}

		if ( !file.getAbsoluteFile().toString().toUpperCase().endsWith( ".JAVA" ) )
		{
			file = new File( file, javaInterface.getName() + ".java" );
		}

		return saveFile( ( ( format ) ? javaInterface.toString() : javaInterface.toUnformattedString() ), file );
	}

	/**
	 * Save file.
	 *
	 * @param content the content
	 * @param outputFile the output file
	 * @return the file
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static File saveFile( String content, File outputFile ) throws IOException
	{
		return saveFile( content, outputFile, true );
	}

	/**
	 * Save file.
	 *
	 * @param content the content
	 * @param outputFile the output file
	 * @param format the format
	 * @return the file
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static File saveFile( String content, File outputFile, boolean format ) throws IOException
	{
		FileWriter fw = new FileWriter( outputFile, false );
		// fw.write( ( ( format ) ? format( content ) : content ) );
		fw.write( content );
		fw.close();
		return outputFile;
	}

	/**
	 * Sets the annotation value.
	 *
	 * @param annotation the annotation
	 * @param value the value
	 * @param overwrite the overwrite
	 * @param multivalue the multivalue
	 * @param literal the literal
	 */
	@SuppressWarnings( { "rawtypes" } )
	public static void setAnnotationValue( AnnotationSource annotation, String value, boolean overwrite, boolean multivalue, boolean literal )
	{
		setAnnotationValue( annotation, null, value, overwrite, multivalue, literal );
	}

	/**
	 * Sets the annotation value.
	 *
	 * @param annotation the annotation
	 * @param name the name
	 * @param value the value
	 * @param overwrite the overwrite
	 * @param multivalue the multivalue
	 * @param literal the literal
	 */
	@SuppressWarnings( { "rawtypes", "unchecked" } )
	public static void setAnnotationValue( AnnotationSource annotation, String name, String value, boolean overwrite, boolean multivalue, boolean literal )
	{
		if ( ( name != null ) && ( !name.isEmpty() ) )
		{
			Iterator< ValuePair > i = annotation.getValues().iterator();
			while ( i.hasNext() )
			{
				ValuePair v = i.next();
				if ( v.getName().equals( name ) )
				{
					annotation.removeValue( name );
				}
			}

			if ( literal )
			{
				annotation.setLiteralValue( name, value );
			}
			else
			{
				annotation.setStringValue( name, value );
			}
		}
		else
		{
			if ( literal )
			{
				annotation.setLiteralValue( value );
			}
			else
			{
				annotation.setStringValue( value );
			}
		}
	}
}
