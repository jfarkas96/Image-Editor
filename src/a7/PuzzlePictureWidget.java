package a7;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class PuzzlePictureWidget extends JPanel implements KeyListener {

	private PictureView a1, a2, a3, a4, a5, b1, b2, b3, b4, b5, c1, c2, c3, c4, c5, d1, d2, d3, d4, d5, e1, e2, e3, e4, e5;
	private double newHeight;
	private double newWidth;
	private int currentX = 5;
	private int currentY = 5;

	public PuzzlePictureWidget(Picture p){
		this.setLayout(new GridBagLayout());
		newHeight = p.getHeight()/5;
		newWidth = p.getWidth()/5;
		a5 = new PictureView(new SubPictureImpl(p, 0, p.getHeight()-(int)newHeight,(int)newWidth,(int)newHeight).createObservable());
		a4 = new PictureView(new SubPictureImpl(p, 0, p.getHeight()-(int)newHeight*2,(int)newWidth,(int)newHeight).createObservable());
		a3 = new PictureView(new SubPictureImpl(p, 0, p.getHeight()-(int)newHeight*3,(int)newWidth,(int)newHeight).createObservable());
		a2 = new PictureView(new SubPictureImpl(p, 0, p.getHeight()-(int)newHeight*4,(int)newWidth,(int)newHeight).createObservable());
		a1 = new PictureView(new SubPictureImpl(p, 0, 0,(int)newWidth,(int)newHeight).createObservable());
		b5 = new PictureView(new SubPictureImpl(p, (int)newWidth, p.getHeight()-(int)newHeight,(int)newWidth,(int)newHeight).createObservable());
		b4 = new PictureView(new SubPictureImpl(p, (int)newWidth, p.getHeight()-(int)newHeight*2,(int)newWidth,(int)newHeight).createObservable());
		b3 = new PictureView(new SubPictureImpl(p, (int)newWidth, p.getHeight()-(int)newHeight*3,(int)newWidth,(int)newHeight).createObservable());
		b2 = new PictureView(new SubPictureImpl(p, (int)newWidth, p.getHeight()-(int)newHeight*4,(int)newWidth,(int)newHeight).createObservable());
		b1 = new PictureView(new SubPictureImpl(p, (int)newWidth, 0,(int)newWidth,(int)newHeight).createObservable());
		c5 = new PictureView(new SubPictureImpl(p, (int)newWidth*2, p.getHeight()-(int)newHeight,(int)newWidth,(int)newHeight).createObservable());
		c4 = new PictureView(new SubPictureImpl(p, (int)newWidth*2, p.getHeight()-(int)newHeight*2,(int)newWidth,(int)newHeight).createObservable());
		c3 = new PictureView(new SubPictureImpl(p, (int)newWidth*2, p.getHeight()-(int)newHeight*3,(int)newWidth,(int)newHeight).createObservable());
		c2 = new PictureView(new SubPictureImpl(p, (int)newWidth*2, p.getHeight()-(int)newHeight*4,(int)newWidth,(int)newHeight).createObservable());
		c1 = new PictureView(new SubPictureImpl(p, (int)newWidth*2, 0,(int)newWidth,(int)newHeight).createObservable());
		d5 = new PictureView(new SubPictureImpl(p, (int)newWidth*3, p.getHeight()-(int)newHeight,(int)newWidth,(int)newHeight).createObservable());
		d4 = new PictureView(new SubPictureImpl(p, (int)newWidth*3, p.getHeight()-(int)newHeight*2,(int)newWidth,(int)newHeight).createObservable());
		d3 = new PictureView(new SubPictureImpl(p, (int)newWidth*3, p.getHeight()-(int)newHeight*3,(int)newWidth,(int)newHeight).createObservable());
		d2 = new PictureView(new SubPictureImpl(p, (int)newWidth*3, p.getHeight()-(int)newHeight*4,(int)newWidth,(int)newHeight).createObservable());
		d1 = new PictureView(new SubPictureImpl(p, (int)newWidth*3, 0,(int)newWidth,(int)newHeight).createObservable());
		e5 = new PictureView(new PictureImpl((int)newWidth, (int)newHeight).createObservable());
		e4 = new PictureView(new SubPictureImpl(p, (int)newWidth*4, p.getHeight()-(int)newHeight*2,(int)newWidth,(int)newHeight).createObservable());
		e3 = new PictureView(new SubPictureImpl(p, (int)newWidth*4, p.getHeight()-(int)newHeight*3,(int)newWidth,(int)newHeight).createObservable());
		e2 = new PictureView(new SubPictureImpl(p, (int)newWidth*4, p.getHeight()-(int)newHeight*4,(int)newWidth,(int)newHeight).createObservable());
		e1 = new PictureView(new SubPictureImpl(p, (int)newWidth*4, 0,(int)newWidth,(int)newHeight).createObservable());

		GridBagConstraints a5pos = new GridBagConstraints();
		a5pos.gridx = 0;
		a5pos.gridy = 4;
		GridBagConstraints a4pos = new GridBagConstraints();
		a4pos.gridx = 0;
		a4pos.gridy = 3;
		GridBagConstraints a3pos = new GridBagConstraints();
		a3pos.gridx = 0;
		a3pos.gridy = 2;
		GridBagConstraints a2pos = new GridBagConstraints();
		a2pos.gridx = 0;
		a2pos.gridy = 1;
		GridBagConstraints a1pos = new GridBagConstraints();
		a1pos.gridx = 0;
		a1pos.gridy = 0;

		GridBagConstraints b5pos = new GridBagConstraints();
		b5pos.gridx = 1;
		b5pos.gridy = 4;
		GridBagConstraints b4pos = new GridBagConstraints();
		b4pos.gridx = 1;
		b4pos.gridy = 3;
		GridBagConstraints b3pos = new GridBagConstraints();
		b3pos.gridx = 1;
		b3pos.gridy = 2;
		GridBagConstraints b2pos = new GridBagConstraints();
		b2pos.gridx = 1;
		b2pos.gridy = 1;
		GridBagConstraints b1pos = new GridBagConstraints();
		b1pos.gridx = 1;
		b1pos.gridy = 0;

		GridBagConstraints c5pos = new GridBagConstraints();
		c5pos.gridx = 2;
		c5pos.gridy = 4;
		GridBagConstraints c4pos = new GridBagConstraints();
		c4pos.gridx = 2;
		c4pos.gridy = 3;
		GridBagConstraints c3pos = new GridBagConstraints();
		c3pos.gridx = 2;
		c3pos.gridy = 2;
		GridBagConstraints c2pos = new GridBagConstraints();
		c2pos.gridx = 2;
		c2pos.gridy = 1;
		GridBagConstraints c1pos = new GridBagConstraints();
		c1pos.gridx = 2;
		c1pos.gridy = 0;

		GridBagConstraints d5pos = new GridBagConstraints();
		d5pos.gridx = 3;
		d5pos.gridy = 4;
		GridBagConstraints d4pos = new GridBagConstraints();
		d4pos.gridx = 3;
		d4pos.gridy = 3;
		GridBagConstraints d3pos = new GridBagConstraints();
		d3pos.gridx = 3;
		d3pos.gridy = 2;
		GridBagConstraints d2pos = new GridBagConstraints();
		d2pos.gridx = 3;
		d2pos.gridy = 1;
		GridBagConstraints d1pos = new GridBagConstraints();
		d1pos.gridx = 3;
		d1pos.gridy = 0;

		GridBagConstraints e5pos = new GridBagConstraints();
		e5pos.gridx = 4;
		e5pos.gridy = 4;
		GridBagConstraints e4pos = new GridBagConstraints();
		e4pos.gridx = 4;
		e4pos.gridy = 3;
		GridBagConstraints e3pos = new GridBagConstraints();
		e3pos.gridx = 4;
		e3pos.gridy = 2;
		GridBagConstraints e2pos = new GridBagConstraints();
		e2pos.gridx = 4;
		e2pos.gridy = 1;
		GridBagConstraints e1pos = new GridBagConstraints();
		e1pos.gridx = 4;
		e1pos.gridy = 0;

		add(a1,a1pos);
		add(b1,b1pos);
		add(c1,c1pos);
		add(d1,d1pos);
		add(e1,e1pos);
		add(a2,a2pos);
		add(b2,b2pos);
		add(c2,c2pos);
		add(d2,d2pos);
		add(e2,e2pos);
		add(a3,a3pos);
		add(b3,b3pos);
		add(c3,c3pos);
		add(d3,d3pos);
		add(e3,e3pos);
		add(a4,a4pos);
		add(b4,b4pos);
		add(c4,c4pos);
		add(d4,d4pos);
		add(e4,e4pos);
		add(a5,a5pos);
		add(b5,b5pos);
		add(c5,c5pos);
		add(d5,d5pos);
		add(e5,e5pos);

		a1.addKeyListener(this);
		b1.addKeyListener(this);
		c1.addKeyListener(this);
		d1.addKeyListener(this);
		e1.addKeyListener(this);
		a2.addKeyListener(this);
		b2.addKeyListener(this);
		c2.addKeyListener(this);
		d2.addKeyListener(this);
		e2.addKeyListener(this);
		a3.addKeyListener(this);
		b3.addKeyListener(this);
		c3.addKeyListener(this);
		d3.addKeyListener(this);
		e3.addKeyListener(this);
		a4.addKeyListener(this);
		b4.addKeyListener(this);
		c4.addKeyListener(this);
		d4.addKeyListener(this);
		e4.addKeyListener(this);
		a5.addKeyListener(this);
		b5.addKeyListener(this);
		c5.addKeyListener(this);
		d5.addKeyListener(this);
		e5.addKeyListener(this);


	}

	@Override
	public void keyPressed(KeyEvent e) {
		PictureView current = a1;
		PictureView destination = a1;

		if (currentX == 1){
			switch(currentY){
			case 1: current=a1; break;
			case 2: current=a2; break;
			case 3: current=a3; break;
			case 4: current=a4; break;
			case 5: current=a5; break;
			}
		}
		else if(currentX == 2){
			switch(currentY){
			case 1: current=b1; break;
			case 2: current=b2; break;
			case 3: current=b3; break;
			case 4: current=b4; break;
			case 5: current=b5; break;
			}
		}
		else if(currentX == 3){
			switch(currentY){
			case 1: current=c1; break;
			case 2: current=c2; break;
			case 3: current=c3; break;
			case 4: current=c4; break;
			case 5: current=c5; break;
			}
		}
		else if(currentX == 4){
			switch(currentY){
			case 1: current=d1; break;
			case 2: current=d2; break;
			case 3: current=d3; break;
			case 4: current=d4; break;
			case 5: current=d5; break;
			}
		}
		else if(currentX == 5){
			switch(currentY){
			case 1: current=e1; break;
			case 2: current=e2; break;
			case 3: current=e3; break;
			case 4: current=e4; break;
			case 5: current=e5; break;
			}
		}
		if (e.getKeyCode() == 37){
			if(currentX!=1){
				currentX--;
			}
		}
		else if(e.getKeyCode() == 38){
			if(currentY!=1){
				currentY--;
			}
		}
		else if(e.getKeyCode() == 39){
			if(currentX!=5){
				currentX++;
			}
		}
		else if(e.getKeyCode() == 40){
			if(currentY!=5){
				currentY++;
			}
		}
		if (currentX == 1){
			switch(currentY){
			case 1: destination=a1; break;
			case 2: destination=a2; break;
			case 3: destination=a3; break;
			case 4: destination=a4; break;
			case 5: destination=a5; break;
			}
		}
		else if(currentX == 2){
			switch(currentY){
			case 1: destination=b1; break;
			case 2: destination=b2; break;
			case 3: destination=b3; break;
			case 4: destination=b4; break;
			case 5: destination=b5; break;
			}
		}
		else if(currentX == 3){
			switch(currentY){
			case 1: destination=c1; break;
			case 2: destination=c2; break;
			case 3: destination=c3; break;
			case 4: destination=c4; break;
			case 5: destination=c5; break;
			}
		}
		else if(currentX == 4){
			switch(currentY){
			case 1: destination=d1; break;
			case 2: destination=d2; break;
			case 3: destination=d3; break;
			case 4: destination=d4; break;
			case 5: destination=d5; break;
			}
		}
		else if(currentX == 5){
			switch(currentY){
			case 1: destination=e1; break;
			case 2: destination=e2; break;
			case 3: destination=e3; break;
			case 4: destination=e4; break;
			case 5: destination=e5; break;
			}
		}
		Picture temp_Picture = current.getPicture();
		current.setPicture(destination.getPicture());
		destination.setPicture(temp_Picture.createObservable());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}


}
