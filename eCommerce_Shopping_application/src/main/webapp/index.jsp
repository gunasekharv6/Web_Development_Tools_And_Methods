<!DOCTYPE html>
<html>
    <head>
        <title>Shopping Cart</title>
        <link href="./nav.css" type="text/css" rel="stylesheet">
        <style type='text/css'>
            body {
                font: 15px verdana;
                margin: 10px;
                padding: 10px;
            }
            h1 {
                color: green;
            }
        </style>
    </head>
    <body>
        <div class="sidenav" id="mySidenav">
            <br>
<!--            <form>
                <input type="radio" id="book" name="param" value="Book"/>
                <label class="radio" for="book"> Books </label>
                <br/>
                
                <input type="radio" id="music" name="param" value="Music"/>
                <label class="radio" for="music"> Music </label>
                <br/>
                
                <input type="radio" id="computer" name="param" value="Computer"/>
                <label class="radio" for="computer"> Computer </label>
                <br/>
                
                <input type="radio" id="cart" name="param" value="Cart"/>
                <label class="radio" for="cart"> View Cart </label>
            </form>-->
            
            
            <a href="product.htm?param=Book">Books</a>
            <a href="product.htm?param=Music">Music</a>
            <a href="product.htm?param=Computer">Computer</a>
            <br><hr>
            <a href="product.htm?param=Cart">View Cart</a>
        </div>
        <div class="welcome-div">
            <h1>Welcome to Online Shopping Experience</h1>
            <h3>Order for Delivery or pickup today</h3>
        </div>
    </body>
</html>
