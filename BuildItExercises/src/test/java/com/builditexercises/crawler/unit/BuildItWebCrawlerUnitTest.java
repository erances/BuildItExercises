package com.builditexercises.crawler.unit;

import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.builditexercises.crawler.BuildItWebCrawler;

/**
 * Unit Test class for BuildIt exercises.
 * 
 */
@RunWith(SpringRunner.class)
public class BuildItWebCrawlerUnitTest {

	@Before
	public void setUp() {
		
	}
	
	
	/**
	 * test explore() url param if null
	 */
	@Test
	public void testExploreWithNullUrl() {
		
		boolean retVal = true;
		retVal = new BuildItWebCrawler().explore(null, 10);
		assertFalse(retVal);
	}
	
	/**
	 * test explore() url param if ""
	 */
	@Test
	public void testExploreWithEmptyStringUrl() {
		
		boolean retVal = true;
		retVal = new BuildItWebCrawler().explore("", 10);
		assertFalse(retVal);
	}
	
	/**
	 * test explore() url param 
	 *   if it doesn't start with 'https://'
	 */
	@Test
	public void testExploreDoesNotStartWithHttps() {
		
		boolean retVal = true;
		retVal = new BuildItWebCrawler().explore("wiprodigital.com", 10);
		assertFalse(retVal);
	}
	
	/**
	 * test explore() url param
	 *   if it doesn't start with "http://"
	 */
	@Test
	public void testExploreDoesNotStartWithHttp() {
		
		boolean retVal = true;
		retVal = new BuildItWebCrawler().explore("wiprodigital.com.", 10);
		assertFalse(retVal);
	}
	
	/**
	 * test explore() maxPages if zero
	 */
	@Test
	public void testExploreMaxPagesZero() {
		
		boolean retVal = true;
		retVal = new BuildItWebCrawler().explore("http://wiprodigital.com", 0);
		assertFalse(retVal);
	}
	
	/**
	 * test explore() maxPages if less than zero
	 */
	@Test
	public void testExploreMaxPagesLessThanZero() {
		
		boolean retVal = true;
		retVal = new BuildItWebCrawler().explore("http://wiprodigital.com", -1);
		assertFalse(retVal);
	}
}
