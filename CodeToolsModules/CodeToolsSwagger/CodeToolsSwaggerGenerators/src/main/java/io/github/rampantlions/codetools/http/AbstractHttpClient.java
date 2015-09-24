/* AbstractApacheHttpClient.java	1.00 Jan 26, 2015
 *
 * Copyright (c) 2015, All rights reserved.
 */

package io.github.rampantlions.codetools.http;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import retrofit.client.Header;
import retrofit.client.Request;
import retrofit.client.Response;
import retrofit.mime.TypedByteArray;
import retrofit.mime.TypedOutput;

/**
 * Class <code>AbstractApacheHttpClient</code>.
 * Some segments of code in this class facilitates using Retrofit, Feign, Jersey, and DropWizard.
 *
 * @author <a href="josh.wiechman@gmail.com">Wiechman, Joshua</a>
 * @version 1.00, Jan 26, 2015
 * @param <ClientType> the generic type
 */
@SuppressWarnings( "deprecation" )
public abstract class AbstractHttpClient< ClientType extends AbstractHttpClient< ClientType >> extends ClientUtilities< ClientType > implements retrofit.client.Client // , feign.Client
{
	/**
	 * Class <code>GenericEntityHttpRequest</code>.
	 * This class is utilized by Retrofit.
	 */
	private static class GenericEntityHttpRequest extends HttpEntityEnclosingRequestBase
	{

		/** The method. */
		private final String method;

		/**
		 * Instantiates a new generic entity http request.
		 *
		 * @param request the request
		 */
		GenericEntityHttpRequest( final Request request )
		{
			super();
			method = request.getMethod();
			setURI( URI.create( request.getUrl() ) );

			/* Add all headers. */
			for ( Header header : request.getHeaders() )
			{
				addHeader( new BasicHeader( header.getName(), header.getValue() ) );
			}

			/* Add the content body. */
			setEntity( new TypedOutputEntity( request.getBody() ) );
		}

		// GenericEntityHttpRequest( final feign.Request request )
		// {
		// super();
		// method = request.method();
		// setURI( URI.create( request.url() ) );
		//
		// /* Add all headers. */
		// for ( Entry< String, Collection< String >> header : request.headers().entrySet() )
		// {
		// StringBuilder val = new StringBuilder();
		// for ( String valitem : header.getValue() )
		// {
		// if ( val.length() > 0 )
		// {
		// val.append( "," );
		// }
		// val.append( valitem );
		// }
		// addHeader( new BasicHeader( header.getKey(), val.toString() ) );
		// }
		//
		// TypedOutput to = new TypedOutput();
		//
		// /* Add the content body. */
		// //setContentType( typedOutput.mimeType() );
		// setEntity( new TypedOutputEntity( request.getBody() ) );
		// }

		/**
		 * getMethod
		 * (non-Javadoc).
		 *
		 * @return the method
		 * @see org.apache.http.client.methods.HttpRequestBase#getMethod()
		 */
		@Override
		public String getMethod()
		{
			return method;
		}
	}

	/**
	 * Class <code>GenericHttpRequest</code>.
	 * This class is utilized by Retrofit.
	 */
	private static class GenericHttpRequest extends HttpRequestBase
	{

		/** The method. */
		private final String method;

		/**
		 * Instantiates a new generic http request.
		 *
		 * @param request the request
		 */
		public GenericHttpRequest( final Request request )
		{
			method = request.getMethod();
			setURI( URI.create( request.getUrl() ) );

			/* Add all headers. */
			for ( Header header : request.getHeaders() )
			{
				addHeader( new BasicHeader( header.getName(), header.getValue() ) );
			}
		}

		/**
		 * getMethod
		 * (non-Javadoc).
		 *
		 * @return the method
		 * @see org.apache.http.client.methods.HttpRequestBase#getMethod()
		 */
		@Override
		public String getMethod()
		{
			return method;
		}
	}

	/**
	 *  Container class for passing an entire {@link TypedOutput} as an {@link HttpEntity}.
	 */
	static class TypedOutputEntity extends AbstractHttpEntity
	{

		/** The typed output. */
		final TypedOutput typedOutput;

		/**
		 * Instantiates a new typed output entity.
		 *
		 * @param typedOutput the typed output
		 */
		TypedOutputEntity( final TypedOutput typedOutput )
		{
			this.typedOutput = typedOutput;
			setContentType( typedOutput.mimeType() );
		}

