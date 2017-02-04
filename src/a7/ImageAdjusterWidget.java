package a7;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class ImageAdjusterWidget extends JPanel implements MouseListener, KeyListener {

	private JSlider blur;
	private JSlider saturation;
	private JSlider brightness;
	private Picture picture;
	private PictureView picture_view;

	public ImageAdjusterWidget(Picture picture){
		setLayout(new BorderLayout());
		this.picture = picture;
		picture_view = new PictureView(picture.createObservable());
		picture_view.addMouseListener(this);
		picture_view.addKeyListener(this);
		this.add(picture_view, BorderLayout.NORTH);
		JPanel blurPanel = new JPanel(new FlowLayout());
		JPanel saturationPanel = new JPanel(new FlowLayout());
		JPanel brightnessPanel = new JPanel(new FlowLayout());

		blur = new JSlider(0,5,0);
		saturation = new JSlider(-100, 100, 0);
		brightness = new JSlider(-100, 100, 0);

		blur.setMajorTickSpacing(1);
		saturation.setMajorTickSpacing(25);
		brightness.setMajorTickSpacing(25);

		blur.setPaintTicks(true);
		blur.setPaintLabels(true);
		saturation.setPaintTicks(true);
		saturation.setPaintLabels(true);
		brightness.setPaintTicks(true);
		brightness.setPaintLabels(true);

		blurPanel.add(new JLabel("Blur: "));
		brightnessPanel.add(new JLabel("Brightness: "));
		saturationPanel.add(new JLabel("Saturation: "));

		blurPanel.add(blur);
		saturationPanel.add(saturation);
		brightnessPanel.add(brightness);

		JPanel sliders = new JPanel(new GridLayout(0,1,0,0));
		sliders.add(blurPanel);
		sliders.add(saturationPanel);
		sliders.add(brightnessPanel);
		this.add(sliders, BorderLayout.CENTER);

		blur.addMouseListener(this);
		blur.addKeyListener(this);
		saturation.addMouseListener(this);
		saturation.addKeyListener(this);
		brightness.addMouseListener(this);
		brightness.addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		Picture saturated_picture = new PictureImpl(picture.getWidth(), picture.getHeight());
		int saturationFactor = saturation.getValue();
		Picture blur_picture = new PictureImpl(picture.getWidth(), picture.getHeight());
		int blurFactor = blur.getValue();
		Picture new_picture = new PictureImpl(picture.getWidth(), picture.getHeight());
		int brightnessFactor = brightness.getValue();

		double saturatedRed = 0;
		double saturatedBlue = 0;
		double saturatedGreen = 0;
		double blurRed = 0;
		double blurBlue = 0;
		double blurGreen = 0;
		int numberPixels = 0;
		Pixel light = new ColorPixel(1.0, 1.0, 1.0);
		Pixel dark = new ColorPixel(0.0, 0.0, 0.0);

		for(int i = 0; i<picture.getWidth(); i++){
			for(int j = 0; j<picture.getHeight(); j++){
				Pixel oldPixel = picture.getPixel(i, j);
				if (saturationFactor<=0){
					saturatedRed = oldPixel.getRed() * (1.0 + (saturationFactor / 100.0) ) - 
							(oldPixel.getIntensity() * saturationFactor / 100.0);
					saturatedBlue = oldPixel.getBlue() * (1.0 + (saturationFactor / 100.0) ) - 
							(oldPixel.getIntensity() * saturationFactor / 100.0);
					saturatedGreen = oldPixel.getGreen() * (1.0 + (saturationFactor / 100.0) ) - 
							(oldPixel.getIntensity() * saturationFactor / 100.0);
				}
				else if(saturationFactor>0){
					double a = Math.max(Math.max(oldPixel.getRed(), oldPixel.getBlue()), oldPixel.getGreen())+0.0001;

					saturatedRed = oldPixel.getRed() * ((a + ((1.0 - a) * (saturationFactor / 100.0))) / a);
					saturatedBlue = oldPixel.getBlue() * ((a + ((1.0 - a) * (saturationFactor / 100.0))) / a);
					saturatedGreen = oldPixel.getGreen() * ((a + ((1.0 - a) * (saturationFactor / 100.0))) / a);
				}

				Pixel saturatedPixel = new ColorPixel(saturatedRed, saturatedBlue, saturatedGreen);

				saturated_picture.setPixel(i, j, saturatedPixel);
			}

		}
		for(int i = 0; i<picture.getWidth(); i++){
			for(int j = 0; j<picture.getHeight(); j++){
				for(int k=i-blurFactor; k<i+blurFactor+1; k++){
					for(int l=j-blurFactor; l<j+blurFactor+1; l++){
						if(k>-1 && l>-1 && k<picture.getWidth() && l<picture.getHeight()){
							blurRed+=saturated_picture.getPixel(k, l).getRed();
							blurBlue+=saturated_picture.getPixel(k, l).getBlue();
							blurGreen+=saturated_picture.getPixel(k, l).getGreen();
							numberPixels++;
						}
					}
				}
				Pixel p = new ColorPixel((blurRed/numberPixels), (blurBlue/numberPixels), (blurGreen/numberPixels));
				blur_picture.setPixel(i, j, p);

				blurRed = 0;
				blurBlue = 0;
				blurGreen = 0;
				numberPixels = 0;
			}
		}
		for(int i = 0; i<picture.getWidth(); i++){
			for(int j = 0; j<picture.getHeight(); j++){
				Pixel oldPixel = blur_picture.getPixel(i, j);
				if(brightnessFactor>=0){
					double factor = (double)brightnessFactor/100;
					new_picture.setPixel(i,j, new ColorPixel(factor*light.getRed()+(1-factor)*oldPixel.getRed(),
							factor*light.getGreen()+(1-factor)*oldPixel.getGreen(),
							factor*light.getBlue()+(1-factor)*oldPixel.getBlue()));
				}
				else{
					double factor = Math.abs((double)brightnessFactor/100);
					new_picture.setPixel(i,j, new ColorPixel(factor*dark.getRed()+(1-factor)*oldPixel.getRed(),
							factor*dark.getGreen()+(1-factor)*oldPixel.getGreen(),
							factor*dark.getBlue()+(1-factor)*oldPixel.getBlue()));
				}
			}
		}
		picture_view.setPicture(new_picture.createObservable());

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

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
		Picture saturated_picture = new PictureImpl(picture.getWidth(), picture.getHeight());
		int saturationFactor = saturation.getValue();
		Picture blur_picture = new PictureImpl(picture.getWidth(), picture.getHeight());
		int blurFactor = blur.getValue();
		Picture new_picture = new PictureImpl(picture.getWidth(), picture.getHeight());
		int brightnessFactor = brightness.getValue();

		double blurRed = 0;
		double blurBlue = 0;
		double blurGreen = 0;
		int numberPixels = 0;
		Pixel light = new ColorPixel(1.0, 1.0, 1.0);
		Pixel dark = new ColorPixel(0.0, 0.0, 0.0);

		for(int i = 0; i<picture.getWidth(); i++){
			for(int j = 0; j<picture.getHeight(); j++){
				double saturatedRed = 0;
				double saturatedBlue = 0;
				double saturatedGreen = 0;
				Pixel oldPixel = picture.getPixel(i, j);
				if (saturationFactor<=0){
					saturatedRed = oldPixel.getRed() * (1.0 + (saturationFactor / 100.0) ) - 
							(oldPixel.getIntensity() * saturationFactor / 100.0);
					saturatedBlue = oldPixel.getBlue() * (1.0 + (saturationFactor / 100.0) ) - 
							(oldPixel.getIntensity() * saturationFactor / 100.0);
					saturatedGreen = oldPixel.getGreen() * (1.0 + (saturationFactor / 100.0) ) - 
							(oldPixel.getIntensity() * saturationFactor / 100.0);
				}
				else if(saturationFactor>0){
					double a = Math.max(Math.max(oldPixel.getRed(), oldPixel.getBlue()), oldPixel.getGreen());

					saturatedRed = oldPixel.getRed() * ((a + ((1.0 - a) * (saturationFactor / 100.0))) / a);
					saturatedBlue = oldPixel.getBlue() * ((a + ((1.0 - a) * (saturationFactor / 100.0))) / a);
					saturatedGreen = oldPixel.getGreen() * ((a + ((1.0 - a) * (saturationFactor / 100.0))) / a);
				}

				saturated_picture.setPixel(i, j, new ColorPixel(saturatedRed, saturatedBlue, saturatedGreen));
			}

		}
		for(int i = 0; i<picture.getWidth(); i++){
			for(int j = 0; j<picture.getHeight(); j++){
				for(int k=i-blurFactor; k<i+blurFactor+1; k++){
					for(int l=j-blurFactor; l<j+blurFactor+1; l++){
						if(k>-1 && l>-1 && k<picture.getWidth() && l<picture.getHeight()){
							blurRed+=saturated_picture.getPixel(k, l).getRed();
							blurBlue+=saturated_picture.getPixel(k, l).getBlue();
							blurGreen+=saturated_picture.getPixel(k, l).getGreen();
							numberPixels++;
						}
					}
				}
				Pixel p = new ColorPixel(blurRed/numberPixels, blurBlue/numberPixels, blurGreen/numberPixels);
				blur_picture.setPixel(i, j, p);

				blurRed = 0;
				blurBlue = 0;
				blurGreen = 0;
				numberPixels = 0;
			}
		}
		for(int i = 0; i<picture.getWidth(); i++){
			for(int j = 0; j<picture.getHeight(); j++){
				Pixel oldPixel = blur_picture.getPixel(i, j);
				if(brightnessFactor>=0){
					double factor = (double)brightnessFactor/100;
					new_picture.setPixel(i,j, new ColorPixel(factor*light.getRed()+(1-factor)*oldPixel.getRed(),
							factor*light.getGreen()+(1-factor)*oldPixel.getGreen(),
							factor*light.getBlue()+(1-factor)*oldPixel.getBlue()));
				}
				else{
					double factor = Math.abs((double)brightnessFactor/100);
					new_picture.setPixel(i,j, new ColorPixel(factor*dark.getRed()+(1-factor)*oldPixel.getRed(),
							factor*dark.getGreen()+(1-factor)*oldPixel.getGreen(),
							factor*dark.getBlue()+(1-factor)*oldPixel.getBlue()));
				}
			}
		}
		picture_view.setPicture(new_picture.createObservable());
	}
}
