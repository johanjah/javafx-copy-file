package foss.johan.copytools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 
 * @author johan
 *
 */
public class CopyManager {

	/**
	 * copying files from source folder to destination folder. it will reading files
	 * inside folder inside source folder (repeating). if destination file already
	 * exists it will produce (x) number. while x is integer >= 1. example : if
	 * filename.exe already exists new file will be like filename (1).exe
	 * 
	 * @param source
	 * @param dest
	 * @throws IOException
	 * @throws FileAlreadyExistsException
	 * 
	 * @author johan
	 */
	public void copyFile(File source, File dest) throws IOException {
		File[] listFiles = source.listFiles();
		String strDestPath = dest.getAbsolutePath();

		for (File srcFile : listFiles) {
			if (srcFile.isFile() && !srcFile.isHidden()) {

				String fileName = srcFile.getName();
				StringBuilder fileNameBuilder = new StringBuilder(fileName);
				File destFile = new File(strDestPath + "\\" + fileName);

				if (destFile.exists()) {
					if (fileName.contains(".")) {
						destFile = new File(strDestPath + "\\" + fileNameBuilder
								.replace(fileName.lastIndexOf("."), fileName.lastIndexOf("."), " (1)").toString());
						fileName = destFile.getName();
						fileNameBuilder = new StringBuilder(fileName);
					}
					for (int x = 1; destFile.exists(); x++) {
						if (fileName.contains(".")) {
							destFile = new File(strDestPath + "\\" + fileNameBuilder
									.replace(fileName.lastIndexOf(" "), fileName.lastIndexOf("."), " (" + x + ")")
									.toString());
						} else {
							destFile = new File(strDestPath + "\\" + fileName + " (" + x + ")");
						}
					}
					copyFileUsingStream(srcFile, destFile);
				} else {
					copyFileUsingStream(srcFile, destFile);
				}

			} else if (srcFile.isDirectory()) {
				copyFile(srcFile, dest);
			}
		}
	}

	private void copyFileUsingStream(File source, File dest) throws IOException {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(source);
			os = new FileOutputStream(dest);
			byte[] buffer = new byte[16384];
			int length;
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
		} finally {
			is.close();
			os.close();
		}
	}
}
