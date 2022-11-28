package br.uel.bd1.dadosparlamentares.util;
import br.uel.bd1.dadosparlamentares.business.GenericBusiness;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Named
@RequestScoped

public class GenerateReports {

    public static String s;

    public String CallScript() throws IOException {

//        String pathPython = "C:\\Users\\PCMonstro\\Desktop\\Sistema-de-analise-de-dados-abertos\\report_script.py";
//        String [] cmd = new String[20];
//        cmd[0] = "python";
//        cmd[1] = pathPython;
//        cmd[2] = "1 2 3 4 5";
//        cmd[3] = "1 2 3 4 5";
//        cmd[4] = "Bar Graph 1";
//        cmd[5] = "X";
//        cmd[6] = "Y";
//        cmd[7] = "C:\\Users\\PCMonstro\\Desktop\\Sistema-de-analise-de-dados-abertos\\graph1.png";
//        cmd[8] = "1 2 3 4 5";
//        cmd[9] = "5 4 3 2 1";
//        cmd[10] = "Bar Graph 2";
//        cmd[11] = "X";
//        cmd[12] = "Y";
//        cmd[13] = "C:\\Users\\PCMonstro\\Desktop\\Sistema-de-analise-de-dados-abertos\\graph2.png";
//        cmd[14] = "1 2 3 4 5";
//        cmd[15] = "Pie Chart 1";
//        cmd[16] = "C:\\Users\\PCMonstro\\Desktop\\Sistema-de-analise-de-dados-abertos\\graph3.png";
//        cmd[17] = "4 3 2 1";
//        cmd[18] = "Pie Chart 2";
//        cmd[19] = "C:\\Users\\PCMonstro\\Desktop\\Sistema-de-analise-de-dados-abertos\\graph4.png";
//        Runtime r = Runtime.getRuntime();
//
//        Process p = r.exec(cmd);
//        BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
//        while((s=in.readLine()) != null){
//            System.out.println(s);
//        }

        return "relatorios";
    }

}
