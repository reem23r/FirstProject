 
package CarDrivingSimulator;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

 
public class GeoTransformation extends JFrame {
    
    public GeoTransformation()
    {
        initUI();
    }
    private void initUI() {
        setTitle("Car driving simulator");
        add(new Surface());
        setSize(1300, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
    public void run() {
    GeoTransformation r1 = new GeoTransformation();
    r1.setVisible(true);
    }
    });
        
    }


}
