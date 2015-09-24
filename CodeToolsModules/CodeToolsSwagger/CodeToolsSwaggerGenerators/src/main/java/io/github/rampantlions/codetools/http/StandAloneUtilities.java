
package io.github.rampantlions.codetools.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.logging.Level;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.logging.LogFactory;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.IncorrectnessListener;
import com.gargoylesoftware.htmlunit.InteractivePage;
import com.gargoylesoftware.htmlunit.ScriptException;
import com.gargoylesoftware.htmlunit.SilentCssErrorHandler;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HTMLParserListener;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.javascript.JavaScriptErrorListener;

@SuppressWarnings( "deprecation" )
public class StandAloneUtilities
{
	public static String get( URL url ) throws IOException, NoSuchAlgorithmException, KeyManagementException
	{
		// Create a trust manager that does not validate certificate chains
		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
			public java.security.cert.X509Certificate[] getAcceptedIssuers()
			{
				return null;
			}

			public void checkClientTrusted( X509Certificate[] certs, String authType )
			{}

			public void checkServerTrusted( X509Certificate[] certs, String authType )
			{}
		} };

		SSLContext sc = SSLContext.getInstance( "SSL" );
		sc.init( null, trustAllCerts, new java.security.SecureRandom() );
		HttpsURLConnection.setDefaultSSLSocketFactory( sc.getSocketFactory() );

		HostnameVerifier allHostsValid = new HostnameVerifier() {
			public boolean verify( String hostname, SSLSession session )
			{
				return true;
			}
		};

		HttpsURLConnection.setDefaultHostnameVerifier( allHostsValid );

		String input = "";

		URLConnection conn = url.openConnection();

		BufferedReader br = new BufferedReader( new InputStreamReader( conn.getInputStream() ) );
		String inputLine;

		while ( ( inputLine = br.readLine() ) != null )
		{
			input += inputLine;
		}
		br.close();

		return input;
	}
	
	/**
	 * The Class HostVerifier.
	 */
	public static class HostVerifier implements X509HostnameVerifier
	{

		/**
		 * verify
		 * (non-Javadoc)
		 * 
		 * @param hostname
		 * @param session
		 * @return
		 * @see javax.net.ssl.HostnameVerifier#verify(java.lang.String, javax.net.ssl.SSLSession)
		 */
		@Override
		public boolean verify( String hostname, SSLSession session )
		{
			return true;
		}

		/**
		 * verify
		 * (non-Javadoc)
		 * 
		 * @param host
		 * @param ssl
		 * @throws IOException
		 * @see org.apache.http.conn.ssl.X509HostnameVerifier#verify(java.lang.String, javax.net.ssl.SSLSocket)
		 */
		@Override
		public void verify( String host, SSLSocket ssl ) throws IOException
		{

		}

		/**
		 * verify
		 * (non-Javadoc)
		 * 
		 * @param host
		 * @param cns
		 * @param subjectAlts
		 * @throws SSLException
		 * @see org.apache.http.conn.ssl.X509HostnameVerifier#verify(java.lang.String, java.lang.String[], java.lang.String[])
		 */
		@Override
		public void verify( String host, String[] cns, String[] subjectAlts ) throws SSLException
		{

		}

		/**
		 * verify
		 * (non-Javadoc)
		 * 
		 * @param host
		 * @param cert
		 * @throws SSLException
		 * @see org.apache.http.conn.ssl.X509HostnameVerifier#verify(java.lang.String, java.security.cert.X509Certificate)
		 */
		@Override
		public void verify( String host, X509Certificate cert ) throws SSLException
		{

		}
	}

	/**
	 * A factory for creating TrustSSLSocket objects.
	 */
	public class TrustSSLSocketFactory extends SSLSocketFactory
	{

		/** The ssl context. */
		SSLContext sslContext = SSLContext.getInstance( "TLS" );

		/**
		 * Instantiates a new trust ssl socket factory.
		 *
		 * @param truststore the truststore
		 * @throws NoSuchAlgorithmException the no such algorithm exception
		 * @throws KeyManagementException the key management exception
		 * @throws KeyStoreException the key store exception
		 * @throws UnrecoverableKeyException the unrecoverable key exception
		 */
		public TrustSSLSocketFactory( KeyStore truststore ) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException
		{
			super( truststore );

			TrustManager tm = new X509TrustManager() {
				public void checkClientTrusted( X509Certificate[] chain, String authType ) throws CertificateException
				{}

				public void checkServerTrusted( X509Certificate[] chain, String authType ) throws CertificateException
				{}

				public X509Certificate[] getAcceptedIssuers()
				{
					return null;
				}
			};

			sslContext.init( null, new TrustManager[] { tm }, null );
		}

		/**
		 * createSocket
		 * (non-Javadoc)
		 * 
		 * @return
		 * @throws IOException
		 * @see org.apache.http.conn.ssl.SSLSocketFactory#createSocket()
		 */
		@Override
		public Socket createSocket() throws IOException
		{
			return sslContext.getSocketFactory().createSocket();
		}

		/**
		 * createSocket
		 * (non-Javadoc)
		 * 
		 * @param socket
		 * @param host
		 * @param port
		 * @param autoClose
		 * @return
		 * @throws IOException
		 * @throws UnknownHostException
		 * @see org.apache.http.conn.ssl.SSLSocketFactory#createSocket(java.net.Socket, java.lang.String, int, boolean)
		 */
		@Override
		public Socket createSocket( Socket socket, String host, int port, boolean autoClose ) throws IOException, UnknownHostException
		{
			return sslContext.getSocketFactory().createSocket( socket, host, port, autoClose );
		}
	}

	/*
	 * Host name verifier.
	 * 
	 * @return the hostname verifier
	 */
	public static X509HostnameVerifier hostNameVerifier()
	{
		// HostnameVerifier hostnameVerifier = org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;
		X509HostnameVerifier allHostsValid = new HostVerifier();
		return allHostsValid;
	}

	/**
	 * New web client.
	 *
	 * @return the web client
	 */
	public static WebClient newWebClient()
	{
		LogFactory.getFactory().setAttribute( "org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog" );
		java.util.logging.Logger.getLogger( "org.apache.http.wire" ).setLevel( Level.OFF );
		java.util.logging.Logger.getLogger( "com.gargoylesoftware" ).setLevel( Level.OFF );
		java.util.logging.Logger.getLogger( "com.gargoylesoftware.htmlunit" ).setLevel( Level.OFF );
		java.util.logging.Logger.getLogger( "org.apache.commons.httpclient" ).setLevel( Level.OFF );
		java.util.logging.Logger.getLogger( "o.a.axis" ).setLevel( Level.OFF );
		java.util.logging.Logger.getLogger( "o.a.axis.transport.http" ).setLevel( Level.OFF );
		java.util.logging.Logger.getLogger( "org.apache.axis" ).setLevel( Level.OFF );

		System.setProperty( "org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog" );

		// WebClient webClient = new WebClient( BrowserVersion.INTERNET_EXPLORER_8 );
		WebClient webClient = new WebClient( BrowserVersion.FIREFOX_38 );
		// WebClient webClient = new WebClient( BrowserVersion.CHROME );

		webClient.getOptions().setJavaScriptEnabled( false );
		webClient.getOptions().setThrowExceptionOnScriptError( false );
		webClient.getOptions().setCssEnabled( true );
		webClient.getOptions().setUseInsecureSSL( true );
		webClient.getOptions().setRedirectEnabled( true );
		webClient.getOptions().setThrowExceptionOnFailingStatusCode( true );
		webClient.getOptions().setPrintContentOnFailingStatusCode( false );

		// LogFactory.getFactory().setAttribute( "org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog" );
		//
		// System.setProperty( "org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog" );
		// java.util.logging.Logger.getLogger( "com.gargoylesoftware" ).setLevel( Level.OFF );
		// java.util.logging.Logger.getLogger( "com.gargoylesoftware.htmlunit" ).setLevel( Level.OFF );
		// java.util.logging.Logger.getLogger( "com.gargoylesoftware.htmlunit.level" ).setLevel( Level.OFF );
		// java.util.logging.Logger.getLogger( "com.gargoylesoftware.htmlunit.javascript.StrictErrorReporter.level" ).setLevel( Level.OFF );
		// java.util.logging.Logger.getLogger( "com.gargoylesoftware.htmlunit.javascript.host.ActiveXObject.level" ).setLevel( Level.OFF );
		// java.util.logging.Logger.getLogger( "com.gargoylesoftware.htmlunit.javascript.host.html.HTMLDocument.level" ).setLevel( Level.OFF );
		// java.util.logging.Logger.getLogger( "com.gargoylesoftware.htmlunit.html.HtmlScript.leve" ).setLevel( Level.OFF );

		webClient.setIncorrectnessListener( new IncorrectnessListener() {

			@Override
			public void notify( final String arg0, final Object arg1 )
			{
				// Ignore.

			}
		} );

		webClient.setCssErrorHandler( new SilentCssErrorHandler() );
		webClient.setJavaScriptErrorListener( new JavaScriptErrorListener() {

			public void loadScriptError( final HtmlPage arg0, final URL arg1, final Exception arg2 )
			{
				// Ignore.

			}

			public void malformedScriptURL( final HtmlPage arg0, final String arg1, final MalformedURLException arg2 )
			{
				// Ignore.

			}

			public void scriptException( final HtmlPage paramHtmlPage, final ScriptException paramScriptException )
			{
				// Ignore.

			}

			public void timeoutError( final HtmlPage arg0, final long arg1, final long arg2 )
			{
				// Ignore.

			}

			@Override
			public void loadScriptError(InteractivePage arg0, URL arg1, Exception arg2) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void malformedScriptURL(InteractivePage arg0, String arg1, MalformedURLException arg2) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void scriptException(InteractivePage arg0, ScriptException arg1) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void timeoutError(InteractivePage arg0, long arg1, long arg2) {
				// TODO Auto-generated method stub
				
			}
		} );

		webClient.setHTMLParserListener( new HTMLParserListener() {

			@Override
			public void error( final String paramString1, final URL paramURL, final String paramString2, final int paramInt1, final int paramInt2, final String paramString3 )
			{
				// Ignore.

			}

			@Override
			public void warning( final String paramString1, final URL paramURL, final String paramString2, final int paramInt1, final int paramInt2, final String paramString3 )
			{
				// Ignore.

			}
		} );

		return webClient;
	}

	/**
	 * Setup ignore security cert.
	 *
	 * @param client2 the new up ignore security cert
	 */
	public static void setupIgnoreSecurityCert( final HttpClient client2 )
	{
		// Install the all-trusting trust manager
		try
		{
			SSLContext sc = SSLContext.getInstance( "SSL" );
			sc.init( null, ClientUtilities.trustManager(), new java.security.SecureRandom() );

			SSLSocketFactory socketFactory = new SSLSocketFactory( sc );
			socketFactory.setHostnameVerifier( hostNameVerifier() );

			Scheme sch = new Scheme( "https", 443, socketFactory );
			client2.getConnectionManager().getSchemeRegistry().register( sch );

		}
		catch ( NoSuchAlgorithmException | KeyManagementException e )
		{
			// e.printStackTrace();
		}
	}

	/**
	 * Trust manager.
	 *
	 * @return the trust manager[]
	 */
	public static TrustManager[] trustManager()
	{
		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
			@Override
			public void checkClientTrusted( final X509Certificate[] certs, final String authType )
			{}

			@Override
			public void checkServerTrusted( final X509Certificate[] certs, final String authType )
			{}

			@Override
			public java.security.cert.X509Certificate[] getAcceptedIssuers()
			{
				return null;
			}
		} };
		return trustAllCerts;
	}

}
