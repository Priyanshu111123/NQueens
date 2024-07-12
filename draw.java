import java.awt.*;
import javax.swing.*;
import java.util.Queue;
import java.util.LinkedList;
class draw implements Runnable{
    public void run(){ 
        while(!N_Queens.a.isEmpty()){
                int ar[][]=new int [N_Queens.n][N_Queens.n];
                ar=N_Queens.a.poll();
                int k=0;
        for(int i=0;i<N_Queens.n;i++){
            for(int j=0;j<N_Queens.n;j++){
                
                if(ar[i][j]==1){
                    k++;
        N_Queens.g.setColor(Color.GREEN);
                N_Queens.g.fillRect(8+i*100,30+j*100,100,100);
            N_Queens.g.drawImage(N_Queens.queenImage, 10 + i * 100, 30 + j * 100, 100, 100, null);

                    try
                    {
                        if(k==N_Queens.n)
                        Thread.sleep(3000);
                        Thread.sleep(150);
                    }
                    catch (InterruptedException ie)
                    {
                        ie.printStackTrace();
                    }
            }
            else{
                if((i+j)%2==0){
        N_Queens.g.setColor(new Color(150,20,150));
                N_Queens.g.fillRect(8+i*100,30+j*100,100,100);
            }
            else{
            
        N_Queens.g.setColor(Color.WHITE);
                N_Queens.g.fillRect(8+i*100,30+j*100,100,100);
            }
        }
            }
        }
            }    }
}