package com.builditexercises.crawler.unit;

import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.builditexercises.crawler.BuildItWebCrawlerTentacles;

/**
 * Unit Test class for BuildItWebCrawlerTentacles
 *
 */
@RunWith(SpringRunner.class)
public class BuildItWebCrawlerTentaclesUnitTest {

	@Before
	public void setUp() {
		
	}
	
	
	/**
	 * test move() with invalid status code
	 *   (other than 200)
	 */
	@Test
	public void testMoveWithInvalidStatusCode() {
		
		boolean retVal = true;
		retVal = new BuildItWebCrawlerTentacles().move("https://hello-world-internationalized");
		assertFalse(retVal);
	}
	
	/**
	 * test move() with response other than HTML
	 */
	@Test
	public void testMoveWithResponseOtherThanHtml() {
		
		boolean retVal = true;
		retVal = new BuildItWebCrawlerTentacles().move(
				"https://s17776.pcdn.co/wp-content/themes/wiprodigital/images/logo-dk.png");
		assertFalse(retVal);
	}
}
