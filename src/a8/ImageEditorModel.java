package a8;

public class ImageEditorModel {

	private Frame2D original;
	private ObservableFrame2D current;

	public ImageEditorModel(Frame2D f) {
		original = f;
		current = original.copy().createObservable();
	}

	public ObservableFrame2D getCurrent() {
		return current;
	}

	public Pixel getPixel(int x, int y) {
		return current.getPixel(x, y);
	}

	public void paintAt(int x, int y, Pixel brushColor, int brush_size, int opacity) {
		current.suspendObservable();;

		for (int xpos=x-brush_size+1; xpos <=x+brush_size-1; xpos++) {
			for (int ypos=y-brush_size+1; ypos <=y+brush_size-1; ypos++) {
				if (xpos >= 0 &&
						xpos < current.getWidth() &&
						ypos >= 0 &&
						ypos < current.getHeight()) {
					double newred = brushColor.getRed()*((double)opacity/100) + current.getPixel(xpos, ypos).getRed()*(1-((double)opacity/100));
					double newblue = brushColor.getBlue()*((double)opacity/100) + current.getPixel(xpos, ypos).getRed()*(1-((double)opacity/100));
					double newgreen = brushColor.getGreen()*((double)opacity/100) + current.getPixel(xpos, ypos).getRed()*(1-((double)opacity/100));
					Pixel newpix = new ColorPixel(newred, newgreen, newblue);
					current.setPixel(xpos, ypos, newpix);
				}
			}
		}
		current.resumeObservable();
	}

	public void setFrame(Frame2D f) {
		original = f;
		current = original.copy().createObservable();
	}

	public void paintAt(int x, int y, int brushSize, int blurFactor) {
		current.suspendObservable();
		double newred = 0;
		double newblue = 0;
		double newgreen = 0;
		int numpix = 0;
		Frame2D newframe = current.copy();

		for (int xpos=x-brushSize+1; xpos <=x+brushSize-1; xpos++) {
			for (int ypos=y-brushSize+1; ypos <=y+brushSize-1; ypos++) {
				if (xpos >= 0 &&
						xpos < current.getWidth() &&
						ypos >= 0 &&
						ypos < current.getHeight()) {
					for(int k = xpos-blurFactor;k < xpos+blurFactor+1; k++){
						for(int l = ypos-blurFactor;l < ypos+blurFactor+1; l++){
							if(k >= 0 && l >= 0 && k < current.getWidth() && l < current.getHeight()){
								newred = newred + current.getPixel(k, l).getRed();
								newblue = newblue + current.getPixel(k, l).getBlue();
								newgreen = newgreen + current.getPixel(k, l).getGreen();
								numpix++;
							}
						}
					}
					Pixel p = new ColorPixel((newred/numpix), (newgreen/numpix), (newblue/numpix));
					newframe.setPixel(xpos, ypos, p);
					newred = 0;
					newblue = 0;
					newgreen = 0;
					numpix = 0;
				}
			}
		}
		for(int i = 0; i < newframe.getWidth(); i++) {
			for(int j = 0; j < newframe.getHeight(); j++){
				current.setPixel(i,j,newframe.getPixel(i, j));
			}
		}
		current.resumeObservable();
	}
}

