
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />

<style>
     .updated_news_title{
    flex: 0.1;
  
    color:steelblue;
    font-family: 'PT Sans', sans-serif;
  
    border-bottom: 2px solid silver;
    margin-right: 20px;
    margin-left: 20px;
  }
  .updated_news_contents{
    display: flex;
    flex: 0.3;
  
    margin-right: 20px;
    margin-left:  20px;
    margin-top: 5px;
    margin-bottom: 20px;
  
    font-family: 'Nanum Gothic', sans-serif;
  }
  .updated_news_left{
    display: flex;
    flex-direction: column;
    flex: 1;
  }
  .updated_news_left1, .updated_news_left2, .updated_news_left3, .updated_news_left4{
    flex: 1;
    font-size: 13px;
    color: black;
  }
  .updated_news_red{
    color: whitesmoke;
    background-color:coral;
  
    font-size: 14px;
    border-radius: 3px;
  }
  .updated_news_blue{
    color: whitesmoke;
    background-color:#4F92CD;
  
    font-size: 14px;
    border-radius: 3px;
  }
  .updated_news_right{
    display: flex;
    flex-direction: column;
    flex: 1;
  }
  .updated_news_right1, .updated_news_right2{
    flex: 0.3;
    
    color: black;
    font-size: 12px;
    line-height: 20px;
  
    border-bottom: 1px solid silver;
    border-bottom-style: dashed;
  }
  .updated_news_right3{
    flex: 1;
  }
  .updated_news_right_number{
    color:navy;
    font-size: 10px;
  }
  .miniroom_title{
    flex: 0.1;
  
    color: steelblue;
    font-family: 'PT Sans', sans-serif;
  
    border-bottom: 2px solid silver;
    margin-right: 20px;
    margin-left: 20px;
  }
  .miniroom_contents{
    flex: 1;
  }
  .miniroom_gif{
    width: 500px;
    height: 200px;

    margin-top: 15px;
    margin-left: 25px;

    border-radius: 5px;
  }
  body {
    background-color: #a3a3a3;
    background-image: url("../static/images/pattern.png");
    background-size: 100px;
  
    position: fixed;
    left: 0;
    top: 0;
    right: 0;
    bottom: 0;
  }
  
  .bookcover {
    background-color:gray;
    border-radius: 9px;
    border: 1px solid #738186;
  
    width: 960px;
    height: 660px;
  
    margin: 100px auto;
  
    position: relative;
  }
  
  .bookdot{
      position: absolute;
      top: 10px;
      bottom: 10px;
      left: 10px;
      right: 10px;
  
      border-style: dashed;
      color:whitesmoke;
  }
  
  .page{
      display: flex;
  
      position: absolute;
      top: 10px;
      bottom: 10px;
      left: 10px;
      right: 10px;
  
      background-color:whitesmoke;
      border-radius: 9px;
  }
  
  .home{
    display: flex;
    flex-direction: column;
    flex: 1;
  }
  
  .upside{
    flex:0.1;
    color: black;
  
    font-size: 13px;
  }
  
  .title{
    font-family: 'Stylish', sans-serif;
    font-size: 25px;
  }

  .home_main{
    display: flex;
    flex:1;
  }

  .home_contents{
    position: relative;
    display: flex;
    flex-direction: column;
    flex: 1;
  
    margin-left: 30px;
    margin-bottom: 15px;
  
    border: 1px solid silver;
    border-radius: 9px;
  
    background-color: white;
  }
  
  
  .profile{
    display: flex;
    flex-direction: column;
    flex: 0.4;
  
    margin-left: 15px;
    margin-bottom: 15px;
  
    border: 1px solid silver;
    border-radius: 9px;
  
    background-color: white;
  
    font-family: 'Nanum Gothic', sans-serif;
  }
  
  .profile_1{
    flex: 0.6;
  }
  .profile_image{
    width: 180px;
    height: 180px;
  
    margin: 20px;
    border-radius: 5px;
  }
  .profile_2{
    flex: 1;
  
    color: black;
    font-size: 13px;
  
    margin-right: 20px;
    margin-left: 20px;
  }
  .profile_3{
    flex:0.1;
  
    color: black;
    font-size: 12px;
  
    margin: 20px;
    margin-bottom: 30px;
  }
    /*프로필 드랍다운*/
    .profile-dropdown {
      flex: 0;
      border: 1px solid #c9d4da;
      padding: 5px;
      margin-top: 10px;
      font-size: 0.8rem;
      position: relative;
    }
    
    .triangle-down {
      width: 0;
      height: 0;
      border-left: 4.5px solid transparent;
      border-right: 4.5px solid transparent;
      border-top: 5px solid #838383;
    }
    
    .dropdown-btn {
      display: flex;
      justify-content: space-between;
      align-items: center;
    }
    
    .dropdown-content {
      display: none;
      position: absolute;
      top: 0;
      left: 0;
      width: 100%;
    }
    
    .profile-dropdown:hover > .dropdown-content {
      display: block;
    }
    
    .dropdown-content > a {
      display: block;
      background-color: #f9f9f9;
      box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
      width: 100%;
      padding: 6px;
      color: black;
      text-decoration: none;
    }
    
    .dropdown-content > a:hover {
      background-color: #f1f1f1;
    }
  /*오른쪽 메뉴버튼*/
  .menu_bar{
    display: flex;
    flex-direction: column;
    flex: 0.09;
  
    margin-top: 70px;
    margin-bottom: 360px;
    margin-right: 15px;

    font-family: 'Nanum Gothic', sans-serif;
  }

  .menu_bar > a{
    flex: 1;

    background-color: #a3a3a3ee;
    color: whitesmoke;
    text-align: left;
    line-height: 30px;

    margin-top: 6px;
    margin-bottom: 6px;

    border-top: 1px solid silver;
    border-bottom: 1px solid silver;
    border-right: 1px solid silver;
    border-top-right-radius: 5px;
    border-bottom-right-radius: 5px;

    text-decoration: none;
    font-size: 13px;
  }
  .menu_bar > a:hover{
    background-color:#4F92CD;
  }
	
	.div_page ul {
	display: flex;
	justify-content: center;
	list-style: none;
	}
	
	a {
	text-decoration: none;
	color: black;
	}
	
	 .paginate_button:hover {
	   text-decoration: underline;
	   color: #508FED;
	 }
	 
	 .paginate_button{
	 	width:15px; 
	 	height:30px;
	 }
	 
	 .photo_cont {
	  border: 1px solid dimgrey;
	  resize: none;
	}
	.photo_cont:focus {
	  outline: none;
	}

