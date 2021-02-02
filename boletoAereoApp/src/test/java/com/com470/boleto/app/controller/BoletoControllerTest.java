
package com.com470.boleto.app.controller;

import com.com470.boleto.app.dao.BoletoDao;
import com.com470.boleto.app.entities.Boleto;
import com.com470.boleto.app.service.BoletoService;
import java.util.Date;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoletoControllerTest {
    
    @Autowired
    private BoletoService boletoservice;
    
    @MockBean
    private BoletoDao boletoDao;

    @Before
    public void setUp() throws Exception {
    }
         
    @Test
    public void testCreateBoleto() {
        Boleto boleto = new Boleto();
        boleto.setBoletoId(1);
        boleto.setNombreDelPasajero("Jorge Perez");
        boleto.setSalida("Sucre");
        boleto.setDestino("Potosi");
        boleto.setFecha(new Date());
        boleto.setEmail("jorge.perez@gmail.com");
        Mockito.when(boletoDao.save(boleto)).thenReturn(boleto);
        assertThat(boletoDao.save(boleto), Matchers.is(CoreMatchers.equalTo(boleto)));
    }

    @Test
    public void testUpdateBoleto() {
        Boleto boleto = new Boleto();
        boleto.setBoletoId(1);
        boleto.setNombreDelPasajero("Jorge Perez");
        boleto.setSalida("Sucre");
        boleto.setDestino("Potosi");
        boleto.setFecha(new Date());
        boleto.setEmail("jorge.perez@gmail.com");
        Mockito.when(boletoDao.findOne(1)).thenReturn(boleto);
        boleto.setEmail("jorgehuetado@gmail.com");
        Mockito.when(boletoDao.save(boleto)).thenReturn(boleto);
        assertThat(boletoservice.updateBoleto(1, "jorge.perez@gmail.com"), CoreMatchers.is(CoreMatchers.equalTo(boleto)));
    }

    @Test
    public void testGetBoletoById() {
        Boleto boleto = new Boleto();
        boleto.setBoletoId(1);
        boleto.setNombreDelPasajero("Jorge Perez");
        boleto.setSalida("Sucre");
        boleto.setDestino("Potosi");
        boleto.setFecha(new Date());
        boleto.setEmail("jorge.perez@gmail.com");
        //Mockito.when(boletoDao.findOne(1)).thenReturn(boleto);
        //boleto.setEmail("jorgehuetado@gmail.com");
        Mockito.when(boletoDao.save(boleto)).thenReturn(boleto);
        assertThat(boletoservice.getBoletoById(1), Matchers.is(CoreMatchers.equalTo(boleto)));  
    }

    @Test
    public void testGetAllBoletos() {
        Boleto boleto = new Boleto();
        boleto.setBoletoId(1);
        boleto.setNombreDelPasajero("Jorge Perez");
        boleto.setSalida("Sucre");
        boleto.setDestino("Potosi");
        boleto.setFecha(new Date());
        boleto.setEmail("jorge.perez@gmail.com");
        //Mockito.when(boletoDao.findOne(1)).thenReturn(boleto);
        //boleto.setEmail("jorgehuetado@gmail.com");
        Mockito.when(boletoDao.save(boleto)).thenReturn(boleto);
        assertThat(boletoservice.getAllBoletos(), Matchers.is(CoreMatchers.equalTo(boleto)));
    }

    @Test
    public void testDeleteBoleto() {
        Boleto boleto = new Boleto();
        boleto.setBoletoId(1);
        boleto.setNombreDelPasajero("Jorge Perez");
        boleto.setSalida("Sucre");
        boleto.setDestino("Potosi");
        boleto.setFecha(new Date());
        boleto.setEmail("jorge.perez@gmail.com");
        Mockito.when(boletoDao.findOne(1)).thenReturn(boleto);
        //boleto.setEmail("jorgehuetado@gmail.com");
        Mockito.when(boletoDao.save(boleto)).thenReturn(boleto);
        assertThat(boletoservice.deleteBoleto(1), CoreMatchers.is(CoreMatchers.equalTo(boleto)));
    }
    
    
}
