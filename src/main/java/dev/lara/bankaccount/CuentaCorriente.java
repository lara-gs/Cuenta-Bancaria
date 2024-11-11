package dev.lara.bankaccount;

public class CuentaCorriente extends Cuenta {
    private float sobregiro = 0;

    public CuentaCorriente(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
    }

    @Override
    public void consignar(float balance) {
        if (balance > 0) {
            if (sobregiro > 0) {
                if (balance >= sobregiro) {
                    balance -= sobregiro;
                    sobregiro = 0;
                } else {
                    sobregiro -= balance;
                    balance = 0;
                }
            }
            saldo += balance;
            numConsignaciones++;
        }
    }

    @Override
    public String imprimirDetallesCuenta(){
        return super.imprimirDetallesCuenta() + "\nSobregiro: " + sobregiro;
    }

    public float getSobregiro() {
        return sobregiro;
    }

    public void setSobregiro(float sobregiro) {
        this.sobregiro = sobregiro;
    }
}
