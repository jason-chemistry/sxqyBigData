$(function() {

	//init();
	//左上角时间
	setInterval(getTime,1000);

	//十分钟获取今日数据
	getTodayData();
	setInterval(getTodayData,600000);


	//十分钟获取预约等信息
	getDrugMessage();
	setInterval(getDrugMessage,600000);

	//十分钟获取预约情况
	getDepartment();
	setInterval(getDepartment,600000);
	getWeekMzCount();
});

function init() {
	var myColor = ['#1089E7', '#F57474', '#56D0E3', '#F8B448', '#8B78F6'];
	//急诊
	var lineChart1 = echarts.init(document.getElementById('lineChart1'));
	lineChart1.setOption({
		//		title: {
		//			text: '今日门急诊人次',
		//		 textStyle: {
		//            fontWeight: "normal",
		//            color: "#fff", 
		//            fontSize: 14
		//    }
		//		},
		tooltip: {
			trigger: 'axis',
			axisPointer: {
				type: 'cross',
				label: {
					backgroundColor: '#6a7985'
				}
			}
		},
		legend: {
			padding: [30, 0, 0, 0], //可设定图例[距上方距离，距右方距离，距下方距离，距左方距离]
			data: ['门诊', '急诊'],
			textStyle: { //图例文字的样式
				color: '#ccc',
				fontSize: 14
			}
		},

		grid: {
			left: '3%',
			right: '4%',
			bottom: '5%',
			containLabel: true
		},
		xAxis: [{
			type: 'category',
			boundaryGap: false,
			data: ['8:00', '10:00', '12:00', '14:00', '16:00', '18:00'],
			axisLine: {
				lineStyle: {
					color: '#FFF'

				}
			}
		}],
		yAxis: [{
			type: 'value',
			axisLine: {
				lineStyle: {
					color: '#FFF'

				}
			}

		}],
		series: [{

				name: '门诊',
				type: 'line',
				stack: '总量',
				areaStyle: {},
				//				itemStyle: {
				//					normal: {
				//						color: '#000', //改变折线点的颜色
				//						lineStyle: {
				//							color: '#fff' //改变折线颜色
				//						}
				//					}
				//				},
				data: [120, 132, 101, 134, 90, 230]
			},
			{
				name: '急诊',
				type: 'line',
				stack: '总量',
				areaStyle: {},
				data: [220, 182, 191, 234, 290, 330]
			}
		]
	});

	// var lineChart2 = echarts.init(document.getElementById('lineChart2'));
	// lineChart2.setOption({
	// 	radar: [{
	// 		indicator: [{
	// 				text: '111',
	//
	// 			},
	// 			{
	// 				text: '销售单位'
	// 			},
	// 			{
	// 				text: '使用单位'
	// 			},
	// 			{
	// 				text: '生产单位'
	// 			},
	// 			{
	// 				text: '处置单位'
	// 			},
	// 			{
	// 				text: '储存单位'
	// 			}
	// 		],
	// 		center: ['50%', '47%'], // 位置
	// 		radius: 130, //大小
	// 		startAngle: 90,
	// 		splitNumber: 4,
	// 		shape: 'circle',
	// 		name: {
	// 			formatter: '{value}',
	// 			textStyle: {
	// 				color: 'aqua' // 文字颜色
	// 			}
	// 		},
	// 		splitArea: {
	// 			areaStyle: {
	// 				color: [
	// 					'rgba(114, 172, 209, 0.1)',
	// 					'rgba(114, 172, 209, 0.1)',
	// 					'rgba(114, 172, 209, 0.1)',
	// 					'rgba(114, 172, 209, 0.1)',
	// 					'rgba(114, 172, 209, 0.1)'
	// 				], //圆环颜色
	// 				shadowColor: 'aqua', // 圆颜色
	// 				shadowBlur: 10
	// 			}
	// 		},
	// 		axisLine: {
	// 			lineStyle: {
	// 				color: 'aqua' // 分割线
	// 			}
	// 		},
	// 		splitLine: {
	// 			lineStyle: {
	// 				color: 'aqua' //圆线
	// 			}
	// 		}
	// 	}],
	// 	series: [{
	// 		name: '雷达图',
	// 		type: 'radar',
	// 		itemStyle: {
	// 			emphasis: {
	// 				// color: 各异,
	// 				lineStyle: {
	// 					width: 4
	// 				}
	// 			}
	// 		},
	// 		data: [{
	// 			value: [5678, 3678, -6781, 1678, 1780, 3671],
	// 			areaStyle: {
	// 				normal: {
	// 					color: 'rgba(0, 255, 255, 0.8)' // 选择区域颜色
	// 				}
	// 			}
	// 		}]
	// 	}]
	// });
	//
	// var lineChart3 = echarts.init(document.getElementById('lineChart3'));
	// lineChart3.setOption({
	// 	tooltip: {
	// 		trigger: 'item',
	// 		formatter: '{a} <br/>{b}: {c} ({d}%)'
	// 	},
	// 	title: {
	// 		text: '总预约人数:' + '2000',
	// 		x: 'center',
	// 		y: 'center',
	// 		textStyle: {
	// 			fontSize: 20,
	// 			color: '#39CCCC'
	// 		}
	// 	},
	// 	legend: {
	// 		orient: 'horizontal',
	// 		left: 10,
	// 		data: ['直接访问', '邮件营销', '联盟广告', '视频广告', '搜索引擎']
	// 	},
	// 	series: [{
	// 		name: '访问来源',
	// 		type: 'pie',
	// 		radius: ['50%', '70%'],
	// 		avoidLabelOverlap: false,
	// 		label: {
	// 			normal: {
	// 				show: false,
	// 				position: 'center'
	// 			},
	//
	// 		},
	// 		labelLine: {
	// 			normal: {
	// 				show: false
	// 			}
	// 		},
	// 		data: [{
	// 				value: 335,
	// 				name: '直接访问'
	// 			},
	// 			{
	// 				value: 310,
	// 				name: '邮件营销'
	// 			},
	// 			{
	// 				value: 234,
	// 				name: '联盟广告'
	// 			},
	// 			{
	// 				value: 135,
	// 				name: '视频广告'
	// 			},
	// 			{
	// 				value: 1548,
	// 				name: '搜索引擎'
	// 			}
	// 		],
	// 		itemStyle: {
	// 			emphasis: {
	// 				shadowBlur: 10,
	// 				shadowOffsetX: 0,
	// 				shadowColor: 'rgba(0, 0, 0, 0.5)'
	// 			},
	// 			normal: {
	// 				color: function(params) {
	// 					//自定义颜色
	// 					var colorList = [
	// 						'#2f83e4', '#00e5c1', '#23cbff', '#36478c', '#29527e', '#029bbb',
	// 					];
	// 					return colorList[params.dataIndex]
	// 				}
	// 			}
	// 		}
	// 	}]
	// });
	//
	// var lineChart4 = echarts.init(document.getElementById('lineChart4'));
	// lineChart4.setOption({
	// 	xAxis: {
	// 		type: 'category',
	// 		data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
	// 		axisLine: {
	// 			lineStyle: {
	// 				color: '#FFF'
	//
	// 			}
	// 		}
	// 	},
	// 	yAxis: {
	// 		type: 'value',
	// 		axisLine: {
	// 			lineStyle: {
	// 				color: '#FFF'
	//
	// 			}
	// 		}
	// 	},
	// 	series: [{
	// 		data: [120, 200, 150, 80, 70, 110, 130],
	// 		type: 'bar'
	// 	}]
	// });

}
function getTodayData() {

	$.ajax({
		url:'http://localhost:9090/TodayData',//地址
		dataType:'json',//数据类型
		type:'GET',//类型
		timeout:2000,//超时
		//请求成功
		success:function(data,status){
			console.log(data);
			console.log(data.checkPeople);
			$(".checkPeople").html(data.checkPeople);
			$(".zyPeople").html(data.zyPeople);
			$(".inPeople").html(data.inPeople);
			$(".mzPeople").html(data.mzPeople);
		},
		//失败/超时
		error:function(XMLHttpRequest,textStatus,errorThrown){

		}
	})


}
function getDrugMessage() {
	$.ajax({
		url:'http://localhost:9090/MZVisits/DrugMessage',//地址
		dataType:'json',//数据类型
		type:'GET',//类型
		timeout:2000,//超时
		//请求成功
		success:function(data,status){
			console.log(data);
			console.log(data.yiQuYao)
			$(".YiQuYao").html(data.yiQuYao);
			$(".WeiQuYao").html(data.weiQuYao);
			$(".DaiShoufei").html(data.daiShoufei);
			$(".YyCount").html(data.yyCount);
		},
		//失败/超时
		error:function(XMLHttpRequest,textStatus,errorThrown){

		}
	})
}
function  getDepartment() {
	var names=[];
	var nums=[];
	$.ajax({
		url:'http://localhost:9090/MZVisits',//地址
		dataType:'json',//数据类型
		type:'GET',//类型
		timeout:2000,//超时
		//请求成功
		success:function(data,status){
			for(var i=0;i<data.length;i++){
				names.push(data[i].name.replace(/\s+/g,""));    //挨个取出类别并填入类别数组
				nums.push(data[i].count.replace(/\s+/g,""));
			}
			var lineChart4 = echarts.init(document.getElementById('lineChart4'));
			lineChart4.setOption({

				grid: {
					left:120
				},

				xAxis: {
					type: 'value',

					axisLine: {
						lineStyle: {
							color: '#FFF'

						}
					},

				},

				yAxis: {
					type: "category",

					data:names,
					axisLabel: {
						textStyle: {
							//文字样式
							color: "#fff",
							fontSize: "12",

						},
						show:true,					//---是否显示
						inside:false,				//---是否朝内
						rotate:0,					//---旋转角度
						margin: 8,
					},
					// 控制网格线是否显示
					splitLine: {
						//  改变轴线颜色
						lineStyle: {
							color: "rgba(0,0,0,0)"
						}
					},

					axisLine: {
						//隐藏y轴线
						show: false
					},


				},

				series: [
					{
						itemStyle: {

							normal: {

								//好，这里就是重头戏了，定义一个list，然后根据所以取得不同的值，这样就实现了，

								color: function(params) {

									// build a color map as your need.

									var colorList = [

										'#C1232B','#B5C334','#FCCE10','#E87C25','#27727B',

										'#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD',

										'#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0'

									];

									return colorList[params.dataIndex]

								},

								//以下为是否显示，显示位置和显示格式的设置了

								label: {

									show: true,

									position: 'right',


								}

							}

						},
						type: 'bar',
						data: nums,
					}
				]
			});
		},
		//失败/超时
		error:function(XMLHttpRequest,textStatus,errorThrown){

		}
	})
}

