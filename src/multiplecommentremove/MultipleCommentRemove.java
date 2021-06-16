/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiplecommentremove;
import java.util.*;
import static java.lang.System.*;
import java.io.*;
/**
 *
 * @author Asus
 */
public class MultipleCommentRemove {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("D:\\Java\\MultipleCommentRemove\\read.txt");
        //PrintStream fileOut=new PrintStream("C:\\space_elimination_out.txt");
        //setOut(fileOut);
        
        PrintStream fileout = new PrintStream("D:\\Java\\MultipleCommentRemove\\output.txt");
        setOut(fileout);
            
        Scanner sc = new Scanner(file);
        int white_space_count=0;
        int blank_line_count=0;
        int singleline=0;
        int multiline=0;
        while (sc.hasNextLine()) {
            String output="";
            String temp = sc.nextLine();
            int len = temp.length();
            boolean flag=false;
            boolean commentflag=false;
            boolean lineblank=false;
            if(!temp.isEmpty()){ 
                for(int i=0;i<len;i++){               
                    while(temp.charAt(i)==' '){
                        flag=true; 
                        white_space_count++;
                        i++;
                    }
                    if(temp.charAt(0)=='*'){
                        output+=" ";
                        multiline++;
                        lineblank=true;
                        break;
                    }
                    if(temp.charAt(0)=='/' && temp.charAt(1)=='/'){
                        output+=" ";
                        singleline++;
                        lineblank=true;
                        break;
                    }
                    if(temp.charAt(i)=='/' && temp.charAt(i+1)=='/'){
                        output+=" ";
                        singleline++;
                        break;
                    }

                    if(temp.charAt(i)=='/' && temp.charAt(i+1)=='*'){
                        i +=2;
                        commentflag=true;
                        multiline++;
                        lineblank=true;
                        continue;
                    }
                    if(temp.charAt(i)=='*' && temp.charAt(i+1)=='/'){
                        i +=2;
                        commentflag=false;
                        lineblank=true;
                        break;
                    }
                    if(commentflag){
                        continue;
                    }
                    if(flag){
                        output+=" "+temp.charAt(i);
                        flag=false;
                    }
                    else{
                        output+=temp.charAt(i);
                    }
                    
                }
                    
               
            //String output = temp.replaceAll("\\s+", " ");
            //output = temp.replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)", " ");
                if(lineblank==false){
                    out.println(output);
                }
            }
            else{
                blank_line_count++;
            }
        }
        out.println("\nTotal number of white spaces = "+white_space_count );
        out.println("Total number of blank lines = "+blank_line_count);
        out.println("Total number of single lines = "+singleline);
        out.println("Total number of multi lines = "+multiline);
    }
    
}
