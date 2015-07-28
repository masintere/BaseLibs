package com.baselib.pojo.html;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/****************************************************************************
 * <b>Title</b>: InternetAccess.java <p/>
 * <b>Project</b>: WebCrescendo <p/>
 * <b>Description: </b> Put Something Here
 * <p/>
 * <b>Copyright:</b> Copyright (c) 2015<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author Eric Masinter
 * @version 2.0
 * @since Jun 26, 2015<p/>
 * @updates:
 ****************************************************************************/
public class HTMLSpider {

	
	private URL websiteURL;
	private URLConnection connector;
	private String html = "";
	private HttpURLConnection con;
	
	
	public HTMLSpider(String url, String userAgent, String browser) throws IOException{
		this.websiteURL = new URL(url);
		con = (HttpURLConnection) (this.websiteURL.openConnection());
		con.setRequestProperty("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux i686; rv:38.0) Gecko/20100101 Firefox/38.0");
		con.setInstanceFollowRedirects(true);
		con.connect();
	}
	
	/**
	 * Reads the HTML code off of a website and stores it in a new file
	 * @param fileName name of the file the HTML is stored in
	 */
	public String readData(){
			BufferedReader in = null;
		try{
			in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			while((inputLine = in.readLine()) != null){
				html+=(inputLine + "\n");
			}
			in.close();
		}
		
		catch(Exception e){
			System.out.println(e);
		}
		
		return html;
	}
}
