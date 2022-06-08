/* 
 *
 */
 
var arr1 = [1, 2, 3];
var res1 = document.getElementById("res1");
res1.innerHTML += arr1 + "<br>";
res1.innerHTML += "arr1[0] = " + arr1[0] + "<br>";
res1.innerHTML += "arr1[1] = " + arr1[1] + "<br>";
res1.innerHTML += "arr1[2] = " + arr1[2] + "<br>";

arr1[0] = 10;
arr1[1] = 20;
arr1[2] = 30;
res1.innerHTML += arr1 + "<br>";

res1.innerHTML += "arr1.indexof(10) = " + arr1.indexOf(10) + "<br>";
res1.innerHTML += "arr1.indexof(20) = " + arr1.indexOf(20) + "<br>";
res1.innerHTML += "arr1.indexof(30) = " + arr1.indexOf(30) + "<br>";

res1.innerHTML += "arr1.push(40)" + "<br>";
arr1.push(40);
res1.innerHTML += "arr1.push(40)" + "<br>";
arr1.push(50);
res1.innerHTML += "arr1.push(40)" + "<br>";
arr1.push(60);
res1.innerHTML += arr1 + "<br>";

// 맨앞 요소 추가
res1.innerHTML += "arr1.unshift(0)" + "<br>";
arr1.unshift(0);
res1.innerHTML += arr1 + "<br>"

// 맨뒤 요소 삭제 + 반환
res1.innerHTML += "arr1.pop(0)" + "<br>";
arr1.pop();
res1.innerHTML += arr1 + "<br>"

// 맨앞 요소 제거 + 반환
res1.innerHTML += "arr1.shift(0)" + "<br>";
arr1.shift();
res1.innerHTML += arr1 + "<br>"

// 순서를 반대로 뒤집기
// arr1.reverse();

// 요소 선택 잘라내기
// arr1.slice(0, 3);

// 배열 붙이기
// arr1.concat(['a', 'b', 'c']);


// 문제 1
var input1 = document.getElementById("id_input1");
var arr1 = input1.value.split(", ");
var exam1 = document.getElementById("exam1");
exam1.innerHTML += "[" + arr1 + "]";

// 문제 2
var input2 = document.getElementById("id_input2");
var arr2 = input2.value.split(", ");
v1 = 0;
for(i=0; i<arr2.length; i++) {
    v1 += parseInt(arr2[i]);
};
var arr3 = arr1.concat(arr2, v1);
var exam2 = document.getElementById("exam2");
exam2.innerHTML += "[" + arr3 + "]";


