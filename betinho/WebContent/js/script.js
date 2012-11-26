/**
 Arquivos fontes em javascript 
 Copyright 2007 Daniel Gorski 
 Todos os direitos reservados
*/


var netscape =(navigator.appName.indexOf("Netscape") >= 0  && parseFloat(navigator.appVersion) >= 4) ? true : false;
var explorer = (document.all) ? true : false;

function clearForm(){ 
  var tamanho = document.forms[0].elements.length;
  for(var x=0; x < tamanho; x++){
    if(document.forms[0].elements[x].type != 'hidden' && document.forms[0].elements[x].type != 'select-one'){
      document.forms[0].elements[x].value = '';
    }
  }
}

//**************************/
// Função pegaTecla
//
// alteração: 17/10/2006
// event - evento de teclado
// iframe - parametro opcional, deve ser passado igual a "true" se chamado em um iframe
// o método bloquea o uso da tecla "CRTL", para evitar o uso de Copiar e Colar
//**************************/
function pegaTecla( event )
{
  var key = null;
  var charCode = null;
  if(explorer)
  {
    charCode = (event.charCode) ? event.charCode : event.keyCode;
  }
  else if(netscape)
  {
    charCode = (event.charCode) ? event.charCode : event.which;  
  }
  if(charCode == 17){
		if(document.getElementById('erro') != null ){
			document.getElementById('erro').innerHTML = 'Tecla inválida. Favor não apertar CTRL.';
		} else {
			parent.document.getElementById('erro').innerHTML = 'Tecla inválida. Favor não apertar CTRL.';
		}
  } //control
  key = String.fromCharCode(charCode);
  if(charCode == 8) return 'SPECIAL'; //backspace
  else if(charCode == 0) return 'SPECIAL';//delete e setas          
  return key;
}

function isValidaTodosCampos(selectValue){
  var elementos = document.forms[0].elements;
  var tamanho = elementos.length;

  for(var x=0; x < tamanho; x++){
    if (elementos[x].disabled == false)
    {
      if(elementos[x].type != 'hidden'){
        if(elementos[x].type == 'text'){ // || elementos[x].type == 'textarea'
          if (elementos[x].value.trim().length == 0 || elementos[x].value == ''){
            elementos[x].focus();
            return false;
          }
        }else if(elementos[x].type == 'select-one' || elementos[x].type == 'select'){
          if(selectValue != null){
            if(elementos[x].value == selectValue){
              elementos[x].focus();
              return false;
            }
          }else{
            if(elementos[x].value == "0"){
              elementos[x].focus();
              return false;
            }
          }
        }
      }
    }
  }
  return true; 
}


function submitMenu(perform){
 document.forms[0].perform.value = perform;
 document.forms[0].submit();
}

function setSelected(nome, valor){
  var tamanho = document.forms[0].elements.length;
  var select  = document.forms[0].elements[nome];

  for(var x=0; x<tamanho; x++){
    if(document.forms[0].elements[x].type == 'radio')
    {
      if (document.forms[0].elements[x].value == valor && document.forms[0].elements[x].name == nome)
      {
        document.forms[0].elements[x].checked = true; 
        if(document.forms[0].elements[x].disabled == false)
        {
           if(nofocus == null)
              document.forms[0].elements[x].focus();
        }
      }
    }else if((document.forms[0].elements[x].type == 'select-one') ||
             (document.forms[0].elements[x].type == 'select')){
       if(select != null){
         if(document.forms[0].elements[x].name == nome){
           for(var y=0; y<select.length; y++){
             if(select[y].value == valor){
               select[y].selected = true;
               break;
             }else
               select[0].selected = true;
           }
         }
       }  
    }
  }
}  

function validaHora(a){
	if(a.length != 5){
	  return false; 
	}else{
		h = a.substring(0, 2);
		m = a.substring(3, 5);
		if(h > 23){
			return false;
		}
		if(m > 59){
			return false;
		}
	  	return true;
	}
}

function validaData(a)
{
	var err=0;
	var psj=0;
      var teste=0;
      var ano;
     if (a.length != 10)  err=1
	d = a.substring(0, 2)//day
	c = a.substring(2, 3)// '/'
	b = a.substring(3, 5)//  month
	e = a.substring(5, 6)// '/'
      if (a.length == 10)
        ano=  a.substring(8, 10)// year
      f = ano;
	//basic error checking
	if (b<1 || b>12) err = 1
	if (c != '/') err = 1
	if (d<1 || d>31) err = 1
	if (e != '/') err = 1
	if (f<0 || f>99) err = 1
	//advanced error checking
	// months with 30 days
	if (b==4 || b==6 || b==9 || b==11){
		if (d==31) err=1
	}
	// february, leap year
	if (b==2){
		// feb
		var g=parseInt(f/4)
		if (isNaN(g)) {
			err=1
		}
		if (d>29) err=1
		if (d==29 && ((f/4)!=parseInt(f/4))) err=1
	}
	if (err==1){
		return false;
	}
	else{
		return true;
	}
}