.photo{
    position: absolute;
    top: 80px;
    bottom: 15px;
    left: 5px;
    right: 5px;

    overflow: auto;
}
.photo_contents{
    margin: 10px;
    border: 1px solid silver;
    overflow: auto;
}
.photo_date{
    color: steelblue;

    margin-left: 20px;
    margin-top: 10px;

    font-size: 13px;
    font-family: 'Nanum Gothic', sans-serif;
}
.photo_text{
    color: black;

    text-align: center;
    line-height: 25px;
    font-size: 18px;
/*     font-family: 'Gamja Flower', cursive; */

    margin-top: 20px;
    margin-bottom: 20px;
}
#button{
    margin-top: 5px;
    margin-bottom: 10px;

    border: 0;

    font-size: 19px;
    color: black;
    background-color: white;
}
#button:hover{
    color:black;
    background-color: whitesmoke;

    border: 1px solid silver;
    border-radius: 3px;
}
#hidden{
    display: none;
}

 body {
    background-color: #a3a3a3;
    background-image: url("../static/images/pattern.png");
    background-size: 100px;
  }

  .bookcover {
    background-color: gray;
    border-radius: 9px;
    border: 1px solid #738186;
    width: 960px;
    height: 660px;
    margin: 100px auto;
    position: relative;
  }

  .bookdot {
    position: absolute;
    top: 10px;
    bottom: 10px;
    left: 10px;
    right: 10px;
    border-style: dashed;
    color: whitesmoke;
  }

  .page {
    display: flex;
    position: absolute;
    top: 10px;
    bottom: 10px;
    left: 10px;
    right: 10px;
    background-color: whitesmoke;
    border-radius: 9px;
  }

  .photo_write_form {
    display: flex;
    flex-direction: column;
    margin-bottom: 20px;
    
    color: dimgray;
    margin-top: 20px;
    margin-left: 10px;
    font-size: 20px;
    
    overflow: auto;
  }

  .photo_write_form label {
    font-size: 14px;
    font-weight: bold;
    margin-bottom: 5px;
  }

  .photo_write_form input[type="text"],
  .photo_write_form textarea {
    border: 1px solid #ccc;
    border-radius: 5px;
    padding: 8px;
    font-size: 14px;
  }

  #button {
    margin-top: 10px;
    padding: 8px 20px;
    border: 0;
    font-size: 16px;
    color: white;
    background-color: dimgray;
    cursor: pointer;
    border-radius: 3px;
  }

  #button:hover {
    background-color: #508FED;
  }
  
