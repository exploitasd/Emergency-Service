package project;

import java.sql.SQLException;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException, SQLException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		new LoginFrame().createLoginGui();	

	}
}
