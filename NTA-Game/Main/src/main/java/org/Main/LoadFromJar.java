package org.main;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class LoadFromJar extends ClassLoader {

	// load class from fixed directory
	public Class findClass(String name) {
		String url = name.replace(".", "/") + ".class";
		System.out.println("LoadFromJar.findClass() looking for -" + url + "-");

		try {
			// ZipInputStream zip = new ZipInputStream(new
			// FileInputStream("/Users/fhuet/Documents/workspaces/Miage/CustomClass/lib/custom.jar"));
			ZipFile zf = new ZipFile(
					new File(
							"/Users/fhuet/Documents/workspaces/Miage/CustomClass/lib/custom.jar"));
			// while(true) {
			Enumeration<? extends ZipEntry> en = zf.entries();
			while (en.hasMoreElements()) {
				ZipEntry e = en.nextElement();
				if (e != null) {
					// System.out.println("LoadFromJar.findClass() -" +
					// e.getName()+ "-");
					if (url.equals(e.getName())) {

						System.out
								.println("LoadFromJar.findClass() found in zip !");
						byte[] buf= readFromZipEntry(zf.getInputStream(e));
						Class c = defineClass(name, buf, 0, buf.length);
						return c; 
					}
					System.out.println("LoadFromJar.findClass() " + e);
				} else {
					return null;
				}
			}
			// }
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Path file =
		// Paths.get("/Users/fhuet/Documents/workspaces/Miage/CustomClass/lib/custom.jar");
		// try {
		// byte[] bytecode = Files.readAllBytes(file);
		// return defineClass(name,bytecode,0,bytecode.length);
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		return null;
	}

	private byte[] readFromZipEntry(InputStream in) {
		BufferedInputStream bf = new BufferedInputStream(in);
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		byte[] buf = new byte[1024];
		try {
			int i;
			while ((i = bf.read(buf)) > 0) {
				bo.write(buf, 0, i);
				System.out.println("LoadFromJar.readFromZipEntry() read " + i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return bo.toByteArray();
	}

	// public static void main(String[] args) throws ClassNotFoundException {
	// 	String className = "fr.miage.custom.MyCustomInt";
	// 	LoadFromJar lfj = new LoadFromJar();
	// 	Class c = lfj.loadClass(className);
	// 	System.out.println("LoadFromJar.main() LOADED " + c);
	// }
}