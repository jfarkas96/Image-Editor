package views;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import a7.A7Helper;
import a7.Picture;
import a7.PuzzlePictureWidget;

public class FramePuzzle {

	public static void main(String[] args) throws IOException {
		Picture p = A7Helper.readFromURL("https://pbs.twimg.com/profile_images/660946436801101824/niM7azZS.jpg");
		PuzzlePictureWidget simple_widget = new PuzzlePictureWidget(p);

		JFrame main_frame = new JFrame();
		main_frame.setTitle("Assignment 7 Simple Picture View");
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel top_panel = new JPanel();
		top_panel.setLayout(new BorderLayout());
		top_panel.add(simple_widget, BorderLayout.CENTER);
		main_frame.setContentPane(top_panel);

		main_frame.pack();
		main_frame.setVisible(true);
	}
}
