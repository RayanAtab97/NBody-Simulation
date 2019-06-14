import java.applet.Applet;
import java.awt.event.KeyListener;

public class KeyListener
extends Applet
implements KeyListener{

private ArrayList<Integer> keysDown;

public void init(){
	this.addKeyListener(this);

	keysDown = new ArrayList<Integer>();

}

@Override
public void keyPressed(KeyEvent e)
{
	if(!keysDown.contains(e.getKeyCode()) && e.getKeyCode() != 85) {
		keyDown.add(new Integer(e.getKeyCode()));
	}
	if(e.getKeyCode() == KeyEvent.VK_RIGHT){
		xxPos += 5;
	}

	if(e.getKeyCode() == KeyEvent.VK_LEFT){
		xxPos -=5;
	}
	if(e.getKeyCode() == KeyEvent.VK_UP){
		yyPos += 5;

	}
	if (e.getKeyCode() == KeyEvent.VK_DOWN){
		yyPos -=5;
	}
}

@Override
public void keyReleased(KeyEvent e){
	keysDown.remove(new Integer(e.getKeyCode()));
}

public void keyTyped(keyEvent e){

}




}

