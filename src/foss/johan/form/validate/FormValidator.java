package foss.johan.form.validate;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

/**
 * 
 * @author johan
 *
 */
public class FormValidator {

	public boolean validateField(String source, String dest) {
		String strSource = source;
		String strDest = dest;
		if (source.isEmpty() || dest.isEmpty()) {
			if (strSource.isEmpty()) {
				strSource = "source folder is mandatory\n";
			} else {
				strSource = "";
			}
			if (strDest.isEmpty()) {
				strDest = "destination folder is mandatory\n";
			} else {
				strDest = "";
			}
			Alert informationAlert = new Alert(AlertType.INFORMATION, strSource + strDest, ButtonType.CLOSE);
			informationAlert.show();
			return false;
		}
		return true;
	}

	public void successMessage(String dest) {
		Alert informationAlert = new Alert(AlertType.INFORMATION, "Successfully copy file to " + dest,
				ButtonType.CLOSE);
		informationAlert.show();
	}

	public void successMessage() {
		Alert informationAlert = new Alert(AlertType.INFORMATION, "Successfully copy file to ", ButtonType.CLOSE);
		informationAlert.show();
	}

	public void failedMessage(String dest, Exception e) {
		Alert informationAlert = new Alert(AlertType.INFORMATION,
				"Failed copy file to " + dest + "\nError message : " + e.toString(), ButtonType.CLOSE);
		informationAlert.show();
	}
}
