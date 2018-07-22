package com.xiaolianhust.thinkinginjava.chapter20;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import jdk.nashorn.internal.ir.annotations.Ignore;

public class JUnitFlowTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("this is before class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("this is after class");
	}
	
	@Before
	public void setUp() throws Exception{
		System.out.println("this is before");
	}
	
	@After
	public void tearDown() throws Exception {
		System.out.println("this is after");
	}
	
	
	@Test(timeout=2000)
	public void test1() {
		System.out.println("this is test1");
	}
	@org.junit.Ignore
	@Test
	public void test2() {
		System.out.println("this is test2");
	}

}
