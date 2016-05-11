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
	//「PenSize」ボタンが押されたか(=ペンサイズが変更されたか)判定する変数(boolean型)
	//ちなみに，他クラスからアクセスする必要のある変数(このフラグ用変数みたいな)には「static」を付ける(=静的メンバにする)。
	public static boolean ischangedpensize = false;
	//「PenSize」ボタンが押された回数を制御する変数(int型)
	//こちらはこのクラス内でしか使わないので静的メンバである必要はない。
	public int count = 0;
	
	public static boolean ischangedpensize2 = false;
	public int count2 = 0;

	public static void main(String[] args) {
		SimpleButton frame = new SimpleButton("簡単なお絵かきソフト");
		frame.setVisible(true);

		Canvas canvas = new Canvas();
		frame.add(canvas);
	}

	SimpleButton(String title){
		setTitle("title");
		setBounds(100,100,500,450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));

		JButton button = new JButton("PenSize→20");
		int height = button.getMaximumSize().height;
		button.setMaximumSize(new Dimension(200, height));
		button.addActionListener(this);
		
		JButton button2 = new JButton("PenSize→30");
		int height2 = button2.getMaximumSize().height;
		button2.setMaximumSize(new Dimension(200, height2));
		button2.addActionListener(this);

		panel.add(button);
		panel.add(button2);

		Container contentPane = getContentPane();
		contentPane.add(panel, BorderLayout.CENTER);
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Button pushed");
		count++; //ボタンが押された回数を制御するcountを一増やす
		int calc = count % 2; //押された回数が偶数回目か奇数回目か判定するため，2で割って余りを求める
		if(count == 0){
			//例外的に0回目では何もしない(=PenSizeを変更しない)
			SimpleButton.ischangedpensize = false;
		} else if(!(calc == 0)){
			//奇数回目ではPenSizeを大きくするため，ischangedpensizeにtrueを代入する
			System.out.println("奇数回目のクリック");
			SimpleButton.ischangedpensize = true;
		} else if(calc == 0){
			//偶数回目ではPenSizeを元に戻すため，ischangedpensizeにfalseを代入する
			System.out.println("偶数回目のクリック");
			SimpleButton.ischangedpensize = false;
		}
		
		count2++;
		int calc2 = count2 % 2;
		if(count2 == 0){
			SimpleButton.ischangedpensize2 = false;
		} else if(!(calc2 == 0)){
			SimpleButton.ischangedpensize2 = true;
		} else if(calc2 == 0){
			SimpleButton.ischangedpensize2 = false;
		}

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
    	//ボタンが押されていたら(=回数が奇数回目なら)，値が20の円を生成する。
    	if(SimpleButton.ischangedpensize){
    		//変数名を変更。できるだけ意味のない一文字変数は避けたほうが良い。(ローカル変数だったとしても)
    		int size = 20;
    		g.setColor(Color.blue);
    		//って，全部同じ値なのね，コレなら2つ変数を宣言しなくてもいいかも。
    		//演算子と数値の間にスペースを入れたほうが見やすくなるよ。 
    		g.fillOval(x - size / 2, y - size / 2, size, size);
    	}else if(SimpleButton.ischangedpensize2){
    		int size =30;
    		g.setColor(Color.BLUE);
    		g.fillOval(x - size/ 2 , y - size / 2, size, size);
    	} else {
    		//ボタンが押されていなければ10の円を生成する。
    		int size = 10;
    		g.setColor(Color.blue);
    		g.fillOval(x - size / 2, y - size / 2, size, size);
    	}
    }

    //インデントが崩れていたので修正。IDEにはインデントを自動で調節してくれる機能があるので，それを使うと良い。
    public void actionPerformed(ActionEvent e) {

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