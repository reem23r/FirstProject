 
package CarDrivingSimulator;
 
import java.awt.BasicStroke;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.SwingUtilities;
//import static sun.audio.AudioDevice.device;
 

class Surface extends JPanel implements ActionListener{
    
   
    private boolean translatecheckx=true;
    private boolean translatechecky=false;
    private boolean translatecheckz=false;
     private double translatex=0;
      private double translatey=50;
 public  Surface() {
        setSize(1300,600);
        setLocation(10,10);
                          setBackground(new Color(135,206,250));

//        setBackground(Color.WHITE);
//        setDefaultCloseOperation(JPanel);
 JPanel panel = new JPanel();
// panel.setSize(1300,300);
//device.setFullScreenWindow(panel);
        Timer t=new Timer(200,this); 
        t.start();
        
    } 
 
  public static void main(String[] args) {
               

        
    }
public void paint(Graphics g) {
 super.paint(g);
 
      
     
     Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(Color.YELLOW);
 g2d.fillOval(1200, 20, 40, 40);
 
    //the way horiz
    g2d.setColor(Color.gray);
    g2d.fillRect(0, 120, 700, 50);
     g.setColor(Color.white);
         int x1=0; 
        for(int i=0;i<15;i++){
        g.fillRect(x1,142,20,5);
        x1+=50;
        }
        //the way vertical1
    g2d.setColor(Color.gray);
    g2d.fillRect(700, 120, 50, 400);  
      g.setColor(Color.white);
        int y=142; 
        for(int i=0;i<8;i++){
        g.fillRect(720,y,5,20);
        y+=50;
        }
        //the way vertical2
        g2d.setColor(Color.gray);
    g2d.fillRect(700, 480, 500, 50);
     g.setColor(Color.white);
         int x2=720; 
        for(int i=0;i<10;i++){
        g.fillRect(x2,500,20,5);
        x2+=50;
        } BasicStroke thin =new BasicStroke(0.3f);
    g2d.setStroke(thin);
       //painting
       Rectangle2D.Double pa=new Rectangle2D.Double(1135, 380, 20, 100);
  Rectangle2D.Double rect=new Rectangle2D.Double(1118,350,65,50);
 Area w=new Area(pa);
      Area re=new Area(rect);
     w.add(re);
    g2d.setColor(Color.white);

      g2d.fill(w);
    g2d.setColor(Color.black);
    g2d.setFont(new Font("",Font.CENTER_BASELINE,14));
      g2d.drawString("The end", 1123, 380);
         image( g);

     //place
   
   g2d.setColor(Color.red);
    g2d.fillRect(1200, 400, 200, 200);
    g2d.setColor(Color.black);
        g2d.scale(0.2, 0.2);
g2d.translate(4800, 2010);
  g2d.fillRect(1200, 400, 200, 200);
  //
      
}

public void image(Graphics d){
    
 AffineTransform at =AffineTransform.getTranslateInstance(10, 50);
  BufferedImage  anamy = LoadImage("2.png");
if(translatechecky){
 anamy = LoadImage("4.png");
}
if(translatecheckx){
 translatex+=20; 
    if(translatex>680){ 
        translatecheckx=false;
        translatechecky=true;
             //   at.rotate(Math.toRadians(90)); 

    } 

}
else if(translatechecky){
translatey+=20;
if(translatey>425){ 
        translatecheckx=false;
        translatechecky=false;
        translatecheckz=true;
        
    } 
}
else if(translatecheckz){
translatex+=20;
if(translatex>1200){ 
        translatecheckx=false;
        translatechecky=false;
        translatecheckz=false;
    } 
}
  
 at.translate(translatex, translatey);

  Graphics2D g2d = (Graphics2D) d;
  
  g2d.drawImage(anamy,at,null);
}
BufferedImage LoadImage(String filename){
    BufferedImage img=null;
    try{
    img=ImageIO.read(new File(filename));
    }
    catch(IOException e){}
    return img;
}
    @Override
    public void actionPerformed(ActionEvent ae) {

 
      repaint(); 
 
 
    }
    
}