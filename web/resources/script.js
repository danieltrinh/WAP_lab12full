$(function () {
    $(".add_to_cart").click(function () {
        var thisObj = $(this);
        var parentObj = $(this).closest(".product_container");
        var productId = parentObj.data("productid")
console.log(productId );
        $.ajax(
            {
                url: "/product",
                type: "POST",
                data: {
                    product_id: productId
                },
                success: function(data) {
                    var div = $("<div>").text(data);
                    $("#shopping_cart").empty();
                    $("#shopping_cart").append(div);

                    $("#checkout_btn").removeAttr('disabled');
                }
            }
        )
    })
})