</style>
</head>
<body>
<div class="bookcover">
      <div class="bookdot">
        <div class="page">
          <div class="home">
            <div class="upside">
              <br>
             <div style="display: inline-flex; min-width: 260px; max-width: 260px;"><strong>&emsp;&emsp;&emsp;TODAY <span style="color:coral;">${today}</span> | TOTAL
                                    ${total}</strong> &emsp;&emsp;&emsp; &emsp;</div>
<!-- 		              	제목 수정 -->
              	<span class="title" id="titleText">${mainDto.mainTitle}</span> 
<!--               	본인 페이지에만 수정버튼 -->
		         <c:if test="${memDto.id == mainDto.id}">
              		 <button onclick="enableTitleEdit()">수정</button>
           		 </c:if>
            </div>
            <div class="home_main">
              <div class="profile">
                <div class="profile_1">
                  <c:choose>
						<c:when test="${mainDto.id == 'yeju'}">
                  			<img class="profile_image" src="https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjAyMDNfMTk5%2FMDAxNjQzODYxMjcwNDE5.BV_QgQeNkK-qJDVnJJ0LlgfDUd7g3Mh0JHiLZWPDq4kg.ZTAAVOl2nGWeVgM4_5rQVZVugg2rCQ14ngTI_kIBZwYg.JPEG.lhn7069%2FIMG_5843.JPG&type=sc960_832"/>
              			</c:when>
              			<c:otherwise>
			                  <img class="profile_image" src="https://item.kakaocdn.net/do/c5c470298d527ef65eb52883f0f186c4a88f7b2cbb72be0bdfff91ad65b168ab"/>
              			</c:otherwise>
              		</c:choose>
                  
                </div>
<!--                 글이 길면 자동으로 다음줄로 -->
                <div class="profile_2" style="word-wrap: break-word; word-break: break-all;">
                	<c:choose>
              			<c:when test="${mainDto.content == null}">
<!--               			내용을 설정안했을때 -->
							자기소개가 없습니다
              			</c:when>
              			<c:otherwise>
<!--               			내용을 설정했을때 -->
							${mainDto.content}
              			</c:otherwise>
              		</c:choose>
                </div>
                <div class="profile_3">
                  <div class="profile-dropdown">
                    <div class="dropdown-btn">
                      <div class="dropdown-title">Related Link</div>
                      <div class="triangle-down"></div>
                    </div>
                    <div class="dropdown-content">
                      <a href="https://handsomely-click-eea.notion.site/50f33e8928d248aa903feb976d78ed35?v=29af3dde066f4186a5e18814d773b1b4&pvs=4" target="_blank">Notion</a>
                      <a href="https://github.com/AN-YEJU/yechu.git" target="_blank">Github</a>
                    </div>
                  </div>
                </div>
              </div>
			<div class="home_contents">
			    <div class="photo_contents" style="height: 520px; width: 538px;">
		            <form method="post" id="frm" action="photoWrite" enctype="multipart/form-data" style="color: black;">
			        <div style="margin-left: 10px; margin-top: 10px;">
			                <!-- 파일 선택(input type="file") 요소 -->
			                <input type="file" id="photoPath" name="uploadfiles" multiple="multiple"/> 
