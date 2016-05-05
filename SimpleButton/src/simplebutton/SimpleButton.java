package simplebutton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SimpleButton extends JFrame implements ActionListener{

	public int A;//ここが自分なりにメソッド外にフィールド宣言したところ
	public int B;

	public static void main(String[] args) {
		//フレームとキャンバス
		SimpleButton frame = new SimpleButton("簡単なお絵かきソフト");
		frame.setVisible(true);

		Canvas c = new Canvas();
		frame.add(c);
	}

	SimpleButton(String title){
		setTitle(title);
		setBounds(100,100,500,450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		//こっからボタン
		JPanel p = new JPanel();

		JButton button =new JButton("PenSize");
		int height = button.getMaximumSize().height;
		button.setForeground(Color.RED);
		button.setBackground(Color.LIGHT_GRAY);
		button.setMaximumSize(new Dimension(200, height));
		button.addActionListener(this);

		p.add(button);
		p.setLayout(new BoxLayout(p,BoxLayout.PAGE_AXIS));

		Container contentPane = getContentPane();
		contentPane.add(p, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		A = 20;//ここの値をボタンをクリックした時に81行目に代入したい
		B = 20;
	}
}
//クリックで円を、ドラッグで線を書くように
class Canvas extends JPanel implements MouseListener,MouseMotionListener {
	private int x = -100;
	private int y = -100;

    public Canvas() {
    	addMouseListener(this);
    	addMouseMotionListener(this);
        setSize(300, 100);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.blue);

        SimpleButton a = new SimpleButton();//コンストラクターSimpleButton()は未定義です
        SimpleButton b = new SimpleButton();//コンストラクターSimpleButton()は未定義です
        a.A = 10;
        b.B = 10;
		g.fillOval(x-a.A/2, y-b.B/2, a.A, b.B);//57行目の数値をここに代入したい
    }
        public void mouseClicked(MouseEvent e){
        }
        public void mousePressed(MouseEvent e){
        	x = e.getX();
        	y = e.getY();
        	repaint();
        }
        public void mouseReleased(MouseEvent e){
        }
        public void mouseEntered(MouseEvent e){
        }
        public void mouseExited(MouseEvent e){
        }
        public void mouseMoved(MouseEvent e){
        }
        public void mouseDragged(MouseEvent e){
        	x = e.getX();
        	y = e.getY();
        	repaint();
        }
}