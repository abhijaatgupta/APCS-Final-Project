import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.image.BufferStrategy;

import javax.swing.JLabel;
import javax.swing.JPanel;
public class BattleshipDriver extends Canvas implements Runnable{
	private final int WIDTH = 1080;
	private final int HEIGHT = 720;
	private Thread thread;
	public boolean isRunning;
	

	public BattleshipDriver() {
	 new GameGUI(WIDTH, HEIGHT, "Battleship", this);
	 start();
	}
	
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000/amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			render();
			frames++;
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frames = 0;
			}
		}
		stop();
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.blue);
		int x = 1;
		int y = 1;
		int z = 1;
		int a = 1;
		int b = 1;
		int c = 1;
		int d = 1;
		int e = 1;
		int f = 1;
		int h = 1;
		int j = 1;
		int k = 1;
		int l = 1;
		int m = 1;
		int n = 1;
		int o = 1;
	    for(int i = 0; i < 8; i++) {
				g.drawRect(100+x, 10, 40, 40);
				x+= 40;
			}
	    for(int i = 0; i < 8; i++) {
			g.drawRect(100+y, 50, 40, 40);
			y+= 40;
		}
	    for(int i = 0; i < 8; i++) {
			g.drawRect(100+z, 90, 40, 40);
			z+= 40;
		}
	    for(int i = 0; i < 8; i++) {
			g.drawRect(100+a, 130, 40, 40);
			a+= 40;
		}
	    for(int i = 0; i < 8; i++) {
			g.drawRect(100+b, 170, 40, 40);
			b+= 40;
		}
	    for(int i = 0; i < 8; i++) {
			g.drawRect(100+c, 210, 40, 40);
			c+= 40;
		}
	    for(int i = 0; i < 8; i++) {
			g.drawRect(100+d, 250, 40, 40);
			d+= 40;
		}
	    for(int i = 0; i < 8; i++) {
			g.drawRect(100+e, 290, 40, 40);
			e+= 40;
		}
	    for(int i = 0; i < 8; i++) {
			g.drawRect(600+f, 10, 40, 40);
			f+= 40;
		}
	    for(int i = 0; i < 8; i++) {
		g.drawRect(600+h, 50, 40, 40);
		h+= 40;
	    }
	    for(int i = 0; i < 8; i++) {
		g.drawRect(600+j, 90, 40, 40);
		j+= 40;
	    }
	    for(int i = 0; i < 8; i++) {
		g.drawRect(600+k, 130, 40, 40);
		k+= 40;
	    }
	    for(int i = 0; i < 8; i++) {
		g.drawRect(600+l, 170, 40, 40);
		l+= 40;
	    }
	    for(int i = 0; i < 8; i++) {
		g.drawRect(600+m, 210, 40, 40);
		m+= 40;
	    }
	    for(int i = 0; i < 8; i++) {
		g.drawRect(600+n, 250, 40, 40);
		n+= 40;
	    }
	    for(int i = 0; i < 8; i++) {
		g.drawRect(600+o, 290, 40, 40);
		o+= 40;
	    }
	    
		g.dispose();
		bs.show();
		
	}

	public void tick() {
		
	}
	

	public void start() {
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void stop() {
		isRunning = false;
		try {
			thread.join();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	

}