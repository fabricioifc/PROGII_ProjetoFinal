/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifc.conexao.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author fabricio
 */
public class ArquivoUtil {

    public static String getDump() throws SQLException {
        StringBuilder sb = new StringBuilder();

        try {
            File dump = new File("src/main/resources/util/dump.sql");
            FileReader fr = new FileReader(dump);
            BufferedReader br = new BufferedReader(fr);
            String s;
            while ((s = br.readLine()) != null) {
                sb.append(s);
            }
            br.close();

            System.out.println(sb.toString());

            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
