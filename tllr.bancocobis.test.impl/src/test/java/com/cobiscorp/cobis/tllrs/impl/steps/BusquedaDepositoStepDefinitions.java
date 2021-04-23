package com.cobiscorp.cobis.tllrs.impl.steps;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import java.util.ArrayList;
import java.util.Arrays;

import com.cobiscorp.cobis.serenity.actions.FormActions;
import com.cobiscorp.cobis.serenity.actions.HeaderActions;
import com.cobiscorp.cobis.serenity.actions.ValidationActions;
import com.cobiscorp.cobis.tllrs.test.AdminAperturaPlazoFijo;
import com.cobiscorp.cobis.tllrs.test.CabeceraCliente;
import com.cobiscorp.cobis.tllrs.test.FBusquedaClienteForm;
import com.cobiscorp.cobis.tllrs.test.FBusquedaDepositoForm;
import com.cobiscorp.cobis.tllrs.test.FCancelacionNormalForm;
import com.cobiscorp.cobis.tllrs.test.FDetalleBusquedaDeposito;
import com.cobiscorp.cobis.tllrs.test.FDetalleOperacionApertura;
import com.cobiscorp.cobis.tllrs.test.FFormasDePago;
import com.cobiscorp.cobis.tllrs.test.FRecepcionModalForm;
import com.cobiscorp.cobis.tllrs.test.FVistaOperacionForm;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class BusquedaDepositoStepDefinitions {
	ArrayList<String> nombre  = new ArrayList<String>();

	@Cuando("se busca el certificado de depósito por {string} con {string}")
	public void se_busca_el_certificado_de_depósito_por_con(String numero_de_operacion, String numero) {
	    FormActions.selectByText(FBusquedaDepositoForm.Seleccion.buscarPor, numero_de_operacion);
	    FormActions.enterText(FBusquedaDepositoForm.IngresarDatos.input_BuscarTodos, numero);
	    FormActions.clickOn(FBusquedaDepositoForm.Buttons.botonBuscar);
	}

	@Cuando("presionar sobre el DPF en el grid de resultados")
	public void presionar_sobre_el_DPF_en_el_grid_de_resultados() {
		 FormActions.clickOn(FBusquedaDepositoForm.GridListaP.gridPrimerCliente);
	}

	@Cuando("se abre el menú de acciones escoger la opción Activar")
	public void se_abre_el_menú_de_acciones_escoger_la_opción_Activar() {
		HeaderActions.clickAction(FDetalleOperacionApertura.Buttons.botonOpcionesApertura);
	}
	@Cuando("presiona el botón Aceptar")
	public void presiona_el_botón_Aceptar() {
		HeaderActions.clickAction(FDetalleOperacionApertura.Buttons.botonActivar);
		FormActions.clickOn(FDetalleOperacionApertura.Buttons.botonAceptar);
	}
	@Entonces("el Certificado de Depósito se muestra un mensaje de excepcion {string} y se mantiene en estado {string}")
	public void el_Certificado_de_Depósito_se_muestra_un_mensaje_de_excepcion_y_se_mantiene_en_estado(String mensajeExcepcion, String estado) {
		ValidationActions.isEquals(FDetalleOperacionApertura.MensajeExcepcion.mensajeInformacion, mensajeExcepcion );
		ValidationActions.isEquals(FDetalleOperacionApertura.CabeceraInformacion.estadoApertura, estado);
	}
	
	//JCMA QA-S465034
	@Cuando("se presiona el menú acciones, escogiendo la opción Cancelación Normal")
	public void se_presiona_el_menu_acciones_escogiendo_la_opcion_cancelacion_normal(){
		HeaderActions.clickAction(FDetalleBusquedaDeposito.Buttons.botonOpcionesApertura);
		HeaderActions.clickAction(FDetalleBusquedaDeposito.Buttons.botonCancelacionNormal);
	}
	
	
	
	//JCMA QA-S465034
	@Cuando("se diligencia el formulario de Cancelación")
	public void se_diligencia_el_formulario_de_cancelacion(){
		FormActions.selectByText(FCancelacionNormalForm.Seleccion.solicitante, "FERNANDA DIAZ DE LEON");
		FormActions.enterText(FCancelacionNormalForm.IngresarDatos.inputObservacion, "Obervación de prueba");
		FormActions.clickOn(FCancelacionNormalForm.Buttons.botonSiguienteop);
	}
	
	//JCMA QA-S465034
	@Cuando("se diligencia el formulario de forma de pago de {string} con {string} el {string}")
	public void se_diligencia_el_formulario_de_forma_de_pago(String nombre, String formaPago, String monto){ 
		FormActions.clickOn(FFormasDePago.Buttons.botonNuevo);
		FormActions.selectByText(FFormasDePago.Seleccion.formaRecepcion, formaPago);
		FormActions.enterText(FFormasDePago.IngresarDatos.input_MontoRecepcion, monto);
		FormActions.selectByText(FFormasDePago.Seleccion.beneficiario, nombre);
		FormActions.clickOn(FFormasDePago.Buttons.botonAceptarPago);
		FormActions.clickOn(FFormasDePago.Buttons.botonGuardar);
	}
	
	//JCMA QA-S465034
	@Entonces("el Certificado de Depósito se cancela cambiando el estado del mismo")
	public void el_certificado_de_deposito_se_cancela_cambiando_el_estado_del_mismo(){
		ValidationActions.isEquals(FDetalleOperacionApertura.CabeceraInformacion.estadoApertura, "CAN");
	}
	
/*MAAV Apertura de un certificado de depósito Persona Natural_Vencimiento_Capitalización SI_moneda pesos_ND a una Cta. Sin fondos*/
	
	@Cuando("se busca el certificado de depósito por el {string} con {string}")
	public void se_busca_el_certificado_de_deposito_por_el_con(String numero_de_operacion, String numero_de_cuenta) {
	    FormActions.selectByText(FBusquedaDepositoForm.Seleccion.buscarPor, numero_de_operacion);
	    FormActions.enterText(FBusquedaDepositoForm.IngresarDatos.input_BuscarTodos, numero_de_cuenta);
	    FormActions.clickOn(FBusquedaDepositoForm.Buttons.botonBuscar);
	    FormActions.clickOn(FBusquedaDepositoForm.GridListaP.gridPrimerCliente);
	}
	
	
	@Cuando("se presiona el botón siguiente")
	public void se_presiona_el_botón_siguiente() {
		FormActions.clickOn(FCancelacionNormalForm.Buttons.botonSiguientecli);
	}
	
	@Cuando("se diligencia el formulario de Cancelación con el {string} y con {string}")
	public void se_diligencia_el_formulario_de_cancelacion_con_el_y_con(String numero_de_solicitante ,String observacion) {
		FormActions.selectByText(FCancelacionNormalForm.Seleccion.solicitante,numero_de_solicitante);
		FormActions.enterText(FCancelacionNormalForm.IngresarDatos.inputObservacion, observacion);
		FormActions.clickOn(FCancelacionNormalForm.Buttons.botonSiguienteop);
	}
	
	@Cuando("se diligencia el formulario de forma de pago con {string} y {string} y {string}")
	public void se_diligencia_el_formulario_de_forma_de_pago_multimoneda(String formaRecepcion,String monto, String solicitante){
		FormActions.clickOn(FFormasDePago.Buttons.botonNuevo);
		FormActions.selectByText(FFormasDePago.Seleccion.formaRecepcion, formaRecepcion);
		FormActions.enterText(FFormasDePago.IngresarDatos.input_MontoRecepcion, monto);
		FormActions.selectByText(FFormasDePago.Seleccion.beneficiario, solicitante);
		FormActions.clickOn(FFormasDePago.Buttons.botonCuentaCliente);
		FormActions.clickOn(FFormasDePago.Grid.gridPrimerCliente);
		FormActions.clickOn(FFormasDePago.Buttons.botonAceptarPago);
		FormActions.clickOn(FFormasDePago.Buttons.botonGuardar);
	}
	
	@Cuando("se presiona el menú acciones escogiendo la opción Modificación")
	public void se_presiona_el_menu_acciones_escogiendo_la_opcion_modificacion(){
		HeaderActions.clickAction(FDetalleOperacionApertura.Buttons.botonOpcionesApertura);
		HeaderActions.clickAction(FDetalleOperacionApertura.Buttons.botonModificacion);
	}
	@Cuando("en el formulario realiza la busqueda por {string} por {string}, {string}, {string} tipo {string}")
	public void en_el_formulario_realiza_la_busqueda_por_por_tipo(String cliente, String entidad, String tipo, String buscar_por, String tipoCuenta) {
		if(tipo.equals("Persona Natural")){ nombre.addAll(Arrays.asList( cliente.split(" "))); }
		else{ nombre.add(cliente); }
		FormActions.clickOn(AdminAperturaPlazoFijo.Buttons.nuevoCliente);
		FormActions.clickOn(AdminAperturaPlazoFijo.Buttons.botonBuscarCliente);
		FormActions.selectByText(AdminAperturaPlazoFijo.tipoCuenta, tipoCuenta);
		if(entidad!=null){
			FormActions.clickOn(FBusquedaClienteForm.Buttons.botonEntidad);
			if(entidad.equals("Cliente")){ FormActions.clickOn(FBusquedaClienteForm.Buttons.botonEntidadCliente); }
		}
		if(tipo!=null){
			FormActions.clickOn(FBusquedaClienteForm.Buttons.botonTipo);
			if(tipo.equals("Persona Natural")){ FormActions.clickOn(FBusquedaClienteForm.Buttons.botonTipoNatural); }
			else{ FormActions.clickOn(FBusquedaClienteForm.Buttons.botonTipoJuridico); }
		}
		if(buscar_por!=null){
			FormActions.clickOn(FBusquedaClienteForm.Buttons.botonBuscarPor);
			if(buscar_por.equals("Nombre")){ 
				FormActions.clickOn(FBusquedaClienteForm.Buttons.botonBuscarPorNombre);
				FormActions.enterText(FBusquedaClienteForm.FiltroBusquedaCliente.input_BARRA_BUSCAR, nombre.get(0) );
			}
			else if(buscar_por.equals("Código")){ 
				FormActions.clickOn(FBusquedaClienteForm.Buttons.botonBuscarPorCodigo);
				FormActions.enterText(FBusquedaClienteForm.FiltroBusquedaCliente.input_BARRA_BUSCAR_CODIGO, nombre.get(0) );
			}
			else{
				FormActions.enterText(FBusquedaClienteForm.FiltroBusquedaCliente.input_BARRA_BUSCAR_IDENTIFICACION, nombre.get(0) );
			}
		}
		
		FormActions.clickOn(FBusquedaClienteForm.Buttons.botonBuscar);
		if(tipo.equals("Persona Natural")){ FormActions.clickOn(FBusquedaClienteForm.GridListaP.gridClienteNatural); }
		else{ FormActions.clickOn(FBusquedaClienteForm.GridListaP.gridClienteJuridico); }
		FormActions.clickOn(FBusquedaClienteForm.Buttons.botonSiguiente);
		FormActions.clickOn(AdminAperturaPlazoFijo.ButtonsRow.buttonsAcceptRow);
		nombre.clear();
		FormActions.clickOn(AdminAperturaPlazoFijo.Buttons.botonSiguiente);
	}
	
	@Cuando("se diligencia el formulario de Operaciones modificando el {string}")
	public void se_diligencia_el_formulario_de_operaciones_modificando_el_monto(String monto){
		FormActions.enterText(FVistaOperacionForm.IngresarDatos.input_Monto, monto);
		FormActions.clickOn(FVistaOperacionForm.Buttons.botonSimular);
		FormActions.clickOn(FVistaOperacionForm.Buttons.botonAceptarModal);
		FormActions.clickOn(FVistaOperacionForm.Buttons.botonSiguiente);	
	}
	
	@Cuando("se diligencia el formulario de forma de recepcion {string}")
	public void se_diligencia_el_formulario_de_forma_de_recepcion(String monto){
		FormActions.clickOn(AdminAperturaPlazoFijo.ButtonsRow.buttonsDeleteRow);
		FormActions.clickOn(AdminAperturaPlazoFijo.Buttons.botonAceptarEliminacion);
		FormActions.clickOn(FRecepcionModalForm.Buttons.botonNuevo);
		FormActions.selectByText(FRecepcionModalForm.Seleccion.formaRecepcion, "CONTABLE");
		FormActions.enterText(FRecepcionModalForm.IngresarDatos.input_MontoRecepcion, monto);
		FormActions.clickOn(FRecepcionModalForm.Buttons.botonAceptarRecepcion);
		FormActions.clickOn(FRecepcionModalForm.Buttons.botonSeleccionRecepcion);
		FormActions.clickOn(FRecepcionModalForm.Buttons.botonGuardarRecepcion);
		
	}
	
	@Cuando("se actualiza el {string} del Certificado de Depósito")
	public void se_actualiza_el_monto_del_certificado_de_deposito(String monto){
		ValidationActions.isEquals(FDetalleOperacionApertura.CabeceraInformacion.montoApertura, monto);
	}
	
	@Cuando("se diligencia el formulario de Operaciones modificando la forma de pago")
	public void se_diligencia_el_formulario_de_operaciones_modificando_la_forma_de_pago(){
		FormActions.selectByText(FVistaOperacionForm.Seleccion.formaPago, "VENCIMIENTO");
		FormActions.clickOn(FVistaOperacionForm.Buttons.botonSimular);
		FormActions.clickOn(FVistaOperacionForm.Buttons.botonAceptarModal);
		FormActions.clickOn(FVistaOperacionForm.Buttons.botonSiguiente);
	}
	@Cuando("se diligencia el formulario forma de recepción")
	public void se_diligencia_el_formulario_forma_de_recepcion(){
		FormActions.clickOn(FRecepcionModalForm.Buttons.botonGuardarRecepcion);
	}
	
	@Cuando("se actualiza la forma de pago del Certificado de Depósito")
	public void se_actualiza_la_forma_de_pago_del_certificado_de_deposito(){
		FormActions.clickOn(FDetalleOperacionApertura.BarraOpciones.pestañaOperacion);
		ValidationActions.isEquals(FVistaOperacionForm.Seleccion.validarFormaPago, "VENCIMIENTO");
	}
	
	//RSRM - QA-S465778-Modificación de Certificados de Depósito
	@Cuando("diligencia el formulario de Operación {string},{string},{string},{string},{string},{string},{string}")
	public void diligencia_el_formulario_de_Operación(String producto, String forma_pago, String capitaliza, String categoria, String moneda, String monto, String plazo) {
		if(producto.length()>0){FormActions.selectByText(FVistaOperacionForm.Seleccion.producto, producto); } 
		if(forma_pago.length()>0){FormActions.selectByText(FVistaOperacionForm.Seleccion.formaPago, forma_pago); }
		if(capitaliza.length()>0){FormActions.selectByText(FVistaOperacionForm.Seleccion.capitalizaInteres, capitaliza); }
		if(categoria.length()>0){FormActions.selectByText(FVistaOperacionForm.Seleccion.categoria, categoria); }
		if(moneda.length()>0){FormActions.selectByText(FVistaOperacionForm.Seleccion.moneda, moneda); }
		if(monto.length()>0){FormActions.enterText(FVistaOperacionForm.IngresarDatos.input_Monto, monto); }
		if(plazo.length()>0){FormActions.enterText(FVistaOperacionForm.IngresarDatos.input_Plazo, plazo); }
		FormActions.clickOn(FVistaOperacionForm.Buttons.botonSimular);
		FormActions.clickOn(FVistaOperacionForm.Buttons.botonAceptarModal);
		FormActions.clickOn(FVistaOperacionForm.Buttons.botonSiguiente);
	}

	@Dado("diligencia el formulario de Recepción de fondos {string} a {string} con {string} y guardar")
	public void diligencia_el_formulario_de_Recepción_de_fondos_a_con_y_guardar(String formaRecepcion, String cliente, String mondo) {
		if(formaRecepcion.length()>0 && cliente.length()>0 && mondo.length()>0){FormActions.clickOn(FRecepcionModalForm.Buttons.botonNuevo); }
		if(formaRecepcion.length()>0){FormActions.enterTextAndTab(FRecepcionModalForm.IngresarDatos.inputFormaRecepcion, formaRecepcion); }
		if(mondo.length()>0){FormActions.enterText(FRecepcionModalForm.IngresarDatos.input_MontoRecepcion, mondo);}
		if(cliente.length()>0  && mondo.length()>0){FormActions.enterTextAndEnter(FRecepcionModalForm.IngresarDatos.inputprimerCliente, cliente);}
		if(formaRecepcion.length()>0 && cliente.length()>0 && mondo.length()>0){
			FormActions.clickOn(FRecepcionModalForm.Buttons.botonCuentaCliente);
			FormActions.clickOn(FRecepcionModalForm.Grid.gridPrimerCliente);
			FormActions.clickOn(FRecepcionModalForm.Buttons.botonAceptarRecepcion);
		}	
		FormActions.clickOn(FRecepcionModalForm.Buttons.botonSeleccionRecepcion);
		FormActions.clickOn(FRecepcionModalForm.Buttons.botonGuardarRecepcion);
	}

	@Entonces("se actualiza el Certificado de Depósito con el nuevo Cliente {string}")
	public void se_actualiza_el_Certificado_de_Depósito_con_el_nuevo_Cliente(String cliente) {
		ValidationActions.isEquals(FDetalleOperacionApertura.CabeceraInformacion.estadoApertura, "ING");
//		HeaderActions.clickAction(FDetalleOperacionApertura.Buttons.botonEtiquetaTitulares);
//		ValidationActions.isEquals(FDetalleOperacionApertura.GridTitulares.gridTitularesNombre, cliente);
	}
}

