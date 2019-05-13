layui.use(['jquery', 'form', 'layer'], function() {
	var form = layui.form;
	var $ = layui.jquery;
	var layer = layui.layer;
	var publish = undefined;
	//监听提交
	form.on('submit(articleSubmit)', function(data) {
		if (data.field.switch == 'on') {
			publish = 1;
		}else{
			publish = 0
		} 
		$.ajax({
			// url: 'https://www.zyaiyy.cn/s/getshorturl',
			url: 'http://localhost:8086/translation/Article/addarticle',
			type: "POST",
			data: {
				"rLongTitle": data.field.longTitle,
				"rSubheading": data.field.subheading,
				"rSummary": data.field.summary,
				"rContent": data.field.article,
				"rPublish": publish,
				"rStatus": 0
			},
			success: function(data) {
				// $("#url").val("http://www.zyaiyy.cn/s/" + data.shortUrl);
				layer.open({
					title: '编辑',
					content: '添加文章成功',
					yes:function(){
						$(window).attr("location","queryTable.html");
					}
				});
				
			},
		});
		return false;
	});
});
