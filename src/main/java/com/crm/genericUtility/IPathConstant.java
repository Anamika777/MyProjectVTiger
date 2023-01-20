package com.crm.genericUtility;

public interface IPathConstant
{
//String DBURL="http://rmgtestingserver:8888/";
    //String	DBURL="http://localhost:3306/sdet45";
	String DBURL="jdbc:mysql://rmgtestingserver:/3333/projects";
	//String DBUSERNAME="root";
	String DBUSERNAME="root@%";
	
	String DBPASSWORD="root";
	String filepath=".\\src\\test\\resources\\CommonData4.properties";
	String Excelspath="./src\\test\\resources\\TestData4.xlsx";

	
}
