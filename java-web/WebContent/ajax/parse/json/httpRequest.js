///**
// * XMLHttpRequest Module 
// */

var httpRequest = null;

function getXMLHttpRequest() {
	if(window.XMLHttpRequest)
		return new XMLHttpRequest();
	else
		return null;
}

function sendRequest(url, params, callback, method) {
	httpRequest = getXMLHttpRequest();
	
	var httpMethod = method ? method : 'GET';
	
	if(httpMethod != 'GET' && httpMethod != 'POST')
		httpMethod = 'GET';
	
	var httpParams = '';
	if(params != null && params != '') {
		for(var key in params) {
			if(httpParams == '')
				httpParams = key + '=' + encodeURIComponent(params[key]);
			else
				httpParams += '&' + key + '=' + encodeURIComponent(params[key]);
		}
		/*
		 *  전달된 파라미터가 id는 abc, password는 1234일 경우
		 * 	실제 전달할 URL의 Parameter로 가공 하기 위함.
		 * 		-> id=abc&password=1234
		 */
	}
	
	var httpURL = url;
	if(httpMethod == 'GET' && params != '') {
		httpURL = httpURL + '?' + httpParams;
		/*
		 *  sample.jsp로 URL이 전달되었다면, 뒤에 파라미터를 붙이겠다.
		 *  sample.jsp + ? + id=abc&password=1234
		 *  	-> sample.jsp?id=abc&password=1234
		 */
	}
	
	httpRequest.onreadystatechange = callback;
	
	httpRequest.open(httpMethod, httpURL, true);
	
	if(httpMethod == 'POST') {
		httpRequest.setRequestHeader('Content-Type'
				, 'application/x-www-form-urlencoded; charset=utf-8');
	}
	/*
	 *  Content-Type
	 * 		: Request 데이터의 Type 정보를 표현
	 * 
	 *  Text
	 *   - text/html
	 *   - text/plain
	 *   - text/javascript
	 *   - text/css
	 *  
	 *  File
	 *   - multipart/form-data
	 *  
	 *  Application
	 *   - application/json
	 *   - application/x-www-form-urlencoded
	 *   	HTML 기본 형식
	 *   	대용량 데이터 전송(파일 첨부)에는 비효율적,
	 *   	multipart/form-data 를 활용!
	 */ 
	
	httpRequest.send(httpMethod == 'POST' ? httpParams : null);
}