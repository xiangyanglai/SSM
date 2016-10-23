//定义构造函数
var MySlide = function(element,opt){
	this.$element = $(element);
	this.options = $.extend({},this.defaults,opt);
	this.e
	this.current = 0;
	this.length = this.$element.find(".item").size();
}


//定义MySlide方法
MySlide.prototype = {
	log: function()
	{
		this.$element.find(".current").removeClass("current");
		if(this.current == this.length-1)
		{
		    this.current = 0;
		}else{
		    this.current++;
		}
		this.$element.find(".item").eq(this.current).addClass("current");
	},
	changeSlide: function()
	{
		this.$element.find(".current").removeClass("current");
		if(this.current == this.length-1)
		{
		    this.current = 0;
		}else{
		    this.current++;
		}
		this.$element.find(".item").eq(this.current).addClass("current");
	}
};


//在插件中使用MySlide对象
$.fn.mySlidePlugin = function(options) {
    return this.each(function(){
	    //创建MySlide的实体
 	   var mySlide = new MySlide(this, options);
       setInterval(mySlide.log.bind(mySlide),2000);
    });
}