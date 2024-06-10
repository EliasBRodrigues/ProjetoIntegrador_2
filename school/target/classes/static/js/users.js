const mainUrl = '/api';
function createRow (user) {
    let usernameColumn = '<td>' + user.email + '</td>';
    let editButtonColumn =
        '<td>' +
        '<a href="/users/edit-user/' + user.id  + '" class="btn btn-primary">Changes</a>' +
        '</td>';
    let row = '<tr>' + usernameColumn + editButtonColumn + '</tr>';
    $('.user-container').append(row);
}

function loadUsersByGroup(url,groupName){
    $('.user-container').empty();
    $('#user-group').empty();
    fetch(url).
    then((response) => response.json()).
    then((json) => json.forEach((user, idx) => {
        createRow(user)
    }))
    $('#user-group').append(groupName)
}

$( document ).ready(function() {

    $('#admin-button').click(() => {
        loadUsersByGroup(mainUrl + '/admins','Admin:')
    })
    $('#teacher-button').click(() => {
        loadUsersByGroup(mainUrl + '/teachers','Teacher:')
    })
    $('#user-button').click(() => {
        loadUsersByGroup(mainUrl + '/users','Users:')
    })
    $('#student-button').click(() => {
        loadUsersByGroup(mainUrl + '/students','Students:')
    })
});

$(document).load( loadUsersByGroup(mainUrl + '/users','Users:'));

