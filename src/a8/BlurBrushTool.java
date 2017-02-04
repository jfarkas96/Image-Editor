package a8;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class BlurBrushTool implements Tool {
	private BlurBrushToolUI ui;
	private ImageEditorModel model;
	
	public BlurBrushTool(ImageEditorModel model) {
		this.model = model;
		ui = new BlurBrushToolUI();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		model.paintAt(e.getX(), e.getY() , ui.getBrushSize(), ui.getBlurFactor());

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		model.paintAt(e.getX(), e.getY() , ui.getBrushSize(), ui.getBlurFactor());
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getName() {
		return "Blur Brush";
	}

	@Override
	public JPanel getUI() {
		return ui;
	}

}
