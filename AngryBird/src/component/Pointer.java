package component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Getter;
import teamProject.frame.MainFrame;

public class Pointer extends JLabel {

	private ImageIcon imageicon;

	public Pointer(ImageIcon imageicon) {
		this.imageicon = imageicon;
		setIcon(imageicon);

	}

}