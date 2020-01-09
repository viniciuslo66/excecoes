package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidades.Reserva;

/**
 * Programa
 */
public class Programa {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Numero do quarto: ");
        int numeroQuarto = sc.nextInt();
        System.out.print("Data do check-in (dd/mm/aaaa): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Data do check-out (dd/mm/aaaa): ");
        Date checkOut = sdf.parse(sc.next());

        if (!checkOut.after(checkIn)) {
            System.out.println("Erro na reserva: check-in não pode ser posterior a data de check-out!!");
        } else {
            Reserva reserva = new Reserva(numeroQuarto, checkIn, checkOut);
            System.out.println("Reserva: " + reserva);

            System.out.println();
            System.out.println("Atualizar data do check-in e check-out: ");
            System.out.print("Data do check-in (dd/mm/aaaa): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Data do check-out (dd/mm/aaaa): ");
            checkOut = sdf.parse(sc.next());

            String erro = reserva.atualizarData(checkIn, checkOut);
            if (erro != null) {
                System.out.println("Erro in reservation: " + erro);
            } else {
                System.out.println("Reserva: " + reserva);
            }

        }

        sc.close();
    }
}