String.prototype.trim = function() {
// skip leading and trailing whitespace
// and return everything in between
  var x=this;
  x=x.replace(/^\s*(.*)/, "$1");
  x=x.replace(/(.*?)\s*$/, "$1");
  return x;
}

// copy 'txtIn' to 'txtOut', trimming off unused whitespace
function btnClick() {
 // get the string value from the 'txtIn' element
  var s = document.frm1.txtIn.value;

 // trim the string value and put it into the 'txtOut' element
  document.frm1.txtOut.value = s.trim();
}
function pegaTecla( event )
{
  var key = null;
  var charCode = null;
  if(explorer)
  {
    charCode = (event.charCode) ? event.charCode : event.keyCode;
  }
  else if(netscape)
  {
    charCode = (event.charCode) ? event.charCode : event.which;  
  }
  if(charCode == 17){
		if(document.getElementById('erro') != null ){
			alert( 'Tecla inválida. Favor não apertar CTRL.' ) ;
		} else {
			alert( 'Tecla inválida. Favor não apertar CTRL.' );
		}
  } //control
  key = String.fromCharCode(charCode);
  if(charCode == 8) return 'SPECIAL'; //backspace
  else if(charCode == 0) return 'SPECIAL';//delete e setas          
  return key;
}
function verificaNro( evento ){
  var key = pegaTecla( evento );
  if(key == 'SPECIAL') return true;
	return ( ("0123456789").indexOf(key) != -1 );
}
function formataData( nomeCampo, evento ){

  if(explorer)
  {
    if(evento.keyCode == 8) return true;
    else if(evento.keyCode == 0) return true;        
  }
  else if(netscape)
  {
    if(evento.which == 8) return true;
    else if(evento.which == 0) return true;    
  }

  if(nomeCampo.value.length==10)
    return false;
    
	var isNro = verificaNro( evento );
	if( isNro ){
		if( ( nomeCampo.value.length == 2 )||( nomeCampo.value.length == 5 ) )
			nomeCampo.value += "/";
	}
	return isNro;
}

function formataHora( nomeCampo, evento ){

  if(explorer)
  {
    if(evento.keyCode == 8) return true;
    else if(evento.keyCode == 0) return true;        
  }
  else if(netscape)
  {
    if(evento.which == 8) return true;
    else if(evento.which == 0) return true;    
  }

  if(nomeCampo.value.length==5)
    return false;
    
	var isNro = verificaNro( evento );
	if( isNro ){
		if( ( nomeCampo.value.length == 2 ))
			nomeCampo.value += ":";
	}
	return isNro;
}

function voltar(){
 document.location = "menu.do";
}



function PopUpCenter(url, x, y){
  winl = (screen.width - x) / 2;
  wint = (screen.height - y) / 2;
  param = 'scrollbars=1,menubar=0,location=0,resizable=0,toolbar=0,status=1,width='+x
  param +=',height='+y+',top='+wint+',left='+winl
  win =window.open(url,'_blank',param)
  return win;
}
function calendario(){
	PopUpCenter('calendar.do',300,200,'Yes','Yes');

}

function FormataCpf(campo,tammax,teclapres) {
 var tecla = pegaTecla( teclapres );
 if(tecla == 'SPECIAL') return true;
 vr = teclapres.srcElement.value;
 vr = vr.replace( "/", "" );
 vr = vr.replace( "/", "" );
 vr = vr.replace( ",", "" );
 vr = vr.replace( ".", "" );
 vr = vr.replace( ".", "" );
 vr = vr.replace( ".", "" );
 vr = vr.replace( ".", "" );
 vr = vr.replace( "-", "" );
 vr = vr.replace( "-", "" );
 vr = vr.replace( "-", "" );
 vr = vr.replace( "-", "" );
 vr = vr.replace( "-", "" );
 tam = vr.length;

 if (tam < tammax && tecla != 8){ tam = vr.length + 1 ; }

 if (tecla == 8 ){ tam = tam - 1 ; }
  
 if ( tecla == 8 || tecla >= 48 && tecla <= 57 || tecla >= 96 && tecla <= 105 ){
  if ( tam <= 2 ){ 
    event.srcElement.value = vr ; }
   if ( (tam > 2) && (tam <= 5) ){
    event.srcElement.value = vr.substr( 0, tam - 2 ) + '-' + vr.substr( tam - 2, tam ) ; }
   if ( (tam >= 6) && (tam <= 8) ){
    event.srcElement.value = vr.substr( 0, tam - 5 ) + '.' + vr.substr( tam - 5, 3 ) + '-' + vr.substr( tam - 2, tam ) ; }
   if ( (tam >= 9) && (tam <= 11) ){
    event.srcElement.value = vr.substr( 0, tam - 8 ) + '.' + vr.substr( tam - 8, 3 ) + '.' + vr.substr( tam - 5, 3 ) + '-' + vr.substr( tam - 2, tam ) ; }
   if ( (tam >= 12) && (tam <= 14) ){
    event.srcElement.value = vr.substr( 0, tam - 11 ) + '.' + vr.substr( tam - 11, 3 ) + '.' + vr.substr( tam - 8, 3 ) + '.' + vr.substr( tam - 5, 3 ) + '-' + vr.substr( tam - 2, tam ) ; }
   if ( (tam >= 15) && (tam <= 17) ){
    event.srcElement.value = vr.substr( 0, tam - 14 ) + '.' + vr.substr( tam - 14, 3 ) + '.' + vr.substr( tam - 11, 3 ) + '.' + vr.substr( tam - 8, 3 ) + '.' + vr.substr( tam - 5, 3 ) + '-' + vr.substr( tam - 2, tam ) ;}
 }  
}

