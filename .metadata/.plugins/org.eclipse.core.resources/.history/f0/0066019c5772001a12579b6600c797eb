/**
 * Rectangle Object(Class) 정의
 *  : 외부 정적 파일에 JavaScript 소스를 만들어, 문서에 삽입!
 *  	-> exam17.html
 */

var Rectangle = function(x1, y1, x2, y2, backgroundColor){
	this.x1 = x1;
	this.y1 = y1;
	this.x2 = x2;
	this.y2 = y2;
	this.backgroundColor = backgroundColor;
}

Rectangle.prototype.borderColor = '#333';
Rectangle.prototype.show = function(){
	document.write(
				'<div style ="' +
				'position:absolute;'+
				'left : ' + this.x1 + 'px;' + 
				'top : ' + this.y1 + 'px;' +
				'width : ' + (this.x2 - this.x1) + 'px;'+
				'height : ' + (this.y2 - this.y1) + 'px;'+
				'background-color : ' + this.backgroundColor + ';' + 
				'border: 2px solid' + this.borderColor +
				'"></div>'
			
				);
}