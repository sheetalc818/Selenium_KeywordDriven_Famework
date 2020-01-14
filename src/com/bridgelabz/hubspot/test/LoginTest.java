package com.bridgelabz.hubspot.test;

import org.testng.annotations.Test;

import com.bridgelabz.keyword.engine.KeywordEngine;

/**
 * @author Sheetal
 * @since 13/01/2019
 * @purpose Tests for login and sign up
 */
public class LoginTest 
{
	public KeywordEngine keywordEngine;

	@Test
	public void loginTest() 
	{
		keywordEngine = new KeywordEngine();
		keywordEngine.startExecution("login");
	}

	@Test
	public void signUpTest() 
	{
		keywordEngine = new KeywordEngine();
		keywordEngine.startExecution("signup");
	}
}
