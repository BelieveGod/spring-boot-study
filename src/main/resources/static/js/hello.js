function init(){
	console.log("init ....");
	let target=document.getElementById("btn");
	target.addEventListener("click",function(){
		let srciptElement=document.createElement("iframe");
		srciptElement.src="http://localhost:8080/jsonp?callback=callback";
		document.querySelector('head').appendChild(srciptElement);
	})
}

function callback(data){
	console.log(data);
}

init();