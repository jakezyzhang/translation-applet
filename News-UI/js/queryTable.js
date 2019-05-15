layui.use(['table', 'jquery'], function() {
	var $ = layui.jquery;
	var table = layui.table;
	downDatas = []
	
	table.render({
		elem: '#reg_data_table',
		url: 'http://localhost:8086/translation/Article/queryArticle',
		title: '新闻列表',
		cols: [
			[{
					field: 'rLongTitle',
					title: '标题',
					width: 150
				},
				{
					field: 'rSummary',
					title: '文章简介',
					width: 150
				},
				{
					field: 'publishInfo',
					title: '是否发布',
					width: 150
				},
				{
					field: 'lastEditTime',
					title: '更新时间',
					width: 150
				},
				{
					fixed: 'right',
					title: '操作',
					toolbar: '#bar',
					width: 150
				}
			]
		],
		parseData: function(res){
			return {
				"code":res.status,
			};
			
		},
		page: true,
		limit: 15,
		limits: [15, 30, 45, 60, 75, 90]
		
	});
	table.on('tool(reg_data_table)', function(obj) {
		// alert(obj.data['rId'])
		//       var data = obj.data;
		//       var odata = {}
		//       odata['rId'] = [data['rId']]
		// alert(odata['rid'])
		var data = obj.data //获得当前行数据（json格式的键值对）//获得 lay-event 对应的值（编辑、删除、添加）
		,editList=[]; //存放获取到的那条json数据中的value值（不放key）
		$.each(data,function(name,value) {//循环遍历json数据
			editList.push(value);//将json数据中的value放入数组中（下面的子窗口显示的时候要用到）
		});
		if (obj.event === 'del') {
			layer.confirm('确认删除？', function(index) {
				// alert('odata['rid']')
				$.ajax({
					url: "http://localhost:8086/translation/Article/modifyarticlebystatus",
					data: {
						rId: obj.data['rId'],
						rStatus: 1
					},
					type: "POST"
						// , dataType: "json"
						,
					success: function(data) {
						// alert(data['success'])
						if (data['success'] == true) {
							layer.msg("已删除");
							obj.del();
						} else {
							layer.msg("删除失败")
							return;
						}

					},
					error: function(err) {
						layer.msg("发生错误,刷新后重试");
						return;
					}
				});
				layer.close(index);

			});
		} else if (obj.event === 'edit') {
			//脚本编辑弹出层
			// var name = encodeURIComponent(data.toolName);
			// console.log(name);
			console.log(obj.data['rId'])
			layer.open({
				type: 2,
				title: '编辑文章信息',
				shadeClose: true,
				shade: 0.8,
				maxmin: true,
				area: ['70%', '70%'],
				content: 'queryTableEditor.html?rId=' + obj.data['rId'], //设置你要弹出的jsp页面
				success: function(layero, index) {
					var body = layer.getChildFrame('body', index);
					var iframeWin = window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();  
					var inputList = body.find("input"); //获取到子窗口的所有的input标签
					// for (var i = 0; i < inputList.length; i++) {
					// 	$(inputList[i]).val(editList[i]); //遍历子窗口的input标签，将之前数组中的值一次放入显示
					// }
					$(inputList[0]).val(editList[3]);
					$(inputList[1]).val(editList[4]);
					$(inputList[2]).val(editList[6]);
					$(inputList[3]).val(editList[7]);
				}
			});
		}
	});
})
