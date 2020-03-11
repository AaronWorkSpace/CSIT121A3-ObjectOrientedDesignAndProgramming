// Done by: Aaron Lim
// It is my own work, and I have not passed my
// program to my friends…
// and willing to accept whatever consequences 

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class AaronLim_A3 extends JFrame implements ActionListener{
    private final JButton [] jbArray;
    private final GridLayout gl;
    private final JButton [] jbBottom;
    private final JButton [] jbSummary;
 
    public AaronLim_A3(){
        super("Good Luck To You");
        
        gl = new GridLayout(9, 7);
        setLayout(gl);
        
        jbArray = new JButton [49];
        
        for (int i = 0; i < 49; i++){
            jbArray[i] = new JButton("SP");
            add(jbArray[i]);
            jbArray[i].addActionListener(this);
        }
        
        
        jbSummary = new JButton[7];
        jbSummary[0] = new JButton("S");
        jbSummary[1] = new JButton("U");
        jbSummary[2] = new JButton("M");
        jbSummary[3] = new JButton("M");
        jbSummary[4] = new JButton("A");
        jbSummary[5] = new JButton("R");
        jbSummary[6] = new JButton("Y");
                
        for (int i = 0; i < 7; i++){
            add(jbSummary[i]);
            jbArray[i].addActionListener(this);
        }
        
        jbBottom = new JButton[7];
        
        for (int i = 0; i < 7; i++){
            jbBottom[i] = new JButton("SP");
            add(jbBottom[i]);
            jbBottom[i].addActionListener(this);
        }
        
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        List <Integer> digit49 = IntStream.rangeClosed(1, 49)
                                          .boxed()
                                          .collect(Collectors.toCollection(ArrayList::new));
        
        Collections.shuffle(digit49);
        
        List <Integer> lucky7 = digit49.stream()
                                       .limit(7)
                                       .collect(Collectors.toList());
        
        List<Integer> lucky6 = lucky7.stream()
                                     .limit(6)
                                     .sorted()
                                     .collect(Collectors.toList());
        
        Collections.shuffle(digit49);
        
        int j = 0;
        for (JButton k : jbArray){
                for(int w = 0; w < 7; w++){
                    if(digit49.get(j) == lucky7.get(w) && 
                       digit49.get(j) != lucky7.get(6)){
                        k.setBackground(Color.YELLOW);
                        k.setFont(new Font(k.getFont().getName(), Font.BOLD, 15));
                    }
                    else if (digit49.get(j) == lucky7.get(6)){
                        k.setBackground(Color.GREEN);
                        k.setFont(new Font(k.getFont().getName(), Font.BOLD, 15));
                    }
                }
                k.setText(String.valueOf(digit49.get(j)));
            j++;
        }
        
        for (JButton i : jbSummary){
            i.setForeground(Color.red);
            i.setFont(new Font(i.getFont().getName(),Font.BOLD, 18));
        }
        
        int q = 0;
        for(JButton i : jbBottom){
            if (q == 6){
                i.setBackground(Color.GREEN);
                i.setFont(new Font(i.getFont().getName(), Font.BOLD, 15));
                i.setText(lucky7.get(q).toString());
            }
            else{
                i.setBackground(Color.YELLOW);
                i.setFont(new Font(i.getFont().getName(), Font.BOLD, 15));
                i.setText(lucky6.get(q).toString());
            }
            q++;
        }
        
        for (JButton h : jbArray){
            h.removeActionListener(this);
        }
        
        for(JButton h : jbBottom){
            h.removeActionListener(this);
        }
    }
    
    public static void main(String [] args){
        AaronLim_A3 assignment = new AaronLim_A3();
    }
}
