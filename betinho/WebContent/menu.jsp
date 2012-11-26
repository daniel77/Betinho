

<!--

***** EXAMPLE 1: LIST MENU (v5+ browsers only) *****

You just need a series of <ul> lists, one nested inside another, with <a> tags in each item,
and <ul> tags after <a> tags to trigger another level of submenus.
The script will then automatically manage them as a multilevel popup menu.
Paste your data into here to get started, and be careful to close all your </li> tags!

-->
<table >
<tr>
<td>
<ul class="menulist" id="listMenuRoot">
 <li>
 	<a href="#">Cadastro</a>
  <ul>
   <li><a href="crianca.html">Criança</a></li>
   <li><a href="padrinho.html">Padrinho</a></li>
  </ul>
 
 </li>
 <li>
  <a href="#">Medicação</a>
  <ul>

   <li><a href="remedio.html">Remedio</a></li>
  </ul>
 </li>
 
 <!--  li>
  <a href="#">CID10</a>
  <ul>
      <li> <a href="cid10.html">Cid10</a></li>
      

  </ul>
 </li -->
 
  <li>
  <a href="#">Relatórios</a>
  <ul>
      <li> <a href="javascript:emitirRelatorio('relCriancas');">Crianças Cadastradas</a></li>
	  <li> <a href="javascript:emitirRelatorio('relContatos');">Contatos Cadastradas</a></li>
      <li> <a href="javascript:emitirRelatorio('cid10');">CID10 Cadastrados</a></li>

  </ul>
 </li>
 
 <li>
 	<a href="#">Ajuda</a>
  <ul>
   <li><a href="javascript:openHelp();">Tópicos de Ajuda</a></li>
  </ul>
 
 </li>
  <li>
 	<a href="login.html?perform=sair">Sair</a>
 
 </li> 
</ul>
</td>

</tr>
</table>
<script type="text/javascript">
//<!--
/*

FREESTYLE MENUS v1.0 RC (c) 2001-2006 Angus Turnbull, http://www.twinhelix.com
Altering this notice or redistributing this file is prohibited.

*/
//<![CDATA[


// Here's a menu object to control the above list of menu data:
var listMenu = new FSMenu('listMenu', true, 'display', 'block', 'none');

//listMenu.showDelay = 0;
//listMenu.switchDelay = 125;
//listMenu.hideDelay = 500;
//listMenu.cssLitClass = 'highlighted';
//listMenu.showOnClick = 0;
//listMenu.hideOnClick = true;
//listMenu.animInSpeed = 0.2;
//listMenu.animOutSpeed = 0.2;



// They are listed inside the "fsmenu.js" file for you to modify and extend :).

// I'm applying two at once to listMenu. Delete this to disable!
listMenu.animations[listMenu.animations.length] = FSMenu.animFade;
listMenu.animations[listMenu.animations.length] = FSMenu.animSwipeDown;
//listMenu.animations[listMenu.animations.length] = FSMenu.animClipDown;

var arrow = null;
if (document.createElement && document.documentElement)
{
 arrow = document.createElement('span');
 arrow.appendChild(document.createTextNode('>'));
 // Feel free to replace the above two lines with these for a small arrow image...
 //arrow = document.createElement('img');
 //arrow.src = 'arrow.gif';
 //arrow.style.borderWidth = '0';
 arrow.className = 'subind';
}
addEvent(window, 'load', new Function('listMenu.activateMenu("listMenuRoot", arrow)'));


function emitirRelatorio(rel){
	PopUpCenter("/betinho/relatorios.html?perform="+rel,800,600);
}

function openHelp(){
	PopUpCenter("/betinho/manual_do_sistema.pdf",800,600);
}
//-->
</script>