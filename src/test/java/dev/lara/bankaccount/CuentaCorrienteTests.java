package dev.lara.bankaccount;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;

public class CuentaCorrienteTests {
    @Test
    void testConsignar() {
        CuentaCorriente cuenta = new CuentaCorriente(5000, 12);
        cuenta.consignar(2000);
        assertThat(cuenta.getSaldo(), equalTo(7000.0f));
        cuenta.setSobregiro(1000);
        cuenta.consignar(3000);
        assertThat(cuenta.getSaldo(), equalTo(9000.0f));
        assertThat(cuenta.getSobregiro(), equalTo(0.0f));

    }

    @Test
    void testImprimirDetallesCuenta() {
        CuentaCorriente cuenta = new CuentaCorriente(5000, 12);
        cuenta.setSobregiro(0);
        String detallesCuenta = cuenta.imprimirDetallesCuenta();
        assertThat(detallesCuenta, containsString("Saldo: 5000.0"));
        assertThat(detallesCuenta, containsString("Sobregiro: 0.0"));

    }

    @Test
    void testConsignarSinSobregiro() {
        CuentaCorriente cuenta = new CuentaCorriente(5000, 12);
        cuenta.consignar(2000);

        assertThat(cuenta.getSaldo(), equalTo(7000.0f));
        assertThat(cuenta.getSobregiro(), equalTo(0.0f));
    }

    @Test
    void testConsignarConSobregiroMayor() {
        CuentaCorriente cuenta = new CuentaCorriente(5000, 12);
        cuenta.setSobregiro(3000);
        cuenta.consignar(2000);

        assertThat(cuenta.getSaldo(), equalTo(5000.0f));
        assertThat(cuenta.getSobregiro(), equalTo(1000.0f));
    }

    @Test
    void testImprimirDetallesCuentaConSobregiro() {
        CuentaCorriente cuenta = new CuentaCorriente(5000, 12);
        cuenta.setSobregiro(1500);
        String detallesCuenta = cuenta.imprimirDetallesCuenta();

        assertThat(detallesCuenta, containsString("Sobregiro: 1500.0"));
    }

    @Test
    void testSobregiroPorDefecto() {
        CuentaCorriente cuenta = new CuentaCorriente(5000, 12);
        assertThat(cuenta.getSobregiro(), equalTo(0.0f));
    }

    @Test
    void testConsignarValorNegativo() {
        CuentaCorriente cuenta = new CuentaCorriente(5000, 12);
        cuenta.consignar(-1000);
        assertThat(cuenta.getSaldo(), equalTo(5000.0f));
        assertThat(cuenta.getSobregiro(), equalTo(0.0f));
    }

}