		/**
		 * getContent
		 * (non-Javadoc).
		 *
		 * @return the content
		 * @throws IOException Signals that an I/O exception has occurred.
		 * @see org.apache.http.HttpEntity#getContent()
		 */
		@Override
		public InputStream getContent() throws IOException
		{
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			typedOutput.writeTo( out );
			return new ByteArrayInputStream( out.toByteArray() );
		}

		/**
		 * getContentLength
		 * (non-Javadoc).
		 *
		 * @return the content length
		 * @see org.apache.http.HttpEntity#getContentLength()
		 */
		@Override
		public long getContentLength()
		{
			return typedOutput.length();
		}

		/**
		 * isRepeatable
		 * (non-Javadoc).
		 *
		 * @return true, if is repeatable
		 * @see org.apache.http.HttpEntity#isRepeatable()
		 */
		@Override
		public boolean isRepeatable()
		{
			return true;
		}

		/**
		 * isStreaming
		 * (non-Javadoc).
		 *
		 * @return true, if is streaming
		 * @see org.apache.http.HttpEntity#isStreaming()
		 */
		@Override
		public boolean isStreaming()
		{
			return false;
		}

		/**
		 * writeTo
		 * (non-Javadoc).
		 *
		 * @param out the out
		 * @throws IOException Signals that an I/O exception has occurred.
		 * @see org.apache.http.HttpEntity#writeTo(java.io.OutputStream)
		 */
		@Override
		public void writeTo( final OutputStream out ) throws IOException
		{
			typedOutput.writeTo( out );
		}
	}

	/**
	 * Creates the default client.
	 *
	 * @return the http client
	 */
	public static HttpClient createDefaultClient()
	{
		HttpParams params = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout( params, 800000 );
		HttpConnectionParams.setSoTimeout( params, 800000 );
		DefaultHttpClient client = new DefaultHttpClient( params );

		ClientUtilities.setupIgnoreSecurityCert( client );

		return client;
	}

	/**
	 * Creates the request.
	 *
	 * @param request the request
	 * @return the http uri request
	 */
	static HttpUriRequest createRequest( final Request request )
	{
		if ( request.getBody() != null )
		{
			return new GenericEntityHttpRequest( request );
		}
		return new GenericHttpRequest( request );
	}

	// static HttpUriRequest createRequest( final feign.Request request )
	// {
	// if ( request.body() != null )
	// {
	// return new GenericEntityHttpRequest( request );
	// }
	// return new GenericHttpRequest( request );
	// }

	/**
	 * Parses the response.
	 *
	 * @param url the url
	 * @param response the response
	 * @return the response
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	static Response parseResponseRetrofit( final String url, final HttpResponse response ) throws IOException
	{
		StatusLine statusLine = response.getStatusLine();
		int status = statusLine.getStatusCode();
		String reason = statusLine.getReasonPhrase();
		List< Header > headers = new ArrayList< Header >();
		String contentType = "application/octet-stream";
		for ( org.apache.http.Header header : response.getAllHeaders() )
		{
			String name = header.getName();
			String value = header.getValue();
			if ( "Content-Type".equalsIgnoreCase( name ) )
			{
				contentType = value;
			}
			headers.add( new Header( name, value ) );
		}
		TypedByteArray body = null;
		HttpEntity entity = response.getEntity();
		if ( entity != null )
		{
			byte[] bytes = EntityUtils.toByteArray( entity );
			body = new TypedByteArray( contentType, bytes );
		}
		return new Response( url, status, reason, headers, body );
	}

	// static feign.Response parseResponseFeign( final String url, final HttpResponse response ) throws IOException
	// {
	// StatusLine statusLine = response.getStatusLine();
	// int status = statusLine.getStatusCode();
	// String reason = statusLine.getReasonPhrase();
	// List< Header > headers = new ArrayList< Header >();
	// String contentType = "application/octet-stream";
	// for ( org.apache.http.Header header : response.getAllHeaders() )
	// {
	// String name = header.getName();
	// String value = header.getValue();
	// if ( "Content-Type".equalsIgnoreCase( name ) )
	// {
	// contentType = value;
	// }
	// headers.add( new Header( name, value ) );
	// }
	// TypedByteArray body = null;
	// HttpEntity entity = response.getEntity();
	// if ( entity != null )
	// {
	// byte[] bytes = EntityUtils.toByteArray( entity );
	// body = new TypedByteArray( contentType, bytes );
	// }
	// feign.Response.Body
	//
	// return new feign.Response( status, reason, headers, body );
	// }

	/** The use basic auth. */
	protected boolean useBasicAuth = false;

