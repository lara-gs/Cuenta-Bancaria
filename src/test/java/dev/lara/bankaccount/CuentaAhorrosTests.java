package dev.lara.bankaccount;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;

public class CuentaAhorrosTests {
    @Test
    void testConsignar() {
        CuentaAhorros cuenta = new CuentaAhorros(15000, 5);
        cuenta.consignar(5000);
        assertThat(cuenta.getSaldo(), is(20000.0f));
        assertThat(cuenta.isActiva(), is(true));
    }

    @Test
    void testConsignarCuentaInactiva() {
        CuentaAhorros cuenta = new CuentaAhorros(5000, 5);
        cuenta.consignar(3000);
        assertThat(cuenta.getSaldo(), is(5000.0f));
        assertThat(cuenta.isActiva(), is(false));

    }

    @Test
    void testImprimirDetallesCuenta() {
        CuentaAhorros cuenta = new CuentaAhorros(12000, 5);
        String detalles = cuenta.imprimirDetallesCuenta();
        assertThat(detalles, containsString("Saldo: 12000.0"));
        assertThat(detalles, containsString("Activa: true"));

    }

    @Test
    void testRetirarCuentaActiva() {
        CuentaAhorros cuenta = new CuentaAhorros(15000, 5);
        cuenta.retirar(5000);
        assertThat(cuenta.getSaldo(), is(10000.0f));
        assertThat(cuenta.isActiva(), is(true));
    }

    @Test
    void testRetirarCuentaInactiva() {
        CuentaAhorros cuenta = new CuentaAhorros(8000, 5);
        cuenta.retirar(2000);
        assertThat(cuenta.getSaldo(), is(8000.0f));
        assertThat(cuenta.isActiva(), is(false));
    }

    @Test
    void testGenerarExtractoMensualConRetirosExcedentes() {
        CuentaAhorros cuenta = new CuentaAhorros(20000, 5);
        cuenta.retirar(1000);
        cuenta.retirar(1000);
        cuenta.retirar(1000);
        cuenta.retirar(1000);
        cuenta.retirar(1000); 
        cuenta.generarExtractoMensual();
        assertThat(cuenta.getSaldo(), lessThan(20000.0f)); 
        assertThat(cuenta.getComisionMensual(), is(1062.7604F)); 
    }

    @Test
    void testImprimirDetallesCuentaInactiva() {
        CuentaAhorros cuenta = new CuentaAhorros(8000, 5); 
        String detalles = cuenta.imprimirDetallesCuenta();
        assertThat(detalles, containsString("Saldo: 8000.0"));
        assertThat(detalles, containsString("Activa: false")); 
    }
    @Test
    void testGenerarExtractoMensualCuentaInactiva() {
        CuentaAhorros cuenta = new CuentaAhorros(5000, 5); 
        cuenta.generarExtractoMensual(); 
        assertThat(cuenta.getSaldo(), lessThan(5000.0f)); 
        assertThat(cuenta.isActiva(), is(false));  
    }
    @Test
    void testRetirarInactivaNoPermiteRetiros() {
        CuentaAhorros cuenta = new CuentaAhorros(8000, 5);
        cuenta.retirar(1000);
        assertThat(cuenta.getSaldo(), is(8000.0f)); 
        assertThat(cuenta.isActiva(), is(false)); 
    }
}
