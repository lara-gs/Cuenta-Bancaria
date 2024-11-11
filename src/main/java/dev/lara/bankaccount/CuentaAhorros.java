package dev.lara.bankaccount;

public class CuentaAhorros extends Cuenta {

    protected boolean activa;

    public CuentaAhorros(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
        this.activa = saldo >= 10000;
    }

    private void verificarEstadoCuenta() {
        activa = saldo >= 10000;
    }

    @Override
    public void consignar(float balance) {
        if (activa) {
            super.consignar(balance);
            verificarEstadoCuenta();
        }
    }

    @Override
    public void retirar(float balance) {
        if (activa) {
            super.retirar(balance);
            verificarEstadoCuenta();
        }
    }

    @Override
    public void generarExtractoMensual() {
        super.generarExtractoMensual();
        if (numRetiros > 4) {
            comisionMensual += (numRetiros - 4) * 1000;
        }
        verificarEstadoCuenta();
    }

    @Override
    public String imprimirDetallesCuenta() {
        return super.imprimirDetallesCuenta() + "\nActiva: " + activa;
    }

}
