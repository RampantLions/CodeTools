/* @(#)Swagger12Generator.java Sep 15, 2015
 *
 * Copyright (c) 2015. All rights reserved.
 */

package io.github.rampantlions.codetools.swagger.generators;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import io.github.rampantlions.codetools.http.StandAloneUtilities;
import io.github.rampantlions.codetools.restbuilder.generators.models.ApiModel;
import io.github.rampantlions.codetools.restbuilder.generators.models.FieldModel;
import io.github.rampantlions.codetools.restbuilder.generators.models.ModelModel;
import io.github.rampantlions.codetools.restbuilder.generators.models.ParameterModel;
import io.github.rampantlions.codetools.swagger.generators.models.Swagger;
import io.github.rampantlions.codetools.swagger.generators.v12.models.ApiDeclaration12;
import io.github.rampantlions.codetools.swagger.generators.v12.models.ApiObject12;
import io.github.rampantlions.codetools.swagger.generators.v12.models.ItemObject12;
import io.github.rampantlions.codetools.swagger.generators.v12.models.ModelObject12;
import io.github.rampantlions.codetools.swagger.generators.v12.models.OperationObject12;
import io.github.rampantlions.codetools.swagger.generators.v12.models.ParameterObject12;
import io.github.rampantlions.codetools.swagger.generators.v12.models.PropertyObject12;
import io.github.rampantlions.codetools.swagger.generators.v12.models.ResourceListing12;
import io.github.rampantlions.codetools.swagger.generators.v12.models.ResourceObject12;

public class Swagger12Generator extends SwaggerCommonGenerator< Swagger12Generator >
{
	static final Gson gson = io.github.rampantlions.codetools.restbuilder.generators.ModelGsonBuilder.defaultBuilder().setPrettyPrinting().registerTypeAdapter( new TypeToken< Map< String, OperationObject12 >>() {}.getType(), new MapTypeAdapter< OperationObject12 >() ).registerTypeAdapter( new TypeToken< List< ItemObject12 >>() {}.getType(), new ListTypeAdapter< ItemObject12 >() ).create();

	// .registerTypeAdapter( new TypeToken< List< Item12 >>() {}.getType(), new ListTypeAdapter< Item12 >() )
	// .registerTypeAdapter( new TypeToken< List< PropertyObject12 >>() {}.getType(), new ListTypeAdapter< PropertyObject12 >() )

	public static Class< Swagger12Generator > generate( String systemName, URL rootUrl, String packageName, File folder ) throws KeyManagementException, NoSuchAlgorithmException, IOException
	{
		return generate( systemName, rootUrl, StandAloneUtilities.get( rootUrl ), packageName, folder );
	}

	public static Class< Swagger12Generator > generate( String systemName, URL rootUrl, String data, String packageName, File folder ) throws KeyManagementException, NoSuchAlgorithmException, IOException
	{
		Swagger versionCheck = Swagger.fromJson( data, Swagger.class );
		switch ( versionCheck.getSwaggerVersion() )
		{
			case "1.2":
			{
				generateApis( systemName, rootUrl, data, packageName, folder );
				generateModels( systemName, rootUrl, null, data, packageName, folder );
			}
				break;
			default:
				System.err.println( "Swagger version " + versionCheck.getSwaggerVersion() + " not \"1.2\"." );
				// Throw Exception here!
				break;
		}
		return Swagger12Generator.class;
	}

