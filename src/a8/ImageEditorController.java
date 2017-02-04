package a8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JOptionPane;

public class ImageEditorController implements ToolChoiceListener, MouseListener, MouseMotionListener, ActionListener {

	private ImageEditorView view;
	private ImageEditorModel model;
	private Tool current_tool;
	private PixelInspectorTool inspector_tool;
	private PaintBrushTool paint_brush_tool;
	private BlurBrushTool blur_brush_tool;

	public ImageEditorController(ImageEditorView view, ImageEditorModel model) {
		this.view = view;
		this.model = model;

		inspector_tool = new PixelInspectorTool(model);
		paint_brush_tool = new PaintBrushTool(model);
		blur_brush_tool = new BlurBrushTool(model);

		view.addToolChoiceListener(this);
		view.addMouseListener(this);
		view.addMouseMotionListener(this);
		PixelInspectorUI inspector_tool_ui = (PixelInspectorUI) inspector_tool.getUI();
		inspector_tool_ui.getButton().addActionListener(this);
		view.getOpenButton().addActionListener(this);
		view.getUndoButton().addActionListener(this);

		this.toolChosen(view.getCurrentToolName());
	}

	@Override
	public void toolChosen(String tool_name) {
		if (tool_name.equals("Pixel Inspector")) {
			view.installToolUI(inspector_tool.getUI());
			current_tool = inspector_tool;
		} else if (tool_name.equals("Paint Brush")) {
			view.installToolUI(paint_brush_tool.getUI());
			current_tool = paint_brush_tool;
		} 
		else if (tool_name.equals("Blur Brush")) {
			view.installToolUI(blur_brush_tool.getUI());
			current_tool = blur_brush_tool;
		} 
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		current_tool.mouseClicked(e);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		current_tool.mousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		current_tool.mouseReleased(e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		current_tool.mouseEntered(e);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		current_tool.mouseExited(e);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		current_tool.mouseDragged(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		current_tool.mouseMoved(e);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Copy Color") {
			double red = inspector_tool.getRed();
			double blue = inspector_tool.getBlue();
			double green = inspector_tool.getGreen();
			PaintBrushToolUI paintbrush = (PaintBrushToolUI) paint_brush_tool.getUI();
			paintbrush.setSliders((int) (red * 100), (int) (100 * green),(int) (blue * 100));
		}
		if (e.getActionCommand() == "Open New Image") {
			String url = JOptionPane.showInputDialog(view.getParent(), "URL?", null);
			try {
				Frame2D f = MutableFrame2D.readFromURL(url);
				model.setFrame(f);
				view.setView(model, model.getCurrent());
			} catch (Exception ex){
			}
		}
		if(e.getActionCommand() == "Undo"){
			view.undo();
			Frame2D f = view.getFrame();
			model.setFrame(f);
			view.setView(model, model.getCurrent());
		}
		view.installToolUI(current_tool.getUI());
	}

}
