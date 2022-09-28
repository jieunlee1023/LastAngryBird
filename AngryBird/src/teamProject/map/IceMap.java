package teamProject.map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import teamProject.frame.MainFrame;

public class IceMap extends Background {

	MainFrame mContext;

	private JLabel iceMap;
	private JLabel holder;

	public IceMap(MainFrame mContext) {
		this.mContext = mContext;
		initData();
		setInitLayout();
	}

	private void initData() {
		setTitle("Ice Map");
		setSize(1000, 570);
		iceMap = new JLabel(new ImageIcon("images/bg2.png"));

		holder = new JLabel(new ImageIcon("images/img.png"));
	}

	private void setInitLayout() {
		setVisible(true);
		setLayout(null);
		setLocationRelativeTo(null);

		holder.setSize(60, 150);
		holder.setLocation(80, 340);
		add(holder);

		iceMap.setSize(1000, 570);
		iceMap.setLocation(0, 0);
		add(iceMap);

	}

}
