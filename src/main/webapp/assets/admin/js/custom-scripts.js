/*------------------------------------------------------
    Author : www.webthemez.com
    License: Commons Attribution 3.0
    http://creativecommons.org/licenses/by/3.0/
---------------------------------------------------------  */

(function ($) {
    "use strict";
    var mainApp = {

        initFunction: function () {
            /*MENU 
            ------------------------------------*/
            $('#main-menu').metisMenu();
			
            $(window).bind("load resize", function () {
                if ($(this).width() < 768) {
                    $('div.sidebar-collapse').addClass('collapse')
                } else {
                    $('div.sidebar-collapse').removeClass('collapse')
                }
            });
        },

        initialization: function () {
            mainApp.initFunction();

        }

    }
    // Initializing ///

    $(document).ready(function () {
        mainApp.initFunction(); 
		$("#sideNav").click(function(){
			if($(this).hasClass('closed')){
				$('.navbar-side').animate({left: '0px'});
				$(this).removeClass('closed');
				$('#page-wrapper').animate({'margin-left' : '260px'});
				
			}
			else{
			    $(this).addClass('closed');
				$('.navbar-side').animate({left: '-260px'});
				$('#page-wrapper').animate({'margin-left' : '0px'}); 
			}
		});
    });

}(jQuery));

(function($) {
    $.ajaxSetup({
        error: function(xhr, status, error) {
        	
        	if (xhr.status === 0) {
                alert('Not connect.\n Verify Network.');
            } else if (xhr.status == 400) {
                alert('Server understood the request, but request content was invalid. [400]');
            } else if (xhr.status == 401) {
                alert('Unauthorized access. [401]');
            } else if (xhr.status == 403) {
                alert('Forbidden resource can not be accessed. [403]');
            } else if (xhr.status == 404) {
                alert('Requested page not found. [404]');
            } else if (xhr.status == 500) {
                alert('Internal server error. [500]');
            } else if (xhr.status == 503) {
                alert('Service unavailable. [503]');
            }  else if (xhr.status == 999) {
        		location.href='/admin/login';
        	} else if (xhr.status === 'parsererror') {
                alert('Requested JSON parse failed. [Failed]');
            } else if (xhr.status === 'timeout') {
                alert('Time out error. [Timeout]');
            } else if (xhr.status === 'abort') {
                alert('Ajax request aborted. [Aborted]');
            } else {
                alert('Uncaught Error.n' + xhr.responseText);
            }
        	
        },
    });
})(jQuery);


function activeMenu(str) {
	$a = $("#main-menu").find("a[href='" + str + "']");
	$a.addClass("active-menu");
	if(length==0){
		$a.addClass("active-menu");
	}else{
		$a.addClass("active");
		$a.closest(".li-menu").addClass("active");
		$a.closest(".li-menu").find(".nav-first").addClass("active-menu");
	}
}