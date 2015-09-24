/* Utilities.java	1.00 Jan 26, 2015
 *
 * Copyright (c) 2015, All rights reserved.
 */

package io.github.rampantlions.codetools.http;

import javax.net.ssl.TrustManager;
import javax.xml.bind.DatatypeConverter;

import org.apache.http.auth.NTCredentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.X509HostnameVerifier;

import retrofit.RequestInterceptor;

import com.gargoylesoftware.htmlunit.WebClient;

/**
 * Class <code>Utilities</code>.
 * Some segments of code in this class facilitates using Retrofit, Feign, Jersey, and DropWizard.
 *
 * @author <a href="josh.wiechman@gmail.com">Wiechman, Joshua</a>
 * @version 1.00, Jan 26, 2015
 * @param <ClientType> the generic type
 */
public abstract class ClientUtilities< ClientType extends ClientUtilities< ClientType >>
{


	/** The Constant DEFAULT_USER_AGENT. */
	public static final String DEFAULT_USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:23.0) Gecko/20100101 Firefox/23.0";

	/**
	 * Base64 encode.
	 *
	 * @param credentials the credentials
	 * @return the string
	 */
	public static String base64Encode( final NTCredentials credentials )
	{
		return ClientUtilities.base64Encode( credentials.getUserName(), credentials.getPassword() );
	}

	/**
	 * Base64 encode.
	 *
	 * @param stringToEncode the string to encode
	 * @return the string
	 */
	public static String base64Encode( final String stringToEncode )
	{
		return DatatypeConverter.printBase64Binary( stringToEncode.getBytes() );
	}

	/**
	 * Base64 encode.
	 *
	 * @param username the username
	 * @param password the password
	 * @return the string
	 */
	public static String base64Encode( final String username, final String password )
	{
		return ClientUtilities.base64Encode( username + ":" + password );
	}

	/**
	 * Default interceptor.
	 *
	 * @param credentials the credentials
	 * @return the request interceptor
	 */
	public static RequestInterceptor defaultInterceptor( final NTCredentials credentials )
	{
		RequestInterceptor requestInterceptor = new RequestInterceptor() {
			@Override
			public void intercept( RequestFacade request )
			{
				// request.addHeader("User-Agent", USER_AGENT);
				request.addHeader( "Authorization", "Basic " + ClientUtilities.base64Encode( credentials ) );
				// getToken(username, password)
			}
		};
		return requestInterceptor;
	}

	/**
	 * Gets the default user agent.
	 *
	 * @return the default user agent
	 */
	public static String getDefaultUserAgent()
	{
		return ClientUtilities.DEFAULT_USER_AGENT;
	}

	/**
	 * Host name verifier.
	 *
	 * @return the hostname verifier
	 */
	public static X509HostnameVerifier hostNameVerifier()
	{
		return StandAloneUtilities.hostNameVerifier();
	}

	/**
	 * New web client.
	 *
	 * @return the web client
	 */
	public static WebClient newWebClient()
	{
		return StandAloneUtilities.newWebClient();
	}

	/**
	 * Setup ignore security cert.
	 *
	 * @param client2 the new up ignore security cert
	 */
	public static void setupIgnoreSecurityCert( final HttpClient client2 )
	{
		StandAloneUtilities.setupIgnoreSecurityCert( client2 );
	}

	/**
	 * Trust manager.
	 *
	 * @return the trust manager[]
	 */
	public static TrustManager[] trustManager()
	{
		return StandAloneUtilities.trustManager();
	}

	/** The credentials. */
	protected UsernamePasswordCredentials credentials;

	/**
	 * Gets the credentials.
	 *
	 * @return the credentials
	 */
	public UsernamePasswordCredentials getCredentials()
	{
		return credentials;
	}

	/**
	 * Login.
	 *
	 * @throws Exception the exception
	 */
	protected abstract void login() throws Exception;

	/**
	 * Sets the credentials.
	 *
	 * @param credentials the new credentials
	 */
	protected void setCredentials( final UsernamePasswordCredentials credentials )
	{
		this.credentials = credentials;
	}
}