function isAlfaNroAcento( event ){ 
  var caractere = pegaTecla( event );
  if(caractere == 'SPECIAL') return true;  
  var strValidos = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789 ";  
  if ( strValidos.indexOf( caractere ) == -1 ) 
    return false; 
  
  return true;     
}

function isAlfaNro( event ){ 
  var caractere = pegaTecla( event );
  if(caractere == 'SPECIAL') return true;    
  var strValidos = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789 ";
  
  if ( strValidos.indexOf( caractere ) == -1 ) 
    return false; 
  
  return true;     
}

/*   
 * Método para verificar se é alfa caracter, numeros e /.
 * @author Marcel Oliveira
 */
function isAlfaNroBarra( event ){ 
  var caractere = pegaTecla( event );
  if(caractere == 'SPECIAL') return true;    
  var strValidos = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789/ ";
  
  if ( strValidos.indexOf( caractere ) == -1 ) 
    return false; 
  
  return true;     
}

/*   
 * Método para verificar se é alfa caracter, numeros e os seguintes caracteres especias: - /
 * @author Marcel Oliveira
 */
function isAlfaNroEsp( event ){ 
  var caractere = pegaTecla( event );
  if(caractere == 'SPECIAL') return true;    
  var strValidos = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789áêéíõóúôç/- ";
  
  if ( strValidos.indexOf( caractere ) == -1 ) 
    return false; 
  
  return true;     
}

/*   
 * Método para verificar se é alfa caracter.
 * @author Lucas Afonso Corrêa
 */
function isAlfa( event ){ 
  var caractere = pegaTecla( event );
  if(caractere == 'SPECIAL') return true;    
  var strValidos = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789ãáêéíõóúôç";
  
  if ( strValidos.indexOf( caractere ) == -1 ) 
    return false; 
  
  return true;    }

/*
 * @author Luiz Henrique Grossl
 * @since 04-01-2003
 * verifica se esta sendo digitado um nro, trava o campo só para nros
 */
function verificaNro( evento ){
  var key = pegaTecla( evento );
  if(key == 'SPECIAL') return true;
	return ( ("0123456789").indexOf(key) != -1 );
}

/*
 * @author Luiz Henrique Grossl
 * @since 04-01-2003
 * verifica se esta sendo digitado um nro real (ex.: 123,12) e trava o campo só para nros e vírgula
 */
function verificaNroReal( evento ){
  var key = pegaTecla( evento );
  if(key == 'SPECIAL') return true;
	return ( ("0123456789,").indexOf(key) != -1 );
}

function formataCPF( nomeCampo, evento ){
	var isNro = verificaNro( evento );
	if( isNro ){
		if( ( nomeCampo.value.length == 3 )||( nomeCampo.value.length == 7 ) )
			nomeCampo.value += ".";
		else if( nomeCampo.value.length == 11 )
			nomeCampo.value += "-";
    else if( nomeCampo.value.length == 14)
      return false;
	}
	return isNro;
}

/*
 * formata um cpf para o formato xxx.xxx.xxx-xx
 * @author Luiz Henrique Grossl
 * @since 22-01-2003
 * @return String: retorna cpf com a máscara
 */
function maskCPF(cpf){
  var cpfFormatado = "";

  for(i=0; i<cpf.length; i++){
		if( (i == 3)||(i == 6) )
			cpfFormatado += ".";
		else if( i == 9 )
			cpfFormatado += "-";
    cpfFormatado += cpf.charAt(i);
	}

	return cpfFormatado;
}

