$(function(){
	activeMenu();
});

function activeMenu(str) {
	var url = window.location.pathname;
	var arr = url.split('/');
	
	if(arr[1]=='front'){
		$('#menu-item-'+arr[3]) .addClass('current-menu-item'); 
		
	}
}