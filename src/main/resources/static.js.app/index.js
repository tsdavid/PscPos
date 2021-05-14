var main = {

    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        })
    },
    
    save : function () {
        var data = {
            title : $('#title').val(),
            code : $('#code').val(),
            contributor : $('#contributor').val(),
            barcode : $('#barcode').val(),
            price : $('#price').val()

        };

        $.ajax({
            type : 'POST',
            url : '/api/v1/items',
            dataType : 'json',
            contentType : 'application/json; charset=utf-8',
            data : JSON.stringify(data)
        }).done(function () {
            alert("Complete Register Item.")
            window.location.href='/'
        }).fail(function (error) {
            alert(JSON.stringify(error));

        })
    }


}

main.init();