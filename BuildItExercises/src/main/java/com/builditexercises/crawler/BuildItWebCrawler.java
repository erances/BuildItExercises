package com.builditexercises.crawler;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class BuildItWebCrawler {

	private Set<String> pagesVisited = new HashSet<>();
	private List<String> pagesToVisit = new LinkedList<>();
	
	private static final String URL_NULL_OR_EMPTY_STRING = 
			"Failed. null or empty string is entered in URL.";
	
	private static final String DOES_NOT_START_WITH_HTTP_OR_HTTPS = 
			"Failed. Url does not start with 'http://' or 'https://'";
	
	private static final String MAX_PAGES_ZERO_OR_LESS_THAN_ZERO =
			"Failed. Maximum page is zero or less than 0";
	
	
	/**
	 * This is the main feature that does everything.
	 *   It creates BuildItWebCrawler tentacles that make an HTTP
	 *   request and parse the response (the web page).
	 *   
	 * @param url - main url to explore
	 * @param maxPages - maximum pages to search/explore
	 */
	public boolean explore(String url, int maxPages) {
		
		//validate url param
		if(url == null || ("".equals(url))) {
			System.out.println(URL_NULL_OR_EMPTY_STRING);
			return false;
		}
		
		if(!url.startsWith("https://") 
				&& !url.startsWith("http://")) {
			System.out.println(DOES_NOT_START_WITH_HTTP_OR_HTTPS);
			return false;
		}
		
		//validate maxPages param
		if(maxPages == 0 || maxPages < 0) {
			System.out.println(MAX_PAGES_ZERO_OR_LESS_THAN_ZERO);
			return false;
		}
		
		while(this.pagesVisited.size() < maxPages) {
			
			String currentUrl;
			BuildItWebCrawlerTentacles tentacles =
					new BuildItWebCrawlerTentacles();
			
			if(this.pagesToVisit.isEmpty()) 
			{
				currentUrl = url;
				this.pagesVisited.add(url);
			} 
			else 
			{
				currentUrl = this.nextUrl();
			}
			
			//collecting links for this page happens here
			tentacles.move(currentUrl);
			
			this.pagesToVisit.addAll(tentacles.getLinks());
		}
		
		System.out.println("\n**Done** Visited " 
				+ this.pagesVisited.size() 
				+ " web pages(s)");
		
		return true;
	}
	
	
	/**
	 * Returns next URL to visit. Also does a check
	 *   to make sure this method doesn't return a URL
	 *   that has already been visited.
	 * 
	 * @return
	 */
	private String nextUrl() 
	{
		String nextUrl;
		
		do 
		{
			nextUrl = this.pagesToVisit.remove(0);
		} while(this.pagesVisited.contains(nextUrl));
		
		this.pagesVisited.add(nextUrl);
		
		return nextUrl;
	}
	
}
