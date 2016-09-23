#Shopping Cart test routine
#@author Daniel Kist

clear

#1 - List products - Authorization is not required
curl -i -H "Accept: application/json" http://localhost:8080/products

sleep 5

clear

#2 - Load cart (empty)
curl -i -H "Accept: application/json" -H "Authorization: cart-1-062c1ec1-c03f-4e6d-b459-c13fd4832d85" http://localhost:8080/shoppingcart

sleep 5

clear

#3 - Add one product
curl -H "Accept: application/json" -H "Content-type: application/json" -H "Authorization: cart-1-062c1ec1-c03f-4e6d-b459-c13fd4832d85" -X POST -d '{"product_id": "2034b075-eed2-4fb6-b57d-6ca6ca6eed39", "quantity":"1"}' http://localhost:8080/shoppingcart/items

sleep 5

clear

#4 - Add another product
curl -H "Accept: application/json" -H "Content-type: application/json" -H "Authorization: cart-1-062c1ec1-c03f-4e6d-b459-c13fd4832d85" -X POST -d '{"product_id": "bceb4f87-7ed0-4f39-98a2-ccb4b672123b", "quantity":"5"}' http://localhost:8080/shoppingcart/items

sleep 5

clear

#5 - Load cart with products
curl -i -H "Accept: application/json" -H "Authorization: cart-1-062c1ec1-c03f-4e6d-b459-c13fd4832d85" http://localhost:8080/shoppingcart

sleep 5

clear

#6 - Remove Product (Use command #2 or #5 to retrive items IDs)
#curl -i -H "Authorization: cart-1-062c1ec1-c03f-4e6d-b459-c13fd4832d85" -X DELETE http://localhost:8080/shoppingcart/items/{GET_ONE_ID_FROM_CART}
