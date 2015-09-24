
package io.github.rampantlions.codetools.swagger.generators;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import io.github.rampantlions.codetools.http.StandAloneUtilities;
import io.github.rampantlions.codetools.restbuilder.generators.models.ApiModel;
import io.github.rampantlions.codetools.restbuilder.generators.models.FieldModel;
import io.github.rampantlions.codetools.restbuilder.generators.models.ModelModel;
import io.github.rampantlions.codetools.restbuilder.generators.models.ParameterModel;
import io.github.rampantlions.codetools.swagger.generators.models.Swagger;
import io.github.rampantlions.codetools.swagger.generators.v11.models.Api11;
import io.github.rampantlions.codetools.swagger.generators.v11.models.ApiDeclaration11;
import io.github.rampantlions.codetools.swagger.generators.v11.models.Item11;
import io.github.rampantlions.codetools.swagger.generators.v11.models.Model11;
import io.github.rampantlions.codetools.swagger.generators.v11.models.Operation11;
import io.github.rampantlions.codetools.swagger.generators.v11.models.Parameter11;
import io.github.rampantlions.codetools.swagger.generators.v11.models.Parameters11;
import io.github.rampantlions.codetools.swagger.generators.v11.models.Parameters11.Parameters11TypeAdapter;
import io.github.rampantlions.codetools.swagger.generators.v11.models.Property11;


public class Swagger11Generator extends SwaggerCommonGenerator< Swagger11Generator >
{
	static final Gson gson = io.github.rampantlions.codetools.restbuilder.generators.ModelGsonBuilder.defaultBuilder().setPrettyPrinting()

	.registerTypeAdapter( new TypeToken< Parameters11 >() {}.getType(), new Parameters11TypeAdapter() ).registerTypeAdapter( new TypeToken< List< Item11 >>() {}.getType(), new ListTypeAdapter< Item11 >() ).registerTypeAdapter( new TypeToken< List< Property11 >>() {}.getType(), new ListTypeAdapter< Property11 >() ).create();

	public static Class< Swagger11Generator > generate( String systemName, URL rootUrl, String packageName, File folder ) throws KeyManagementException, NoSuchAlgorithmException, IOException
	{
		return generate( systemName, rootUrl, StandAloneUtilities.get( rootUrl ), packageName, folder );
	}

	public static Class< Swagger11Generator > generate( String systemName, URL rootUrl, String data, String packageName, File folder ) throws KeyManagementException, NoSuchAlgorithmException, IOException
	{
		Swagger versionCheck = Swagger.fromJson( data, Swagger.class );
		switch ( versionCheck.getSwaggerVersion() )
		{
			case "1.1":
			{
				generateApis( systemName, rootUrl, data, packageName, folder );
				generateModels( systemName, rootUrl, data, packageName, folder );
			}
				break;
			default:
				System.err.println( "Swagger version " + versionCheck.getSwaggerVersion() + " not \"1.1\"." );
				// Throw Exception here!
				break;
		}
		return Swagger11Generator.class;
	}

	public static Class< Swagger11Generator > generateApis( String systemName, URL rootUrl, String data, String packageName, File folder ) throws IOException
	{
		Swagger versionCheck = Swagger.fromJson( data, Swagger.class );
		switch ( versionCheck.getSwaggerVersion() )
		{
			case "1.1":
			{
				String apiVersion = versionCheck.getApiVersion();
				File apisFolder = getApiDir( folder, systemName, apiVersion );
				apisFolder.mkdirs();

				Set< ApiModel > sApis = new HashSet<>();

				String modelPackage = getModelPackage( packageName, systemName, apiVersion );
				String apiPackage = getApisPackage( packageName, systemName, apiVersion );

				ApiDeclaration11 doc = ApiDeclaration11.fromJson( gson, data, ApiDeclaration11.class );

				for ( Api11 api : doc.getApis() )
				{
					for ( Operation11 operation : api.getOperations() )
					{

						ApiModel apiModel = new ApiModel();
						apiModel.setName( operation.getNickname() );
						apiModel.setMultiple( operation.getResponseClass().trim().toUpperCase().startsWith( "LIST[" ) );
						apiModel.setReturnType( getSimpleType( operation.getResponseClass().trim().replace( "list[", "" ).replace( "]", "" ), modelPackage ) );
						apiModel.setHttpMethod( operation.getHttpMethod().trim().toUpperCase() );
						apiModel.setPath( api.getPath() );

						Parameters11 parameters = operation.getParameters();
						if ( parameters != null )
						{
							for ( Parameter11 parm : parameters.getParameter() )
							{
								ParameterModel parameterModel = new ParameterModel();
								parameterModel.setSerialName( parm.getName() );
								parameterModel.setName( StringUtils.uncapitalize( StringUtils.capitalize( parm.getName().replace( "$", "" ) ).replace( " ", "" ) ) );
								parameterModel.setType( parm.getParamType().trim().toUpperCase() );
								parameterModel.setDataType( getSimpleType( parm.getDataType().trim().replace( "list[", "" ).replace( "]", "" ), modelPackage ) );
								parameterModel.setMultiple( parameters.getAllowMultiple() );

								apiModel.getParameters().add( parameterModel );
							}
						}
						sApis.add( apiModel );
					}
				}

				writeApis( apiPackage, sApis, apisFolder );
			}
				break;
			default:
				System.err.println( "Swagger version " + versionCheck.getSwaggerVersion() + " not \"1.1\"." );
				// Throw Exception here!
				break;
		}
		return Swagger11Generator.class;
	}

