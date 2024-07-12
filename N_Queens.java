import java.awt.*;
import javax.swing.*;
import java.util.Queue;
import java.util.LinkedList;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.image.BufferedImage;
import java.io.IOException;
public class N_Queens extends JPanel{
    static int n=4,j1=0,i1=0,x1=0;
    static Graphics g;
    int ar[][]=new int[n][n];
    static Queue<int[][]> a=new LinkedList<>();  
    static BufferedImage queenImage;
    void solve(int arr[][],int k)  {
        for(int i=0;i<arr[k].length;i++){
            int t=0;
            int x=i+1,y=i-1;
            for(int j=k-1;j>=0;j--){
                j1=j;
                if(arr[j][i]==1){
                    t=1;
                }
                if(y>=0&&arr[j][y]==1){
                    t=1;
                }
                if(x<arr[j].length&&arr[j][x]==1){
                    t=1;
                }
                x++;
                y--;
                        i1 = i;
                        j1 = j;
            }
            
            if(t==0){
            if(k==arr.length-1){
                arr[k][i]=1;
                        int a1[][]=new int[n][n];
                        for(int l=0;l<n;l++){
            for(int j=0;j<n;j++){
                a1[l][j]=arr[l][j];
            }
        } 
                        a.add(a1);
        arr[k][i]=0;
            }
            else{
                arr[k][i]=1;
                        i1 = i;
                        int a1[][]=new int[n][n];
                        for(int l=0;l<n;l++){
            for(int j=0;j<n;j++){
                a1[l][j]=arr[l][j];
            }
        } 
                        a.add(a1);
                    solve(arr,k+1);
                arr[k][i]=0;
            }
            }
    }
    }
    public void paint(Graphics g){
        super.paint(g);
        N_Queens.g.setColor(new Color(150,20,0));
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if((i+j)%2==0)
                g.fillRect(i*100,j*100,100,100);
            }
        }
        System.out.println(j1);
        int arr[][]=new int[n][n];
            solve(arr,0);
               Runnable r=new draw();
               Thread t=new Thread(r);
               t.start();
    }  public static void startApplication() {
        SwingUtilities.invokeLater(() -> {
            JFrame f = new JFrame();
            f.setVisible(true);
            g = f.getGraphics();
            f.setSize(n * 100 + 100, n * 100 + 100);
            try {
                queenImage = ImageIO.read(new File("—Pngtree—gold chess queen 3d render_13004591.png"));
            } catch (IOException e) {
            }
            N_Queens q = new N_Queens();
            f.add(q);
        });
    }
    public static void main(String args[])throws Exception{
        JFrame f=new JFrame();
        f.setVisible(true);
        f.setSize(400,300);
        JPanel p=new JPanel();
        JTextField jt=new JTextField(10);
        p.add(jt);
        JLabel lj=new JLabel("Enter the number of queens");
        p.add(lj);
        JButton jb=new JButton("Submit");
        p.add(jb);
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        f.add(p); p.add(Box.createVerticalStrut(300));
        jb.addActionListener(e->{
            n=Integer.parseInt(jt.getText());
            f.setVisible(false);
            startApplication();
        });
        
    }
}