/*
 * Valida um cpf com a máscara e seta o campo com o valor do cpf sem a máscara
 * @author Luiz Henrique Grossl
 * @since 20-01-2003 
 * @param cpf: valor do cpf com máscara
 * @param nomeCampo: campo que receberá o valor do cpf sem a máscara se validado
 * @return true: cpf válido, false: cpf inválido
 */
function validaCPF(cpf,nomeCampo){
  var numCpf = "";
  for(i=0; i<cpf.length; i++){
    // retira os pontos e o traço
    if(i != 3 && i != 7 && i != 11)
      numCpf += cpf.charAt(i);
  } 
  if(verificaNumCPF(numCpf)){
   // pegaElemento(nomeCampo).value = numCpf;
    return true;
  }
  return false;
}

/*
 * Valida um cpf sem a máscara
 * @author Luiz Henrique Grossl
 * @since 20-01-2003 
 * @return true: cpf válido, false: cpf inválido
 */
function verificaNumCPF(cpf) {
  // Aqui começa a checagem do CPF (xxx.xxx.xxx-xx)
  var POSICAO, I, SOMA, DV, DV_INFORMADO;
  var DIGITO = new Array(10);

  // Retira os dois últimos dígitos do número informado
  DV_INFORMADO = cpf.substr(9, 2); 

  // Desemembra o número do CPF na array DIGITO
  for (I=0; I<=8; I++) {
    DIGITO[I] = cpf.substr( I, 1);
  }

  // Calcula o valor do 10º dígito da verificação
  POSICAO = 10;
  SOMA = 0;
  for (I=0; I<=8; I++) {
    SOMA = SOMA + DIGITO[I] * POSICAO;
    POSICAO = POSICAO - 1;
  }
   
  DIGITO[9] = SOMA % 11;
  if (DIGITO[9] < 2) {
    DIGITO[9] = 0;
  }else{
    DIGITO[9] = 11 - DIGITO[9];
  }

  // Calcula o valor do 11º dígito da verificação
  POSICAO = 11;
  SOMA = 0;
  for (I=0; I<=9; I++) {
    SOMA = SOMA + DIGITO[I] * POSICAO;
    POSICAO = POSICAO - 1;
  }

  DIGITO[10] = SOMA % 11;
  if (DIGITO[10] < 2) {
      DIGITO[10] = 0;
  } else {
      DIGITO[10] = 11 - DIGITO[10];
  }

  // Verifica se os valores dos dígitos verificadores conferem
  DV = DIGITO[9] * 10 + DIGITO[10];

  if (DV != DV_INFORMADO) 
    return false;
  else 
    return true;
}

function validaEmail( email ){
var 
	valores = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890-_.@";
	valor = false;
	pto = false;
	arroba = false;
	ptoPosArroba = false;
	posArroba = false;
	email = email.toUpperCase();
	
	for(i = 0; i < email.length; i++){
		if(email.charAt(email.length - 1)=="."){
			return false;
		}
		for(j = 0; j < valores.length; j++){
			if(email.charAt(i) == valores.charAt(j)){
				valor = true;
				j = valores.length;
			}else{
				valor = false;
			}
		}
		if(!valor){
			return false;
		}
		if(email.charAt(i) == "@"){
			if(i == 0){
				return false;
			}else if(email.charAt(i - 1) == "."){
				return false;
			}else if(!arroba){
				arroba = true;
			}else{
				return false;
			}
		}else if(email.charAt(i) == "."){
			if((!pto)&&(i != 0)){
				if((arroba)&&(email.charAt(i - 1) == "@")){
					return false;
				}else{
					pto = true;
				}
			}else{
				return false;
			}
		}else if(email.charAt(i) == " "){
			return false;
		}else if((arroba)&&(!posArroba)){
			posArroba = true;
			pto = false;
		}else if((posArroba)&&(pto)){
			ptoPosArroba = true;
			pto =  false;
		}else{
			pto = false;
		}
	}
	if((arroba)&&(posArroba)&&(ptoPosArroba)){
		return true;
	}
}


/*
 * verifica uma data final é maior que a data inicial
 */
function validaDatas(dtInicio_, dtFim_){
  dataInicio_ = dtInicio_.substring(6,10) + dtInicio_.substring(3,5) + dtInicio_.substring(0,2)
  + dtInicio_.substring(11,13) + dtInicio_.substring(14,16);
  dataFim_ = dtFim_.substring(6,10) + dtFim_.substring(3,5) + dtFim_.substring(0,2)
  + dtFim_.substring(11,13) + dtFim_.substring(14,16);
		
  if(dataInicio_ > dataFim_)	
    return false;
  else
    return true;
}

function setFocus(){ 
  var campos = document.forms[0].elements;
  
  for(i=0; i<campos.length; i++){
    if(campos[i].type!="hidden" && campos[i].type=="text"){
      if(!campos[i].disabled)
      {
        campos[i].focus();
        break;
      }
    }
  }
}



