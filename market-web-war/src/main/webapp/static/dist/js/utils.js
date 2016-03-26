define(function (require, exports, module) {
    var $ = require("$");
    var modalHtml = ''
        + '<div class="modal fade" id="infoModal" tabindex="-1" role="dialog" aria-labelledby="infoModalLabel">'
        + '<div class="modal-dialog" role="document">'
        + '<div class="modal-content">'
        + '<div class="modal-header">'
        + '<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>'
        + '<h4 class="modal-title" id="infoModalLabel"></h4>'
        + '</div>'
        + '<div class="modal-body">'
        + '<div id="modal-content"></div>'
        + '</div>'
        + '<div class="modal-footer" id="modal-footer">'
        + '</div>'
        + '</div>'
        + '</div>'
        + '</div>';

    exports.modalTips =function(title, content,footer) {
        $('body').append(modalHtml);
        $('#infoModal').modal('show');
        $('#infoModalLabel').html(title);
        $('#modal-content').html(content);
        if(footer){
            $('#modal-footer').html(footer);
        }else{
            $('#modal-footer').remove();
        }
    }
});

