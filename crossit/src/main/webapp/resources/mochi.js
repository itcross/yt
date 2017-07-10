	$(document).ready(function(){
		$("#chkto").click(function(){
			if($(this).is(":checked")){
				$("input[type=checkbox]").each(function(e){
					$(this).prop("checked",true);
				});
			}else{
				$("input[type=checkbox]").each(function(e){
					$(this).prop("checked",false);
				});
			}
		});
		
		$(".loginp").focus(function(){
			this.placeholder = "";
		});
		$(".placeid").blur(function(){
			this.placeholder = "ID";
		});
		$(".placepw").blur(function(){
			this.placeholder = "PASSWORD";
		});
		
		
	});