function getWeekMzCount() {
	var day=[];
	var count=[];
	$.ajax({
		url:'http://localhost:9090/MZVisits/WeekCount',//地址
		dataType:'json',//数据类型
		type:'GET',//类型
		timeout:2000,//超时
		//请求成功
		success:function(data,status){
			for(var i=0;i<data.length;i++){
				day.push(data[i].day.replace(/\s+/g,""));    //挨个取出类别并填入类别数组
				count.push(data[i].count.replace(/\s+/g,""));
			}
			var lineChart1 = echarts.init(document.getElementById('lineChart1'));
			var colors = ['#5793f3', '#d14a61', '#675bba'];
			lineChart1.setOption({
				color:  ['#5793f3', '#d14a61', '#675bba'],

				grid: {
						left:'70%'
				},
				xAxis: [
					{
						type: 'category',
						axisTick: {
							alignWithLabel: true,

						},
						axisLine: {
							onZero: false,
							lineStyle: {
								color: colors[1]
							}
						},
						axisPointer: {
							label: {
								formatter: function (params) {
									return '降水量  ' + params.value
										+ (params.seriesData.length ? '：' + params.seriesData[0].data : '');
								}
							}
						},
						axisLabel: {
							textStyle: {
								//文字样式
								color: "#fff",
								fontSize: "12",

							},
							show:true,					//---是否显示
							inside:false,				//---是否朝内
							rotate:0,					//---旋转角度
							margin: 8,
						},
						data: day
					},

				],
				yAxis: [
					{
						type: 'value',
						axisLabel: {
							textStyle: {
								//文字样式
								color: "#fff",
								fontSize: "12",

							},
							show:true,					//---是否显示
							inside:false,				//---是否朝内
							rotate:0,					//---旋转角度
							margin: 8,
						},
					},
				],
				series: [

					{
						name: '一周就诊人数',
						type: 'line',
						smooth: true,
						data: count
					}
				]
			})
		},
		//失败/超时
		error:function(XMLHttpRequest,textStatus,errorThrown){

		}
	})


}

