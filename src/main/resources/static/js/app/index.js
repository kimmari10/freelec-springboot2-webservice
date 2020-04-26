var main = {
    init: function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });

        $('#btn-update').on('click', function () {
            _this.update();
        });

        $('#btn-delete').on('click', function () {
            _this.delete();
        });

        $('#btn-join').on('click', function () {
            _this.join();
        });

    },
    save: function () {
        var formData = new FormData();

        formData.append("file", $("#uploadFile")[0].files[0]);
        formData.append("title", $('#title').val());
        formData.append("author", $('#author').val());
        formData.append("content", $('#content').val());

        $.ajax({
            url: "/api/v1/posts",
            data: formData,
            processData: false,
            contentType: false,
            type: "POST"
        }).done(function () {
            alert('글이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });

    },

    update: function () {
        var data = {
            title : $('#title').val(),
            content : $('#content').val()
        };

        var id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('글이 수정되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

    delete: function () {
        var id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8'
        }).done(function () {
            alert('글이 삭제되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

    join: function () {
        $.ajax({
            type: 'POST',
            url: '/user/join',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8'
        }).done(function () {
            alert('회원가입 되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }

};

main.init();