function updateCommodities () {
                var categoryId=$($("#choice-category")).children('option:selected').val();
                $.ajax({
                    url : "../api/queryCommodityByCategoryId?categoryId="+categoryId,
                    success : function(data) {
                        $(".container").html("");
                        var json;
    					parseJSON(data).then(function(o){
    						json=o;
    						for (var i = 0; i < json.length; i++) {
    		                      
                                var context='<div class="card col-xs-12 col-sm-6 col-md-4" >'
                                   + '<img class="card-img" src="'
                                +json[i].imgUrl
                                     +'">'
                                    +'<div class="card-body">'
                                    +'<span id="name" class="label label-primary">'
                                +json[i].name
                                    +'</span>&nbsp;&nbsp;&nbsp;&nbsp;'
                                   +'<span id="money" class="label label-danger">'
                                +json[i].money
                                +'元</span>&nbsp;&nbsp;&nbsp;&nbsp;'
                                    +'<span id="category" class="label label-info">燈具</span>'
                                   +'</div>'
                                    +'<div class="delete" data-index="'
                                    +json[i].id
                                    +'">'
                                    +'<span class="glyphicon glyphicon-remove"></span>'
                                    +'</div>'
                                    +'<a class="update" href="../api/queryCommodityById?commodityId='
                                    +json[i].id
                                    +'">'
                                    +'<span class="glyphicon glyphicon-edit"></span>'
                                    +'</a>'
                                    +'</div>'
                                $(".container").append(context);
                            }
    					}).catch(function(err){
    						window.location.href="../admin/login.jsp"
    					});
                        
                    },
                    error:function(){
                    	window.location.href="../admin/login.jsp";
                    }
                });
              
            }

$(document).ready(function() {	
	
			/**
			 * 获得商品类别
			 */
			$.ajax({
				url : "../api/queryAllCategory",
				success : function(data) {
			
					var json;
					parseJSON(data).then(function(o){
						json=o;
						for (var i = 0; i < json.length; i++) {
							$("#choice-category").append(
									"<option value='" + json[i].id + "'>"
											+ json[i].name + "</option>")
						}
						$("#choice-category").append("<option value='0'>全部</option>")
						updateCommodities();
					}).catch(function(err){
						window.location.href="../admin/login.jsp"
					});
					

				}
			});
			/**
			* 监听select切换
			* */
			$("#choice-category").change(updateCommodities);

			/**
             *点击删除
             *
             **/
			$(".container").on("click",".delete",function(){
                if(confirm("真的要删除吗?")){
                    var e=$(this);
                    var id=e.attr("data-index");
                    $.ajax({
                            url: "../api/deleteCommodityById?id=" + id,
                            success: function () {
                                updateCommodities();
                            }
                        }
                    )
                }
                else{}
			});
});