package a8;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PixelInspectorUI extends JPanel{

	private JLabel x_label;
	private JLabel y_label;
	private JLabel pixel_info;
	private JButton button;
	private FrameView magnify;
	
	public PixelInspectorUI() {
		x_label = new JLabel("X: ");
		y_label = new JLabel("Y: ");
		pixel_info = new JLabel("(r,g,b)");
		JPanel stats = new JPanel( new BorderLayout());
		stats.add(x_label, BorderLayout.NORTH);
		stats.add(y_label, BorderLayout.CENTER);
		stats.add(pixel_info, BorderLayout.SOUTH);
		button = new JButton("Copy Color");
		JPanel pixel_panel = new JPanel( new BorderLayout());
		pixel_panel.add(stats, BorderLayout.NORTH);
		pixel_panel.add(button, BorderLayout.SOUTH);
		magnify = new FrameView(new MutableFrame2D(100, 100, new ColorPixel(1,1,1)).createObservable());

		setLayout(new GridLayout(2,1));
		add(pixel_panel);
		add(magnify);
	}
	
	public void setInfo(int x, int y, Pixel p) {
		x_label.setText("X: " + x);
		y_label.setText("Y: " + y);
		pixel_info.setText(String.format("(%3.2f, %3.2f, %3.2f)", p.getRed(), p.getBlue(), p.getGreen()));		
	}
	
	public JButton getButton() {
		return button;
	}

	public void setMagnify(int x, int y, ImageEditorModel model) {
		Pixel oneone;
		Pixel onetwo;
		Pixel onethree;
		Pixel onefour;
		Pixel onefive;
		Pixel twoone;
		Pixel twotwo;
		Pixel twothree;
		Pixel twofour;
		Pixel twofive;
		Pixel threeone;
		Pixel threetwo;
		Pixel threethree;
		Pixel threefour;
		Pixel threefive;
		Pixel fourone;
		Pixel fourtwo;
		Pixel fourthree;
		Pixel fourfour;
		Pixel fourfive;
		Pixel fiveone;
		Pixel fivetwo;
		Pixel fivethree;
		Pixel fivefour;
		Pixel fivefive;
		try {
			oneone = model.getPixel(x-2, y-2);
		} catch (Exception e) {
			oneone = new ColorPixel(0,0,0);
		}
		try {
			onetwo = model.getPixel(x-1, y-2);
		} catch (Exception e) {
			onetwo = new ColorPixel(0,0,0);
		}
		try {
			onethree = model.getPixel(x, y-2);
		} catch (Exception e) {
			onethree = new ColorPixel(0,0,0);
		}
		try {
			onefour = model.getPixel(x+1, y-2);
		} catch (Exception e) {
			onefour = new ColorPixel(0,0,0);
		}
		try {
			onefive = model.getPixel(x+2, y-2);
		} catch (Exception e) {
			onefive = new ColorPixel(0,0,0);
		}
		try {
			twoone = model.getPixel(x-2, y-1);
		} catch (Exception e) {
			twoone = new ColorPixel(0,0,0);
		}
		try {
			twotwo = model.getPixel(x-1, y-1);
		} catch (Exception e) {
			twotwo = new ColorPixel(0,0,0);
		}
		try {
			twothree = model.getPixel(x, y-1);
		} catch (Exception e) {
			twothree = new ColorPixel(0,0,0);
		}
		try {
			twofour = model.getPixel(x+1, y-1);
		} catch (Exception e) {
			twofour = new ColorPixel(0,0,0);
		}
		try {
			twofive = model.getPixel(x+2, y-1);
		} catch (Exception e) {
			twofive = new ColorPixel(0,0,0);
		}
		try {
			threeone = model.getPixel(x-2, y);
		} catch (Exception e) {
			threeone = new ColorPixel(0,0,0);
		}
		try {
			threetwo = model.getPixel(x-1, y);
		} catch (Exception e) {
			threetwo = new ColorPixel(0,0,0);
		}
		try {
			threethree = model.getPixel(x, y);
		} catch (Exception e) {
			threethree = new ColorPixel(0,0,0);
		}
		try {
			threefour = model.getPixel(x+1, y);
		} catch (Exception e) {
			threefour = new ColorPixel(0,0,0);
		}
		try {
			threefive = model.getPixel(x+2, y);
		} catch (Exception e) {
			threefive = new ColorPixel(0,0,0);
		}
		try {
			fourone = model.getPixel(x-2, y+1);
		} catch (Exception e) {
			fourone = new ColorPixel(0,0,0);
		}
		try {
			fourtwo = model.getPixel(x-1, y+1);
		} catch (Exception e) {
			fourtwo = new ColorPixel(0,0,0);
		}
		try {
			fourthree = model.getPixel(x, y+1);
		} catch (Exception e) {
			fourthree = new ColorPixel(0,0,0);
		}
		try {
			fourfour = model.getPixel(x+1, y+1);
		} catch (Exception e) {
			fourfour = new ColorPixel(0,0,0);
		}
		try {
			fourfive = model.getPixel(x+2, y+1);
		} catch (Exception e) {
			fourfive = new ColorPixel(0,0,0);
		}
		try {
			fiveone = model.getPixel(x-2, y+2);
		} catch (Exception e) {
			fiveone = new ColorPixel(0,0,0);
		}
		try {
			fivetwo = model.getPixel(x-1, y+2);
		} catch (Exception e) {
			fivetwo = new ColorPixel(0,0,0);
		}
		try {
			fivethree = model.getPixel(x, y+2);
		} catch (Exception e) {
			fivethree = new ColorPixel(0,0,0);
		}
		try {
			fivefour = model.getPixel(x+1, y+2);
		} catch (Exception e) {
			fivefour = new ColorPixel(0,0,0);
		}
		try {
			fivefive = model.getPixel(x+2, y+2);
		} catch (Exception e) {
			fivefive = new ColorPixel(0,0,0);
		}
		MutableFrame2D mag = new MutableFrame2D(100,100, new ColorPixel(0,0,0));
		for (int i=0; i<20; i++){
			for (int j=0; j<20; j++) {
				mag.setPixel(i, j, oneone);
			}
		}
		for (int i=20; i<40; i++){
			for (int j=0; j<20; j++) {
				mag.setPixel(i, j, onetwo);
			}
		}
		for (int i=40; i<60; i++){
			for (int j=0; j<20; j++) {
				mag.setPixel(i, j, onethree);
			}
		}
		for (int i=60; i<80; i++){
			for (int j=0; j<20; j++) {
				mag.setPixel(i, j, onefour);
			}
		}
		for (int i=80; i<100; i++){
			for (int j=0; j<20; j++) {
				mag.setPixel(i, j, onefive);
			}
		}
		for (int i=0; i<20; i++){
			for (int j=20; j<40; j++) {
				mag.setPixel(i, j, twoone);
			}
		}
		for (int i=20; i<40; i++){
			for (int j=20; j<40; j++) {
				mag.setPixel(i, j, twotwo);
			}
		}
		for (int i=40; i<60; i++){
			for (int j=20; j<40; j++) {
				mag.setPixel(i, j, twothree);
			}
		}
		for (int i=60; i<80; i++){
			for (int j=20; j<40; j++) {
				mag.setPixel(i, j, twofour);
			}
		}
		for (int i=80; i<100; i++){
			for (int j=20; j<40; j++) {
				mag.setPixel(i, j, twofive);
			}
		}
		for (int i=0; i<20; i++){
			for (int j=40; j<60; j++) {
				mag.setPixel(i, j, threeone);
			}
		}
		for (int i=20; i<40; i++){
			for (int j=40; j<60; j++) {
				mag.setPixel(i, j, threetwo);
			}
		}
		for (int i=40; i<60; i++){
			for (int j=40; j<60; j++) {
				mag.setPixel(i, j, threethree);
			}
		}
		for (int i=60; i<80; i++){
			for (int j=40; j<60; j++) {
				mag.setPixel(i, j, threefour);
			}
		}
		for (int i=80; i<100; i++){
			for (int j=40; j<60; j++) {
				mag.setPixel(i, j, threefive);
			}
		}
		for (int i=0; i<20; i++){
			for (int j=60; j<80; j++) {
				mag.setPixel(i, j, fourone);
			}
		}
		for (int i=20; i<40; i++){
			for (int j=60; j<80; j++) {
				mag.setPixel(i, j, fourtwo);
			}
		}
		for (int i=40; i<60; i++){
			for (int j=60; j<80; j++) {
				mag.setPixel(i, j, fourthree);
			}
		}
		for (int i=60; i<80; i++){
			for (int j=60; j<80; j++) {
				mag.setPixel(i, j, fourfour);
			}
		}
		for (int i=80; i<100; i++){
			for (int j=60; j<80; j++) {
				mag.setPixel(i, j, fourfive);
			}
		}
		for (int i=0; i<20; i++){
			for (int j=80; j<100; j++) {
				mag.setPixel(i, j, fiveone);
			}
		}
		for (int i=20; i<40; i++){
			for (int j=80; j<100; j++) {
				mag.setPixel(i, j, fivetwo);
			}
		}
		for (int i=40; i<60; i++){
			for (int j=80; j<100; j++) {
				mag.setPixel(i, j, fivethree);
			}
		}
		for (int i=60; i<80; i++){
			for (int j=80; j<100; j++) {
				mag.setPixel(i, j, fivefour);
			}
		}
		for (int i=80; i<100; i++){
			for (int j=80; j<100; j++) {
				mag.setPixel(i, j, fivefive);
			}
		}
		magnify.setFrame(mag.createObservable());
	}
}
