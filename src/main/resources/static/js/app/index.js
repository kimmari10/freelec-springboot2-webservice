$(".fileDrop").on("dragenter dragover",function(e){
    e.preventDefault();
});

$(".fileDrop").on("drop",function(e){
    e.preventDefault();

    var files=e.originalEvent.dataTransfer.files;
    var file=files[0];
    var formData = new FormData();
    formData.append("file",file);

    $.ajax({ //비동기 방식으로 호출
        url: "/upload/uploadAjax",
        data: formData,
        dataType: "text",
        processData: false,
        contentType: false,
        type: "post",
        success: function(data){
            //console.log(data);
            //data : 업로드한 파일 정보와 Http 상태 코드
            var fileInfo=getFileInfo(data);  //첨부파일의 정보
            //console.log(fileInfo);
            var html="<a href='"+fileInfo.getLink+"'>"+
                fileInfo.fileName+"</a><br>";
            html += "<input type='hidden' class='file' value='"
                +fileInfo.fullName+"'>"; //hidden 태그를 추가
            $("#uploadedList").append(html); //div에 추가
        }
    });
});



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
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
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