	/** The client. */
	protected final HttpClient client;

	/** The context. */
	protected HttpContext context;

	/** The sso. */
	protected boolean sso = false;

	/**
	 * Instantiates a new abstract apache http client.
	 *
	 * @param client the client
	 * @param context the context
	 * @param credentials the credentials
	 */
	protected AbstractHttpClient( final HttpClient client, final HttpContext context, final UsernamePasswordCredentials credentials )
	{
		this.client = ( client != null ) ? client : AbstractHttpClient.createDefaultClient();
		this.context = ( context != null ) ? context : new BasicHttpContext();
		this.credentials = credentials;
	}

	/**
	 *  Execute the specified {@code request} using the provided {@code client}.
	 *
	 * @param client the client
	 * @param request the request
	 * @return the http response
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected HttpResponse execute( final HttpClient client, final HttpUriRequest request ) throws IOException
	{
		return client.execute( request, context );
	}

	/**
	 * execute
	 * (non-Javadoc).
	 *
	 * @param request the request
	 * @return the response
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see retrofit.client.Client#execute(retrofit.client.Request)
	 */
	@Override
	public Response execute( final Request request ) throws IOException
	{
		HttpUriRequest apacheRequest = AbstractHttpClient.createRequest( request );

		if ( ( useBasicAuth ) && ( credentials != null ) )
		{
			String string = "Basic " + Base64.encodeBase64String( ( credentials.getUserName() + ":" + credentials.getPassword() ).getBytes() );
			apacheRequest.addHeader( "Accept", "application/json" );
			apacheRequest.addHeader( "Authorization", string );
		}
		HttpResponse apacheResponse = execute( client, apacheRequest );
		return AbstractHttpClient.parseResponseRetrofit( request.getUrl(), apacheResponse );
	}

	// @Override
	// public feign.Response execute( feign.Request paramRequest, feign.Request.Options paramOptions ) throws IOException
	// {
	// HttpUriRequest apacheRequest = AbstractHttpClient.createRequest( request );
	//
	// if ( ( useBasicAuth ) && ( credentials != null ) )
	// {
	// String string = "Basic " + Base64.encodeBase64String( ( credentials.getUserName() + ":" + credentials.getPassword() ).getBytes() );
	// apacheRequest.addHeader( "Accept", "application/json" );
	// apacheRequest.addHeader( "Authorization", string );
	// }
	// HttpResponse apacheResponse = execute( client, apacheRequest );
	// return AbstractHttpClient.parseResponseRetrofit( request.getUrl(), apacheResponse );
	// }

	/**
	 * Gets the.
	 *
	 * @param request the request
	 * @return the http response
	 * @throws ClientProtocolException the client protocol exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public HttpResponse get( HttpGet request ) throws ClientProtocolException, IOException
	{
		return client.execute( request, context );
	}

	/**
	 * Gets the.
	 *
	 * @param url the url
	 * @return the http response
	 * @throws ClientProtocolException the client protocol exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws AuthenticationException the authentication exception
	 */
	public HttpResponse get( String url ) throws ClientProtocolException, IOException, AuthenticationException
	{
		HttpGet request = new HttpGet( url );
		if ( ( useBasicAuth ) && ( credentials != null ) )
		{
			request.addHeader( new BasicScheme().authenticate( credentials, request ) );
		}

		for ( Entry< String, String > staticRequestParam : staticRequestParams.entrySet() )
		{
			request.addHeader( staticRequestParam.getKey(), staticRequestParam.getValue() );
		}

		return get( request );
	}

	public Map< String, String > staticRequestParams = new HashMap< String, String >();

	/**
	 * Gets the.
	 *
	 * @param url the url
	 * @param creds the creds
	 * @return the http response
	 * @throws ClientProtocolException the client protocol exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws AuthenticationException the authentication exception
	 */
	public HttpResponse get( String url, UsernamePasswordCredentials creds ) throws ClientProtocolException, IOException, AuthenticationException
	{
		HttpGet request = new HttpGet( url );

		for ( Entry< String, String > staticRequestParam : staticRequestParams.entrySet() )
		{
			request.addHeader( staticRequestParam.getKey(), staticRequestParam.getValue() );
		}
		request.addHeader( new BasicScheme().authenticate( creds, request ) );

		return get( request );
	}

