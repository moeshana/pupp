package pupp;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class PuppPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private static final int FPS = 30;
	private BufferedImage biAbs;
	private BufferedImage biHead1;
	private BufferedImage biHead2;
	private BufferedImage biHead3;
	private BufferedImage biHead4;
	private BufferedImage biTorso;
	private BufferedImage biHead;
	private BufferedImage biLeftBicep;
	private BufferedImage biRightBicep;
	private BufferedImage biLeftArm;
	private BufferedImage biRightArm;
	private BufferedImage biLeftThigh;
	private BufferedImage biRightThigh;
	private BufferedImage biLeftShin;
	private BufferedImage biRightShin;
	//private double absRot = 0.0;
	//private double torsoRot = 0.0;
	//private double headRot = 0.0;
	private double LBicepRot = 0.0;
	private double RBicepRot = 0.0;
	private double LArmRot = 0.0;
	private double RArmRot = 0.0;
	private double LThighRot = 0.0;
	private double RThighRot = 0.0;
	private double LShinRot = 0.0;
	private double RShinRot = 0.0;
	
	public PuppPanel() {
		try {
			initParts();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		this.setSize(1200,600);
		this.setBackground(new Color(34, 0, 0));
		this.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		javax.swing.Timer t = new javax.swing.Timer(
				1000 / FPS,
				ae ->{
					repaint();
				}
			);
			t.start();
	}
	public void initParts() throws IOException {
		LBicepRot = 0.0;
		RBicepRot = 0.0;
		LArmRot = 0.0;
		RArmRot = 0.0;
		LThighRot = 0.0;
		RThighRot = 0.0;
		LShinRot = 0.0;
		RShinRot = 0.0;
		BufferedImage bi = ImageIO.read(new File("./data/cut2.png"));
			for(int i = 0 ; i < 4; i ++) {
			
			this.biAbs = new BufferedImage(68, 66, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2d = biAbs.createGraphics();
			AffineTransform at = new AffineTransform();
			at.translate(-147.0 , -9.0);
			g2d.drawRenderedImage(bi, at);
			
			this.biTorso = new BufferedImage(65, 85, BufferedImage.TYPE_INT_ARGB);
			g2d = biTorso.createGraphics();
			at = new AffineTransform();
			at.translate(-71.0, -10.0);
			g2d.drawRenderedImage(bi, at);
			
			this.biHead = new BufferedImage(64, 72, BufferedImage.TYPE_INT_ARGB);
			g2d = biHead.createGraphics();
			at = new AffineTransform();
			at.translate(7.0, -10.0);
			this.biHead1 = new Head(0).head;
			this.biHead2 = new Head(1).head;
			this.biHead3 = new Head(2).head;
			this.biHead4 = new Head(3).head;
			
			g2d.drawRenderedImage(bi, at);
			
			this.biLeftThigh = new BufferedImage(30, 250, BufferedImage.TYPE_INT_ARGB);
			g2d = biLeftThigh.createGraphics();
			at = new AffineTransform();
			at.translate(-350.0, -10.0);
			g2d.drawRenderedImage(bi, at);
			
			this.biRightThigh = new BufferedImage(30, 250, BufferedImage.TYPE_INT_ARGB);
			g2d = biRightThigh.createGraphics();
			at = new AffineTransform();
			at.translate(-350.0, -10.0);
			g2d.drawRenderedImage(bi, at);
			
			this.biLeftShin = new BufferedImage(30, 300, BufferedImage.TYPE_INT_ARGB);
			g2d = biLeftShin.createGraphics();
			at = new AffineTransform();
			at.translate(-400.0, -10.0);
			g2d.drawRenderedImage(bi, at);
			
			this.biRightShin = new BufferedImage(30, 300, BufferedImage.TYPE_INT_ARGB);
			g2d = biRightShin.createGraphics();
			at = new AffineTransform();
			at.translate(-400.0, -10.0);
			g2d.drawRenderedImage(bi, at);
			
			this.biLeftBicep = new BufferedImage(30, 100, BufferedImage.TYPE_INT_ARGB);
			g2d = biLeftBicep.createGraphics();
			at = new AffineTransform();
			at.translate(-250.0, -10.0);
			g2d.drawRenderedImage(bi, at);
			
			this.biRightBicep = new BufferedImage(30, 100, BufferedImage.TYPE_INT_ARGB);
			g2d = biRightBicep.createGraphics();
			at = new AffineTransform();
			at.translate(-250.0, -10.0);
			g2d.drawRenderedImage(bi, at);
			
			this.biLeftArm = new BufferedImage(30, 150, BufferedImage.TYPE_INT_ARGB);
			g2d = biLeftArm.createGraphics();
			at = new AffineTransform();
			at.translate(-300.0, -10.0);
			g2d.drawRenderedImage(bi, at);
			
			this.biRightArm = new BufferedImage(30, 150, BufferedImage.TYPE_INT_ARGB);
			g2d = biRightArm.createGraphics();
			at = new AffineTransform();
			at.translate(-300.0, -10.0);
			g2d.drawRenderedImage(bi, at);
		}}		
	public void updateRotations(String part) {
		switch(part) {
		case "LBicepRight" :
			LBicepRot += Math.toRadians(11.25);
			break;
		case "LBicepLeft" :
			LBicepRot -= Math.toRadians(11.25);
			break;
		case "RBicepRight" : 
			RBicepRot += Math.toRadians(11.25);
			break;
		case "RBicepLeft" : 
			RBicepRot -= Math.toRadians(11.25);
			break;
		case "LForeArmRight" :
			LArmRot += Math.toRadians(11.25);
			break;
		case "LForeArmLeft" :
			LArmRot -= Math.toRadians(11.25);
			break;
		case "RForeArmRight" :
			RArmRot += Math.toRadians(11.25);
			break;
		case "RForeArmLeft" :
			RArmRot -= Math.toRadians(11.25);
			break;
		case "LThighRight" :
			LThighRot += Math.toRadians(11.25);
			break;
		case "LThighLeft" :
			LThighRot -= Math.toRadians(11.25);
			break;
		case "RThighRight" :
			RThighRot += Math.toRadians(11.25);
			break;
		case "RThighLeft" :
			RThighRot -= Math.toRadians(11.25);
			break;
		case "LShinRight" :
			LShinRot += Math.toRadians(11.25);
			break;
		case "LShinLeft" :
			LShinRot -= Math.toRadians(11.25);
			break;
		case "RShinRight" :
			RShinRot += Math.toRadians(11.25);
			break;
		case "RShinLeft" :
			RShinRot -= Math.toRadians(11.25);
			break;
		}
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	
		Graphics2D g2d = (Graphics2D) g.create();
		AffineTransform gat = new AffineTransform();
		gat.translate(getWidth() / 2.0, getHeight() / 2.0);
		gat.scale(1.5, -1.5);
		g2d.transform(gat);
		g2d.setStroke(new BasicStroke(3.0f));
		g2d.setPaint(Color.BLACK);
		
		
        for(int i = 0; i < 4; i++) {
		
        AffineTransform atAbs = new AffineTransform();
		//atAbs.rotate(absRot);
		atAbs.translate(34.0 + (-400 + 250.0*i), 33.0);
		atAbs.rotate(Math.toRadians(180.0));
		g2d.drawRenderedImage(biAbs, atAbs);
		AffineTransform atTorso = new AffineTransform();
		atTorso.translate(32.5, 0.0);
		//atTorso.rotate(torsoRot);
		atTorso.translate(-32.5, -85.0);
		atTorso.preConcatenate(atAbs);
		g2d.drawRenderedImage(biTorso, atTorso);
		
		AffineTransform atHead = new AffineTransform();
		atHead.translate(5.0,0.0);
		atHead.scale(0.15,0.15);
		atHead.translate(165.0, 0.0);
		//atHead.rotate(headRot);
		atHead.translate(-165.0, -480.0);
		atHead.preConcatenate(atTorso);
		switch(i) {
		case 0 : g2d.drawRenderedImage(biHead1, atHead);
			break;
		case 1 : g2d.drawRenderedImage(biHead2, atHead);
			break;
		case 2 : g2d.drawRenderedImage(biHead3, atHead);
			break; 
		case 3 : g2d.drawRenderedImage(biHead4, atHead);
			break;
		default : g2d.drawRenderedImage(biHead, atHead);
		}
		
		
		AffineTransform atLeftThigh = new AffineTransform();
		atLeftThigh.translate(-25 + (-400 + 250.0*i),-32);
		atLeftThigh.rotate(LThighRot);
		atLeftThigh.translate(15,0);
		atLeftThigh.rotate(Math.toRadians(180.0));
		g2d.drawRenderedImage(biLeftThigh, atLeftThigh);
		
		AffineTransform atLeftShin = new AffineTransform();
		atLeftShin.translate(0,140);
		atLeftShin.rotate(LShinRot);
		atLeftShin.translate(0, 0);
		atLeftShin.preConcatenate(atLeftThigh);
		g2d.drawRenderedImage(biLeftShin, atLeftShin);
		
		AffineTransform atRightThigh = new AffineTransform();
		atRightThigh.translate(25 + (-400 + 250.0*i),-32);
		atRightThigh.rotate(RThighRot);
		atRightThigh.translate(15,0);
		atRightThigh.rotate(Math.toRadians(180.0));
		g2d.drawRenderedImage(biRightThigh, atRightThigh);
		
		AffineTransform atRightShin = new AffineTransform();
		atRightShin.translate(0,140);
		atRightShin.rotate(RShinRot);
		atRightShin.translate(0, 0);
		atRightShin.preConcatenate(atRightThigh);
		g2d.drawRenderedImage(biRightShin, atRightShin);
		
		AffineTransform atLeftBicep = new AffineTransform();
		atLeftBicep.translate(-30 + (-400 + 250.0*i), 100);
		atLeftBicep.rotate(LBicepRot);
		atLeftBicep.translate(15, 0);
		atLeftBicep.rotate(Math.toRadians(180.0));
		g2d.drawRenderedImage(biLeftBicep, atLeftBicep);
		
		AffineTransform atLeftArm = new AffineTransform();
		atLeftArm.translate(0, 100);
		atLeftArm.rotate(LArmRot);
		atLeftArm.preConcatenate(atLeftBicep);
		g2d.drawRenderedImage(biLeftArm, atLeftArm);
		
		AffineTransform atRightBicep = new AffineTransform();
		atRightBicep.translate(30 + (-400 + 250.0*i), 100);
		atRightBicep.rotate(RBicepRot);
		atRightBicep.translate(15, 0);
		atRightBicep.rotate(Math.toRadians(180.0));
		g2d.drawRenderedImage(biRightBicep, atRightBicep);
		
		AffineTransform atRightArm = new AffineTransform();
		atRightArm.translate(0, 100);
		atRightArm.rotate(RArmRot);
		atRightArm.preConcatenate(atRightBicep);
		g2d.drawRenderedImage(biRightArm, atRightArm);
		}
		g2d.dispose();
		Toolkit.getDefaultToolkit().sync();
	}
}	