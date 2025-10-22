

function EnergyDrink(make, name, size, price) {
    this.make = make;
    this.name = name;
    this.size = size;
    this.price = price;
}

const rbClassic = new EnergyDrink("Red Bull", "Classic", "250ml", 2.5);
const rbSApricot = new EnergyDrink("Red Bull", "Strawberry Apricot", "250ml", 2.5);
const mClassic = new EnergyDrink("Monster", "Classic", "500ml", 3.0);
const mUGold = new EnergyDrink("Monster", "Ultra Gold", "500ml", 3.0);

const stock = new Map();
stock.set(rbClassic, 50);
stock.set(rbSApricot, 50);
stock.set(mClassic, 50);
stock.set(mUGold, 50);

const carrito = [rbClassic, mClassic];

function updateProductDisplay() {
    const productosDiv = document.getElementById("productos");
    productosDiv.innerHTML = '';
    stock.forEach((quantity, drink) => {
        if (quantity > 0) {
    const drinkDiv = document.createElement("div");
    drinkDiv.className = "producto";
    
    drinkDiv.innerHTML = `
        <h3>${drink.make} (${drink.size})</h3>
        <img class="productImg" src="img/${drink.name}.png" alt="">
        <p>Name: ${drink.name}</p>
        <p>Price: ${drink.price}</p>
        <p>In Stock: ${quantity}</p>
    `;
    const addButton = document.createElement("button");
    addButton.textContent = "Add to Cart";
    addButton.onclick = () => addToCart(drink);
    drinkDiv.appendChild(addButton);
    document.getElementById("productos").appendChild(drinkDiv);
        }
});
};

function updateCartDisplay() {
    const carritoDiv = document.getElementById("lista-carrito");
    carritoDiv.innerHTML = '';
    carrito.forEach(drink => {
    const drinkDiv = document.createElement("div");
    drinkDiv.className = "productoCarro";
    
    drinkDiv.innerHTML = `
        <h3>${drink.make} (${drink.name})</h3>
        <img class="productImg" src="img/${drink.make}${drink.name}.png" alt="">
        <p>Price: ${drink.price}</p>
    `;
    const removeButton = document.createElement("button");
    removeButton.textContent = "Remove from Cart";
    removeButton.onclick = () => removeFromCart(drink);
    drinkDiv.appendChild(removeButton);
    document.getElementById("lista-carrito").appendChild(drinkDiv);
});
};


function addToCart(drink) {
    if (stock.get(drink) > 0) {
        carrito.push(drink);
        stock.set(drink, stock.get(drink) - 1);
        alert(`${drink.name} added to cart.`);
    } else {
        alert(`${drink.name} is out of stock.`);
    }
    updateCartDisplay();
    updateStockDisplay();
    updateProductDisplay();
}
function removeFromCart(drink) {
    const index = carrito.indexOf(drink);
    if (index > -1) {
        carrito.splice(index, 1);
        stock.set(drink, stock.get(drink) + 1);
        alert(`${drink.name} removed from cart.`);
    }
    updateCartDisplay();
}

updateProductDisplay();
updateCartDisplay();