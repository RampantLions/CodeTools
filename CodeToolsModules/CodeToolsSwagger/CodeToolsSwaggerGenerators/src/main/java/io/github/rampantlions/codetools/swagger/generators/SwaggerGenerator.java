
package io.github.rampantlions.codetools.swagger.generators;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import io.github.rampantlions.codetools.http.StandAloneUtilities;
import io.github.rampantlions.codetools.swagger.generators.models.Swagger;

public class SwaggerGenerator extends SwaggerCommonGenerator< SwaggerGenerator >
{
	
	public static Class< SwaggerGenerator > generate( String systemName, URL rootUrl, String packageName, File folder ) throws KeyManagementException, NoSuchAlgorithmException, IOException
	{
		return generate( systemName, rootUrl, StandAloneUtilities.get( rootUrl ), packageName, folder );
	}

	public static Class< SwaggerGenerator > generate( String systemName, URL rootUrl, String data, String packageName, File folder ) throws KeyManagementException, NoSuchAlgorithmException, IOException
	{
		Swagger versionCheck = Swagger.fromJson( data, Swagger.class );
		switch ( versionCheck.getSwaggerVersion() )
		{
			case "1.1":
			{
				Swagger11Generator.generate( systemName, rootUrl, data, packageName, folder );
			}
				break;
			case "1.2":
			{
				Swagger12Generator.generate( systemName, rootUrl, data, packageName, folder );
			}
				break;
			default:
				System.err.println( "Swagger version " + versionCheck.getSwaggerVersion() + " not recognized." );
				break;
		}
		return SwaggerGenerator.class;
	}

	public static Class< SwaggerGenerator > generateModels( String systemName, URL rootUrl, String data, String packageName, File folder ) throws IOException, KeyManagementException, NoSuchAlgorithmException
	{
		Swagger versionCheck = Swagger.fromJson( data, Swagger.class );
		switch ( versionCheck.getSwaggerVersion() )
		{
			case "1.1":
			{
				Swagger11Generator.generate( systemName, rootUrl, data, packageName, folder );
			}
				break;
			case "1.2":
			{
				Swagger12Generator.generate( systemName, rootUrl, data, packageName, folder );
			}
				break;
			default:
				System.err.println( "Swagger version " + versionCheck.getSwaggerVersion() + " not recognized." );
				break;
		}
		return SwaggerGenerator.class;
	}

	public static String getVersion( URL rootUrl ) throws KeyManagementException, NoSuchAlgorithmException, IOException
	{
		return getVersion( StandAloneUtilities.get( rootUrl ) );
	}
}
