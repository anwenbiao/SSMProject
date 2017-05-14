  require.config({
            paths: {
                echarts: 'http://echarts.baidu.com/build/dist'
            }
        });
        
        // 使用
        require(
            [
                'echarts',
                'echarts/chart/bar' // 使用柱状图就加载bar模块，按需加载
            ],
            function (ec) {
                // 基于准备好的dom，初始化echarts图表
                var myChart = ec.init(document.getElementById('zzt')); 
                
                var option = {
    title : {
        text: '同江金融2015、2016年累计投资金额',       
    },
    tooltip : {
        trigger: 'select'
    },
    calculable : true,
    xAxis : [
        {
            type : 'category',
            data : ['01','02','03','04','05','06','07','08','09','10','11','12','01/16','02','03','04','05','06']
        }
    ],
    yAxis : [
        {
            type : 'value',
    axisLabel : {
    formatter: '{value} 亿'
},
splitNumber:4
        }
		
    ],
    series : [
       
        {
            name:'累计投资金额',
            type:'bar',
            data:[6.5, 7,7.5, 8, 8.5, 9, 9.5, 10, 10.5,11, 11.5, 12,12.5, 13.5, 15.5, 16.5, 18, 20],
           
        }
    ]
};
        
                // 为echarts对象加载数据 
                myChart.setOption(option); 
            }
        );
		
		// 项目期限
        require(
            [
                'echarts',
                'echarts/chart/pie' // 使用柱状图就加载bar模块，按需加载
            ],
            function (ec) {
                // 基于准备好的dom，初始化echarts图表
                var myChart = ec.init(document.getElementById('main1')); 
                var option = {
    title : {
        
    },
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        orient : 'vertical',
        x : 'left',
        data:['']
    },
   
    calculable : true,
    series : [
        {
            name:'项目期限',
            type:'pie',
            radius : '55%',
            center: ['50%', '50%'],
            data:[
                {value:255, name:'1-3个月'},
                {value:110, name:'6-9个月'},
                {value:234, name:'9-12个月'},
                {value:300, name:'3-6个月'}
            ]
        }
    ]
};
                    
                    
                myChart.setOption(option); 
            }
        );
		
		// 项目额度
        require(
            [
                'echarts',
                'echarts/chart/pie' // 使用柱状图就加载bar模块，按需加载
            ],
            function (ec) {
                // 基于准备好的dom，初始化echarts图表
                var myChart = ec.init(document.getElementById('main2')); 
                var option = {
    title : {
        
    },
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        orient : 'vertical',
        x : 'left',
        data:['']
    },
   
    calculable : true,
    series : [
        {
            name:'项目额度',
            type:'pie',
            radius : '55%',
            center: ['50%', '50%'],
            data:[
                {value:180, name:'10-30万'},
                {value:600, name:'30-80万'},
                {value:40, name:'100-500万'},
                {value:820, name:'80-100万'}
            ]
        }
    ]
};
                    
                    
                myChart.setOption(option); 
            }
        );
		
		// 年龄分布
        require(
            [
                'echarts',
                'echarts/chart/pie' // 使用柱状图就加载bar模块，按需加载
            ],
            function (ec) {
                // 基于准备好的dom，初始化echarts图表
                var myChart = ec.init(document.getElementById('main3')); 
                var option = {
    title : {
        
    },
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        orient : 'vertical',
        x : 'left',
        data:['']
    },
   
    calculable : true,
    series : [
        {
            name:'项目期限',
            type:'pie',
            radius : '55%',
            center: ['50%', '50%'],
            data:[
                {value:255, name:'28-35岁'},
                {value:210, name:'43-59岁'},
                {value:134, name:'18-27岁'},
                {value:300, name:'36-42岁'}
            ]
        }
    ]
};
                    
                    
                myChart.setOption(option); 
            }
        );


