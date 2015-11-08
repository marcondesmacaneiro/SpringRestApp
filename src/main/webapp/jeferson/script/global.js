/* 
 Created on : 18/10/2015, 16:25:39
 Author     : Jeferson Duwe <duwejeferson@gmail.com>
 */

// Funções Globais

function buscarLista(field, entidade, descriptor, fuckingPluralName) {
    fuckingPluralName = (fuckingPluralName) ? fuckingPluralName : entidade;
    $.getJSON('../' + entidade, function (res) {
        $.each(res._embedded[fuckingPluralName], function (i, obj) {
            field.append('<option value="' + obj._links.self.href + '">' + obj[descriptor] + '</option>');
        });
    });
}

// Ready

$(document).ready(function () {
    $(window).on('beforeunload', function () {
        return 'Deseja mesmo sair?';
    });

    $('#menu-album').on('click', function () {
        $.get('forms/frmAlbum.html', function (res) {
            $('#container').html('');
            $('#container').html(res);
        });
    });
    $('#menu-artista').on('click', function () {
        $.get('forms/frmArtista.html', function (res) {
            $('#container').html('');
            $('#container').html(res);
        });
    });
    $('#menu-genero').on('click', function () {
        $.get('forms/frmGenero.html', function (res) {
            $('#container').html('');
            $('#container').html(res);
        });
    });
    $('#menu-musica').on('click', function () {
        $.get('forms/frmMusica.html', function (res) {
            $('#container').html('');
            $('#container').html(res);
        });
    });
});