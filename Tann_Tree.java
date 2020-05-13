import java.awt.*;
import javax.swing.*;
import java.util.Random;
import java.util.ArrayList;

public class Tann_Tree {
    public static void main() {
        JFrame f = new JFrame("Tree");
        MyPanel p = new MyPanel();
        f.add(p);
        f.setSize(1280,1024);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

    }

    private static class MyPanel extends JPanel {
        private ArrayList<Branch> tree = new ArrayList<Branch>();

        public MyPanel() {
            setBackground(new Color (225,225,255)); 
            addBranch(640,1024,512,20,1,-90.0);
        }

        public void paintComponent(Graphics g) {
            Random rand = new Random();
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(new Color (0,0,0));
            addBranch(640,1024,512,80,1,-90.0);
            g2.setColor(new Color (20,100,20));
            for (Branch b : tree) {
                int r = rand.nextInt(4);
                g2.setStroke(new BasicStroke(b.getW()));
                if (r == 1) {
                    if (b.getD() > 6) g2.setColor(new Color(30,200, 30));
                    else g2.setColor(new Color(105 ,55 , 20 ));
                }
                else g2.setColor(new Color(120 - (b.getD() * 12),50 + b.getD()*13, 20 + b.getD()));
                g2.drawLine(b.getX1(), b.getY1(), b.getX2(), b.getY2());
            }
        }

        public void addBranch(int x1, int y1, int l, int w, int d, double a) {
            Random rand = new Random();
            int x2 = x1+(int)(Math.cos(Math.toRadians(a)) * l);
            int y2 = y1+(int)(Math.sin(Math.toRadians(a)) * l);
            if (d != 8) {

                tree.add(new Branch(x1,y1,x2,y2,w,l,d));
                if (d %4 == 0) {
                    for (int i = 1; i <= d+1; i++) {
                        addBranch(x2,y2,l*2/3, w*1/2, d+1, a+(10/i));
                        addBranch(x2,y2,l*2/3, w*1/2, d+1, a-(10/i));
                    }
                }
                int yo = rand.nextInt(120)-60;
                addBranch(x2,y2,l * 1/3,w * 2/3,d+1,a+10+ yo);
                addBranch(x2,y2,l * 1/3,w * 2/3,d+1,a-10+ yo);
                addBranch(x2,y2,l * 2/3,w * 1/3,d+1,a+10+ yo);
                addBranch(x2,y2,l * 2/3,w * 1/3,d+1,a-10+ yo);
                if ((d > 3 )) {
                    addBranch(x2,y2,l * 2/3,w * 1/3,d+1,a+25+ yo);
                    addBranch(x2,y2,l * 2/3,w * 1/3,d+1,a-25- yo);
                }
                if (yo < -20) {
                    addBranch(x2,y2,l * 2/3,w * 1/3,d+1,a+40+ yo);
                }
                if (yo > 20) {
                    addBranch(x2,y2,l * 2/3,w * 1/3,d+1,a-40- yo);
                }
                addBranch((x2+x1)/2,(y1+y2)/2,l * 2/3,w * 1/2,d+1,a+25);
                addBranch((x2+x1)/2,(y1+y2)/2,l * 2/3,w * 1/2,d+1,a-25);
            }
        }
    }

    private static class Branch {
        private int x1, y1, x2, y2, w, d, h;
        public Branch(int x1, int y1, int x2, int y2, int w, int h, int d) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.w = w;
            this.h = h;
            this.d = d;
        }

        public int getX1() {return x1;}

        public int getY1() {return y1;}

        public int getX2() {return x2;}

        public int getY2() {return y2;}

        public int getW() {return w;}

        public int getH() {return h;}

        public int getD() {return d;}
    }
}
