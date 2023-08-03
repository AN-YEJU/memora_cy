<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/upload" enctype="multipart/form-data">
	<input type="file" name="uploadfiles" multiple="multiple"/> 
<button class="uploadBtn">Upload</button>
</form>
<script
  src="https://code.jquery.com/jquery-3.5.1.min.js"
  integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
  crossorigin="anonymous">
</script>
<script>

    $('.uploadBtn').click(function( ) {

        var formData = new FormData();

        var inputFile = $("input[type='file']");

        var files = inputFile[0].files;

        for (var i = 0; i < files.length; i++) {
            console.log(files[i]);
            formData.append("uploadFiles", files[i]);
        }

        //실제 업로드 부분
        //upload ajax
        $.ajax({
            url: '/uploadAjax',
            processData: false,
            contentType: false,
            data: formData,
            type: 'POST',
            dataType:'json',
            success: function(result){
                console.log(result);
                //나중에 화면 처리
                // 추가
                showUploadedImages(result);
            },
            error: function(jqXHR, textStatus, errorThrown){
                console.log(textStatus);
            }

        }); //$.ajax
    }); //end click

     // 추가 
     // Ajax 업로드 이후 이미지들을 호출하는 함수 
   function showUploadedImages(arr){

	   console.log(arr);

       var divArea = $(".uploadResult");

       var str = "";

       for(var i = 0; i < arr.length; i++){
           str += "<div>";
           str += "<img src='/display?fileName="+arr[i].thumbnailURL+"'>";
           str += "<button class='removeBtn' data-name='"+arr[i].imageURL+"'>REMOVE</button>"
           str += "<div>"
       }
       divArea.append(str);

   }

   $(".uploadResult").on("click", ".removeBtn", function(e){

       var target = $(this);
       var fileName = target.data("name");
       var targetDiv = $(this).closest("div");

       console.log(fileName);

       $.post('/removeFile', {fileName: fileName}, function(result){
           console.log(result);
           if(result === true){
               targetDiv.remove();
           }
       } )

   });

</script>


</body>
</html>