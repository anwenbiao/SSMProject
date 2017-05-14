
function validateYx(type,id) {
	var tf;
	switch (type) {
	case "phone":
		tf = /^(13|14|15|17|18)\d{9}$/i.test($("#"+id).val()); 
		if(!tf){
			tips(id,"请输入正确的手机号");
		}
		break;
	case "unnormal":
		tf = /.+/i.test($("#"+id).val());
		if(!tf){
			tips(id,"输入值不能为空和包含其他非法字符");
		}
		break;
	case "chinese":
		tf = /^[\u0391-\uFFE5]+$/i.test($("#"+id).val()); 
		if(!tf){
			tips(id,"请输入中文");
		}
		break;
	default:
		break;
	}
	return tf;
}

function notNull(id){
	if($("#"+id).val()==""||$("#"+id).val()==null){
		tips(id,"此处不能为空");
		return false;
	}
	return true;
}

//判断密码是否相同
function equals(id1,id2) {
	if($("#"+id1).val()!=$("#"+id2).val()){
		tips(id2,"两次输入的密码不一致");
		return false;
	}
	return true;
}

function tips(id,msg){
	layer.tips(msg, '#'+id, {
		tips: [3, 'rgba(0,0,0, .7)'], //还可配置颜色
		tipsMore: true
	});
}