	@SuppressWarnings( "unused" )
	public static Class< Swagger11Generator > generateModels( String systemName, URL rootUrl, String data, String packageName, File folder ) throws IOException
	{
		Swagger versionCheck = Swagger.fromJson( data, Swagger.class );
		switch ( versionCheck.getSwaggerVersion() )
		{
			case "1.1":
			{
				String apiVersion = versionCheck.getApiVersion();

				File modelFolder = getModelDir( folder, systemName, apiVersion );
				modelFolder.mkdirs();

				Set< ModelModel > sModels = new HashSet<>();

				String modelPackage = getModelPackage( packageName, systemName, apiVersion );

				ApiDeclaration11 doc = ApiDeclaration11.fromJson( gson, data, ApiDeclaration11.class );

				for ( Entry< String, Model11 > model : doc.getModels().entrySet() )
				{
					ModelModel modelModel = new ModelModel();

					modelModel.setSerialName( model.getValue().getId() );
					modelModel.setName( StringUtils.capitalize( model.getValue().getId().replace( "$", "" ) ).replace( " ", "" ) );

					for ( Entry< String, Property11 > property : model.getValue().getProperties().entrySet() )
					{
						FieldModel fieldModel = new FieldModel();
						fieldModel.setSerialName( property.getKey() );
						fieldModel.setName( StringUtils.uncapitalize( StringUtils.capitalize( property.getKey().replace( "$", "" ) ).replace( " ", "" ) ) );

						if ( property.getValue().getType().trim().equalsIgnoreCase( "array" ) )
						{
							fieldModel.setMultiple( true );
							if ( property.getValue().getItems().get( 0 ).getType() == null )
							{
								fieldModel.setDataType( getSimpleType( property.getValue().getItems().get( 0 ).getRef().replace( "list[", "" ).replace( "]", "" ), modelPackage ) );
							}
							else
							{
								fieldModel.setDataType( getSimpleType( property.getValue().getItems().get( 0 ).getType().replace( "list[", "" ).replace( "]", "" ), modelPackage ) );
							}
						}
						else
						{
							fieldModel.setMultiple( property.getValue().getType().trim().toUpperCase().startsWith( "LIST[" ) );
							fieldModel.setDataType( getSimpleType( property.getValue().getType().trim().replace( "list[", "" ).replace( "]", "" ), modelPackage ) );
						}

						// property.getValue().getFormat() = "DateTime" -> Type?
						if ( ( property.getValue().getEnums() != null ) && ( property.getValue().getEnums().size() > 0 ) )
						{
							for ( Entry< Integer, String > enumvalue : property.getValue().getEnums().entrySet() )
							{
								// TODO add to enums
							}
						}

						modelModel.getFields().add( fieldModel );
					}
					sModels.add( modelModel );
				}
				writeModels( modelPackage, sModels, modelFolder );
			}
				break;
			default:
				System.err.println( "Swagger version " + versionCheck.getSwaggerVersion() + " not \"1.1\"." );
				// Throw Exception here!
				break;
		}
		return Swagger11Generator.class;
	}

	public static String getSimpleType( Operation11 operation, String modelPackage )
	{
		return getSimpleType( operation.getResponseClass(), modelPackage );
	}

	public static String getSimpleType( String pretype, String modelPackage )
	{
		String type = null;
		switch ( ( ( pretype == null ) ? "" : pretype.toUpperCase() ) )
		{
			case "VOID":
				type = "void";
				break;
			case "STRING":
				type = "java.lang.String";
				break;
			case "BOOLEAN":
				type = "boolean";
				break;
			case "NUMBER":
				type = "double";
				break;
			case "INTEGER":
				type = "int";
				break;
			case "OBJECT":
				type = "java.lang.Object";
				break;
			case "ANY":

				if ( pretype.equals( "Number" ) )
				{
					type = "double";
				}
				else
				{
					type = "java.lang.Object";
				}
				break;
			default:
				if ( pretype.toUpperCase().startsWith( "LIST[" ) )
				{
					String listrem = pretype.replace( "list[", "" ).replace( "]", "" );
					type = "java.util.List<" + getSimpleType( listrem, modelPackage ) + ">";
				}
				else
				{
					type = modelPackage + "." + pretype;
				}
				break;
		}
		return type;
	}

	public static String typeConverstion( String type )
	{
		return typeConverstion( type, null );
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
	public static String typeConverstion( String type, String format )
	{
		String returntype = null;
		switch ( type.trim().toUpperCase() )
		{
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
		}
		return returntype;
	}
}
