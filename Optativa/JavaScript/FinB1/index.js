
//Objeto constructor para las bebidas energéticas
function EnergyDrink(make, name, size, price) {
    this.make = make;
    this.name = name;
    this.size = size;
    this.price = price;
}

//Algunas bebidas energéticas de ejemplo
const rbClassic = new EnergyDrink("Red Bull", "Classic", "250ml", 2.5);
const rbSApricot = new EnergyDrink("Red Bull", "Strawberry Apricot", "250ml", 2.5);
const rbBlueberry = new EnergyDrink("Red Bull", "Blueberry", "250ml", 2.5);
const rbCoconut = new EnergyDrink("Red Bull", "Coco-Myrtille", "250ml", 2.5);
const rbIcedVanilla = new EnergyDrink("Red Bull", "Iced Vanilla Berry", "250ml", 2.5);

const mClassic = new EnergyDrink("Monster", "Classic", "500ml", 3.0);
const mUGold = new EnergyDrink("Monster", "Ultra Gold", "500ml", 3.0);
const mUltraParadise = new EnergyDrink("Monster", "Ultra Paradise", "500ml", 3.0);
const mUltraStrawberry = new EnergyDrink("Monster", "Ultra Strawberry Dreams", "500ml", 3.0);
const mZeroUltra = new EnergyDrink("Monster", "Zero Ultra", "500ml", 3.0);

//Stock inicial de cada bebida
let stock = new Map();
stock.set(rbClassic, 50);
stock.set(rbSApricot, 50);
stock.set(rbBlueberry, 50);
stock.set(rbCoconut, 50);
stock.set(rbIcedVanilla, 50);

stock.set(mClassic, 50);
stock.set(mUGold, 50);
stock.set(mUltraParadise, 50);
stock.set(mUltraStrawberry, 50);
stock.set(mZeroUltra, 50);

//Carrito de compras
let carrito = new Map();

//Funcion para actualizar la tienda
function updateProductDisplay() {
    //Seleccionar el contenedor de productos
    const productosDiv = document.getElementById("productos");
    productosDiv.innerHTML = '';

    stock.forEach((quantity, drink) => {
        if (quantity > 0) {
            //Crear el div del producto
            const drinkDiv = document.createElement("div");
            drinkDiv.className = "producto";
    
            //Estructura del producto
            drinkDiv.innerHTML = `
            <img class="productImg" src="${getDrinkImage(drink)}" alt="${drink.make} ${drink.name} img">
            <div class="product-info">
            <h3>${drink.make} (${drink.size})</h3>
            <p>${drink.name}</p>
            <p>Price: $${drink.price}</p>
            <p>In Stock: ${quantity}</p>
            </div>
            `;

            //Boton para añadir al carrito
            const addButton = document.createElement("button");
            const infoDiv = drinkDiv.querySelector(".product-info");

            addButton.textContent = "Add to Cart";
            addButton.onclick = () => addToCart(drink);
            
            //Agregar el boton al div del producto y el producto al contenedor
            infoDiv.appendChild(addButton);
            productosDiv.appendChild(drinkDiv);
        }
    });
};

//Funcion para actualizar el carrito
function updateCartDisplay() {
    //Seleccionar el contenedor del carrito
    const carritoDiv = document.getElementById("lista-carrito");

    //Seleccionar los botones de checkout y vaciar carrito
    const checkoutButton = document.getElementById("checkout");
    const vaciarButton = document.getElementById("vaciar-carrito");
    carritoDiv.innerHTML =  '';

    //Recorrer el carrito y mostrar los productos
    carrito.forEach((quantity, drink) => {
        if (quantity > 0) {
            //crear el div del producto en el carrito
            const drinkDiv = document.createElement("div");
            drinkDiv.className = "productoCarro";
            let precioTotal = drink.price * quantity;

            //Estructura del producto en el carrito
            drinkDiv.innerHTML = `
            <h3>${drink.make} ${drink.name} (${drink.size})</h3>
            <img class="productImg" src="${getDrinkImage(drink)}" alt="">
            <p>Price: $${precioTotal} // Ammount: ${quantity}</p>
            `;

            //Boton para eliminar del carrito
            const removeButton = document.createElement("button");
            removeButton.textContent = "Remove from Cart";
            removeButton.onclick = () => removeFromCart(drink);

            //Agregar el boton al div del producto y el producto al carrito
            drinkDiv.appendChild(removeButton);
            carritoDiv.appendChild(drinkDiv);
        } 
    });

    //Mostrar u ocultar botones segun el estado del carrito
    if (checkCartEmpty()) {
        checkoutButton.style.display = 'none';
        vaciarButton.style.display = 'none';
    } else {
        checkoutButton.style.display = 'block';
        checkoutButton.textContent = `Checkout $${calculateTotal().toFixed(2)}`;
        vaciarButton.style.display = 'block';
    };
};

//Funcion para añadir
function addToCart(drink) {
    if (stock.get(drink) > 0) {
        //Inicializar el contador en 0 si no existe o aumentar en 1
        //Sumar al carrito y restar del stock
        let totalAfterAdd = calculateTotal() + drink.price;
        if(totalAfterAdd > 100.00) {
            alert("You cannot exceed $100 in total purchases.");
            return;
        }else{
            carrito.set(drink, (carrito.get(drink) || 0) + 1);
            stock.set(drink, stock.get(drink) - 1);
        }
    } else {
        alert(`${drink.name} is out of stock.`);
    }
    updateCartDisplay();
    updateProductDisplay();
}

//Funcion para eliminar
function removeFromCart(drink) {
    //Restar del carrito y sumar al stock
    carrito.set(drink, carrito.get(drink) - 1);
    stock.set(drink, stock.get(drink) + 1);

    updateCartDisplay();
    updateProductDisplay();
}

//Funcion para vaciar el carrito
function clearCart() {
    carrito.forEach((quantity, drink) => {
        //Devolver al stock
        stock.set(drink, stock.get(drink) + quantity);
    });
    //Limpiar el carrito
    carrito.clear();
    alert("Cart cleared.");

    updateCartDisplay();
    updateProductDisplay();
}
function calculateTotal() {
    let total = 0; 
    carrito.forEach((quantity, drink) => {
        total += drink.price * quantity;
    });
    return total;
}

//Funcion para proceder al pago
function checkout() {
    //En teoria nunca deberia estar vacio al llamar a esta funcion ya que el boton se oculta
    if (carrito.size === 0) {
        alert("Your cart is empty.");
        return;
    } else {
        let total = calculateTotal();
        //Confirmar el pago
        let respuesta = confirm(`The total amount is $${total}. \nDo you want to proceed to checkout?`);
        if (respuesta) {
            alert("Purchase successful! Thank you for your order.");
            carrito.clear();
            updateCartDisplay();
            updateProductDisplay();
        }
    }
}
//Funcion para comprobar si el carrito esta vacio
function checkCartEmpty() {
    if(carrito.size === 0) return true;
    for (const quantity of carrito.values()) {
            if (quantity > 0) return false; 
    }
    return true;   
}
//Funcion para obtener la ruta de la imagen de la bebida
function getDrinkImage(drink) {
    return `img/${drink.make} ${drink.name}.png`;
}

//Inicializar la tienda y el carrito
updateProductDisplay();
updateCartDisplay();