package chapter17;

import java.util.List;


public class ContainerTester<C> {
	public static int fieldWidth = 8;
	public static TestParam[] defaultParams = TestParam.array(10, 5000, 100, 5000, 1000, 5000, 10000, 500);
	protected C container;
	private String headline = "";
	private List<ContainerTest<C>> tests;
	private static int sizeWidth = 5;
	private static String sizeFormat = "%" + sizeWidth + "s";
	private TestParam[] paramList = defaultParams;
	
	public ContainerTester(C container, List<ContainerTest<C>> tests) {
		super();
		this.container = container;
		this.tests = tests;
		if(container != null)
			headline = container.getClass().getName();
	}
	
	public ContainerTester(C container, List<ContainerTest<C>> tests, TestParam[] paramList) {
		this(container, tests);
		this.paramList = paramList;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	protected C initialize(int size) {
		return container;
	}
	
	public static <C> void run(C cntnr, List<ContainerTest<C>> tests) {
		new ContainerTester<>(cntnr, tests).timeTest();
	}
	
	public static <C> void run(C cntnr, List<ContainerTest<C>> tests, TestParam[] paramList) {
		new ContainerTester<>(cntnr, tests, paramList).timeTest();
	}
	

	public void timeTest() {
		// TODO Auto-generated method stub
		displayHeader();
		for(TestParam param : paramList) {
			System.out.format(sizeFormat, param.size);
			for(ContainerTest<C> currTest : tests) {
				C kcontainer = initialize(param.size);
				long start = System.nanoTime();
				int reps = currTest.test(kcontainer, param);
				long duration = System.nanoTime() - start;
				System.out.format(numberFiled(), duration / reps);
			}
			System.out.println();
		}
	}

	private void displayHeader() {
		// TODO Auto-generated method stub
		int width = fieldWidth * tests.size() + sizeWidth;
		int dashLength = width - headline.length() - 1;
		StringBuffer head = new StringBuffer(width);
		for(int i = 0;i < 0;++i)
			head.append("-");
		head.append(' ');
		head.append(headline);
		head.append(' ');
		for(int i = 0;i < dashLength / 2; ++i)
			head.append('-');
		System.out.println(head);
		System.out.format(sizeFormat, "size");
		for(ContainerTest<C> t : tests) {
			System.out.format(stringField(), t.name);
		}
		System.out.println();
	}
	
	private static String stringField() {
		return "%" + fieldWidth + "s";
	}
	
	private static String numberFiled() {
		return "%" + fieldWidth + "d";
	}
	
}
