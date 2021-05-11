<!-- aa는 성수test페이지 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    


    
<head>
<jsp:include page="Header.jsp" />
</head>

<body>
	 <div class="container">
	<div class="row">
	<div class="col-sm-12 text-center" >
	<div class="col-sm-3"></div>
	
	<div class="col-sm-50">
	<form action="proc.do" method="post">
		<table class="table table-boardered">
			<tr>
				<th>닉네임</th>
				<td><input type="text" class="form-control" name="nickName" id="nickName" placeholder="닉네임을 넣으세요"><span id="result3"></td>		
			</tr>
		
			<tr>
				<th>아이디</th>
				<td><input type="text" class="form-control" name="userid" id="userid" placeholder="아이디 입력"><span id="result"></span></td>		
			</tr>
			<tr>
				<th>패스워드</th>
				<td><input type="password" class="form-control"name="passwd" id="passwd" placeholder="비밀번호 입력"></td>		
			</tr>
			
			<tr>
				<th>패스워드확인</th>
				<td><input type="password" class="form-control" name="passwd2" id="passwd2"><span id="result2"></span></td>		
			</tr>
			
			<tr>
				<th>이름</th>
				<td><input type="text" class="form-control" name="username" placeholder="id를 넣으세요"></td>		
			</tr>
	
			<tr>
				<th>전화번호</th>
				<td><input type="tel" class="form-control" name="phone" id ="phone" ></td>		
			</tr>
			
			<tr>
				<th>주소</th>
				<td><input type="email" class="form-control"name="addr" id="sample4_roadAddress" placeholder="주소입력"></td>		
			</tr>
			
			<tr>
				<th>이메일</th>
				<td><input type="email" class="form-control" name="email1"></td>
				<td>@</td>
				<td><input type="email" class="form-control" name="email2"></td><br>
				<td><button type="button" id="mailAuth">메일 인증</button><span id="result4" text=""></span></td>		
			</tr>
			
			<tr>
				<td colspan="2">
				<input type="submit" class="btn btn-primary" value="회원가입">
				<input type="reset" class="btn btn-danger" value="취소">
				</td>
			</tr>
			
			
		</table>
	</form>
	</div>
	</div>
	</div>
</div>
</body>
