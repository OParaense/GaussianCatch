package Aula03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/* @author OParaense */

public class Main {

    public static void main(String[] args) throws FileNotFoundException{
        
        ArrayList<String> hf = new ArrayList();
        
        double energiaFormacao = 0;
        final double KCALMOL = 627.5095;
        final double EV = 27.2114;
        
        Scanner in = new Scanner(new File("Clozapina.out"));
        while(in.hasNextLine()){
            String linha = in.nextLine();
            if(linha.contains("HF="))
                hf.add(linha);
        }
        
        for(String linha : hf.get(hf.size()-1).split("\\|")){
            if(linha.contains("HF="))
                energiaFormacao = Double.valueOf(linha.split("=")[1]) * KCALMOL;
        }
        
        System.out.println("HF = " + energiaFormacao);
        
    }
}
