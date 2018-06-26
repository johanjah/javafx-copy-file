package foss.johan.tools;

import java.io.File;

import com.jfoenix.controls.JFXTextField;

import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * 
 * @author johan
 *
 */
public class FileBrowser {
	public void browseFolder(JFXTextField txtSource, Stage stage) {
		DirectoryChooser chooser = new DirectoryChooser();
		try {
			chooser.setTitle("Select Folder");
			File f = chooser.showDialog(stage);

			String fileName = f.getAbsolutePath();
			txtSource.setText(fileName);
		} catch (NullPointerException e) {
		}
	}

	public void browseFile(JFXTextField txtDest, Stage stage) {
		FileChooser chooser = new FileChooser();
		try {
			chooser.setTitle("Select File");
			File f = chooser.showOpenDialog(stage);
			String fileName = f.getAbsolutePath();
			txtDest.setText(fileName);
		} catch (NullPointerException e) {
		}
	}
}