function getTime() {
	let date = new Date();

	let dateDay = date.getDay();

	let week;
	if(dateDay == 1){
		week= '星期一'
	} else if(dateDay == 2){
		week= '星期二'
	} else if(dateDay == 3){
		week= '星期三'
	} else if(dateDay == 4){
		week= '星期四'
	} else if(dateDay == 5){
		week= '星期五'
	} else if(dateDay == 6){
		week= '星期六'
	} else {
		week='星期日'
	}
	let time1=dateFormat("YYYY年mm月dd日 HH:MM:SS", date);
	let times=time1+" "+week;
	$(".time").html(times);
}
function dateFormat(fmt, date) {
	let ret;
	const opt = {
		"Y+": date.getFullYear().toString(),        // 年
		"m+": (date.getMonth() + 1).toString(),     // 月
		"d+": date.getDate().toString(),            // 日
		"H+": date.getHours().toString(),           // 时
		"M+": date.getMinutes().toString(),         // 分
		"S+": date.getSeconds().toString()          // 秒
		// 有其他格式化字符需求可以继续添加，必须转化成字符串
	};
	for (let k in opt) {
		ret = new RegExp("(" + k + ")").exec(fmt);
		if (ret) {
			fmt = fmt.replace(ret[1], (ret[1].length == 1) ? (opt[k]) : (opt[k].padStart(ret[1].length, "0")))
		}
	}
	return fmt;
}