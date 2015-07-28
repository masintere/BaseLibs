package com.baselib.pojo.html;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/****************************************************************************
 * <b>Title</b>: DataStream.java <p/>
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
public class DataParser {
	private String data;
	/**
	 * runs through a line of html and access the piece of it to add to the end of the base url
	 * in order to get to a new url
	 * @return the website extension to be added to the end of the original url to reach the new page
	 * @throws IOException
	 */
	public List<String> getUris() throws IOException{
		List<String> data = new ArrayList<String>();
		
	
		String html = this.data;
		int startPos = html.indexOf("<body>");
		String newHtml = html.substring(startPos);
		int hrefPos = newHtml.indexOf("href=\"");
		
		while(hrefPos != -1){
			String newHtmlLine = newHtml.substring(hrefPos + 6);
			int quotePos = newHtmlLine.indexOf("\"");
			String extension = newHtmlLine.substring(0, quotePos);
			extension = extension.toLowerCase();
			data.add(extension);
			newHtml = newHtmlLine; //keep track of which string sets match up so that they can be used again
								   //Can be hard if not paying enough attention to positioning and such
			hrefPos = newHtmlLine.indexOf("href=\"");
		}
		
		return data;
		
	}
	
	/**
	 * finds the title of the html page to use in the WebsiteVO
	 * @return the title of the website
	 */
	public String findTitle(){
		String html = this.data;
		int titlePos = html.indexOf("<title>");
		html.substring(titlePos + 7);
		int titleEndPos = html.indexOf("<");
		html.subSequence(0, titleEndPos);
		return html;
	}
}
