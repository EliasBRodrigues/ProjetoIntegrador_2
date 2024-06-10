
// var userLanguage = localStorage.getItem('userLanguage');
// if (!userLanguage) {
//     userLanguage = navigator.language || navigator.userLanguage;
//     localStorage.setItem('userLanguage', userLanguage);
// }

function changeLanguage(lang) {
    localStorage.setItem('userLanguage', lang);
    window.location.reload();
}