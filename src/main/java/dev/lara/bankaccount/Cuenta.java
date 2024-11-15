package dev.lara.bankaccount;

public class Cuenta {
    protected float saldo;
    protected int numConsignaciones = 0;
    protected int numRetiros = 0;
    protected float tasaAnual;
    protected float comisionMensual = 0;

    public Cuenta(float saldo, float tasaAnual) {
        this.saldo = saldo;
        this.tasaAnual = tasaAnual;
    }

    public void consignar(float balance) {
        if (balance > 0) {
            saldo += balance;
            numConsignaciones++;
        }
    }

    public void retirar(float balance) {
        if (balance > 0 && saldo >= balance) {
            saldo -= balance;
            numRetiros++;

        }
    }

    public void calcularComisionMensual() {
        comisionMensual = saldo * (tasaAnual / 12) / 100;
        saldo -= comisionMensual;
    }

    public void calcularInteresMensual() {
        float tasaMensual = tasaAnual / 12;
        saldo += saldo * (tasaMensual / 100);
    }

    public void generarExtractoMensual() {
        calcularInteresMensual();
        calcularComisionMensual();

    }

    public String imprimirDetallesCuenta() {
        return "Saldo: " + saldo + "\n" +
                "Número de consignaciones: " + numConsignaciones + "\n" +
                "Número de retiros: " + numRetiros + "\n" +
                "Comisión mensual: " + comisionMensual + "\n" +
                "Tasa anual: " + tasaAnual + "%\n";
    }

    public float getSaldo() {
        return saldo;
    }

    public int getNumConsignaciones() {
        return numConsignaciones;
    }

    public void setNumConsignaciones(int numConsignaciones) {
        this.numConsignaciones = numConsignaciones;
    }

    public int getNumRetiros() {
        return numRetiros;
    }

    public void setNumRetiros(int numRetiros) {
        this.numRetiros = numRetiros;
    }

    public float getTasaAnual() {
        return tasaAnual;
    }

    public void setTasaAnual(float tasaAnual) {
        this.tasaAnual = tasaAnual;
    }

    public float getComisionMensual() {
        return comisionMensual;
    }

    public void setComisionMensual(float comisionMensual) {
        this.comisionMensual = comisionMensual;
    }
}
