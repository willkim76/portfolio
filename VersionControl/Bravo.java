/*
 * This program is to demonstrate basic Version Control using Git/GitHub
 */

package VersionControl;

public class Bravo {
	private static final String version = "v1.0.0";

	public static void main(String[] args) {
		Bravo firstBuild = new Bravo();
		System.out.println(firstBuild.getVersion());
	}

	public String getVersion() {
		return version;
	}
}
