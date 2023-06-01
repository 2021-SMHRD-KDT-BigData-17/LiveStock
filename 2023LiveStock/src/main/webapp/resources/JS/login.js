const wrapper = document.querySelector('.wrapper');
const loginLink = document.querySelector('.wrapper');
const registerLink = document.querySelector('.register_link');
const btnPopup = document.querySelector('binLogin-popup');

registerLink.addEventListener('click', ()=> {
    wrapper.classList.add('.active');

});

loginLink.addEventListener('click', ()=> {
    wrapper.classList.remove('active');

});

btnPopup.addEventListener('click', ()=> {
    wrapper.classList.add('active-popup');
});