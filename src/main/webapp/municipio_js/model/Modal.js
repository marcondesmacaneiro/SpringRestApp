function Modal()
{
   this.getModal = function(id, titulo, funcao)
   {
      var html = '';
      
      html += '<div id="'+ id +'" class="modal">';
      html += '   <div class="modal-content">';
      html += '      <h4>'+ titulo +'</h4>';
      html += '      <div id="resultado"></div>';
      html += '   </div>';
      html += '   <div class="modal-footer">';
      html += '      <a onclick="'+ funcao +'" class="waves-effect waves-light btn">Confirmar</a>';
      html += '      <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat">Cancelar</a>';
      html += '   </div>';
      html += '</div>';
      
      return html;
   };
}