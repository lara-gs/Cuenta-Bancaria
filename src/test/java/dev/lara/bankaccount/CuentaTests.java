package dev.lara.bankaccount;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;

public class CuentaTests {
    @Test
    void testCalcularComisionMensual() {
        Cuenta cuenta = new Cuenta(20000, 10);
        cuenta.consignar(1000);
        cuenta.retirar(500);
        cuenta.generarExtractoMensual();
        assertThat(cuenta.getComisionMensual(), greaterThan(0f));

    }

    @Test
    void testCalcularInteresMensual() {
        Cuenta cuenta = new Cuenta(20000, 10);
        cuenta.generarExtractoMensual();
        assertThat(cuenta.getSaldo(), greaterThan(2000f));

    }

    @Test
    void testConsignar() {
        Cuenta cuenta = new Cuenta(20000, 10);
        cuenta.consignar(2500);
        assertThat(cuenta.getSaldo(), is(22500f));
    }

    @Test
    void testGenerarExtractoMensual() {
        Cuenta cuenta = new Cuenta(20000, 10);
        cuenta.generarExtractoMensual();
        assertThat(cuenta.getSaldo(), greaterThan(19998.0f));

    }

    @Test
    void testImprimirDetallesCuenta() {
        Cuenta cuenta = new Cuenta(20000, 10);
        String detallesCuenta = cuenta.imprimirDetallesCuenta();
        assertThat(detallesCuenta, containsString("Saldo: 20000.0"));

    }

    @Test
    void testRetirar() {
        Cuenta cuenta = new Cuenta(20000, 10);
        cuenta.retirar(10000);
        assertThat(cuenta.getSaldo(), is(10000f));

    }

    @Test
    void testRetirarMasDeLoQueHay() {
        Cuenta cuenta = new Cuenta(20000, 10);
        cuenta.retirar(25000);
        assertThat(cuenta.getSaldo(), is(20000f));
        assertThat(cuenta.getNumRetiros(), is(0));
    }

    @Test
    void testComisionMensualSaldoCero() {
        Cuenta cuenta = new Cuenta(0, 10);
        cuenta.generarExtractoMensual();
        assertThat(cuenta.getComisionMensual(), is(0f));
    }

    @Test
    void testGenerarExtractoSinAcciones() {
        Cuenta cuenta = new Cuenta(20000, 10);
        cuenta.generarExtractoMensual();
        assertThat(cuenta.getSaldo(), is(19998.611f));
    }

    @Test
    void testInteresMensualSaldoCero() {
        Cuenta cuenta = new Cuenta(0, 10);
        cuenta.calcularInteresMensual();
        assertThat(cuenta.getSaldo(), is(0f));
    }

    @Test
void testSaldoDespuesComisionEInteres() {
    Cuenta cuenta = new Cuenta(10000, 12);
    cuenta.generarExtractoMensual();
    assertThat(cuenta.getSaldo(), equalTo(9999.0f));
}

@Test
void testIncrementarNumConsignaciones() {
    Cuenta cuenta = new Cuenta(20000, 10);
    cuenta.consignar(500);  
    cuenta.consignar(200);  
    assertThat(cuenta.getNumConsignaciones(), is(2));
}

@Test
void testIncrementarNumRetiros() {
    Cuenta cuenta = new Cuenta(20000, 10);
    cuenta.retirar(500); 
    cuenta.retirar(1000);
    assertThat(cuenta.getNumRetiros(), is(2));
}

@Test
void testConsignarValorPositivo() {
    Cuenta cuenta = new Cuenta(10000, 12);  
    cuenta.consignar(500); 
    assertThat(cuenta.getSaldo(), equalTo(10500.0f));  
}

@Test
void testRetirarValorPositivo() {
    Cuenta cuenta = new Cuenta(10000, 12); 
    cuenta.retirar(2000); 
    assertThat(cuenta.getSaldo(), equalTo(8000.0f));  
}

@Test
void testRetirarMayorAlSaldo() {
    Cuenta cuenta = new Cuenta(10000, 12); 
    cuenta.retirar(15000);
    assertThat(cuenta.getSaldo(), equalTo(10000.0f));
}

@Test
void testGenerarExtractoMensualSinTransacciones() {
    Cuenta cuenta = new Cuenta(10000, 12);
    cuenta.generarExtractoMensual();  
    assertThat(cuenta.getSaldo(), equalTo(9999.0f)); 
    assertThat(cuenta.getComisionMensual(), equalTo(101.0f)); 
}

@Test
void testConsignarMultiplesVeces() {
    Cuenta cuenta = new Cuenta(10000, 12);  
    cuenta.consignar(1000); 
    cuenta.consignar(500); 
    cuenta.consignar(1500); 
    assertThat(cuenta.getSaldo(), equalTo(13000.0f)); 
}

@Test
void testComisionMensualConTransacciones() {
    Cuenta cuenta = new Cuenta(20000, 12); 
    cuenta.consignar(1000); 
    cuenta.retirar(500); 
    cuenta.generarExtractoMensual(); 
    assertThat(cuenta.getComisionMensual(), greaterThan(0f));
}






}