	/**
	 * Gets the client.
	 *
	 * @return the client
	 */
	public HttpClient getClient()
	{
		return client;
	}

	/**
	 * Gets the context.
	 *
	 * @return the context
	 */
	public HttpContext getContext()
	{
		return context;
	}

	/**
	 * Gets the string.
	 *
	 * @param url the url
	 * @return the string
	 * @throws ClientProtocolException the client protocol exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws AuthenticationException the authentication exception
	 */
	public String getString( String url ) throws ClientProtocolException, IOException, AuthenticationException
	{
		HttpResponse response = get( url );
		BufferedReader rd = new BufferedReader( new InputStreamReader( response.getEntity().getContent() ) );
		StringBuffer result = new StringBuffer();
		String line = "";
		while ( ( line = rd.readLine() ) != null )
		{
			result.append( line );
		}

		return result.toString();
	}

	/**
	 * Gets the string.
	 *
	 * @param url the url
	 * @param creds the creds
	 * @return the string
	 * @throws ClientProtocolException the client protocol exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws AuthenticationException the authentication exception
	 */
	public String getString( String url, UsernamePasswordCredentials creds ) throws ClientProtocolException, IOException, AuthenticationException
	{
		HttpResponse response = get( url, creds );

		BufferedReader rd = new BufferedReader( new InputStreamReader( response.getEntity().getContent() ) );

		StringBuffer result = new StringBuffer();
		String line = "";
		while ( ( line = rd.readLine() ) != null )
		{
			result.append( line );
		}

		return result.toString();
	}

	/**
	 * Post exec wait.
	 *
	 * @param request the request
	 * @return the http response
	 */
	protected HttpResponse postExecWait( HttpPost request )
	{
		HttpResponse response = null;
		boolean notReady = true;

		while ( notReady )
		{
			try
			{
				response = client.execute( request );
				notReady = false;

				int status = response.getStatusLine().getStatusCode();
				if ( status < 200 || status >= 400 )
				{
					notReady = true;
				}
			}
			catch ( Exception e )
			{
				notReady = true;
			}
		}
		return response;
	}

	/**
	 * Process form.
	 *
	 * @param request the request
	 * @param form the form
	 * @return the http post
	 * @throws UnsupportedEncodingException the unsupported encoding exception
	 */
	protected HttpPost processForm( HttpPost request, Element form ) throws UnsupportedEncodingException
	{
		List< NameValuePair > urlParameters = new ArrayList< NameValuePair >();

		boolean loginProcessed = false;

		for ( Element tag : form.getElementsByTag( "input" ) )
		{
			switch ( tag.attr( "name" ) )
			{
				case "RelayState":
				case "SAMLRequest":
				case "SAMLResponse":
				case "opentoken":
					urlParameters.add( new BasicNameValuePair( tag.attr( "name" ), tag.attr( "value" ) ) );
					break;

				case "pf.username":
				case "pf.pass":
					if ( !loginProcessed )
					{
						if ( credentials != null )
						{
							urlParameters.add( new BasicNameValuePair( "pf.username", credentials.getUserName() ) );
							urlParameters.add( new BasicNameValuePair( "pf.pass", credentials.getPassword() ) );
							urlParameters.add( new BasicNameValuePair( "pf.username", credentials.getUserName() ) );
							urlParameters.add( new BasicNameValuePair( "pf.ok", "clicked" ) );
							loginProcessed = true;
						}
					}
					break;

				default:
					break;
			}

		}
		request.setEntity( new UrlEncodedFormEntity( urlParameters ) );
		return request;
	}

	/**
	 * Response string.
	 *
	 * @param response the response
	 * @return the string
	 * @throws IllegalStateException the illegal state exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected String responseString( HttpResponse response ) throws IllegalStateException, IOException
	{
		BufferedReader rd = new BufferedReader( new InputStreamReader( response.getEntity().getContent() ) );
		StringBuffer result = new StringBuffer();
		String line = "";
		while ( ( line = rd.readLine() ) != null )
		{
			result.append( line );
		}
		return result.toString();
	}

	/**
	 * Sets the context.
	 *
	 * @param context the new context
	 */
	public void setContext( final HttpContext context )
	{
		this.context = context;
	}
}
