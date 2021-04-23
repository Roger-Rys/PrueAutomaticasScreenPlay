#language: es
#Author: your.email@your.domain.com


Característica: Busqueda de Deposito
	COMO usuario de la plataforma Cobis , usando filial , oficina y rol del modulo de DPF
	QUIERO activar un Certificado de Depósitos a Plazo
	PARA  evidenciar el cambio de estado de un Certificado de Depósito
	
Antecedentes: El usuario ingresa a cobis
	 Dado que usuario:"admuser" realiza Login en COBIS con password:"Passw0rd2019*#" rol:"MENU POR PROCESOS" filial:"BANCO COBIS" oficina:"OFICINA MATRIZ" en la url:"http://www.demo1.cloud-cobiscorp.com/CWC/services/cobis/web/bank/views/commons/login.html"
   Dado que navega desde "Depósitos a Plazo" hacia "Búsqueda de Depósitos"
   
   #QA-S464719
   @BusquedaDeposito
   Esquema del escenario: Verificar la activación de un Certificado de Depósito
	 Cuando se busca el certificado de depósito por <numero_de_operacion> con <numero>
	 Y presionar sobre el DPF en el grid de resultados
	 Y se abre el menú de acciones escoger la opción Activar
	 Y presiona el botón Aceptar
	 Entonces el Certificado de Depósito se muestra un mensaje de excepcion <MensajeExcepcion> y se mantiene en estado <Estado>
	 Ejemplos:
	 |numero_de_operacion  | numero 			| Estado | MensajeExcepcion|
	 |'Numero de operación'| '70100002716'|'ING'	 | 'Excepción de negocio: 16 - 141153 - [BL_activa_deposito] Recuerde depositar los fondos en caja'|
	
 	 #QA-S465034
   @CancelacionDeposito
   Esquema del escenario: Verificar la cancelación de un Certificado de Depósito con NC a cuenta
	 Cuando se busca el certificado de depósito por <numero_de_operacion> con <numero>
	 Y presionar sobre el DPF en el grid de resultados
	 Y se presiona el menú acciones, escogiendo la opción Cancelación Normal
	 Y se presiona el botón siguiente
	 Y se diligencia el formulario de Cancelación con el <nombre_de_solicitante> y con <observacion>
	 Y se diligencia el formulario de forma de pago de <nombre_de_solicitante> con <forma_pago> el <monto>
	 Entonces el Certificado de Depósito se cancela cambiando el estado del mismo
	  Ejemplos:
	 |numero_de_operacion  | numero 			|   nombre_de_solicitante   |      observacion       |   forma_pago  |  monto    |
	 |'Numero de operación'| '70100014210'|  'FERNANDA DIAZ DE LEON'  | 'Obervación de prueba' |  "CONTABLE"   | "7048.32" |

	
    #QA-S465312
   @CancelaCuenta2FormasPagoContEfec
   Esquema del escenario: Verificar la Cancelación de un Certificado de Depósito con 2 Formas de Pago
	 Cuando se busca el certificado de depósito por el <numero_de_operacion> con <numero_de_cuenta>
	 Y se presiona el menú acciones, escogiendo la opción Cancelación Normal
	 Y se presiona el botón siguiente
	 Y se diligencia el formulario de Cancelación con el <nombre_solicitante> y con <observacion>
	 Y se diligencia el formulario de forma de pago con <formaRecepcionFP>,<nombre_beneficiario> y <formaRecepcionFP2>
	 Entonces el Certificado de Depósito se cancela cambiando el estado del mismo
	 Ejemplos:
	 |numero_de_operacion  | numero_de_cuenta 			| nombre_solicitante           | observacion          | formaRecepcionFP | nombre_beneficiario         | formaRecepcionFP2| 
	 |'Numero de operación'| '70100014932'          | 'DIANA LAURA SANCHEZ CHAVEZ' | 'PRUEBA CANCELACION' |  'EFECTIVO'      | 'DIANA LAURA SANCHEZ CHAVEZ'|'CONTABLE'        | 
	 
	 #QA-S465820
   @ActualizacionFormaDePagoDPFP3
   Esquema del escenario: Verificar la Cancelación de un Certificado de Depósito con 2 Formas de Pago
	 Cuando se busca el certificado de depósito por el <numero_de_operacion> con <numero_de_cuenta>
	 Y se presiona el menú acciones escogiendo la opción Modificación
	 Y en el formulario de clientes agregar un <cliente_persona_natural> y con tipo <tipo_cuenta>
	 Y se diligencia el formulario de Operaciones con <forma_de_pago> y <frecuencia>
	 Y se diligencia el formulario de forma de recepción siguiente
	 Y se diligencia el formulario de forma de pago modificacion con <formaRecepcionFP>,<nombre_beneficiario>
	 Entonces se actualiza la forma de pago del Certificado de Depósito con <forma_de_pago>
	 Ejemplos:
	 |numero_de_operacion  | numero_de_cuenta 			| cliente_persona_natural| tipo_cuenta |forma_de_pago|frecuencia  |formaRecepcionFP | nombre_beneficiario|
	 |'Numero de operación'| '70100013504'          |'123456789'             | 'INDISTINTA'|'PERIODICA'  |'MENSUAL'   |'EFECTIVO'       | 'Manuel Gonzalez B'|
	
	
	 #QA-S465407
	 @CancelacionDepositoMultimoneda
	 Esquema del escenario: Validar la cancelación de un Certificado de Depósito multimoneda
	 Cuando se busca el certificado de depósito por el <numero_de_operacion> con <numero_de_cuenta>
	 Y se presiona el menú acciones, escogiendo la opción Cancelación Normal
	 Y se presiona el botón siguiente
	 Y se diligencia el formulario de Cancelación con el <nombre_solicitante> y con <observacion>
	 Y se diligencia el formulario de forma de pago con <forma_recepcion> y <monto> y <nombre_solicitante>
	 Entonces el Certificado de Depósito se cancela cambiando el estado del mismo
		Ejemplos: 
		|numero_de_operacion  | numero_de_cuenta | nombre_solicitante        | observacion          | forma_recepcion    | monto    |
	  |'Numero de operación'|'70200012726'     | 'MARIANA  HERNANDEZ LOPEZ' | 'PRUEBA CANCELACION' | 'CUENTA DE AHORROS'| '6017.50'|
	  
	 #QA-S465709-Modificación de Certificados de Depósito-Parte 1
	 @ActualizacionMontoDPF
	 Esquema del escenario: Verificar la correcta actualización del monto de un Certificado de Depósito
	 Cuando se busca el certificado de depósito por el <numero_de_operacion> con <numero_de_cuenta>
	 Y se presiona el menú acciones escogiendo la opción Modificación
	 Y se presiona el botón siguiente
	 Y se diligencia el formulario de Operaciones modificando el <monto>
	 Y se diligencia el formulario de forma de recepcion <monto>
   Entonces se actualiza el <monto> del Certificado de Depósito
	  Ejemplos:
	 |numero_de_operacion  | numero_de_cuenta 			| monto     |
	 |'Numero de operación'| '70200012930'          |'6,000.00' |
	 
	 #QA-S465709-Modificación de Certificados de Depósito-Parte 1
	 @ActualizacionFormaDePagoDPF
	 Esquema del escenario: Verificar la actualización de un Certificado de Depósito de Periódico a Vencimiento
	 Cuando se busca el certificado de depósito por el <numero_de_operacion> con <numero_de_cuenta>
	 Y se presiona el menú acciones escogiendo la opción Modificación
	 Y se presiona el botón siguiente
	 Y se diligencia el formulario de Operaciones modificando la forma de pago
	 Y se diligencia el formulario forma de recepción
	 Entonces se actualiza la forma de pago del Certificado de Depósito
	 Ejemplos:
	 |numero_de_operacion  | numero_de_cuenta 			| 
	 |'Numero de operación'| '70100013352'          |
	 
	 #QA-S465778-Modificación de Certificados de Depósito - Verificar un Certificado de Depósito adicionando un Cliente 
	 @ModificacionCertificadosDepositoNuevoCliente
	 Esquema del escenario: Verificar la actualización de un Certificado de Depósito adicionando un Cliente con firma indistinta
	 Cuando se busca el certificado de depósito por <numero_de_operacion> con <numero>
	 Y presionar sobre el DPF en el grid de resultados
	 Y se presiona el menú acciones escogiendo la opción Modificación
	 Y en el formulario realiza la busqueda por <cliente_persona_natural1> por <entidad>, <tipo>, <buscar_por> tipo <tipo_cuenta>
	 Y diligencia el formulario de Operación <producto>,<forma_pago>,<capitaliza>,<categoria>,<moneda>,<monto>,<plazo>
	 Y diligencia el formulario de Recepción de fondos <formaRecepcion> a <cliente_persona_natural1> con <monto> y guardar
	 Entonces se actualiza el Certificado de Depósito con el nuevo Cliente <cliente_persona_natural1> y se mantiene en estado <estado>
	 Ejemplos:
	 |numero_de_operacion  |numero 			 |cliente_persona_natural1 	 |entidad	 |tipo						 |buscar_por|tipo_cuenta |producto |forma_pago|capitaliza|categoria|moneda|monto|plazo|formaRecepcion|estado|
	 |'Numero de operación'|'70100002700'|"DIANA LAURA SANCHEZ CHAVEZ"|"Cliente"|"Persona Natural"|"Nombre"	|'INDISTINTA'|''			 |''				|   ''		 |  ''  	 | ''   |''		|''		|""|'ING'|
	 
	 #QA-S465778-Modificación de Certificados de Depósito - Verificar un Certificado de Depósito adicionando un forma de recepción  
	 @ModificacionCertificadosNuevoFormaRecepcion
	 Esquema del escenario: Verificar la actualización de un Certificado de Depósito agregar un forma de recepción adicional
	 Cuando se busca el certificado de depósito por <numero_de_operacion> con <numero>
	 Y presionar sobre el DPF en el grid de resultados
	 Y se presiona el menú acciones escogiendo la opción Modificación
	 Y en el formulario realiza la busqueda por <cliente> por <entidad>, <tipo>, <buscar_por> tipo <tipo_cuenta>
	 Y diligencia el formulario de Operación <producto>,<forma_pago>,<capitaliza>,<categoria>,<moneda>,<monto>,<plazo>
	 Y agregar una nueva forma de recepción eliminar la creada
	 Y diligencia el formulario de Recepción de fondos <formaRecepcion> a <cliente> con <monto2> y guardar
	 Entonces se actualiza el Certificado de Depósito con el Certificado de Depósito y se mantiene en estado <estado>
	 Ejemplos:
	 |numero_de_operacion  |numero 			 |cliente |entidad|tipo|buscar_por|tipo_cuenta |producto |forma_pago|capitaliza|categoria|moneda|monto|monto2	 |plazo|formaRecepcion|estado|
	 |'Numero de operación'|'70100002700'|""			|""		  |""	 |""   		  |''					 |''			 |''				|   ''		 |  ''  	 | ''   |''		|'100000'|	''	  |	'EFECTIVO'	 |'ING'	|	
	 
	 