	public static Class< Swagger12Generator > generateApis( String systemName, URL rootUrl, String data, String packageName, File folder ) throws IOException, KeyManagementException, NoSuchAlgorithmException
	{
		Swagger versionCheck = Swagger.fromJson( data, Swagger.class );
		switch ( versionCheck.getSwaggerVersion() )
		{
			case "1.2":
			{
				String apiVersion = versionCheck.getApiVersion();

				File apisFolder = getApiDir( folder, systemName, apiVersion );
				apisFolder.mkdirs();

				Set< ApiModel > sApis = new HashSet<>();

				String modelPackage = getModelPackage( packageName, systemName, apiVersion );
				String apiPackage = getApisPackage( packageName, systemName, apiVersion );

				ResourceListing12 directory = ResourceListing12.fromJson( gson, data, ResourceListing12.class );

				for ( ResourceObject12 dirApi : directory.getApis() )
				{
					URL newUrl = new URL( rootUrl.toString() + dirApi.getPath() );
					String newData = StandAloneUtilities.get( newUrl );

					ApiDeclaration12 doc = ApiDeclaration12.fromJson( gson, newData, ApiDeclaration12.class );

					for ( ApiObject12 api : doc.getApis() )
					{
						for ( OperationObject12 operation : api.getOperations() )
						{
							ApiModel apiModel = new ApiModel();
							apiModel.setName( operation.getNickname() );
							apiModel.setMultiple( operation.getType().trim().toUpperCase().startsWith( "LIST[" ) );
							apiModel.setReturnType( typeConverstion( modelPackage, operation.getType().trim().replace( "list[", "" ).replace( "List[", "" ).replace( "]", "" ), operation.getFormat() ) );
							apiModel.setHttpMethod( operation.getMethod().trim().toUpperCase() );
							apiModel.setPath( api.getPath() );

							for ( ParameterObject12 parm : operation.getParameters() )
							{
								ParameterModel parameterModel = new ParameterModel();
								parameterModel.setSerialName( parm.getName() );
								parameterModel.setName( StringUtils.uncapitalize( StringUtils.capitalize( parm.getName().replace( "$", "" ) ).replace( " ", "" ) ) );
								parameterModel.setType( parm.getParamType().trim().toUpperCase() );
								parameterModel.setDataType( typeConverstion( modelPackage, parm.getType().trim().replace( "list[", "" ).replace( "List[", "" ).replace( "]", "" ) ) );
								parameterModel.setMultiple( parm.getAllowMultiple() );

								apiModel.getParameters().add( parameterModel );
							}

							sApis.add( apiModel );
						}
					}
				}
				writeApis( apiPackage, sApis, apisFolder );
			}
				break;
			default:
				System.err.println( "Swagger version " + versionCheck.getSwaggerVersion() + " not \"1.2\"." );
				// Throw Exception here!
				break;
		}
		return Swagger12Generator.class;
	}

	@SuppressWarnings( "unused" )
	public static Class< Swagger12Generator > generateModels( String systemName, URL rootUrl, String path, String data, String packageName, File folder ) throws IOException, KeyManagementException, NoSuchAlgorithmException
	{
		Swagger versionCheck = Swagger.fromJson( data, Swagger.class );
		switch ( versionCheck.getSwaggerVersion() )
		{
			case "1.2":
			{
				String apiVersion = versionCheck.getApiVersion();

				File modelFolder = getModelDir( folder, systemName, apiVersion );
				modelFolder.mkdirs();

				Set< ModelModel > sModels = new HashSet<>();

				String modelPackage = getModelPackage( packageName, systemName, apiVersion );

				ResourceListing12 directory = ResourceListing12.fromJson( gson, data, ResourceListing12.class );

				for ( ResourceObject12 dirApi : directory.getApis() )
				{
					URL newUrl = new URL( rootUrl.toString() + dirApi.getPath() );
					String newData = StandAloneUtilities.get( newUrl );

					ApiDeclaration12 doc = ApiDeclaration12.fromJson( gson, newData, ApiDeclaration12.class );

					for ( Entry< String, ModelObject12 > modelPair : doc.getModels().entrySet() )
					{

						ModelModel modelModel = new ModelModel();

						modelModel.setSerialName( modelPair.getValue().getId() );
						modelModel.setName( StringUtils.capitalize( modelPair.getValue().getId().replace( "$", "" ) ).replace( " ", "" ) );

						for ( Entry< String, PropertyObject12 > propertyPair : modelPair.getValue().getProperties().entrySet() )
						{
							FieldModel fieldModel = new FieldModel();
							fieldModel.setSerialName( propertyPair.getKey() );
							fieldModel.setName( StringUtils.uncapitalize( StringUtils.capitalize( propertyPair.getKey().replace( "$", "" ) ).replace( " ", "" ) ) );

							System.out.println( propertyPair.getKey() + " : " + propertyPair.getValue() );

							if ( ( propertyPair.getValue().getType() == null ) && ( propertyPair.getValue().getRef() == null ) )
							{

							}
							else if ( propertyPair.getValue().getType() != null )
							{
								if ( propertyPair.getValue().getType().trim().equalsIgnoreCase( "array" ) )
								{
									fieldModel.setMultiple( true );

									if ( ( propertyPair.getValue().getItems().get( 0 ).getType() == null ) && ( propertyPair.getValue().getItems().get( 0 ).getRef() == null ) )
									{

									}
									if ( ( propertyPair.getValue().getRef() != null ) && ( !propertyPair.getValue().getRef().equalsIgnoreCase( "array" ) ) )
									{
										fieldModel.setDataType( typeConverstion( modelPackage, propertyPair.getValue().getRef().replace( "list[", "" ).replace( "List[", "" ).replace( "]", "" ), propertyPair.getValue().getFormat() ) );
									}
									else
									{
										if ( ( propertyPair.getValue().getItems().get( 0 ).getType() == null ) && ( propertyPair.getValue().getItems().get( 0 ).getRef() == null ) )
										{

										}else if ( propertyPair.getValue().getItems().get( 0 ).getType() == null )
										{
											fieldModel.setDataType( typeConverstion( modelPackage, propertyPair.getValue().getItems().get( 0 ).getRef().replace( "list[", "" ).replace( "List[", "" ).replace( "]", "" ), propertyPair.getValue().getFormat() ) );
										}
										else
										{
											fieldModel.setDataType( typeConverstion( modelPackage, propertyPair.getValue().getItems().get( 0 ).getType().replace( "list[", "" ).replace( "List[", "" ).replace( "]", "" ), propertyPair.getValue().getFormat() ) );
										}
									}
								}
								else
								{
									fieldModel.setDataType( typeConverstion( modelPackage, propertyPair.getValue().getType().replace( "list[", "" ).replace( "List[", "" ).replace( "]", "" ), propertyPair.getValue().getFormat() ) );
								}
							}
							else if ( propertyPair.getValue().getRef() != null )
							{
								fieldModel.setDataType( typeConverstion( modelPackage, propertyPair.getValue().getRef().replace( "list[", "" ).replace( "List[", "" ).replace( "]", "" ), propertyPair.getValue().getFormat() ) );
							}
							else
							{
								fieldModel.setMultiple( propertyPair.getValue().getType().trim().toUpperCase().startsWith( "LIST[" ) );
								fieldModel.setDataType( typeConverstion( modelPackage, propertyPair.getValue().getType().trim().replace( "list[", "" ).replace( "List[", "" ).replace( "]", "" ), propertyPair.getValue().getFormat() ) );
							}

							if ( ( propertyPair.getValue().getEnums() != null ) && ( propertyPair.getValue().getEnums().size() > 0 ) )
							{
								for ( String enumvalue : propertyPair.getValue().getEnums() )
								{
									// TODO add to enums
								}
							}
							modelModel.getFields().add( fieldModel );
						}
						sModels.add( modelModel );
					}
				}
				writeModels( modelPackage, sModels, modelFolder );
			}
				break;
			default:
				System.err.println( "Swagger version " + versionCheck.getSwaggerVersion() + " not \"1.2\"." );
				// Throw Exception here!
				break;
		}
		return Swagger12Generator.class;
	}

