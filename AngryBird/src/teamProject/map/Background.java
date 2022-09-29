package teamProject.map;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import component.Enemy;
import component.Pointer;
import component.player.Player;

public abstract class Background extends JFrame {

	String fileName;
	Background mContext = this;
	protected JLabel backgroundImageLabel;
	protected JLabel holderLabel;

	private MyMouseAdapter myAdapter;

	private double pressX;
	private double pressY;
	private double releaseX;
	private double releaseY;

	private int birdType;

	public Player[] player;
	public Pointer[] pointer;

	
	
	public int getBirdType() {
		return birdType;
	}

	public void setBirdType(int birdType) {
		this.birdType = birdType;
	}

	public double getPressX() {
		return pressX;
	}

	public void setPressX(double pressX) {
		this.pressX = pressX;
	}

	public double getPressY() {
		return pressY;
	}

	public void setPressY(double pressY) {
		this.pressY = pressY;
	}

	public double getReleaseX() {
		return releaseX;
	}

	public void setReleaseX(double releaseX) {
		this.releaseX = releaseX;
	}

	public double getReleaseY() {
		return releaseY;
	}

	public void setReleaseY(double releaseY) {
		this.releaseY = releaseY;
	}

	public Background() {
		// TODO Auto-generated constructor stub
	}

	public Background(String fileName) {
		this.fileName = fileName;
		initDate();
		setInitLayout();
		addEventListener();
	}

	protected void initDate() {
		setSize(1000, 570);
		birdType = 0;
		// 플레이어 주소값 입력
		player = new Player[3];
		player[0] = new Player(new ImageIcon("images/redbird.png"), 140, 440, this);
		player[1] = new Player(new ImageIcon("images/blackbird.png"), 100, 440, this);
		player[2] = new Player(new ImageIcon("images/yellowbird.png"), 60, 440, this);

		pointer = new Pointer[4];
		for (int i = 0; i < player.length; i++) {
			pointer[i] = new Pointer(new ImageIcon("images/pointer.png"));
			pointer[i].setSize(100, 100);
		}

		holderLabel = new JLabel(new ImageIcon("images/img.png"));
		backgroundImageLabel = new JLabel(new ImageIcon(fileName));

		myAdapter = new MyMouseAdapter();

	}

	protected void setInitLayout() {

		setVisible(true);
		setLayout(null);
		setLocationRelativeTo(null);

		backgroundImageLabel.setSize(1000, 570);
		backgroundImageLabel.setLocation(0, 0);
		add(backgroundImageLabel);

		// player
		player[0].setSize(80, 60);
		player[0].setLocation(player[0].getPlayerX(), player[0].getPlayerY());
		player[1].setSize(80, 60);
		player[1].setLocation(player[1].getPlayerX(), player[1].getPlayerY());
		player[2].setSize(80, 60);
		player[2].setLocation(player[2].getPlayerX(), player[2].getPlayerY());

		backgroundImageLabel.add(player[0]);
		backgroundImageLabel.add(player[1]);
		backgroundImageLabel.add(player[2]);

		// 거치대
		holderLabel.setSize(60, 150);
		holderLabel.setLocation(80, 340);
		backgroundImageLabel.add(holderLabel);

		// 맵

	}

	public void addEventListener() {
		addMouseListener(myAdapter);
		addMouseMotionListener(myAdapter);
	}

	class MyMouseAdapter extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent e) {
			pressX = ((Number) e.getX()).doubleValue();
			pressY = ((Number) e.getY()).doubleValue();
			if (birdType == 0) {
				player[0].setLocation(e.getX() - 80 / 2, e.getY() - 65);
			} else if (birdType == 1) {
				player[1].setLocation(e.getX() - 80 / 2, e.getY() - 65);
			} else if (birdType == 2) {
				player[2].setLocation(e.getX() - 80 / 2, e.getY() - 65);
			}
			
		}

		@Override
		public void mouseDragged(MouseEvent e) {

			double a = getPressX() - e.getX();
			double b = getPressY() - e.getY();
			int c = ((Number) Math.sqrt((a * a) + (b * b))).intValue();
			double slope = (b / a);

			int x = ((Number) getPressX()).intValue();
			int y = ((Number) getPressY()).intValue() - 50;

			new Thread(new Runnable() {

				@Override
				public synchronized void run() {

					try {

						Thread.sleep(100);
//						System.out.println("slope: " + slope);
//						if (slope == -1) {
//							System.out.println("-1");
//							pointer[0].setLocation(x + c / 4, y - 5);
//							pointer[1].setLocation(x + c / 2, y - 25);
//							pointer[2].setLocation(x + (c / 2) + (c / 4), y - 45);
//							pointer[3].setLocation(x + c, y - 65);
//
//						} else if (slope > -1 && slope <= 0.5) {
//							System.out.println(" -1 초과 0.5 이");
//							pointer[0].setLocation(x + c / 4, y - 5);
//							pointer[1].setLocation(x + c / 2, y - 15);
//							pointer[2].setLocation(x + c / 2 + c / 4, y - 25);
//							pointer[3].setLocation(x + c, y - 35);
//
//						} else if (slope > 0.5 && slope <= 0) {
//							System.out.println("05초과  0 이하  ");
//							pointer[0].setLocation(x + c / 4, y - 0);
//							pointer[1].setLocation(x + c / 2, y - 5);
//							pointer[2].setLocation(x + c / c / 2 + c / 4, y - 10);
//							pointer[3].setLocation(x + c, y - 15);
//
//						} else if (slope < -1 && slope >= 1.5) {
//							System.out.println("-1초과  1.5 이하 ");
//							pointer[0].setLocation(x + c / 4, y - 5);
//							pointer[1].setLocation(x + c / 2, y - 40);
//							pointer[2].setLocation(x + c / 2 + c / 4, y - 75);
//							pointer[3].setLocation(x + c, y - 105);
//
//						} else if (slope < 1.5) {
//							System.out.println("1.5 이하 ");
//							pointer[0].setLocation(x + c / 4, y - 5);
//							pointer[1].setLocation(x + c / 2, y - 50);
//							pointer[2].setLocation(x + c / 2 + c / 4, y - 85);
//							pointer[3].setLocation(x + c, y - 120);
//
//						}
//
//						add(pointer[0]);
//						add(pointer[1]);
//						add(pointer[2]);
//						add(pointer[3]);

						// 드래그 모션
						if (birdType == 0) {
							player[0].setLocation(e.getX() - 80 / 2, e.getY() - 65);
						} else if (birdType == 1) {
							player[1].setLocation(e.getX() - 80 / 2, e.getY() - 65);
						} else if (birdType == 2) {
							player[2].setLocation(e.getX() - 80 / 2, e.getY() - 65);
						} else {

//							if(pig[1].getState == 0 && pig[1].getState == 0){
//							gameover
//						}else {
//							nextstage
//						}

						}

					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
			}).start();
		}

		@Override
		public void mouseReleased(MouseEvent e) {

			releaseX = ((Number) e.getX()).doubleValue();
			releaseY = ((Number) e.getY()).doubleValue();

			player[birdType].playerMove();
		}
	}

	


}
