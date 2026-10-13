package it.meucci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket s = new ServerSocket(3000);
        Socket lsocket = s.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(lsocket.getInputStream()));
        PrintWriter out = new PrintWriter(lsocket.getOutputStream(), true);
        String testo;

        do {
            testo = in.readLine();
            if (testo == null || "exit".equals(testo)) {
                break;
            }

            try {
                String[] parti = testo.split(" ");
                
                if (parti.length == 3) {
                    float num1 = Float.parseFloat(parti[0]);
                    String operatore = parti[1];
                    float num2 = Float.parseFloat(parti[2]);
                    
                    float risultato = 0;
                    boolean operazioneValida = true;

                    switch (operatore) {
                        case "+":
                            risultato = num1 + num2;
                            break;
                        case "-":
                            risultato = num1 - num2;
                            break;
                        case "*":
                            risultato = num1 * num2;
                            break;
                        case "/":
                            if (num2 != 0) {
                                risultato = num1 / num2;
                            } else {
                                out.println("Errore: Divisione per zero");
                                operazioneValida = false;
                            }
                            break;
                        default:
                            out.println("Errore: Operatore non riconosciuto");
                            operazioneValida = false;
                            break;
                    }
                    if (operazioneValida) {
                        out.println("Risultato: " + risultato);
                    }
                } else {
                    out.println("Errore: Formato non valido. Usa 'numero spazio operatore spazio numero'");
                }
            } catch (NumberFormatException e) {
                out.println("Errore: Formato dei numeri non valido");
            }
        } while (!"exit".equals(testo));

        in.close();
        out.close();
        lsocket.close();
        s.close();
    }
}