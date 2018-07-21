package com.xiaolianhust.thinkinginjava.chapter20;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TableCreater {

	public static void main(String[] args) throws ClassNotFoundException {
		if(args.length < 1) {
			System.out.println("arguments:annotated class");
			System.exit(1);
		}
		
		for(String classFileName : args) {
			//1.从文件名获取对应类的类型对象，以便于后续的反射操作
			Class<?> currClass = Class.forName(classFileName);
			
			//2. 获取表名
			DBTable currClassAnno = currClass.getAnnotation(DBTable.class);
			//判断当前类是否进行了表名注解
			if(currClassAnno == null) {
				System.out.printf("current class(%s) don't have DBTable annotation\n", currClass.getSimpleName());
			}
			String currTableName = currClassAnno.name();
			if(currTableName.length() < 1)
				currTableName = currClass.getName().toUpperCase();
			
			
			//3.针对该类的所有数据域，一个个数据域的判断，它进行了哪种注解，对应于我们定义的那个SQL注解,相当于获取每行字段定义的名字以及其他信息
			List<String> columeDefs = new ArrayList<>();
			for(Field currField : currClass.getDeclaredFields()) {
				String columeName = null;
				Annotation[] allAnno = currField.getDeclaredAnnotations();//因为我们不知道当前数据注解的具体类型，那么只能使用基类数组先表示
				if(allAnno.length < 1)
					continue;
				//如果当前数据的注解时SQLString
				if(allAnno[0] instanceof SQLString) {
					SQLString sString = (SQLString) allAnno[0];
					if(sString.name().length() < 1)
						columeName = currField.getName().toUpperCase();
					else
						columeName = sString.name();
					columeDefs.add(columeName + " VARCHAR(" + sString.value() + ")" + getConstraint(sString.constraints()));
				}
				
				//如果当前注解的类型为SQLInteger
				if(allAnno[0] instanceof SQLInteger) {
					SQLInteger sInt = (SQLInteger) allAnno[0];
					if(sInt.name().length() < 1)
						columeName = currField.getName().toUpperCase();
					else
						columeName = sInt.name();
					columeDefs.add(columeName + " INT" + getConstraint(sInt.constraints()));
				}
			}
			//4. 生成当前类的sql定义命令
			StringBuffer sb = new StringBuffer();
			sb.append("CREATE TABLE " + currTableName + "(");
			for(String columeDef: columeDefs) {
				sb.append("\n   " + columeDef + ",");
			}
			sb.delete(sb.length() - 1, sb.length());
			String sqlcommand = sb.toString() + ");";
			
			System.out.println("current table define sql command:\n" + sqlcommand);
		}
	}

	private static String getConstraint(Constraints constraints) {
		String result = "";
		if(constraints.primaryKey())
			result += " PRIMARY KEY";
		if(!constraints.allowNull())
			result += " NOT NULL";
		if(constraints.unique())
			result += " UNIQUE";
		return result;
		
	}

}
