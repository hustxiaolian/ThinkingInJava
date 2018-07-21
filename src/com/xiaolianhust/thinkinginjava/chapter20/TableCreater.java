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
			//1.���ļ�����ȡ��Ӧ������Ͷ����Ա��ں����ķ������
			Class<?> currClass = Class.forName(classFileName);
			
			//2. ��ȡ����
			DBTable currClassAnno = currClass.getAnnotation(DBTable.class);
			//�жϵ�ǰ���Ƿ�����˱���ע��
			if(currClassAnno == null) {
				System.out.printf("current class(%s) don't have DBTable annotation\n", currClass.getSimpleName());
			}
			String currTableName = currClassAnno.name();
			if(currTableName.length() < 1)
				currTableName = currClass.getName().toUpperCase();
			
			
			//3.��Ը��������������һ������������жϣ�������������ע�⣬��Ӧ�����Ƕ�����Ǹ�SQLע��,�൱�ڻ�ȡÿ���ֶζ���������Լ�������Ϣ
			List<String> columeDefs = new ArrayList<>();
			for(Field currField : currClass.getDeclaredFields()) {
				String columeName = null;
				Annotation[] allAnno = currField.getDeclaredAnnotations();//��Ϊ���ǲ�֪����ǰ����ע��ľ������ͣ���ôֻ��ʹ�û��������ȱ�ʾ
				if(allAnno.length < 1)
					continue;
				//�����ǰ���ݵ�ע��ʱSQLString
				if(allAnno[0] instanceof SQLString) {
					SQLString sString = (SQLString) allAnno[0];
					if(sString.name().length() < 1)
						columeName = currField.getName().toUpperCase();
					else
						columeName = sString.name();
					columeDefs.add(columeName + " VARCHAR(" + sString.value() + ")" + getConstraint(sString.constraints()));
				}
				
				//�����ǰע�������ΪSQLInteger
				if(allAnno[0] instanceof SQLInteger) {
					SQLInteger sInt = (SQLInteger) allAnno[0];
					if(sInt.name().length() < 1)
						columeName = currField.getName().toUpperCase();
					else
						columeName = sInt.name();
					columeDefs.add(columeName + " INT" + getConstraint(sInt.constraints()));
				}
			}
			//4. ���ɵ�ǰ���sql��������
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
