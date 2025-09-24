function showPage(pageId) {
    document.querySelectorAll('.page').forEach(p => p.classList.add('hidden'));
    document.getElementById(pageId).classList.remove('hidden');
}

window.onload = function() {
    showPage('main');
    document.getElementById('nav-main').onclick = () => showPage('main');
    document.getElementById('nav-about').onclick = () => showPage('about');
    document.getElementById('nav-products').onclick = () => showPage('products');
}