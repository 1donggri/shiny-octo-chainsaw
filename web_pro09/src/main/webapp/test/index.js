/**
 * 
 */

window.onload = function() {
	
	var id1 = document.getElementById("id1");
	var password1 = document.getElementById("password1");
	var password2 = document.getElementById("password2");
	var email1 = document.getElementById("email1");
	
	var div1 = document.getElementById("div1");
	var div2 = document.getElementById("div2");
	var div3 = document.getElementById("div3");
	
	// 패스워드 input 을 클릭한 경우
	password1.addEventListener("click", function(e) {
		div2.innerHTML = "영문자 대/소문자 특수문자, 숫자 포함 8 ~ 32자";
		div2.style.fontSize = "12px";
		div2.style.color = "gray";
		
		check(id1, div1);
	});
	
	// 패스워드 input 으로 넘어간 경우
	password1.addEventListener("focus", function(e) {
		check(id1, div1);
	});
	
	// 패스워드 확인 input 으로 넘어간 경우
	password2.addEventListener("focus", function(e) {
		check(id1, div1);
		check(password1, div2);
	});
	
	// 이메일 input 으로 넘어간 경우
	email1.addEventListener("focus", function(e) {
		check(id1, div1);
		check(password1, div2);
		check(password2, div3);
	});
	
	// input 이 공백일 경우 div 에 메시지를 생성하는 메서드 
	function check(input, div) {
		if(input.value == '') {
			div.innerHTML = "필수 입력 항목 입니다";
			div.style.fontSize = "12px";
			div.style.color = "red";
		} else {
			div.innerHTML = "";
		}
	};
}