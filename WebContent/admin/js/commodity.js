function updateCommodities () {
                var categoryId=$($("#choice-category")).children('option:selected').val();
                $.ajax({
                    url : "http://localhost:8080/SHOP/api/queryCommodityByCategoryId?categoryId="+categoryId,
                    success : function(data) {
                        $(".container").html("");
                        var json = JSON.parse(data);
                        for (var i = 0; i < json.length; i++) {
                      
                            var context='<div class="card" >'
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
                                +'</div>'
                            $(".container").append(context);
                        }
                    }
                });
            }

$(document).ready(function() {
			/**
			 * 获得商品类别
			 */
			$.ajax({
				url : "http://localhost:8080/SHOP/api/queryAllCategory",
				success : function(data) {
					var json = JSON.parse(data);
					for (var i = 0; i < json.length; i++) {
						$("#choice-category").append(
								"<option value='" + json[i].id + "'>"
										+ json[i].name + "</option>")
					}
					updateCommodities();
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
                            url: "http://localhost:8080/SHOP/api/deleteCommodityById?id=" + id,
                            success: function () {
                                updateCommodities();
                            }
                        }
                    )
                }
                else{}
			})
});