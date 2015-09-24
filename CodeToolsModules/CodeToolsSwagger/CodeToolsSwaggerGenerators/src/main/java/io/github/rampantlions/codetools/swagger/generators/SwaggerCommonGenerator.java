
package io.github.rampantlions.codetools.swagger.generators;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.jboss.forge.roaster.model.source.JavaClassSource;
import org.jboss.forge.roaster.model.source.JavaInterfaceSource;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;

import io.github.rampantlions.codetools.ModelGenUtils;
import io.github.rampantlions.codetools.restbuilder.generators.CommonGenerator;
import io.github.rampantlions.codetools.restbuilder.generators.models.ApiModel;
import io.github.rampantlions.codetools.restbuilder.generators.models.ModelModel;
import io.github.rampantlions.codetools.swagger.generators.models.Swagger;

public class SwaggerCommonGenerator< T extends SwaggerCommonGenerator< T > > extends CommonGenerator< T >
{
	public static final String Version_String = "v";
	public static final String Models_Folder_String = "models";
	public static final String Apis_Folder_String = "apis";

	public static final String Json_Api_Class_Name = "JsonApi";
	public static final String Model_Api_Class_Name = "ModeledApi";

	public static void writeModels( String modelPackage, Set< ModelModel > sModels, File modelFolder ) throws IOException
	{
		for ( ModelModel aModel : sModels )
		{
			JavaClassSource modelClass = ModelGenUtils.getOrCreateClass( modelPackage, aModel.getName(), modelFolder );
			aModel.generateRetrofitModel( modelClass, modelFolder );
			ModelGenUtils.saveFile( modelClass, modelFolder );
		}
	}

	public static void writeApis( String apiPackage, Set< ApiModel > sApis, File apisFolder ) throws IOException
	{
		JavaInterfaceSource modelApiInterface = ModelGenUtils.getOrCreateInterface( apiPackage, Model_Api_Class_Name, apisFolder );
		JavaInterfaceSource jsonApiInterface = ModelGenUtils.getOrCreateInterface( apiPackage, Json_Api_Class_Name, apisFolder );
		for ( ApiModel aApi : sApis )
		{
			aApi.generateRetrofitApi( modelApiInterface, false, false );
			aApi.generateRetrofitApi( jsonApiInterface, true, false );

		}
		ModelGenUtils.saveFile( modelApiInterface, apisFolder );
		ModelGenUtils.saveFile( jsonApiInterface, apisFolder );
	}

	public static String getVersion( String data )
	{
		Swagger versionCheck = Swagger.fromJson( data, Swagger.class );
		return versionCheck.getApiVersion();
	}

	public static File getSystemDir( File rootFolder, String systemName )
	{
		return new File( rootFolder, ( systemName.trim().replace( ".", "_" ).trim().replace( " ", "_" ) ).toLowerCase() );
	}

	public static File getVersionDir( File rootFolder, String systemName, String apiVersion )
	{
		File systemFolder = getSystemDir( rootFolder, systemName );
		File versionFolder = new File( systemFolder, ( Version_String + apiVersion.trim().replace( ".", "_" ).trim().replace( " ", "_" ) ).toLowerCase() );
		return versionFolder;
	}

	public static File getModelDir( File rootFolder, String systemName, String apiVersion )
	{
		File modelFolder = new File( getVersionDir( rootFolder, systemName, apiVersion ), Models_Folder_String );
		return modelFolder;
	}

	public static String getModelPackage( String rootPackage, String systemName, String apiVersion )
	{
		return rootPackage + "." + ( systemName.trim().replace( ".", "_" ).trim().replace( " ", "_" ) ).toLowerCase() + "." + ( Version_String + apiVersion.trim().replace( ".", "_" ).trim().replace( " ", "_" ) ).toLowerCase() + "." + Models_Folder_String;
	}

	public static String getApisPackage( String rootPackage, String systemName, String apiVersion )
	{
		return rootPackage + "." + ( systemName.trim().replace( ".", "_" ).trim().replace( " ", "_" ) ).toLowerCase() + "." + ( Version_String + apiVersion.trim().replace( ".", "_" ).trim().replace( " ", "_" ) ).toLowerCase() + "." + Apis_Folder_String;
	}

	public static File getApiDir( File rootFolder, String systemName, String data )
	{
		File apisFolder = new File( getVersionDir( rootFolder, systemName, data ), Apis_Folder_String );
		return apisFolder;
	}

	public SwaggerCommonGenerator()
	{

	}

	public static class ListTypeAdapter< LTYPE > implements JsonDeserializer< List< LTYPE > >
	{
		@SuppressWarnings( { "rawtypes", "unchecked" } )
		public List< LTYPE > deserialize( JsonElement json, Type typeOfT, JsonDeserializationContext ctx )
		{
			List< LTYPE > vals = new ArrayList< LTYPE >();
			Class c = null;
			try
			{
				// TODO fix very poorly written code.
				if ( typeOfT.getTypeName().replace( " ", "" ).startsWith( "List<" ) )
				{
					c = Class.forName( typeOfT.getTypeName().replace( " ", "" ).replace( "List<", "" ).replace( ">", "" ).trim() );
				}
				else
				{
					c = Class.forName( typeOfT.getTypeName().replace( " ", "" ).replace( "java.util.List<", "" ).replace( ">", "" ).trim() );
				}
			}
			catch ( ClassNotFoundException e )
			{
				e.printStackTrace();
			}
			if ( json.isJsonArray() )
			{
				for ( JsonElement e : json.getAsJsonArray() )
				{
					vals.add( (LTYPE) ctx.deserialize( e, c ) );
				}
			}
			else if ( json.isJsonObject() )
			{
				vals.add( (LTYPE) ctx.deserialize( json, c ) );
			}
			else
			{
				throw new RuntimeException( "Unexpected JSON type: " + json.getClass() );
			}
			return vals;
		}
	}

	public static class MapTypeAdapter< LTYPE > implements JsonDeserializer< Map< String, LTYPE > >
	{
		@SuppressWarnings( { "rawtypes", "unchecked" } )
		public Map< String, LTYPE > deserialize( JsonElement json, Type typeOfT, JsonDeserializationContext ctx )
		{
			Map< String, LTYPE > vals = new HashMap< String, LTYPE >();
			System.out.println(typeOfT.getTypeName());
			Class c2 = null;
			try
			{
				System.out.println(typeOfT.getTypeName());
				
				// TODO fix very poorly written code.
				String[] dts = typeOfT.getTypeName().replace( " ", "" ).replace( "java.util.Map<", "" ).replace( "Map<", "" ).replace( ">", "" ).trim().split( Pattern.quote( "," ) );
				c2 = Class.forName( dts[1].trim() );
			}
			catch ( ClassNotFoundException e )
			{
				e.printStackTrace();
			}
			if ( json.isJsonObject() )
			{
				Set< Map.Entry< String, JsonElement >> entrySet = json.getAsJsonObject().entrySet();
				for ( Map.Entry< String, JsonElement > entry : entrySet )
				{
					vals.put( (String) entry.getKey(), (LTYPE) ctx.deserialize( entry.getValue(), c2 ) );
				}
			} else if ( json.isJsonArray() )
			{
				for ( JsonElement entry : json.getAsJsonArray() )
				{
					vals.put( "" + vals.size(), (LTYPE) ctx.deserialize( entry, c2 ) );
				}
			}
			else
			{
				System.out.println( json.toString() );
				throw new RuntimeException( "Unexpected JSON type: " + json.getClass() );
			}
			return vals;
		}
	}
}
