/*
* Classe com métodos responsáveis por gerar informações aleátorias para cada 
*campo da tabela.
*/
package controller;

import dao.CustomerDao;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Random;

public class CustomerController {

    public void gerarMedia() throws SQLException {
        new CustomerDao().selectMedia();
    }

    public void gerarResultado() throws SQLException {
        new CustomerDao().selectResutado();
    }

    public String gerarNomes() {
        int i;
        int nrAleatorioVogal;
        int nrAleatorioConsoante;
        String x = "";
        String nome = "";
        String vogal[] = {"a", "e", "i", "o", "u",};
        String consoante[] = {"b", "c", "d", "f", "g", "h", "j", "k", "l", 
            "m", "n", "p", "q", "r", "s", "t", "w", "x", "y", "z"};
        Random random = new Random();
        for (i = 0; i <= 3; i++) {
            nrAleatorioVogal = 0 + random.nextInt(4);
            nrAleatorioConsoante = 0 + random.nextInt(19);
            x = vogal[nrAleatorioVogal] + consoante[nrAleatorioConsoante];
            nome += x;
        }
        return nome;
    }

    public String gerarCpfCnpj() {
        int i;
        int nmImpar;
        int nmPar;
        String x = "";
        String numero = "";
        String par[] = {"0", "2", "4", "6", "8"};
        String impar[] = {"1", "3", "5", "7", "9"};
        Random random = new Random();
        for (i = 0; i <= 5; i++) {
            nmImpar = 0 + random.nextInt(5);
            nmPar = 0 + random.nextInt(5);
            x = impar[nmImpar] + par[nmPar];
            numero += x;
        }
        return numero;
    }

    public int gerarAtivo() {
        int i;
        int bin = 0;
        int inativo[] = {0, 1};
        Random random = new Random();
        for (i = 0; i <= 1; i++) {
            bin = 0 + random.nextInt(2);
        }
        return bin;
    }

    public String gerarValor() {
        Locale.setDefault(Locale.US);
        DecimalFormat df = new DecimalFormat("0.##");
        Random r = new Random();
        double x = 25.00 + (1025.00 - 25.00) * r.nextDouble();
        return df.format(x);
    }

}
