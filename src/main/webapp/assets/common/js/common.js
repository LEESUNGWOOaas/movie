function fnBack() {
	history.back();
}

// 새로고침
function fnReload() {
	location.reload();
}

// 리다이렉트
function fnRedirect(str) {
	location.href = str;
}

//페이지 이동
function fnGoPage(page) {

	var uri = window.location.pathname;
	var nParams = "";
	var params = window.location.search.substring(1);
	var paramArray = params.split("&");
	for (var i = 0; i < paramArray.length; i++) {
		if (paramArray[i].split("=")[0] != "page") {
			if (i != 0) {
				nParams += "&";
			}
			nParams += paramArray[i];
		}
	}

	if (nParams != "")
		nParams += "&";
	nParams += "page=" + page;
	uri = uri + "?" + nParams;
	location.href = uri;
}

// 이전페이지 파라미터
function fnGetPrevParmas(ex) {
	var nParams = "";
	var params = window.location.search.substring(1);
	var paramArray = params.split("&");
	for (var i = 0; i < paramArray.length; i++) {
		if (paramArray[i].split("=")[0] != ex) {
			if (i != 0 && nParams != "") {
				nParams += "&";
			}
			nParams += paramArray[i];
		}
	}
	return nParams;
}

$.fn.serializeObject = function() {
	"use strict"
	var result = {}
	var extend = function(i, element) {
		var node = result[element.name]
		if ("undefined" !== typeof node && node !== null) {
			if ($.isArray(node)) {
				node.push(element.value)
			} else {
				result[element.name] = [ node, element.value ]
			}
		} else {
			result[element.name] = element.value
		}
	}

	$.each(this.serializeArray(), extend)
	return result
}

//폼 입력 확인
function fnValidate($form) {
	var valid = true;
	$form.find("input[required], select[required], textarea[required]").each(function() {
		if (!$(this).val()) {
			var title = $(this).attr("title");
			alert(title + "을(를) 입력해주세요");
			valid = false;
			$(this).focus();
			return false;
		}
	});
	
	return valid;
}

function fnFileDown(f) {
	var downFrm = document.downloadForm;
	downFrm.action = "/common/file/download";
	downFrm.fileId.value = f;
	downFrm.target = "downloadFrame";
	downFrm.submit();
}

function fnExcelSampleDown(f) {
	var downFrm = document.downloadForm;
	downFrm.action = "/common/file/uploadSample";
	downFrm.uploadFormName.value = f;
	downFrm.target = "downloadFrame";
	downFrm.submit();
}

function number2digit(num){
	return ('0'+num).slice(-2);
}

function winOpen(name, value) {

	var argv = winOpen.arguments; 
	var argc = winOpen.arguments.length; 
	var newWin;
	var winfocus = true;
	var posx = "";
	var posy = "";

	if (argc > 0){
		url = argv[0];
	} else return null;

	if (argc > 1){
		winname = argv[1];
	} else winname = null;

	if (argc > 2){
		w = argv[2];
		h = argv[3];
	} else { w=100; h=100; }

	setting = "height=" + h + ", width=" + w;

	if (argc > 4) if (argv[4] != null) setting += "," + argv[4];

	if (argc > 5) winfocus = (argv[5] != null) ? argv[5] : true;

	if (argc > 6){
		if (argv[6] != null) posx = " ,left=" + argv[6];
		if (argv[7] != null) posy = " ,top=" + argv[7];
	} else {
		posx = ",left=" + Math.floor((screen.width)?(screen.width-w)/2:100);
		posy = ",top=" + Math.floor((screen.height)?(screen.height-h)/3:100);
	}
	setting += posx + "" +  posy;

	newWin = window.open(url,winname,setting);

	if (typeof(winfocus) == "object") newWin.focus();

	if (argc < 8) return newWin;
	if (argv[8]) return newWin;
}