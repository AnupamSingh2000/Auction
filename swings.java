import javax.swing.*;
import java.util.ArrayList;
//package com.company;
class Listing extends JFrame{

//    public static void main(String[] args) {
//
//        new Listing();
//    }

    Listing(ArrayList<String> al,int left,String a,int teamid) {

        final ArrayList<String> wordlist = new ArrayList<String>(al);

        JList<String> displayList = new JList<>(wordlist.toArray(new String[0]));

        JScrollPane scrollPane = new JScrollPane(displayList);
        JFrame frame = new JFrame("Team "+a+" -"+teamid+" - Total Money spent - "+(70000-left));
        frame.getContentPane().add(scrollPane);
        frame.revalidate();
        frame.repaint();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 550);
        frame.setVisible(true);
    }


}