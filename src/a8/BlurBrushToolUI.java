package a8;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class BlurBrushToolUI extends JPanel {
	private JSlider blurFact;
	private JSlider brushSize;

	public BlurBrushToolUI(){
		setLayout(new GridLayout(0,1));

		JPanel slider_panel = new JPanel();
		slider_panel.setLayout(new GridLayout(0,1));

		JPanel blurFact_slider_panel = new JPanel();
		JLabel blurFact_label = new JLabel("Blur Factor: ");
		blurFact_slider_panel.setLayout(new BorderLayout());
		blurFact_slider_panel.add(blurFact_label, BorderLayout.WEST);
		blurFact = new JSlider(1,5,1);
		blurFact_slider_panel.add(blurFact, BorderLayout.CENTER);

		JPanel size_slider_panel = new JPanel();
		JLabel size_label = new JLabel("Size:");
		size_slider_panel.setLayout(new BorderLayout());
		size_slider_panel.add(size_label, BorderLayout.WEST);
		brushSize = new JSlider(1,15,1);
		size_slider_panel.add(brushSize, BorderLayout.CENTER);

		Dimension d = blurFact_label.getPreferredSize();
		size_label.setPreferredSize(d);
		slider_panel.add(blurFact_slider_panel);
		slider_panel.add(size_slider_panel);
		add(slider_panel);
	}

	public int getBrushSize() {
		return brushSize.getValue();
	}

	public int getBlurFactor() {
		return blurFact.getValue();
	}
}
