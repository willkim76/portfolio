/*
 * This program is to demonstrate basic Version Control using Git/GitHub
 *
 */
package VersionControl;

public class Alpha {
	private static String version = "v1.0.0";

	public static void main(String[] args) {
		Alpha firstBuild = new Alpha();
		System.out.println(firstBuild.getVersion());
	}

	public String getVersion() {
		return version;
	}
}
