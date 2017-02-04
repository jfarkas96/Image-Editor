package a8;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Stack;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageEditorView extends JPanel implements MouseListener, MouseMotionListener{

	private JFrame main_frame;
	private FrameView frame_view;
	private ImageEditorModel model;
	private ToolChooserWidget chooser_widget;
	private JPanel tool_ui_panel;
	private JPanel tool_ui;
	private JButton undo;
	private JButton open;
	private JPanel button_panel;
	private Stack<FrameView> versions = new Stack<FrameView>();

	public ImageEditorView(JFrame main_frame, ImageEditorModel model) {
		this.main_frame = main_frame;
		this.model = model;

		setLayout(new BorderLayout());

		frame_view = new FrameView(model.getCurrent());

		add(frame_view, BorderLayout.NORTH);
		frame_view.addMouseListener(this);

		tool_ui_panel = new JPanel();
		tool_ui_panel.setLayout(new BorderLayout());

		chooser_widget = new ToolChooserWidget();
		tool_ui_panel.add(chooser_widget, BorderLayout.NORTH);
		add(tool_ui_panel, BorderLayout.CENTER);

		button_panel = new JPanel(new BorderLayout());
		undo = new JButton("Undo");
		open = new JButton ("Open New Image");
		button_panel.add(undo, BorderLayout.WEST);
		button_panel.add(open, BorderLayout.EAST);
		add(button_panel, BorderLayout.SOUTH);


		tool_ui = null;
	}

	public void addToolChoiceListener(ToolChoiceListener l) {
		chooser_widget.addToolChoiceListener(l);
	}

	public String getCurrentToolName() {
		return chooser_widget.getCurrentToolName();
	}

	public void installToolUI(JPanel ui) {
		if (tool_ui != null) {
			tool_ui_panel.remove(tool_ui);
		}
		tool_ui = ui;
		tool_ui_panel.add(tool_ui, BorderLayout.CENTER);
		validate();
		main_frame.pack();
	}

	@Override
	public void addMouseMotionListener(MouseMotionListener l) {
		frame_view.addMouseMotionListener(l);
	}

	@Override
	public void removeMouseMotionListener(MouseMotionListener l) {
		frame_view.removeMouseMotionListener(l);
	}

	@Override
	public void addMouseListener(MouseListener l) {
		frame_view.addMouseListener(l);
	}

	public void removeMouseListener(MouseListener l) {
		frame_view.removeMouseListener(l);
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		ObservableFrame2D copy = frame_view.getFrame().copy().createObservable();
		versions.push(new FrameView(copy));
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

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
		ObservableFrame2D copy = frame_view.getFrame().copy().createObservable();
		versions.push(new FrameView(copy));
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void setView(ImageEditorModel model2, ObservableFrame2D current) {
		model = model2;
		frame_view.setFrame(current);
	}

	public JButton getOpenButton() {
		return open;
	}

	public JButton getUndoButton() {
		return undo;
	}
	
	public void undo(){
		try{
			frame_view.setFrame(versions.pop().getFrame());
		}
		catch (Exception e) {}
	}

	public Frame2D getFrame() {
		return frame_view.getFrame();
	}
}
