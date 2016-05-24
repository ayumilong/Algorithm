/**
 * File Name: Test.java
 * Package Name: yz.other
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 12:00:47 AM May 6, 2016
 * Author: Yaolin Zhang
 */
package yz.other;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.io.IOException;
import java.lang.reflect.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

class Test {
    private final Character m_value = 'a';
    
    public String toString() { return "" + m_value; }

    public static void main1(String[] args) {
    		System.out.println("DD");
        try {
            Field f = Test.class.getDeclaredField("m_value");
            f.setAccessible(true);
            Test a = new Test();
            f.set(a, (char) 'b' );
            System.out.println(a);
        } catch (Exception e) {    
            e.printStackTrace();
        }
    }
    
    public static void main2(String[] args) {
    	System.out.println(Byte.MIN_VALUE + " " + Byte.MAX_VALUE + " " + 0x90);
        for (byte b = Byte.MIN_VALUE; b < Byte.MAX_VALUE; b++) {

            if (b == 0x90) {

                System.out.print("We found it");

             }

        }

    }
    
    public static void main(String[] args) throws MalformedURLException, IOException {
    	HttpURLConnection connection = (HttpURLConnection) new URL("http://www.google.com/nohelp").openConnection();
    	if (connection.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
    	    System.out.println("Page not found");
    	}
    		Pattern pattern = Pattern.compile("^([0-9]+)$");
    		Matcher matcher = pattern.matcher("");
    		if(matcher.matches()){
    			System.out.println("DD");
    		}

        final List<Integer> list = new ArrayList<Integer>();

        Collections.addAll(list, 1, 5, 2, 3, 7, 3, 8, 9);

        final Integer pos = Integer.valueOf(3);

        list.remove(pos);

        System.out.println(list);

    }
}


class StatusFrame extends JFrame {

	   public StatusFrame() {

	       // init frame

	       setVisible(true);

	   }     

	   public void showHalfWayDoneProgress() {

	       myPanel.add(new JLabel("50%"));

	   }
	   private JPanel myPanel;
	}

	 

	class ApplicationThread extends Thread {

	   public void run () {

	       StatusFrame frame = new StatusFrame();      

	       // do some CPU intensive computations

	       frame.showHalfWayDoneProgress();      

	       // do more CPU intensive computations
	       try {
			frame.wait();
			frame.showHalfWayDoneProgress();
			frame.notify();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       

	   }

	} 