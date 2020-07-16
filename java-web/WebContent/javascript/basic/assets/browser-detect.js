/**
 * Browser Detecting
 * 
 * 		navigator : 브라우저의 정보
 * 			-> 브라우저의 종류나 버전을 파악하는데 많이 활용
 * 			appName 	: 웹 브라우저의 종류
 * 			appCodeName : 웹 브라우저의 코드 이름
 *  		platform 	: 사용자의 시스템 환경 정보
 *  		userAgent 	: 웹 브라우저의 종류와 버전 정보
 *  		appVersion 	: 웹 브라우저의 버전
 *  브라우저별로 제공하는 기능이 달라서 브라우저 정보 체크 할 때 필요
 */

var BrowserDetect = { // JSON
	init : function() {
		this.browser = this.searchString(this.dataBrowser)
					|| 'an unknown browser';
		this.version = this.searchVersion(navigator.userAgent)
					|| 'an unknown version';
		this.Os		 = this.searchString(this.dataOS)					
					|| 'an unkown OS';
	},
	
	searchString : function(data) {
		for (var i = 0; i < data.length; i++) {
			var dataString = data[i].string; //문자열 값
			var dataProp = data[i].prop; // 프로퍼티 값 
			this.versionSearchString = data[i].versionSearch 
									|| data[i].identity;
			if(dataString){
				if(dataString.indexOf(data[i].subString) != -1)
					return data[i].identity;
			}else if(dataProp)
				return data[i].identitu;
		}
	}, 
	
	searchVersion : function(dataString){
		var index = dataString.indexOf(this.versionSearchString);
		if(index == -1) return;
		return parseFloat(dataString.substring(index
						+ this.versionSearchString.length + 1 ));
	},
	
	//[] 배열 안에 {} 오브젝트로
	dataBrowser : [{
		// navigator : 브라우저 정보 ( 공급자, 버전, ...)
		string : navigator.userAgent, 
		subString : "Chrome",
		identity : "Chrome"
	},{
		string : navigator.userAgent,
		subString : "Gecko",
		identity : "Mozilla",
		versionSearch : "rv"
	}],
	
	dataOS : [{
		string : navigator.platform,
		subString : "Win",
		identity : "Windows"
	},{
		string : navigator.platform,
		subString : "Max",
		identity : "Mac"
	},{
		string : navigator.platform,
		subString : "Linux",
		identity : "Linux"
	},{
		string : navigator.userAgent,
		subString : "iPhone",
		identity : "iPhone/iPod"
	}]
}
