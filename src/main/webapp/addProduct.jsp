<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>New Product</title>
</head>

<body>
    <h1>Add a New Product</h1>
    <form action="productEntry" method="POST">
        <table>
            <tr>
                <td>Product Name</td>
                <td></td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>Product Price</td>
                <td></td>
                <td><input type="text" name="price"></td>
            </tr>
            <tr>
                <td>Product Quantity</td>
                <td></td>
                <td><input type="text" name="quantity"></td>
            </tr>
        </table>
        <button type="submit">Submit</button>
    </form>
</body>

</html>