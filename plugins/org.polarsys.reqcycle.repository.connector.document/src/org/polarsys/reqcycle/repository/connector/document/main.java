package org.polarsys.reqcycle.repository.connector.document;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.eclipse.core.resources.IResource;


public class main {

	public static void main(String[] args) {
		
		String s ="E_TOR-ALL_DFS_NV-00201 A document that uses  DFS_MUD type is an Excel document. It may have multiple sheets. \n\n\n "
				+ "\nThe following requirements of \tthis type apply to all sheets in the document."
				+ "\n#EndText"
				+ "Attribut12333 "
				+ "Attribut32132"
				+ " E_TOR-"
				+"E_TOR-ALL_DFS_NV-00303 A document that uses  DFS_MUD type is an Excel document. It may have multiple sheets. \n\n\n "
				+ "\nThe following requirements of \tthis type apply to all sheets in the document."
				+ "\n#EndText"
				+ "Attribut12333 "
				+ "Attribut32132 E_TOR";
		Pattern pat = Pattern.compile("E_TOR(.*?)#EndText",Pattern.MULTILINE|Pattern.DOTALL);
		Matcher matcher = pat.matcher(s);
		 while (matcher.find()) {
		System.out.println(matcher.group());
		System.out.println("-------------------------------------------");
		 }
		 
		/*	Pattern pat1 = Pattern.compile("(E_TOR.*)",Pattern.MULTILINE|Pattern.DOTALL);
			Matcher matcher1 = pat1.matcher(s);
			 while (matcher1.find()) {
			System.out.print(matcher1.group());
			 }*/
	}
}
