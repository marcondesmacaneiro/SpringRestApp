function carregarMunicipio() {
   $.getJSON("municipio", function (result) {
      $("#main").html("");

      var html = '';
      html += '<table class="striped responsive-table">';
      html += '   <thead>';
      html += '      <tr>';
      html += '         <th class="padding-left-10">IBGE</th>';
      html += '         <th class="padding-left-10">Nome</th>';
      html += '         <th data-field="action" class="text-align-center"><a onclick="atribuirModal(\'cadastrar();\', \'Inclusão do município\'); cadastrarClick();" class="textoverde btn-floating btn-small waves-effect waves-light"><i class="material-icons">add</i></a></th>';
      html += '      </tr>';
      html += '   </thead>';

      html += '   <tbody>';
      $.each(result._embedded.municipio, function (i, field) {
         html += '   <tr>';
         html += '      <td class="padding-left-10 width-20">' + field.ibge + '</td>';
         html += '      <td class="padding-left-10 width-60">' + field.nome + '</td>';
         html += '      <td class="text-align-center width-20">';
         html += '         <a class="pointer textoverde" onclick="atribuirModal(\'alterar(' + field.ibge + ');\', \'Alteração do município ' + field.nome + '\'); alterarClick(); carregar(' + field.ibge + ');"><i class="material-icons">description</i></a>';
         html += '         <a class="pointer textoverde" onclick="atribuirModal(\'excluir(' + field.ibge + ');\', \'Exclusão do município ' + field.nome + '\');"><i class="material-icons">delete</i></a>';
         html += '      </td>';
         html += '   </tr>';
      });

      html += '   </tbody>';
      html += '</table>';

      html += '<div id="modal"></div>';

      $("#main").append(html);
   });
}

function atribuirModal(funcao, titulo) {
   $('#modal').html(modal.getModal('modalFuncao', titulo, funcao));

   $('#modalFuncao').openModal();
}

function cadastrarClick() {
   $.get("frmAlterarMunicipio.html", function (data, status) {
      $("div#resultado").html(data);
   });
}

function alterarClick() {
   $.get("frmAlterarMunicipio.html", function (data, status) {
      $("div#resultado").html(data);
   });
}

function cadastrar() {
   if (validarMunicipio()) {
      $.ajax({
         url: 'municipioController/',
         type: 'POST',
         contentType: "application/json",
         data: "{\"ibge\":\"" + $("#ibge").val() + "\", \"nome\":\"" + $("#nome").val() + "\"}",
         success: function (data) {
            fecharModal();
            carregarMunicipio();
         }
      });
   }
}

function alterar(ibge) {
   if (validarMunicipio()) {
      $.ajax({
         url: 'municipioController/' + ibge,
         type: 'PUT',
         contentType: "application/json",
         data: "{\"ibge\":\"" + $("#ibge").val() + "\", \"nome\":\"" + $("#nome").val() + "\"}",
         success: function (data) {
            fecharModal();
            carregarMunicipio();
         }
      });
   }
}

function excluir(ibge) {
   $.getJSON("municipio/search/findByIbge?ibge=" + ibge, function (result) {
      $.ajax({
         url: 'municipioController/' + ibge,
         type: 'DELETE',
         contentType: "application/json",
         data: "{\"ibge\":\"" + result._embedded.municipio[0].ibge + "\", \"nome\":\"" + result._embedded.municipio[0].nome + "\"}",
         success: function (data) {
            fecharModal();
            carregarMunicipio();
         }
      });
   });
}

function carregar(ibge) {
   $.getJSON("municipio/search/findByIbge?ibge=" + ibge, function (result) {
      $("#ibge").val(result._embedded.municipio[0].ibge);
      $("#nome").val(result._embedded.municipio[0].nome);
      
      $("#ibge").addClass("valid");
      $("label[for='ibge']").addClass("active");
      
      $("#nome").addClass("valid");
      $("label[for='nome']").addClass("active");
      
      $("#ibge").prop( "disabled", true );
   });
}

function fecharModal() {
   $('#modalFuncao').closeModal();
}

function validarMunicipio() {
   if ($('#ibge').val().length != 7) {
      Materialize.toast('Código IBGE inválido, deve ter 7 dígitos', 4000);
      return false;
   }
   
   if ($.trim($('#nome').val()) == '') {
      Materialize.toast('Nome é obrigatório', 4000);
      return false;
   }
   
   return true;
}