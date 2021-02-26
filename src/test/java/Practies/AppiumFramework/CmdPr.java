package Practies.AppiumFramework;

import java.io.IOException;

public class CmdPr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CmdPr p=new CmdPr();
		p.executeCmd();
		

	}
	public void executeCmd() {
	    String anyCommand="appium";
	    try {
	        Process process = Runtime.getRuntime().exec("cmd /c start cmd.exe /K " + anyCommand);

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