	public static String typeConverstion( String modelPackage, String type )
	{
		return typeConverstion( modelPackage, type, null );
	}

	/**
	 * Type converstion.
	 * 
	 * Based on https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#431-primitives
	 *
	 * @param type the type
	 * @param format the format
	 * @return the string
	 */
	@SuppressWarnings( "unused" )
	public static String typeConverstion( String modelPackage, String type, String format )
	{
		String returntype = null;
		switch ( ( ( type == null ) ? "" : type ).trim().toUpperCase() )
		{
			case "VOID":
				returntype = "void";
				break;
			case "INTEGER":
				switch ( ( ( format == null ) ? "" : format ).trim().toUpperCase() )
				{
					case "INT64":
						returntype = "java.lang.Long";
						break;
					case "INT32":
					default:
						returntype = "java.lang.Integer";
						break;
				}
				break;
			case "NUMBER":
				switch ( ( ( format == null ) ? "" : format ).trim().toUpperCase() )
				{
					case "FLOAT":
						returntype = "java.lang.Float";
						break;
					case "DOUBLE":
					default:
						returntype = "java.lang.Double";
						break;
				}
				break;
			case "STRING":
				switch ( ( ( format == null ) ? "" : format ).trim().toUpperCase() )
				{
					case "BYTE":
						returntype = "java.lang.Byte";
						break;
					case "DATE":
					case "DATE-TIME":
						returntype = "java.util.Date";
						break;
					default:
						returntype = "java.lang.String";
						break;
				}
				break;
			case "BOOLEAN":
				returntype = "java.lang.Boolean";
				break;
			case "ANY":
				if ( format != null )
				{
					for ( String possibility : format.split( Pattern.quote( "," ) ) )
					{
						returntype = typeConverstion( modelPackage, possibility );

						if ( returntype != null )
						{
							break;
						}
					}
				}
				if ( returntype == null )
				{
					returntype = "java.lang.Object";
				}
				break;

			default:
				if ( type.toUpperCase().startsWith( "LIST[" ) )
				{
					String listrem = type.replace( "list[", "" ).replace( "List[", "" ).replace( "]", "" );
					returntype = "java.util.List<" + typeConverstion( modelPackage, listrem, format ) + ">";
				}
				else
				{
					if ( type == null )
					{
						returntype = "java.lang.Object";
					}
					else if ( StringUtils.capitalize( type ).contains( "." ) )
					{
						returntype = StringUtils.capitalize( type );
					}
					else
					{
						returntype = modelPackage + "." + StringUtils.capitalize( type );
					}
				}
				break;
		}
		return returntype;
	}
}
