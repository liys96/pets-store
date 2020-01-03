/**
 * 时间插件+table表格奇偶样式
 */
$('.tablelist tbody tr:odd').addClass('odd');
    var start = {
      elem: '#startTime',
      format: 'YYYY-MM-DD hh:mm:ss',
      max: '2099-06-16', //最大日期
      istime: true,
      istoday: false,
      choose: function(datas){
        end.min = datas; //开始日选好后，重置结束日的最小日期
        end.start = datas; //将结束日的初始值设定为开始日
      }
    };

    var end = {
      elem: '#endTime',
      format: 'YYYY-MM-DD hh:mm:ss',
      max: '2099-06-16',
      istime: true,
      istoday: false,
      choose: function(datas){
        start.max = datas; //结束日选好后，充值开始日的最大日期
      }
    };
    laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
    laydate(start);
    laydate(end);

