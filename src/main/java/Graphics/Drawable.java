package Graphics;



import java.awt.*;
import java.awt.event.MouseEvent;

public interface Drawable extends  Shape {

void draw(Graphics2D g);
void onClick(MouseEvent e);
boolean contains(int x,int y);
void removeArcs();
long getID();

}
