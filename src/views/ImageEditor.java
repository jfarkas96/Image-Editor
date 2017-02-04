package views;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import a8.Frame2D;
import a8.ImageEditorController;
import a8.ImageEditorModel;
import a8.ImageEditorView;
import a8.MutableFrame2D;

public class ImageEditor {
	public static void main(String[] args) throws IOException {
		Frame2D f = MutableFrame2D.readFromURL("https://pbs.twimg.com/profile_images/660946436801101824/niM7azZS.jpg");

		JFrame main_frame = new JFrame();
		main_frame.setTitle("Assignment 8 Image Editor");
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ImageEditorModel model = new ImageEditorModel(f);
		ImageEditorView view = new ImageEditorView(main_frame, model);
 		ImageEditorController controller = new ImageEditorController(view, model);
		

		JPanel top_panel = new JPanel();
		top_panel.setLayout(new BorderLayout());
		top_panel.add(view, BorderLayout.CENTER);
		main_frame.setContentPane(top_panel);

		main_frame.pack();
		main_frame.setVisible(true);
	}
}