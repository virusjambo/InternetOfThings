var userid = null;
var uid = null;
var devices=null;
$(document).ready(function() {
	if (window.location.search) {
		uid = window.location.search;
		userid=uid.replace('?','');
		userid=userid.split('&')[0];
		userid = userid.split('=')[1];
	}
	;
	var getdevices = function() {

		$.ajax({
			url : "/info/getcustomerinfo" + uid,
			type : "GET",
			contentType : "application/json",
			dataType : "json",
			success : function(res) {
				if (res.success) {
					devices=res.deviceInfo;
					buildDevices();
				} else {
					alert("Invalid user name or password");
				}
			},
			failure : function(res) {
				alert("failure");
			}
		});
	}
	if (userid) {
		getdevices();
	}

	var buildDevices = function() {
	if(devices){
		
		for(var i=0;i<devices.length;i++){	
			var device=devices[i];
			var d='checked';
			if(device.status=='OFF'){
				$('input[name='+ i+']').attr('checked', false); // Checks it
				d='';
			}
			
		$("#accordion").append('<div class="panel panel-default">'	+
		   '<div class="panel-heading">' +	
				'<div class="panel-title">'+
				'<div class="row">'+
				'<div class="col-xs-12 col-sm-6 col-md-8">'+
					'<a data-toggle="collapse"  data-parent="#accordion"'+
						'href="#'+device.id+'">'+device.name +'</a>'+
						'</div>'+
						'<div class="col-xs-6 col-md-4">'+
						'<input  type="checkbox" class="col-lg-6" name="'+ i+'" '+d+'>'+
						'</div>'+
					'</div>'+
				'</div>'+
				 '</div>'+
			'<div id="'+device.id+'" class="panel-collapse collapse">'+
				'<div class="panel-body">'+ 
				'<label >Device Name</label> <input type="text" class="form-control"'+
						' id="'+device.id +'_name" disabled value='+ device.name+'>'+
				'<label>MAC Address</label> <input type="text" class="form-control"'+
						'id="'+device.id +'_mac" disabled value='+ device.macAddress+'>' +
				'</div>'+
				'</div>'+
				'</div>');
		
		$("[name='"+i+"']").bootstrapSwitch();
		

		}
		
	}
	}
	
	$('#accordion').on('switchChange.bootstrapSwitch', function(event, state) {
		if(event.target.name){
			var device=devices[event.target.name]	;
			updatestatus(userid,device,state);
			
		}
		});

	
});



var updatestatus = function(userid,device,state) {

	var deviceinfo={};
	deviceinfo.userId=userid;
	deviceinfo.macAddress=device.macAddress;
	if(state){
		 deviceinfo.toStatus='ON'
	}else{
		 deviceinfo.toStatus='OFF'

	}
 
	$.ajax({
		url : "/info/changeStatus",
		type : "POST",
		contentType : "application/json",
		dataType : "json",
		data:JSON.stringify(deviceinfo),
		success : function(res) {
			if (res.success) {
				alert(" update status success");
			} else {
				alert("Unable to update status");
			}
		},
		failure : function(res) {
			alert("failure");
		}
	});
	
}