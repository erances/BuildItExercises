package com.builditexercises.crawler;

public class BuildItWebCrawlerTest {

	/**
	 * Test Class for this exercise.
	 *   Run this application through this class.
	 */
	public static void main(String[] args) 
	{
		//parameters
		//1. url - the url to crawl
		//2. maxPages - maximum pages to search/crawl
		
		BuildItWebCrawler crawler = new BuildItWebCrawler();
		crawler.explore("http://wiprodigital.com", 40);
	}
}
