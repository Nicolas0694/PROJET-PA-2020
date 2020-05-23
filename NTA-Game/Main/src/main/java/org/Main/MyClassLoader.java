package org.Main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.security.SecureClassLoader;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class MyClassLoader extends SecureClassLoader {
	private ArrayList<File> path = null;

	public MyClassLoader(ArrayList<File> p) {
		super();
		this.path = p;
	}


	public MyClassLoader(ClassLoader classLoader, ArrayList<File> p) {
		super(classLoader);
		this.path = p;
	}


	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] b = loadClassData(name);
		return super.defineClass(name, b, 0, b.length);
	}

	private byte[] loadClassData(String name) throws ClassNotFoundException {
		System.out.println("MyClassLoader.loadClassData() " + name);
		String file_path = name.replace('.', '/') + ".class";

		Pattern isZipOrJar = Pattern.compile(".*(zip|jar)");

		try {
			for (File f : path) {
				// Si dossier
				if (f.isDirectory()) {
					String abs_path = f.getAbsolutePath() + "\\" + file_path;
					File fp = new File(abs_path);
					if (fp.exists()) {
						return Files.readAllBytes(fp.toPath());
					} else {
						throw new ClassNotFoundException();
					}
					// Si Fichier .zip ou .jar
				} else if (isZipOrJar.matcher(f.getName()).matches()) {
					ZipFile zp = new ZipFile(f);
					ZipEntry ze = zp.getEntry(file_path);
					if (ze == null) {
						zp.close();
						throw new ClassNotFoundException();
					}
					InputStream is = zp.getInputStream(ze);
					byte[] bytecode = is.readAllBytes();
					zp.close();
					is.close();
					return bytecode;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		throw new ClassNotFoundException();
	}

	public static final void log(Object o) {
		System.out.println(o);
	}
}
