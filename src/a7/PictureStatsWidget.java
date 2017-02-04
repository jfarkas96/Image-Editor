package a7;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PictureStatsWidget extends JPanel implements MouseListener {

	private Container Stats;
	private JLabel X;
	private JLabel Y;
	private JLabel Red;
	private JLabel Green;
	private JLabel Blue;
	private JLabel Brightness;
	private PictureView picture_view;

	public PictureStatsWidget(Picture picture){
		setLayout(new BorderLayout());

		picture_view = new PictureView(picture.createObservable());
		picture_view.addMouseListener(this);
		add(picture_view, BorderLayout.CENTER);
		X = new JLabel("X: ");
		Y = new JLabel("Y: ");
		Red = new JLabel("Red: ");
		Green = new JLabel("Green: ");
		Blue = new JLabel("Blue: ");
		Brightness = new JLabel("Brightness: ");
		Stats = new JPanel(new GridLayout(0,1,0,0));
		Stats.add(X);
		Stats.add(Y);
		Stats.add(Red);
		Stats.add(Blue);
		Stats.add(Green);
		Stats.add(Brightness);
		add(Stats, BorderLayout.WEST);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Pixel p;
		p = picture_view.getPicture().getPixel(e.getX(),e.getY());
		X.setText("X: "+e.getX());
		Y.setText("Y: "+e.getY());
		Red.setText("Red: "+(double)Math.round(p.getRed()*100)/100);
		Blue.setText("Blue: "+(double)Math.round(p.getBlue()*100)/100);
		Green.setText("Green: "+(double)Math.round(p.getGreen()*100)/100);
		Brightness.setText("Brightness: "+(double)Math.round(p.getIntensity()*100)/100);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}
