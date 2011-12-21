package com.droidfire.test;

import java.net.URI;

import com.droidfire.campfire.Site;

import junit.framework.TestCase;

public class SiteTest extends TestCase {

	public SiteTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public final void testLogin() {
		Site site = new Site(URI.create("https://sample.campfirenow.com"));
		String response = site.login("", "");
		assertTrue(response != null);
	}

}
