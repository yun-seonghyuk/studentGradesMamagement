/**
 * 
 */


// 로그인에서 아이디 비밀번호 입력 여부 체크
function loginCheck(){
	if(document.frm.memberId.value.length == 0){
		alert('아이디를 입력해 주세요.');
		document.frm.memberId.focus();
		return false;
	}
	
	if(document.frm.memberPwd.value == ''){
		alert('비밀번호를 입력해 주세요.');
		document.frm.memberPwd.focus();
		return false;
	}
	return true;
}

function joinCheck(){
	// 입력 여부 체크 - 이름
	if(document.frm.memberName.value.length == 0){
		alert('이름을 입력해 주세요.');
		document.frm.memberName.focus();
		return false;
	}
	
	
	// 입력 여부 체크 - 아이디
	
	if(document.frm.memberId.value == 0){
		alert('비밀번호를 입력해 주세요.');
		document.frm.memberId.focus();
		return false;
	}
	
	
	// 입력 여부 체크 - 비밀번호
	if(document.frm.memberPwd.value == ''){
		alert('비밀번호를 입력해 주세요.');
		document.frm.memberPwd.focus();
		return false;
	}
	
	// 비밀번호 일치여부
		
	if(document.frm.memberPwd.value != document.frm.pwd_check.value){
		alert('비밀번호가 일치하지 않습니다.');
		
		document.frm.memberPwd.value = '';
		document.frm.pwd_check.value ='';
		
		document.frm.memberPwd.focus();
		return false;
	}
	// 아이디 중복 체크 여부 확인
	if(document.frm.reid.value == 0){
		alert('중복 체크를 하지 않았습니다.');
		document.frm.memberId.focus();
		return false;
	}
	
	 return true;
	
}

function idCheck(){
	if(document.frm.memberId.value == 0){
		alert('비밀번호를 입력해 주세요.');
		document.frm.memberId.focus();
		return false;
	}
	let url = "idCheck?memberId="+ document.frm.memberId.value;
	//		idCheck?memberId=green;
	
	window.open(url,'_blank_1','toolbar=no, menubar=no, scrollbars=yes, resizeable=no width = 450, height = 200');
}

function idOk(){
	let memberId = document.frm.memberId.value;
	
	opener.frm.memberId.value = memberId;
	opener.frm.reid.value = memberId;
	
	self.close();	//새로열린 창 닫기
}

function scoreInputCheck(){
    if(document.frm.kor.value == 0){
      alert('국어점수를 입력해 주세요.');
      document.frm.kor.focus();
      return false;
    }
    if(document.frm.eng.value == 0){
      alert('영어점수를 입력해 주세요.');
      document.frm.eng.focus();
      return false;
    }
    if(document.frm.math.value == 0){
      alert('수학점수를 입력해 주세요.');
      document.frm.math.focus();
      return false;
    }
    if(document.frm.science.value == 0){
      alert('과학점수를 입력해 주세요.');
      document.frm.science.focus();
      return false;
    }
    if(document.frm.social.value == 0){
      alert('사회점수를 입력해 주세요.');
      document.frm.social.focus();
      return false;
    }
	 return true;	  
}


