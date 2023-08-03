
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
	 
	 .visit_cont {
	  border: 1px solid dimgrey;
	  resize: none;
	}
	.visit_cont:focus {
	  outline: none;
	}

    /*달력*/
.calendar{
    display: flex;

    position: inherit;
    top: 15px;
    bottom: 477px;
    left: 40px;
    right: 40px;

    border: 1px solid silver;
    border-radius: 5px;

    font-family: 'Nanum Gothic', sans-serif;
}
.today{
    flex: 0.25;

    text-align: center;
    line-height: 22px;
    font-size: 16px;
    
    color: steelblue;
}
.day_list{
    flex: 1;

    margin-left: 10px;
    margin-top: 2px;
    line-height: 20px;
    font-size: 13px;

    color: black;
}
/*다이어리*/
.diary{
    position: absolute;
    top: 80px;
    bottom: 15px;
    left: 5px;
    right: 5px;

    overflow: auto;
}
.diary_contents{
    margin: 10px;
    border: 1px solid silver;
}
.diary_date{
    color: steelblue;

    margin-left: 20px;
    margin-top: 10px;

    font-size: 13px;
    font-family: 'Nanum Gothic', sans-serif;
}
.diary_text{
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

  .diary_write_form {
    display: flex;
    flex-direction: column;
    margin-bottom: 20px;
    
    color: dimgray;
    margin-top: 20px;
    margin-left: 10px;
    font-size: 20px;
  }

  .diary_write_form label {
    font-size: 14px;
    font-weight: bold;
    margin-bottom: 5px;
  }

  .diary_write_form input[type="text"],
  .diary_write_form textarea {
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
							<span class="content" id="contentText">자기소개가 없습니다</span>
              			</c:when>
              			<c:otherwise>
<!--               			내용을 설정했을때 -->
                			<p class="content" id="contentText">${mainDto.content}</p> 
              			</c:otherwise>
              		</c:choose>
                </div>
<!--               	본인 페이지에만 수정버튼 -->
                <c:if test="${memDto.id == mainDto.id}">
              		 <div align="right"><button onclick="enableContentEdit()" style="margin-right: 20px;">수정</button></div>
           		 </c:if>
           		 
                <div class="profile_3">
                  <div class="profile-dropdown">
                    <div class="dropdown-btn">
                      <div class="dropdown-title">Related Link</div>
                      <div class="triangle-down"></div>
                    </div>
                    <div class="dropdown-content">
                      <a href="https://handsomely-click-eea.notion.site/50f33e8928d248aa903feb976d78ed35?v=29af3dde066f4186a5e18814d773b1b4&pvs=4" target="_blank">Notion</a>
                      <a href="https://github.com/AN-YEJU/yechu.git" target="_blank">Github</a>
                      <!-- <a href="" target="_blank">Instagram</a> -->
                    </div>
                  </div>
                </div>
              </div>
               <div class="home_contents">
                <form action="diaryModify" method="post" id="frm">
                <input type="hidden" name=diaryId value="${diary_view.diaryId}">
                  <div class="diary_write_form">
                    <label for="diaryTitle">제목</label>
                    <input type="text" id="diaryTitle" name="diaryTitle" value="${diary_view.diaryTitle}">
                  </div>
                  <div class="diary_write_form">
                    <label for="diaryCont">내용</label>
                    <textarea id="diaryCont" name="diaryCont" rows="10" style="width: 519px; height: 322px; resize: none; font-family: 'Nanum Gothic', sans-serif;">${diary_view.diaryCont}</textarea>
                  </div>
				<div align="center">
                  <input type="button" value="수정" id="button" onclick="fn_submit()">
                  <a href="diary"><input type="button" value="목록가기" id="button"></a>
                </div>
                </form>
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
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript">
	function fn_submit() {
	// 		form 요소 자체
	var formData = $("#frm").serialize();
	
	$.ajax({
	  type:"post"
	  ,data:formData
	  ,url:"diaryModify"
	  ,success: function(data) {
	    alert("수정완료");
	    location.href="diary";
	  }
	  ,error: function() {
	    alert("오류발생")
	  }
	});
	}
	
	
	function enableTitleEdit() {
		  // 현재 제목 텍스트 요소를 가져옵니다.
		  const titleText = document.getElementById('titleText');

		  // 텍스트 입력창(input) 요소를 생성합니다.
		  const inputElement = document.createElement('input');
		  inputElement.type = 'text';
		  inputElement.value = titleText.innerText;

		  // 제목 텍스트 요소를 숨깁니다.
		  titleText.style.display = 'none';

		  // 텍스트 입력창을 미니홈피 제목 영역에 추가합니다.
		  titleText.parentNode.insertBefore(inputElement, titleText);

		  // 텍스트 입력창에 포커스를 줍니다.
		  inputElement.focus();

		  // 수정이 완료되면 엔터키 또는 포커스가 사라질 때 값을 저장하고 업데이트하는 이벤트를 추가합니다.
		  inputElement.addEventListener('keyup', function (event) {
		    if (event.key === 'Enter') {
		      updateTitle(inputElement.value);
		    }
		  });
		  inputElement.addEventListener('blur', function () {
		    updateTitle(inputElement.value);
		  });
		}

		function updateTitle(newTitle) {
		  // 서버로 제목을 업데이트하는 AJAX 요청을 보냅니다.
		  const xhr = new XMLHttpRequest();
		  xhr.open('POST', '/modifyTitle', true); // 서버의 컨트롤러 URL에 맞게 경로 수정
		  xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		  xhr.onreadystatechange = function () {
		    if (xhr.readyState === XMLHttpRequest.DONE) {
		      if (xhr.status === 200) {
		        // 서버에서 응답이 정상적으로 왔을 경우
		        const titleText = document.getElementById('titleText');
		        titleText.style.display = 'inline';
		        titleText.innerText = newTitle;
		        const inputElement = titleText.previousSibling;
		        inputElement.remove();
		      } else {
		        // 서버에서 응답이 오류로 왔을 경우
		        console.error('서버 오류 발생');
		      }
		    }
		  };

		  // 서버로 보낼 데이터 준비 (제목 수정에 필요한 파라미터 전달)
		  const params = 'mainTitle=' + encodeURIComponent(newTitle);

		  // 파라미터를 URL 인코딩하여 서버로 전송
		  xhr.send(params);
		}
		
//	 	프로필 소개-------------------------------------------------
	function enableContentEdit() {
	  // 현재 내용 텍스트 요소를 가져옵니다.
	  const contentText = document.getElementById('contentText');

	  // 텍스트 입력창(input) 요소를 생성합니다.
	  const inputElement = document.createElement('input');
	  inputElement.type = 'text';
	  inputElement.value = contentText.innerText;

	  // 내용 텍스트 요소를 숨깁니다.
	  contentText.style.display = 'none';

	  // 텍스트 입력창을 미니홈피 내용 영역에 추가합니다.
	  contentText.parentNode.insertBefore(inputElement, contentText);

	  // 텍스트 입력창에 포커스를 줍니다.
	  inputElement.focus();

	  // 수정이 완료되면 엔터키 또는 포커스가 사라질 때 값을 저장하고 업데이트하는 이벤트를 추가합니다.
	  inputElement.addEventListener('keyup', function (event) {
	    if (event.key === 'Enter') {
	      updateContent(inputElement.value);
	    }
	  });
	  inputElement.addEventListener('blur', function () {
	    updateContent(inputElement.value);
	  });
	}

	function updateContent(newContent) {
	  // 서버로 내용을 업데이트하는 AJAX 요청을 보냅니다.
	  const xhr = new XMLHttpRequest();
	  xhr.open('POST', '/modifyContent', true); // 서버의 컨트롤러 URL에 맞게 경로 수정
	  xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	  xhr.onreadystatechange = function () {
	    if (xhr.readyState === XMLHttpRequest.DONE) {
	      if (xhr.status === 200) {
	        // 서버에서 응답이 정상적으로 왔을 경우
	        const contentText = document.getElementById('contentText');
	        contentText.style.display = 'inline';
	        contentText.innerText = newContent;
	        const inputElement = contentText.previousSibling;
	        inputElement.remove();
	      } else {
	        // 서버에서 응답이 오류로 왔을 경우
	        console.error('서버 오류 발생');
	      }
	    }
	  };

	  // 서버로 보낼 데이터 준비 (내용 수정에 필요한 파라미터 전달)
	  const params = 'content=' + encodeURIComponent(newContent);

	  // 파라미터를 URL 인코딩하여 서버로 전송
	  xhr.send(params);
	}
</script>