package com.builditexercises.crawler;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class BuildItWebCrawlerTentacles {

	private List<String> links = new LinkedList<>();
	private Document document;
	
	
	/**
	 * Performs all the work. It makes an HTTP request,
	 *   checks the response, and then gathers all links
	 *   and links to images on the page.
	 * 
	 * @param url - url to visit
	 * @return whether or not crawling is successful
	 */
	public boolean move(String url)
	{
		try
		{
			Connection connection = Jsoup.connect(url);
			Document document = connection.get();
			this.document = document;
			
			//connection status here
			if (connection.response().statusCode() == 200) 
			{
				System.out.println("\n**Visiting  web page at " + url);
			} 
			else 
			{
				System.out.println("**Failed. An error occurred.");
				return false;
			}
			
			
			//we make sure that only html is returned
			if (!connection.response().contentType().contains("text/html"))
			{
				System.out.println("**Failed. Non HTML is retrieved");
				return false;
			}
			
			
			//collect all links on this page
			Elements linksOnPage = document.select("a[href]");
			
			for(Element link : linksOnPage) 
			{
				String pageLink = link.absUrl("href");
				if (pageLink.contains("wiprodigital.com")) 
				{
					this.links.add(pageLink);
					System.out.println("<< Links: [" + pageLink + "]");
				}
				else
				{
					if (pageLink.contains("wipro")
							|| pageLink.contains("Wipro")) {
						System.out.println("<< Links: [" + pageLink + "]");
					}
				}
				
			}
			
			
			//collect all links to images on this page
			Elements linksOnImage = document.select("img");
			
			for(Element linkImage : linksOnImage) {
				System.out.println("<< Image: [" + linkImage.attr("src") + "]");
			}
			
			return true;
			
		} catch(IOException ioe) {
			//crawling is not successful 
			return false;
		}
	}
	
	
	public List<String> getLinks() {
		return this.links;
	}
	
}
