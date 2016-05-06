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

	public static void main(String[] args) {
		SimpleButton frame = new SimpleButton("簡単なお絵かきソフト");
		frame.setVisible(true);

		Canvas c = new Canvas();
		frame.add(c);
	}

	SimpleButton(String title){
		setTitle("title");
		setBounds(100,100,500,450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p,BoxLayout.PAGE_AXIS));

		JButton button =new JButton("PenSize");
		int height = button.getMaximumSize().height;
		button.setMaximumSize(new Dimension(200, height));
		button.addActionListener(this);
		button.setActionCommand("1");//ここが一番の更新

		p.add(button);

		Container contentPane = getContentPane();
		contentPane.add(p, BorderLayout.CENTER);
		}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
}
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

    	public void actionPerformed(ActionEvent e) {/* 変数 actionPerformed に void は無効な型です
    		                                        //トークン ")" に構文エラーがあります。正しくは ; です
    		                                        //トークン "(" に構文エラーがあります。正しくは ; です*/

    	int A = 10;
    	int B = 10;
        g.setColor(Color.blue);
		g.fillOval(x-A/2, y-B/2, A, B);

		String cmd = e.getActionCommand();
		if (cmd.equals("1")){
			A = 20;
		}
    }
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