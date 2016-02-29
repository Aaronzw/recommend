package UI;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class myGridBagLayout extends GridBagConstraints{
	private static final long serialVersionUID = 1L;
	public myGridBagLayout(int gridx, int gridy){
		this.gridx = gridx;
		this.gridy = gridy;
	}
	public myGridBagLayout(int gridx, int gridy, int gridwidth, int gridheight){
		this.gridx = gridx;
		this.gridy = gridy;
		this.gridwidth = gridwidth;
		this.gridheight = gridheight;
	}
	public myGridBagLayout set_Fill(int fill){
		this.fill = fill;
		return this;
	}
	public myGridBagLayout set_Anchor(int anchor){
		this.anchor = anchor;
		return this;
	}
	public myGridBagLayout setWeight(int weightx, int weighty){
		this.weightx = weightx;
		this.weighty = weighty;
		return this;
	}
	public myGridBagLayout setInset(int distance){
		this.insets =  new Insets(distance, distance, distance, distance);
		return this;
	}
	public myGridBagLayout setInset(int top, int left, int bottom, int right){
		this.insets = new Insets(top, left, bottom, right);
		return this;
	}
	public myGridBagLayout setIpad(int ipadx, int ipady){
		this.ipadx = ipadx;
		this.ipady = ipady;
		return this;
	}
}
