package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reserva {

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private Integer numeroQuarto;
    private Date checkIn;
    private Date checkOut;

    public Reserva() {
    }

    public Reserva(Integer numeroQuarto, Date checkIn, Date checkOut) throws DomainException {
        if (!checkOut.after(checkIn)) {
            throw new DomainException("Check-in não pode ser posterior a data de check-out!!");
        }
        this.numeroQuarto = numeroQuarto;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckout() {
        return checkOut;
    }

    public long duracao() {
        long diferenca = checkOut.getTime() - checkOut.getTime();
        return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
    }

    public void atualizarData(Date checkIn, Date checkOut) throws DomainException {

        Date now = new Date();

        if (checkIn.before(now) || checkOut.after(now)) {
            throw new DomainException("A reserva tem que possuir datas futuras!!");
        }
        if (!checkOut.after(checkIn)) {
            throw new DomainException("Check-in não pode ser posterior a data de check-out!!");
        }

        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Quarto: " + numeroQuarto + ", check-in: " + sdf.format(checkIn) + ", check-out: " + sdf.format(checkOut)
                + ", " + duracao() + " noites";
    }

}