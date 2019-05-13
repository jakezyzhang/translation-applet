layui.use(['jquery', 'form', 'layer'], function() {
	var form = layui.form;
	var $ = layui.jquery;
	var layer = layui.layer;
	//监听提交
	form.on('submit(articleSubmit)', function(data) {
		$.ajax({
			// url: 'https://www.zyaiyy.cn/s/getshorturl',
			url: 'https://localhost:8086/translation/Article/addarticle',
			type: "POST",
			data: {
				"rLongTitle": data.field.longTitle,
				"rSubheading": data.field.subheading,
				"rSummary": data.field.summary,
				"rContent": data.field.article,
				"rPublish": 1,
				"rStatus": 0
			},
			success: function(data) {
				// $("#url").val("http://www.zyaiyy.cn/s/" + data.shortUrl);
				layer.open({
					title: '编辑',
					content: '添加文章成功'
				});
			},
		});
		return false;
	});
});
