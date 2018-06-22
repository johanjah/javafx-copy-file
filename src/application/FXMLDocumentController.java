package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import foss.johan.copytools.CopyManager;
import foss.johan.tools.FileBrowser;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {

	FileBrowser fb = new FileBrowser();
	CopyManager cm = new CopyManager();

	@FXML
	private AnchorPane ap;
	@FXML
	private JFXTextField source;
	@FXML
	private JFXTextField dest;

	@FXML
	public void handleClose(MouseEvent eve) {
		System.exit(0);
	}

	@FXML
	public void browseSource() {
		Stage stage = (Stage) ap.getScene().getWindow();
		fb.browseFolder(source, stage);
	}

	@FXML
	public void browseDest() {
		Stage stage = (Stage) ap.getScene().getWindow();
		fb.browseFolder(dest, stage);
	}

	@FXML
	public void start() {
		String strSource = source.getText();
		String strDest = dest.getText();
		try {
			cm.copyFile(new File(strSource), new File(strDest));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	public void clear() {
		source.setText("");
		dest.setText("");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