<%-- 			                <input type="hidden" value="<%=request.getRealPath("/") %>" name="photoPath"> --%>
			            <span>
			                <select name="cateId" style="float: right; margin-right: 10px; width: 80px;">
			                    <c:forEach items="${cateList}" var="dto" varStatus="status">
			                        <c:choose>
			                            <c:when test="${status.first == true}">
			                                <option value='${dto.cateId}' selected>${dto.cateName}</option>
			                            </c:when>
			                            <c:otherwise>
			                                <option value='${dto.cateId}'>${dto.cateName}</option>
			                            </c:otherwise>
			                        </c:choose>
			                    </c:forEach>
			                </select>
			            </span>
			            <div class="select_img"><img id="previewImage" src="" /></div>
			        </div>
			            <div class="photo_write_form">
			                <label for="photoTitle">제목</label>
			                <input type="text" id="photoTitle" name="photoTitle" style="width: 486px;">
			            </div>
			            <div class="photo_write_form">
			                <label for="photoCont">내용</label>
			                <textarea id="photoCont" name="photoCont" rows="10" style="width: 486px; height: 322px; resize: none; font-family: 'Nanum Gothic', sans-serif;" ></textarea>
			            </div>
			            <div align="center">
			                <input type="button" value="등록" id="button" onclick="fn_submit()">
			                <a href="photo"><input type="button" value="목록가기" id="button"></a>
			            </div>
			        </form>
			    </div>
			</div>

            </div>
          </div>
          <div class="menu_bar">
           <a href="home2?guestId=${mainDto.id}" class="menu_button1">&nbsp;&nbsp;홈</a>
            <a href="diary" class="menu_button2">&nbsp;&nbsp;다이어리</a>
            <a href="photo" class="menu_button3">&nbsp;&nbsp;사진첩</a>
            <a href="visit" class="menu_button4">&nbsp;&nbsp;방명록</a>
          </div>
        </div>
      </div>
    </div>
</body>
</html>
<script
  src="https://code.jquery.com/jquery-3.5.1.min.js"
  integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
  crossorigin="anonymous">
</script>
<script type="text/javascript">
	function fn_submit() {
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
            success: function(data){
             
             
             var formData2 = $("#frm").serialize();
	             formData2+= '&photoPath=' + data.filePath;
	
	             $.ajax({
	               type:"post"
	               ,data:formData2
	               ,url:"photoWrite"
	               ,success: function(data) {
	                 alert("작성완료");
	                 location.href="photo";
	               }
	               ,error: function() {
	                 alert("오류발생")
	               }
	             });
	            	 
                //나중에 화면 처리
//                 showUploadedImages(result);
            },
            error: function(data){
            	 alert("이미지만 올려주세요.")
            }

        }); //$.ajax	
	}

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
   //쿠즈로
$(document).ready(function() {
    // 파일 선택(input type="file") 이벤트 핸들러 연결
    $("input[name='uploadfiles']").change(function() {
        if (this.files && this.files[0]) {
            var reader = new FileReader();
            reader.onload = function(data) {
                // 미리 보기할 이미지를 선택하고 크기 설정
                $("#previewImage").attr("src", data.target.result).css("width", "500px");
            };
            reader.readAsDataURL(this.files[0]);
        }
    });

    // 등록 버튼 클릭 시 form 제출
//     $("#button").click(function() {
//         $("#frm").submit();
//     });
});

   
   
// var formData = $("#frm").serialize();

// $.ajax({
//   type:"post"
//   ,data:formData
//   ,url:"photoWrite"
//   ,success: function(data) {
//     alert("작성완료");
//     location.href="photo";
//   }
//   ,error: function() {
//     alert("오류발생")
//   }
// });

</script>